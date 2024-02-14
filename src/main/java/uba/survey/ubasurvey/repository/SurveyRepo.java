package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.Survey;

public interface SurveyRepo extends JpaRepository<Survey, String> {

}
