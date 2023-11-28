package uba.survey.ubasurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class VillageSurvey {
    @Id
    private String id= UUID.randomUUID().toString();

}
