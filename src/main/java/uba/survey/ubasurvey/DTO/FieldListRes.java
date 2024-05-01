package uba.survey.ubasurvey.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FieldListRes {
    private String fieldId;
    private String fieldName;
}
