package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.AddFieldRequest;
import uba.survey.ubasurvey.DTO.FieldResponse;
import uba.survey.ubasurvey.DTO.SectionResponse;
import uba.survey.ubasurvey.DTO.SurveyQuestionResponse;
import uba.survey.ubasurvey.entity.AnswerOption;
import uba.survey.ubasurvey.entity.Field;
import uba.survey.ubasurvey.entity.Section;
import uba.survey.ubasurvey.entity.Survey;
import uba.survey.ubasurvey.exceptions.APIException;
import uba.survey.ubasurvey.exceptions.NotFoundException;
import uba.survey.ubasurvey.repository.FieldRepo;
import uba.survey.ubasurvey.repository.OptionRepo;
import uba.survey.ubasurvey.repository.SectionRepo;
import uba.survey.ubasurvey.repository.SurveyRepo;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepo fieldRepo;
    private final OptionRepo optionRepo;

    private final SectionRepo sectionRepo;
    private final SurveyRepo surveyRepo;
    private final ImageService imageService;

    public String addField(AddFieldRequest addFieldRequest) throws IOException {
        Field field = new Field();
        field.setFieldType(addFieldRequest.getFieldType());
        field.setQuestion(addFieldRequest.getQuestion());
        Section section = sectionRepo.findById(addFieldRequest.getSection()).orElseThrow(() -> new NotFoundException("Section With id " + addFieldRequest.getSection() +
                " Not Found"));
        field.setSection(section);
        Set<Field> sectionFields = section.getFields();
        sectionFields.add(field);
        sectionRepo.save(section);
        if (addFieldRequest.getImage() != null) {
            field.setImage(imageService.compressImages(addFieldRequest.getImage()));
        }
        if (Objects.equals(addFieldRequest.getFieldType(), "DROPDOWN") && addFieldRequest.getOptions().size() > 0) {
            for (String optionName : addFieldRequest.getOptions()) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setOptionName(optionName);
                answerOption.setField(field);
                optionRepo.save(answerOption);
                Set<AnswerOption> answerOptions = field.getAnswerOptions();
                answerOptions.add(answerOption);
                field.setAnswerOptions(answerOptions);

            }
        }
        if (addFieldRequest.getParentField() != null) {
            Field parentField = fieldRepo.findById(addFieldRequest.getParentField()).orElseThrow(() -> new NotFoundException("Field With id " + addFieldRequest.getParentField() +
                    " Not Found"));
            field.setParentField(parentField);
            Set<Field> parentSubFields = parentField.getSubFields();
            parentSubFields.add(field);
            parentField.setSubFields(parentSubFields);
            fieldRepo.save(parentField);
        }
        if (Objects.equals(addFieldRequest.getFieldType(), "YES/NO")) {
            setYES_NOField(field, addFieldRequest, section);
            if (field.getNoField() == null && field.getYesField() == null) {
                throw new APIException("For Field Type Yes/No, Yes Field or No Field is required", HttpStatus.CONFLICT);
            }
        }

        fieldRepo.save(field);
        return "Field Added " + field.getId();
    }

    public void deleteField(String id) {
        fieldRepo.deleteById(id);

    }

    public void setYES_NOField(Field field, AddFieldRequest addFieldRequest, Section section) throws IOException {
        if (addFieldRequest.getYES_question() != null && addFieldRequest.getYES_fieldType() != null) {
            //Yes Fields
            Field yesField = new Field();
            yesField.setQuestion(addFieldRequest.getYES_question());
            yesField.setFieldType(addFieldRequest.getYES_fieldType());
            yesField.setSection(section);
            if (Objects.equals(addFieldRequest.getYES_fieldType(), "DROPDOWN") && addFieldRequest.getYES_options().size() > 0) {
                for (String optionName : addFieldRequest.getYES_options()) {
                    AnswerOption answerOption = new AnswerOption();
                    answerOption.setOptionName(optionName);
                    answerOption.setField(yesField);
                    optionRepo.save(answerOption);
                    Set<AnswerOption> answerOptions = yesField.getAnswerOptions();
                    answerOptions.add(answerOption);
                    yesField.setAnswerOptions(answerOptions);

                }
            }

            if (addFieldRequest.getYES_image() != null) {
                yesField.setImage(imageService.compressImages(addFieldRequest.getYES_image()));
            }
            yesField.setParentField(field);

            fieldRepo.save(yesField);
            field.setYesField(yesField);
        }
        //No Fields
        if (addFieldRequest.getNO_question() != null && addFieldRequest.getNO_fieldType() != null) {
            Field noField = new Field();
            noField.setQuestion(addFieldRequest.getNO_question());
            noField.setFieldType(addFieldRequest.getNO_fieldType());
            noField.setSection(section);
            if (Objects.equals(addFieldRequest.getNO_fieldType(), "DROPDOWN") && addFieldRequest.getNO_options().size() > 0) {
                for (String optionName : addFieldRequest.getNO_options()) {
                    AnswerOption answerOption = new AnswerOption();
                    answerOption.setOptionName(optionName);
                    answerOption.setField(noField);
                    optionRepo.save(answerOption);
                    Set<AnswerOption> answerOptions = noField.getAnswerOptions();
                    answerOptions.add(answerOption);
                    noField.setAnswerOptions(answerOptions);

                }
            }

            if (addFieldRequest.getNO_image() != null) {
                noField.setImage(imageService.compressImages(addFieldRequest.getNO_image()));
            }
            noField.setParentField(field);

            fieldRepo.save(noField);
            field.setNoField(noField);

        }
    }

    public SurveyQuestionResponse getFields(String surveyId) {
        Survey survey = surveyRepo.findById(surveyId).orElseThrow(() -> new NotFoundException("Survey With id " + surveyId +
                " Not Found"));
        List<Section> sections = sectionRepo.findAllBySurvey(survey);
        SurveyQuestionResponse response = new SurveyQuestionResponse();
        response.setSurveyName(survey.getSurveyName());
        response.setSurveyId(surveyId);
        List<SectionResponse> sectionResponseList = new ArrayList<>();
        for (Section section : sections) {

            Set<Field> sectionFields = section.getFields();
            List<FieldResponse> fieldResponseList = new ArrayList<>();
            for (Field field : sectionFields) {
                if (field.getParentField() == null) {
                    FieldResponse fieldResponse = setResponse(field);
                    fieldResponse.setSubfields(field.getSubFields().stream().map(this::setResponse).toList());
                    fieldResponseList.add(fieldResponse);
                }

            }
            sectionResponseList.add(SectionResponse.builder()
                    .fields(fieldResponseList)
                    .sectionName(section.getSectionName())
                    .build());
        }
        response.setSections(sectionResponseList);

        return response;
    }

    private FieldResponse setResponse(Field field) {
        FieldResponse response = new FieldResponse();
        response.setId(field.getId());
        response.setImage(field.getImage());
        response.setQuestion(field.getQuestion());
        response.setOptions(field.getAnswerOptions().stream().map(AnswerOption::getOptionName).toList());
        response.setFieldType(field.getFieldType());
        if (field.getYesField() != null) {
            response.setYESField(FieldResponse.builder()
                    .subfields(field.getYesField().getSubFields() != null ? field.getYesField().getSubFields().stream().map(this::setResponse).toList() : null)
                    .id(field.getYesField().getId())
                    .question(field.getYesField().getQuestion())
                    .fieldType(field.getYesField().getFieldType())
                    .image(field.getYesField().getImage())
                    .options(field.getYesField().getAnswerOptions().stream().map(AnswerOption::getOptionName).toList())
                    .build());
        }
        if (field.getNoField() != null) {
            response.setNoField(FieldResponse.builder()
                    .id(field.getNoField().getId())
                    .subfields(field.getNoField().getSubFields() != null ? field.getNoField().getSubFields().stream().map(this::setResponse).toList() : null)
                    .question(field.getNoField().getQuestion())
                    .fieldType(field.getNoField().getFieldType())
                    .image(field.getNoField().getImage())
                    .options(field.getNoField().getAnswerOptions().stream().map(AnswerOption::getOptionName).toList())
                    .build());
        }
        return response;
    }

    public Map<String, String> getSectionFields(String sectionId) {
        Section section = sectionRepo.findById(sectionId).orElseThrow(() -> new NotFoundException("Section With id " + sectionId +
                " Not Found"));
        return section.getFields().stream().collect(Collectors.toMap(Field::getId, Field::getQuestion));
    }
}
