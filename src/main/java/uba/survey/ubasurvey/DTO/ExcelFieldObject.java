package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ExcelFieldObject {
    private String fieldId;
    private String responseId;
    private Integer counter;
    private List<String> answers;

}
