package AshutoshRajput.CoursesByMe.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqc")
    @SequenceGenerator(name = "seqc",sequenceName = "ex_seq",allocationSize = 1)
    @Column(name = "courseId")
    private Long courseId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code", nullable = false)
    private String code;
    private String description;





}
