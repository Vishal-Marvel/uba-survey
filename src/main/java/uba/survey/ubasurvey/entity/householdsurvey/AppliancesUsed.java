package uba.survey.ubasurvey.entity.householdsurvey;

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
    private String applianceDuration;
}
