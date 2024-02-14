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


    //    public ByteArrayResource createExcel(ExcelQueryObject queryObject)  {
//        try {
//            if (Objects.equals(queryObject.getSurvey(), "village")) {
//                Specification<VillageSurvey> specification = VillageSurveySpecification.filterByQueryObject(queryObject);
//                List<VillageSurvey> sorted = villageSurveyRepo
//                        .findAll(specification)
//                        .stream()
//                        .sorted(Comparator.comparing(VillageSurvey::getDateOfSurvey).reversed())
//                        .toList();
//
//                return villageRequestExcelService.createExcel(sorted.stream().map(this::convertVillageToDto).toList());
//            } else {
//                Specification<HouseholdSurvey> specification = HouseholdSurveySpecification.filterByQueryObject(queryObject);
//
//                List<HouseholdSurvey> householdSurveys = householdSurveyRepo
//                        .findAll(specification)
//                        .stream()
//                        .sorted(Comparator.comparing(HouseholdSurvey::getDateOfSurvey).reversed())
//                        .toList();
//                return householdSurveyExcelService.createExcel(householdSurveys.stream().map(this::convertHouseholdToDto).toList());
//            }
//        }
//        catch (Exception e){
//            throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
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
            SectionResponse generalSection = SectionResponse.builder()
                    .sectionName("Meta Data")
                    .fields(
                            List.of(
                                    FieldResponseDTO.builder()
                                            .id("date")
                                            .fieldType("STRING")
                                            .question("Date")
                                            .build()
                                    , FieldResponseDTO.builder()
                                            .fieldType("STRING")
                                            .id("username")
                                            .question("Sureveyor Name")
                                            .build())
                    ).build();
            surveyQuestionResponse.getSections().add(0, generalSection);
            ExcelDTO excelDTO = new ExcelDTO();
            excelDTO.setFieldData(surveyQuestionResponse);
            List<ExcelFieldObject> excelFieldObjects = new ArrayList<>();
            List<String> responseIds = new ArrayList<>();
            for (Response response : responses) {
                responseIds.add(response.getId());

                ExcelFieldObject dateFieldObject = new ExcelFieldObject();
                dateFieldObject.setFieldId("date");
                dateFieldObject.setResponseId(response.getId());
                dateFieldObject.setAnswers(List.of(response.getDate().toString().substring(0, 10)));
                excelFieldObjects.add(dateFieldObject);

                ExcelFieldObject nameFieldObject = new ExcelFieldObject();
                nameFieldObject.setFieldId("username");
                nameFieldObject.setResponseId(response.getId());
                nameFieldObject.setAnswers(List.of(response.getUser().getUserName()));
                excelFieldObjects.add(nameFieldObject);

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
