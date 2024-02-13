package uba.survey.ubasurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uba.survey.ubasurvey.entity.Field;
import uba.survey.ubasurvey.entity.Section;

import java.util.List;

public interface FieldRepo extends JpaRepository<Field, String> {
    List<Field> findAllBySection(Section section);
}
