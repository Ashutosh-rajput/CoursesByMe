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
public class CourseDelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqd")
    @SequenceGenerator(name = "seqd",sequenceName = "ex_seq",allocationSize = 1)
    @Column(name = "coursedeliveryId")
    private Long coursedeliveryId;
    private Long year;
    private Long semester;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;
}
