package uba.survey.ubasurvey.DTO;

import lombok.Data;

import java.util.Map;

@Data

public class SurveyRecordsListResponse {
    private String surveyId;
    private String villageId;
    private Map<Integer, Integer> year_responses;
}
