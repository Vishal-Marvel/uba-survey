package uba.survey.ubasurvey.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Hidden
@NoArgsConstructor
public class FamilyMemberReq {
    private String name;
    private Integer age;
    private String gender;
    private String educationLevel;
    private String goingToAWCSchoolCollege;
    private Boolean aadharCard;
    private Boolean bankAccount;
    private Boolean computerLiterate;
    private String socialSecurityPension;
    private String majorHealthProblems;
    private Boolean MNREGAJobCard;
    private Boolean inSelfHelpGroups;
    private String occupation;
}
