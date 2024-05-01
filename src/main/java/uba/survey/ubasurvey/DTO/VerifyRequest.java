package uba.survey.ubasurvey.DTO;

import lombok.Data;

@Data
public class VerifyRequest {
    private String surveyId;
    private String aadharNo;
    private String rationNo;
    private String cardType;
    private String mobileNo;
    private String headName;
    private String villageId;
    private Integer wardNo;
    private String gramPanchayatName;
    private String gramPanchayatCode;

}
