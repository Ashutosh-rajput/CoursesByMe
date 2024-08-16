package AshutoshRajput.CoursesByMe.DTO;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
        private Long userid;
        private String username;
        private String password;
        private String email;
        private String fullName;
        private Long mobile;

//        private Set<Expense> expenses;
//
//
//        private Set<Budget> budgets;
//
//
//        private Set<Earning> earnings;

}
