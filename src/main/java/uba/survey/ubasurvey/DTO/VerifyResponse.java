package uba.survey.ubasurvey.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyResponse {
    private String surveyId;
    private Boolean first;
}
