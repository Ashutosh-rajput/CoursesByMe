package AshutoshRajput.CoursesByMe.DTO;

import AshutoshRajput.CoursesByMe.Entity.UserInfo;
import jakarta.persistence.*;
import lombok.*;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
        private Long courseId;
        private String name;
        private String description;
        private Long price;

        private UserInfo userInfo;


    }


