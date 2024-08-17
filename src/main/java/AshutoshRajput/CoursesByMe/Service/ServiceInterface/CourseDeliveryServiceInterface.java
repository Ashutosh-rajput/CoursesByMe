package AshutoshRajput.CoursesByMe.Service.ServiceInterface;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.DTO.CourseDeliveryDTO;

import java.util.List;

public interface CourseDeliveryServiceInterface {
    CourseDeliveryDTO createCourseDelivery(CourseDeliveryDTO courseDeliveryDTO);
    List<CourseDTO> getAllCoursesbyyearandsemester(Long year,Long semester);
    CourseDeliveryDTO getCourseDeliveryByyearsemesterandid(Long year,Long semester,Long courseid);
    CourseDeliveryDTO deleteCourseDeliveryByyearsemesterandid(Long year,Long semester,Long courseid);



}
