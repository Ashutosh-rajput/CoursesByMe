package AshutoshRajput.CoursesByMe.Repo;

import AshutoshRajput.CoursesByMe.Entity.CourseDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseDeliveryRepo extends JpaRepository<CourseDelivery,Long> {
    List<CourseDelivery> findByYearAndSemester(Long year, Long semester);
    Optional<CourseDelivery> findByYearAndSemesterAndCourse_courseId(Long Year, Long Semester, Long courseId);

}
