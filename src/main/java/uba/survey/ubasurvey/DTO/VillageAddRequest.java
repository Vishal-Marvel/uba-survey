package uba.survey.ubasurvey.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class VillageAddRequest {
    private String villageName;
    private String villageCode;
    private String state;
    private String district;
    private Map<String, Integer> gramPanchyat;
    private String blockName;
    private String blockCode;
    private String collegeName;
    private Integer villageNum;
    private Integer wardNo;
}
