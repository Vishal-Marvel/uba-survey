package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.ResponseRecord;

public interface ResponseRecordRepo extends JpaRepository<ResponseRecord, String> {
}
