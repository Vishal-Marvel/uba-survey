package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.List;

@Data
public class SurveyResponseReq {
    private String surveyId;
    private String villageId;
    private List<AnswerRes> answerResList;
}
