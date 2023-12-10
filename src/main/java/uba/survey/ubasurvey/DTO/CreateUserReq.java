package uba.survey.ubasurvey.DTO;

import lombok.Data;
import uba.survey.ubasurvey.entity.UserRole;

@Data
public class CreateUserReq {
    private String userName;
    private String email;
    private String password;

}
