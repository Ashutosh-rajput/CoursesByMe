package AshutoshRajput.CoursesByMe.Config;

import AshutoshRajput.CoursesByMe.Mapper.CourseDeliveryMapper;
import AshutoshRajput.CoursesByMe.Mapper.CourseMapper;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseDeliveryServiceImpl;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.CourseServiceImpl;
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
    public CourseDeliveryServiceImpl courseDeliveryService(){
        return new CourseDeliveryServiceImpl();
    }
    @Bean
    public CourseDeliveryMapper courseDeliveryMapper(){
        return new CourseDeliveryMapper();
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
