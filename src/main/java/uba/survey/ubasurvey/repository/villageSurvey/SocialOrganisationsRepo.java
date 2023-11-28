package uba.survey.ubasurvey.repository.villageSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.villagesurvey.PanchayatOffice;
import uba.survey.ubasurvey.entity.villagesurvey.SocialOrganisations;

public interface SocialOrganisationsRepo extends JpaRepository<SocialOrganisations, String> {

}
