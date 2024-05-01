package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.NextId;

import java.util.Optional;

public interface NextIdRepo extends JpaRepository<NextId, String> {
    Optional<NextId> findBySurveyId(String surveyId);
}
