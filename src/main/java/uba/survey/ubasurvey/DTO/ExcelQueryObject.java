package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExcelQueryObject {
    private String surveyId;
    private Integer year;
    private String village;
}
