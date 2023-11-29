package uba.survey.ubasurvey.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Hidden
@NoArgsConstructor
public class CropDetailsReq {


    // 10.1 Crops
    private String crop;

    // 10.2 Area under the Crop in Prev. Year (Acre)
    private Double areaUnderCrop; // in acres

    // 10.3 Productivity (in quintals per Acre)
    private Double productivityCrop; // in quintals per acre
}
