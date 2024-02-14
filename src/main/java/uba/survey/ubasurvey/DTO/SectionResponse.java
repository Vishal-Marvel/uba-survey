package uba.survey.ubasurvey.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SectionResponse {
    private String sectionName;
    private String sectionId;
    private List<FieldResponseDTO> fields;
}
