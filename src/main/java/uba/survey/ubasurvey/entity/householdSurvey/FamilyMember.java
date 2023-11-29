package uba.survey.ubasurvey.entity.householdSurvey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class FamilyMember {
    @Id
    private String id = UUID.randomUUID().toString();
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
