package uba.survey.ubasurvey.repository.householdSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.householdSurvey.CropDetails;
import uba.survey.ubasurvey.entity.villageSurvey.Dharamashala;

public interface CropDetailsRepo extends JpaRepository<CropDetails, String> {

}
