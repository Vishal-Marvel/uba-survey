package uba.survey.ubasurvey.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UpdateFieldReq {
    private String fieldId;
    private String fieldType;
    private String question;
    private List<String> options;
    private String section;
    private String parentField;
    private MultipartFile image;

    private String YES_fieldType;
    private List<String> YES_options;
    private String YES_question;
    private MultipartFile YES_image;

    private String NO_fieldType;
    private List<String> NO_options;
    private String NO_question;
    private MultipartFile NO_image;

}
