package uba.survey.ubasurvey.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSectonReq {
        private String sectionName;
        private String survey;
}
