package AshutoshRajput.CoursesByMe.Service.ServiceImpl;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import AshutoshRajput.CoursesByMe.ExceptionHandling.CourseDeletionException;
import AshutoshRajput.CoursesByMe.ExceptionHandling.ResourceNotFoundException;
import AshutoshRajput.CoursesByMe.Mapper.CourseMapper;
import AshutoshRajput.CoursesByMe.Repo.CourseDeliveryRepo;
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
    @Autowired
    private CourseDeliveryRepo courseDeliveryRepo;

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
        course.setCode(courseDTO.getCode());
        course.setDescription(courseDTO.getDescription());
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
        if (courseDeliveryRepo.existsByCourse_CourseId(id)) {
            throw new CourseDeletionException("Cannot delete course. Please delete associated deliveries first.");
        }
        courseRepo.delete(course);
        return courseMapper.coursetocourseDTO(course);
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses=courseRepo.findAll();
        return courses.stream().map((course) ->courseMapper.coursetocourseDTO(course)).toList();
    }


}
