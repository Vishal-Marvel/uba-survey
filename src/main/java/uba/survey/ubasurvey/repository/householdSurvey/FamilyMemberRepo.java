package uba.survey.ubasurvey.repository.householdSurvey;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.householdSurvey.FamilyMember;
import uba.survey.ubasurvey.entity.villageSurvey.Dispensary;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, String> {

}
