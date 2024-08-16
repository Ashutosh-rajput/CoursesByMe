package AshutoshRajput.CoursesByMe.Repo;

import AshutoshRajput.CoursesByMe.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course,Long> {
    List<Course> findByUserInfo_userid(Long userId);

}
