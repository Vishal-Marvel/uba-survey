package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.Village;

public interface VillageRepo extends JpaRepository<Village, String> {
}
