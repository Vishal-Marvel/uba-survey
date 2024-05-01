package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uba.survey.ubasurvey.entity.Response;
import uba.survey.ubasurvey.entity.Survey;
import uba.survey.ubasurvey.entity.UniqueSurvey;
import uba.survey.ubasurvey.entity.Village;

import java.util.List;
import java.util.Optional;

public interface ResponseRepo extends JpaRepository<Response, String> {
    List<Response> findAllBySurveyAndVillage(Survey survey, Village village);

    List<Response> findAllBySurvey(Survey survey);

    Optional<Response> findByResponseId(UniqueSurvey responseId);

    @Query("SELECT r FROM Response r where YEAR(r .date) = ?3 and r.survey = ?1 and r.village = ?2")
    List<Response> findAllBySurveyAndVillageAndYear(Survey survey, Village village, Integer year);

    @Query("SELECT r FROM Response r where YEAR(r .date) = ?2 and r.survey = ?1")
    List<Response> findAllBySurveyAndYear(Survey survey, Integer year);
}
