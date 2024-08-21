package AshutoshRajput.CoursesByMe.DTO;

import AshutoshRajput.CoursesByMe.Entity.Course;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDeliveryDTO {
    private Long coursedeliveryId;
    private Long year;
    private Long semester;
    private Long courseId;
//    private Course course;
}
