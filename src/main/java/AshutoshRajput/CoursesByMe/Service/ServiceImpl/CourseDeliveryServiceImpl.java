package AshutoshRajput.CoursesByMe.Service.ServiceImpl;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import AshutoshRajput.CoursesByMe.Entity.CourseDelivery;
import AshutoshRajput.CoursesByMe.DTO.CourseDeliveryDTO;
import AshutoshRajput.CoursesByMe.ExceptionHandling.ResourceNotFoundException;
import AshutoshRajput.CoursesByMe.Mapper.CourseDeliveryMapper;
import AshutoshRajput.CoursesByMe.Mapper.CourseMapper;
import AshutoshRajput.CoursesByMe.Repo.CourseDeliveryRepo;
import AshutoshRajput.CoursesByMe.Repo.CourseRepo;
import AshutoshRajput.CoursesByMe.Service.ServiceInterface.CourseDeliveryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CourseDeliveryServiceImpl implements CourseDeliveryServiceInterface {
    @Autowired
    private CourseDeliveryRepo courseDeliveryRepository;

    @Autowired
    private CourseRepo courseRepository;

    @Autowired
    private CourseDeliveryMapper courseDeliveryMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public CourseDeliveryDTO createCourseDelivery(CourseDeliveryDTO courseDeliveryDTO) {
        Course course = courseRepository.findById(courseDeliveryDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        CourseDelivery courseDelivery = courseDeliveryMapper.courseDeliveryDTOtoCourseDelivery(courseDeliveryDTO, course);
        courseDelivery = courseDeliveryRepository.save(courseDelivery);
        return courseDeliveryMapper.courseDeliveryToCourseDeliveryDTO(courseDelivery);
    }

    @Override
    public List<CourseDTO> getAllCoursesbyyearandsemester(Long year, Long semester) {
        List<CourseDelivery> courseDeliveries=courseDeliveryRepository.findByYearAndSemester(year, semester);
        return courseDeliveries.stream().map(CourseDelivery::getCourse)
                .map(courseMapper::coursetocourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDeliveryDTO getCourseDeliveryByyearsemesterandid(Long year, Long semester, Long courseid) {
        CourseDelivery courseDelivery=courseDeliveryRepository.findByYearAndSemesterAndCourse_courseId(year, semester, courseid)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found"));
        return courseDeliveryMapper.courseDeliveryToCourseDeliveryDTO(courseDelivery);
    }

    @Override
    public CourseDeliveryDTO deleteCourseDeliveryByyearsemesterandid(Long year, Long semester, Long courseid) {
        CourseDelivery courseDelivery=courseDeliveryRepository.findByYearAndSemesterAndCourse_courseId(year, semester, courseid)
                .orElseThrow(() -> new ResourceNotFoundException("CourseInstance not found"));
        courseDeliveryRepository.delete(courseDelivery);

        return courseDeliveryMapper.courseDeliveryToCourseDeliveryDTO(courseDelivery);

    }
}
