package uba.survey.ubasurvey.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UniqueSurvey {
    @Id
    private String id = UUID.randomUUID().toString();
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
    private Boolean isActive = true;
}
