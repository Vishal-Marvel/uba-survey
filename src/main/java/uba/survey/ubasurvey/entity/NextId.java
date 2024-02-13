package uba.survey.ubasurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class NextId {
    @Id
    private String id = UUID.randomUUID().toString();

    private String surveyId;
    private String nextId;
}
