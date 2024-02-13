package uba.survey.ubasurvey.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FieldResponse {
    private String id;
    private String question;
    private List<String> options;
    private String fieldType;
    private List<FieldResponse> subfields;
    private FieldResponse YESField;
    private FieldResponse NoField;
    private byte[] image;

}
