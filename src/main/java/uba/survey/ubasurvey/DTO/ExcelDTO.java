package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ExcelDTO {
    private SurveyQuestionResponse fieldData;
    private List<String> responses;
    private List<ExcelFieldObject> fieldDatas;
}

