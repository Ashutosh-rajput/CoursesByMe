package AshutoshRajput.CoursesByMe.DTO;

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
    private Long courseId;  // Reference to the course
}
