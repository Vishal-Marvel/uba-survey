package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uba.survey.ubasurvey.entity.Section;
import uba.survey.ubasurvey.entity.Survey;

import java.util.List;

public interface SectionRepo extends JpaRepository<Section, String> {
    @Query(value = "select r  from Section r where  r.survey = ?1 and  (r.isActive=true or r.isActive is null)")
    List<Section> findAllBySurvey(Survey survey);
}
