package uba.survey.ubasurvey.entity.householdSurvey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class AppliancesUsed {
    @Id
    private String id = UUID.randomUUID().toString();
    private String applianceName;
    private Double applianceDuration;
}
