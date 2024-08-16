package AshutoshRajput.CoursesByMe.Mapper;

import AshutoshRajput.CoursesByMe.DTO.CourseDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseMapper {
    @Autowired
    private ModelMapper modelMapper;

    public Course courseDTOtocourse(CourseDTO courseDTO){
        return modelMapper.map(courseDTO,Course.class);
    }
    public CourseDTO coursetocourseDTO(Course course){
        return modelMapper.map(course,CourseDTO.class);
    }
}
