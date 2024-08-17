package AshutoshRajput.CoursesByMe.Config;

import AshutoshRajput.CoursesByMe.Mapper.CourseMapper;
import AshutoshRajput.CoursesByMe.Mapper.UserInfoMapper;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseServiceImpl;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.UserInfoServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public UserInfoServiceImpl userInfoService(){
        return new UserInfoServiceImpl();
    }
    @Bean
    public UserInfoMapper userInfoMapper(){
        return new UserInfoMapper();
    }
    @Bean
    public CourseServiceImpl courseService(){
        return new CourseServiceImpl();
    }
    @Bean
    public CourseMapper courseMapper(){
        return new CourseMapper();
    }



}
