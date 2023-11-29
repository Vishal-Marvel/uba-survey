package uba.survey.ubasurvey.entity.householdSurvey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CropDetails {
    @Id
    private String id = UUID.randomUUID().toString();

    // 10.1 Crops
    private String crop;

    // 10.2 Area under the Crop in Prev. Year (Acre)
    private Double areaUnderCrop; // in acres

    // 10.3 Productivity (in quintals per Acre)
    private Double productivityCrop; // in quintals per acre
}
