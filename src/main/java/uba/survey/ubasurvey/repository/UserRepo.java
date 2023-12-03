package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);
}
