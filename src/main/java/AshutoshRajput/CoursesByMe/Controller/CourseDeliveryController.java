package AshutoshRajput.CoursesByMe.Controller;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.DTO.CourseDeliveryDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseDeliveryServiceImpl;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CourseDeliveryController {
    @Autowired
    private CourseDeliveryServiceImpl courseDeliveryService;

    @PostMapping("/instances")
    public CourseDeliveryDTO createdelivery(@RequestBody CourseDeliveryDTO courseDeliveryDTO){
        return courseDeliveryService.createCourseDelivery(courseDeliveryDTO);
    }
    @GetMapping("/instances/{year}/{semester}")
    public List<CourseDTO> getcoursebyyearandsemester(@PathVariable Long year, @PathVariable Long semester){
        return courseDeliveryService.getAllCoursesbyyearandsemester(year, semester);
    }
    @GetMapping("instances/{year}/{semester}/{id}")
    public CourseDeliveryDTO getDeliverybyyearsemcourseid(@PathVariable Long year, @PathVariable Long semester,@PathVariable Long id){
        return courseDeliveryService.getCourseDeliveryByyearsemesterandid(year, semester, id);
    }
}
