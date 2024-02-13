package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.AnswerOption;

public interface OptionRepo extends JpaRepository<AnswerOption, String> {
}
