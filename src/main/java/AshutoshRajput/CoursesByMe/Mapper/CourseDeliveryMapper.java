package AshutoshRajput.CoursesByMe.Mapper;

import AshutoshRajput.CoursesByMe.DTO.CourseDeliveryDTO;
import AshutoshRajput.CoursesByMe.Entity.Course;
import AshutoshRajput.CoursesByMe.Entity.CourseDelivery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDeliveryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CourseDelivery courseDeliveryDTOtoCourseDelivery(CourseDeliveryDTO courseDeliveryDTO,Course course) {
        CourseDelivery courseDelivery = modelMapper.map(courseDeliveryDTO, CourseDelivery.class);
        courseDelivery.setCourse(course);
        return courseDelivery;
    }

    public CourseDeliveryDTO courseDeliveryToCourseDeliveryDTO(CourseDelivery courseDelivery) {
        CourseDeliveryDTO courseDeliveryDTO = modelMapper.map(courseDelivery, CourseDeliveryDTO.class);
        courseDeliveryDTO.setCourseId(courseDelivery.getCourse().getCourseId());
        return courseDeliveryDTO;
    }
}
