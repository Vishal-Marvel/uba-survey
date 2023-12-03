package uba.survey.ubasurvey.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class VillageListResponse {
    private List<String> villages;
}
