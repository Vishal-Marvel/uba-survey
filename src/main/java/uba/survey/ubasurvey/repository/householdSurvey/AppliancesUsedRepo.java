package uba.survey.ubasurvey.repository.householdSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.householdSurvey.AppliancesUsed;
import uba.survey.ubasurvey.entity.villageSurvey.CommunityHall;

public interface AppliancesUsedRepo extends JpaRepository<AppliancesUsed, String> {

}
