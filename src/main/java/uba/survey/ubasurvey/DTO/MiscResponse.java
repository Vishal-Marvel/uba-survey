package uba.survey.ubasurvey.DTO;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Builder;
import lombok.Data;

/**
 * This class represents a miscellaneous response that can be used for various purposes.
 * The only field in this class is a String called response, which holds the content of the response.
 */
@Data
@Hidden
@Builder
public class MiscResponse {
    private String response;
}
