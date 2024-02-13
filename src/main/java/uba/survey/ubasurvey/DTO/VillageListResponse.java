package uba.survey.ubasurvey.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor

public class VillageListResponse {
    private Map<String, String> villages;
}
