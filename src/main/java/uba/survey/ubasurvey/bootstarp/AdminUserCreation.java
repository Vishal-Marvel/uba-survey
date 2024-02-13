package uba.survey.ubasurvey.bootstarp;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uba.survey.ubasurvey.entity.*;
import uba.survey.ubasurvey.repository.NextIdRepo;
import uba.survey.ubasurvey.repository.SurveyRepo;
import uba.survey.ubasurvey.repository.UserRepo;
import uba.survey.ubasurvey.repository.VillageRepo;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class AdminUserCreation implements CommandLineRunner {
    private final UserRepo userRepo;
    private final SurveyRepo surveyRepo;
    private final VillageRepo villageRepo;
    private final NextIdRepo nextIdRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Survey villageSurvey = new Survey();
        Survey houseHoldSurvey = new Survey();
        if (userRepo.findByEmail("admin@ubasurvey.com").isEmpty()){
            User user = new User();
            user.setUserName("admin");
            user.setRole(UserRole.ROLE_ADMIN);
            user.setEmail("admin@ubasurvey.com");
            user.setPassword(passwordEncoder.encode("ubaAdmin@123"));
            userRepo.save(user);
        }
        if (surveyRepo.findAll().isEmpty()){

            villageSurvey.setSurveyName("Village survey");

            houseHoldSurvey.setSurveyName("House Hold survey");
            surveyRepo.saveAll(Arrays.asList(villageSurvey, houseHoldSurvey));

        }
        if (villageRepo.findAll().size()==0){
            Village puducheri = new Village("Puducheri");
            Village somangalam = new Village("Somangalam");
            Village naduveerappattu = new Village("Naduveerappattu");
            Village nandambakkam = new Village("Nandambakkam");
            Village varadharajapuram = new Village("Varadharajapuram");
            Village pazhanthandalam = new Village("Pazhanthandalam");
            Village nallur = new Village("Nallur");
            Village erumaiyur = new Village("Erumaiyur");
            Village thirumudivakkam = new Village("Thirumudivakkam");
            Village puduppair = new Village("Puduppair");

            villageRepo.saveAll(Arrays.asList(
                    puducheri, somangalam, naduveerappattu, nandambakkam, varadharajapuram,
                    pazhanthandalam, nallur, erumaiyur, thirumudivakkam, puduppair
            ));

        }

        if (nextIdRepo.findAll().isEmpty()){
            NextId village = new NextId();
            village.setSurveyId(villageSurvey.getId());
            village.setNextId("");
            NextId houseHold = new NextId();
            houseHold.setSurveyId(houseHoldSurvey.getId());
            houseHold.setNextId("");
            nextIdRepo.saveAll(Arrays.asList(village, houseHold));

        }

    }
}
