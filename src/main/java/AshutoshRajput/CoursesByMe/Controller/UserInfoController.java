package AshutoshRajput.CoursesByMe.Controller;

import AshutoshRajput.CoursesByMe.DTO.UserInfoDTO;
import AshutoshRajput.CoursesByMe.Service.ServiceImpl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/useinfo")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoService;


    @GetMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("message","Welcome this endpoint is freeeee....");
        return "welcome";
    }

    @PostMapping("/create-user")
    public UserInfoDTO createUser(@RequestBody UserInfoDTO userInfoDTO){
        return userInfoService.createUser(userInfoDTO);
    }

    @GetMapping("/get-user/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserInfoDTO> getUserById(@PathVariable Long id){
        UserInfoDTO userInfoDTO=userInfoService.getuserbyid(id);
        return ResponseEntity.ok(userInfoDTO);
    }

    @GetMapping("/get-alluser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<UserInfoDTO> getalluser(){
        return userInfoService.getalluser();
    }

    @PutMapping("/update-user/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserInfoDTO> updateuser(@RequestBody UserInfoDTO userInfoDTO,@PathVariable Long id){
        UserInfoDTO userInfoDTO1=userInfoService.updateuser(userInfoDTO, id);
        return ResponseEntity.ok(userInfoDTO1);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> deleteuser(@PathVariable Long id){
        userInfoService.deleteuser(id);
        return ResponseEntity.ok("Deleted");

    }

    @GetMapping("/getuserbyusernameoremail/{usernameoremail}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserInfoDTO> getUserByUsername(@PathVariable String usernameoremail){
        UserInfoDTO userInfoDTO=userInfoService.getUserByUsernameorEmail(usernameoremail);
        return ResponseEntity.ok(userInfoDTO);
    }



}
