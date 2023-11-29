package uba.survey.ubasurvey.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Hidden
@NoArgsConstructor
public class AppliancesUsedReq {
    private String applianceName;
    private String applianceDuration;
}
