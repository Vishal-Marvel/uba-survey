package uba.survey.ubasurvey.repository.householdSurvey;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.householdSurvey.HouseholdSurvey;

import java.util.List;

public interface HouseholdSurveyRepo extends JpaRepository<HouseholdSurvey, String> {
    List<HouseholdSurvey> findAll(Specification<HouseholdSurvey> specification);

}
