package uba.survey.ubasurvey.bootstarp;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uba.survey.ubasurvey.entity.User;
import uba.survey.ubasurvey.entity.UserRole;
import uba.survey.ubasurvey.repository.UserRepo;

@RequiredArgsConstructor
@Component
public class AdminUserCreation implements CommandLineRunner {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepo.findByEmail("admin@ubasurvey.com").isEmpty()){
            User user = new User();
            user.setUserName("admin");
            user.setRole(UserRole.ROLE_ADMIN);
            user.setEmail("admin@ubasurvey.com");
            user.setPassword(passwordEncoder.encode("ubaAdmin@123"));
            userRepo.save(user);
        }

    }
}
