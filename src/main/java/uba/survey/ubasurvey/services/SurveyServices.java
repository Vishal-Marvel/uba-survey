package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.*;
import uba.survey.ubasurvey.entity.*;
import uba.survey.ubasurvey.exceptions.APIException;
import uba.survey.ubasurvey.exceptions.NotFoundException;
import uba.survey.ubasurvey.repository.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class SurveyServices {
    private final VillageRepo villageRepo;
    private final SurveyRepo surveyRepo;
    private final FieldService fieldService;
    private final ResponseRepo responseRepo;
    private final ExcelService excelService;


private ExcelFieldObject set( String fieldId, String responsId, List<String> answers){
        ExcelFieldObject object = new ExcelFieldObject();
        object.setFieldId(fieldId);
        object.setResponseId(responsId);
        object.setAnswers(answers);
        return object;
    }


    public ByteArrayResource createExcel(ExcelQueryObject excelQueryObject) {
        try {
            Survey survey = surveyRepo.findById(excelQueryObject.getSurveyId()).orElseThrow(() -> new NotFoundException("Survey with id " + excelQueryObject.getSurveyId() + " not found"));
            Village village = villageRepo.findById(excelQueryObject.getVillage()).orElseThrow(() -> new NotFoundException("Village with id " + excelQueryObject.getVillage() + " not found"));

            List<Response> responses = responseRepo.findAllBySurveyAndVillageAndYear(
                    survey,
                    village,
                    excelQueryObject.getYear()
            );
            SurveyQuestionResponse surveyQuestionResponse = fieldService.getFields(survey.getId());
            SectionResponse houseHoldSection = SectionResponse.builder().build();
            SectionResponse generalSection = SectionResponse.builder()
                    .sectionName("Meta Data")
                    .fields(
                            List.of(
                                    FieldResponseDTO.builder()
                                            .fieldType("STRING")
                                            .id("surveyId")
                                            .question("Survey ID")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .id("date")
                                            .fieldType("STRING")
                                            .question("Date")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .fieldType("STRING")
                                            .id("username")
                                            .question("Sureveyor Name")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .id("villageName")
                                            .fieldType("STRING")
                                            .question("Village Name")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .id("villageCode")
                                            .fieldType("INTEGER")
                                            .question("Village Code")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .id("blockName")
                                            .fieldType("STRING")
                                            .question("Block Name")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .id("blockCode")
                                            .fieldType("INTEGER")
                                            .question("Block Code")
                                            .build()

                            )
                    ).build();
            if (survey.getSurveyName().contains("House")){
                houseHoldSection = SectionResponse.builder()
                        .sectionName("House Hold Section ")
                        .fields(
                                List.of(
                                        FieldResponseDTO.builder()
                                                .id("gramPanchayatName")
                                                .fieldType("STRING")
                                                .question("Gram Panchayat Name")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .id("gramPanchayatCode")
                                                .fieldType("INTEGER")
                                                .question("Gram Panchayat Code")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .fieldType("INTEGER")
                                                .id("ward")
                                                .question("Ward No.")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .id("headName")
                                                .fieldType("STRING")
                                                .question("Head Name")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .id("headMobileNumber")
                                                .fieldType("STRING")
                                                .question("Head Mobile Number")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .fieldType("STRING")
                                                .id("headAadhaarNumber")
                                                .question("Head Aadhar Number")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .id("rationCardNumber")
                                                .fieldType("STRING")
                                                .question("Ration Card Number")
                                                .build()
                                        , FieldResponseDTO.builder()
                                                .fieldType("STRING")
                                                .id("rationCardType")
                                                .question("Ration Card Type")
                                                .build()

                                )
                        ).build();

            }
            SectionResponse villageDetails = SectionResponse.builder()
                    .sectionName("village")
                    .fields(
                            List.of(
                                    FieldResponseDTO.builder()
                                            .fieldType("STRING")
                                            .id("district")
                                            .question("District")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .fieldType("STRING")
                                            .id("state")
                                            .question("State")
                                            .build())
                    ).build();
            surveyQuestionResponse.getSections().add(0, generalSection);
            surveyQuestionResponse.getSections().add(1, houseHoldSection);
            surveyQuestionResponse.getSections().add(2, villageDetails);
            ExcelDTO excelDTO = new ExcelDTO();
            excelDTO.setFieldData(surveyQuestionResponse);
            List<ExcelFieldObject> excelFieldObjects = new ArrayList<>();
            List<String> responseIds = new ArrayList<>();
            for (Response response : responses) {
                responseIds.add(response.getId());
                excelFieldObjects.add(set( "surveyId", response.getId(), List.of(response.getResponseId().getId())));
                excelFieldObjects.add(set( "date", response.getId(), List.of(response.getDate().toString().substring(0, 10))));
                excelFieldObjects.add(set( "username", response.getId(), List.of(response.getUser().getUserName())));
                excelFieldObjects.add(set( "villageName", response.getId(), List.of(village.getVillageName())));
                excelFieldObjects.add(set( "villageCode", response.getId(), List.of(village.getVillageCode())));
                excelFieldObjects.add(set( "blockName", response.getId(), List.of(village.getBlockName()    )));
                excelFieldObjects.add(set( "blockCode", response.getId(), List.of(village.getBlockCode())));
                excelFieldObjects.add(set( "state", response.getId(), List.of(village.getState())));
                excelFieldObjects.add(set( "district", response.getId(), List.of(village.getDistrict())));
                excelFieldObjects.add(set( "gramPanchayatName", response.getId(), List.of(response.getResponseId().getGramPanchayatName())));
                excelFieldObjects.add(set( "gramPanchayatCode", response.getId(), List.of(String.valueOf(response.getResponseId().getGramPanchayatCode()))));
                excelFieldObjects.add(set( "ward", response.getId(), List.of(String.valueOf(response.getResponseId().getWardNo()))));
                excelFieldObjects.add(set( "headName", response.getId(), List.of(response.getResponseId().getHeadName())));
                excelFieldObjects.add(set( "headAadhaarNumber", response.getId(), List.of(response.getResponseId().getAadharNo())));
                excelFieldObjects.add(set( "headMobileNumber", response.getId(), List.of(response.getResponseId().getMobileNo())));
                excelFieldObjects.add(set( "rationCardNumber", response.getId(), List.of(response.getResponseId().getRationNo())));
//                System.out.println("respo/nse = " + response.getResponseId().getCardType());
                excelFieldObjects.add(set( "rationCardType", response.getId(), List.of(response.getResponseId().getCardType())));


                for (ResponseRecord responseRecord : response.getResponseRecords()) {
//                    if (responseRecord.getField().getParentField() == null) {
                        ExcelFieldObject excelFieldObject = new ExcelFieldObject();
                        excelFieldObject.setFieldId(responseRecord.getField().getId());
                        excelFieldObject.setResponseId(response.getId());
                        excelFieldObject.setCounter(responseRecord.getCounter());
                        excelFieldObject.setAnswers(responseRecord.getAnswers().stream().map(AnswerOption::getOptionName).toList());
                        excelFieldObjects.add(excelFieldObject);
//                    }
                }
            }
            excelDTO.setFieldDatas(excelFieldObjects);

            excelDTO.setResponses(responseIds);

            return excelService.createExcel(excelDTO);

        } catch (Exception e) {

            throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    private Map<String, String> getFieldIds(Survey survey) {
//
//        Map<String, String> fieldIds = new HashMap<>();
//        fieldIds.put("date", "Date");
//        fieldIds.put("username", "User Name");
//
//        for (Section section : survey.getSections()) {
//            for (Field field : section.getFields()) {
//                if (field.getParentField() == null) {
//                    fieldIds.put(field.getId(), field.getQuestion());
//                    fieldIds.putAll(addfields(field.getYesField()));
//                    fieldIds.putAll(addfields(field.getNoField()));
//                    if (!Objects.equals(field.getFieldType(), "COUNTER")) {
//                        for (Field subField : field.getSubFields()) {
//                            fieldIds.putAll(addfields(subField));
//                        }
//                    }
//                }
//            }
//        }
//        return fieldIds;
//    }

//    private Map<String, String> addfields(Field field) {
//        if (field!=null) {
//            Map<String, String> fieldIds = new HashMap<>();
//            fieldIds.put(field.getId(), field.getQuestion());
//
//            if (field.getYesField() != null) {
//                fieldIds.putAll(addfields(field.getYesField()));
//            }
//            if (field.getNoField() != null) {
//                fieldIds.putAll(addfields(field.getNoField()));
//            }
//            if (!Objects.equals(field.getFieldType(), "COUNTER")) {
//                for (Field subField : field.getSubFields()) {
//                    fieldIds.putAll(addfields(subField));
//                }
//            }
//
//            return fieldIds;
//        }
//        return new HashMap<>();
//    }
}
