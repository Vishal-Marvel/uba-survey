package uba.survey.ubasurvey.repository.villageSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.villagesurvey.Dharamashala;
import uba.survey.ubasurvey.entity.villagesurvey.PanchayatOffice;

public interface PanchayatOfficeRepo extends JpaRepository<PanchayatOffice, String> {

}
