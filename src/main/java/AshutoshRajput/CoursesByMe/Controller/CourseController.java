package AshutoshRajput.CoursesByMe.Controller;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.DTO.UserInfoDTO;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @PostMapping("/courses")
    public CourseDTO createcourse(@RequestBody CourseDTO courseDTO){
        return courseService.createCourse(courseDTO);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getcousers(){
        List<CourseDTO> courseDTOS=courseService.getAllCourses();
        return ResponseEntity.ok(courseDTOS);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getcoursebyid(@PathVariable Long id){
        CourseDTO courseDTO=courseService.getCourseByid(id);
        return ResponseEntity.ok(courseDTO);
    }
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deletecurse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course Deleted");
    }

    @PutMapping("/courses/{courseid}")
    public ResponseEntity<CourseDTO> updatecourse(@RequestBody CourseDTO courseDTO, @PathVariable Long courseid){
        CourseDTO courseDTO1=courseService.updateCourse(courseDTO,courseid);
        return ResponseEntity.ok(courseDTO1);
    }



}
