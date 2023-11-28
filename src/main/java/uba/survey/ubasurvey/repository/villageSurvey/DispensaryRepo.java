package uba.survey.ubasurvey.repository.villageSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.villagesurvey.CommunityHall;
import uba.survey.ubasurvey.entity.villagesurvey.Dispensary;

public interface DispensaryRepo extends JpaRepository<Dispensary, String> {

}
