package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.NextId;

public interface NextIdRepo extends JpaRepository<NextId, String> {
    NextId findBySurveyId(String surveyId);
}
