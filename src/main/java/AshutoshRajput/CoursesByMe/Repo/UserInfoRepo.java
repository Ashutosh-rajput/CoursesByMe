package AshutoshRajput.CoursesByMe.Repo;

import AshutoshRajput.CoursesByMe.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepo extends JpaRepository<UserInfo,Long> {

    Optional<UserInfo> findByusernameoremail(String username);



}
