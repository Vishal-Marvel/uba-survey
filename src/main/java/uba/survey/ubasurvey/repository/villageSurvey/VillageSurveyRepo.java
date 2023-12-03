package uba.survey.ubasurvey.repository.villageSurvey;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.villageSurvey.VillageSurvey;

import java.util.List;


public interface VillageSurveyRepo extends JpaRepository<VillageSurvey, String> {
    List<VillageSurvey> findAll(Specification<VillageSurvey> villageSurveySpecification);
}
