package AshutoshRajput.CoursesByMe.Service.ServiceImpl;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import AshutoshRajput.CoursesByMe.ExceptionHandling.ResourceNotFoundException;
import AshutoshRajput.CoursesByMe.Mapper.CourseMapper;
import AshutoshRajput.CoursesByMe.Repo.CourseRepo;
import AshutoshRajput.CoursesByMe.Service.ServiceInterface.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseServiceInterface {
    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course=courseMapper.courseDTOtocourse(courseDTO);
        return courseMapper.coursetocourseDTO(courseRepo.save(course));
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO, Long id) {
        Course course=courseRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Course with id is not there.")
        );
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setPrice(courseDTO.getPrice());
        return courseMapper.coursetocourseDTO(courseRepo.save(course));
    }

    @Override
    public CourseDTO getCourseByid(Long id) {
        Course course=courseRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Course with id is not there.")
        );
        return courseMapper.coursetocourseDTO(course);
    }

    @Override
    public CourseDTO deleteCourse(Long id) {
        Course course=courseRepo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Course with id is not there.")
        );
        courseRepo.delete(course);
        return courseMapper.coursetocourseDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourseByUserid(Long userid) {
        List<Course> courses=courseRepo.findByUserInfo_userid(userid);
        return courses.stream().map((course) ->courseMapper.coursetocourseDTO(course)).toList();
    }
}
