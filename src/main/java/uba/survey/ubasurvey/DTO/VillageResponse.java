package uba.survey.ubasurvey.DTO;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VillageResponse {
    private String id;
    private String villageName;
    private Integer villageNum;
    private String state;
    private String district;
    private Map<String, String> gramPanchyat;
    private String blockName;
    private String blockCode;
    private String collegeName;
    private Integer wardNo;
    private String villageCode;
}
