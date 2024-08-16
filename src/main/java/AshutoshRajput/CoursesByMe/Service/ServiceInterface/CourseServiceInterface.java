package AshutoshRajput.CoursesByMe.Service.ServiceInterface;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;

import java.util.List;

public interface CourseServiceInterface {
    CourseDTO createCourse(CourseDTO courseDTO);
    CourseDTO updateCourse(CourseDTO courseDTO,Long id);
    CourseDTO getCourseByid(Long id);
    CourseDTO deleteCourse(Long id);

    List<CourseDTO> getAllCourseByUserid(Long userid);

}
