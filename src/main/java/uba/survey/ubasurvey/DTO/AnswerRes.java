package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.List;

@Data
public class AnswerRes {
    private String fieldId;
    private Integer counter;
    private List<String > answerList;
}
