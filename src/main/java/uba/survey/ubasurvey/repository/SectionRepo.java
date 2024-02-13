package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.Section;
import uba.survey.ubasurvey.entity.Survey;

import java.util.List;

public interface SectionRepo extends JpaRepository<Section, String> {
    List<Section> findAllBySurvey(Survey survey);
}
