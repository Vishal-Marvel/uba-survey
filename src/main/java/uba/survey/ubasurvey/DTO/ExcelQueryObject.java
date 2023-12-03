package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExcelQueryObject {
    private String survey;
    private List<String> surveyorNames;
    private Date fromDate;
    private Date toDate;
    private List<String> villages;
}
