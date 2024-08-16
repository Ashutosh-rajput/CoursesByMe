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
    private String description;
    @Column(name = "price", nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private UserInfo userInfo;


}
