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
public class FieldResponseDTO {
    private String id;
    private String question;
    private List<String> options;
    private String fieldType;
    private List<FieldResponseDTO> subfields;
    private FieldResponseDTO YESField;
    private FieldResponseDTO NoField;
    private byte[] image;
    private String parentId;
    private String parentQuestion;
}
