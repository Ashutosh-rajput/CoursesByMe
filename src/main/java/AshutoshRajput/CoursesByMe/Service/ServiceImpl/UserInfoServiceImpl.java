package AshutoshRajput.CoursesByMe.Service.ServiceImpl;

import AshutoshRajput.CoursesByMe.DTO.UserInfoDTO;
import AshutoshRajput.CoursesByMe.Entity.UserInfo;
import AshutoshRajput.CoursesByMe.ExceptionHandling.ResourceNotFoundException;
import AshutoshRajput.CoursesByMe.Mapper.UserInfoMapper;
import AshutoshRajput.CoursesByMe.Repo.UserInfoRepo;
import AshutoshRajput.CoursesByMe.Service.ServiceInterface.UserInfoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoServiceInterface {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserInfoDTO createUser(UserInfoDTO userInfoDTO) {
        UserInfo userInfo=userInfoMapper.userInfoDTOtouserInfo(userInfoDTO);
        userInfo.setRoles("ROLE_USER");
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        UserInfo savedUserInfo=userInfoRepo.save(userInfo);
        return userInfoMapper.userInfotouserInfoDTO(savedUserInfo);
    }

    @Override
    public UserInfoDTO getuserbyid(Long id) {
        UserInfo userInfo=userInfoRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User with that id doesnt exist"+ id));
        return userInfoMapper.userInfotouserInfoDTO(userInfo);
    }

    @Override
    public List<UserInfoDTO> getalluser() {
        List<UserInfo> users=userInfoRepo.findAll();
        return users.stream().map((user)->userInfoMapper.userInfotouserInfoDTO(user)).toList();

    }

    @Override
    public UserInfoDTO updateuser(UserInfoDTO userInfoDTO, Long id) {
        UserInfo userInfo=userInfoRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User with that id doesnt exist"+ id));
        userInfo.setUsername(userInfoDTO.getUsername());
        userInfo.setEmail(userInfoDTO.getEmail());
        userInfo.setFullName(userInfoDTO.getFullName());
        userInfo.setMobile(userInfoDTO.getMobile());
        UserInfo updateduser=userInfoRepo.save(userInfo);
        return userInfoMapper.userInfotouserInfoDTO(updateduser);
    }

    @Override
    public UserInfoDTO deleteuser(Long id) {
        UserInfo userInfo=userInfoRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User with that id doesnt exist"+ id));
        userInfoRepo.delete(userInfo);
        return userInfoMapper.userInfotouserInfoDTO(userInfo);
    }

    @Override
    public UserInfoDTO getUserByUsernameorEmail(String usernameoremail) {
        UserInfo userInfo=userInfoRepo.findByusernameoremail(usernameoremail).orElseThrow(
                ()->new ResourceNotFoundException("User not found with this Username or Email.")
        );
        return userInfoMapper.userInfotouserInfoDTO(userInfo);
    }
}
