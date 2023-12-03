package uba.survey.ubasurvey.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * A class that represents an authentication request with a username or email and a password.
 * The fields are annotated with @NotBlank to ensure that they are not null or empty..
 */
@Data
public class LoginRequest {
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;

}
