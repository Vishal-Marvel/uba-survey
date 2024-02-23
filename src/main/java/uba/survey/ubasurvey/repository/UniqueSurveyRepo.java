package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.UniqueSurvey;

import java.util.List;
import java.util.Optional;

public interface UniqueSurveyRepo extends JpaRepository<UniqueSurvey, String> {
    List<UniqueSurvey> findAllByAadharNoOrRationNoOrMobileNo(String aadharNo, String rationNo, String mobileNo);
}
