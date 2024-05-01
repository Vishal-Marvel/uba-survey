package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.*;
import uba.survey.ubasurvey.entity.*;
import uba.survey.ubasurvey.exceptions.NotFoundException;
import uba.survey.ubasurvey.repository.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ResponseService {
    private final UserRepo userRepo;
    private final VillageRepo villageRepo;
    private final SurveyRepo surveyRepo;
    private final FieldRepo fieldRepo;
    private final ResponseRepo responseRepo;
    private final OptionRepo optionRepo;
    private final ResponseRecordRepo responseRecordRepo;
    private final NextIdRepo nextIdRepo;
    private final SectionRepo sectionRepo;
    private final UniqueSurveyRepo uniqueSurveyRepo;

    public String storeResponse(SurveyResponseReq surveyResponseReq) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(id)
                .orElseThrow(() -> new NotFoundException("User with email " + id + " not found"));

        Village village = villageRepo.findById(surveyResponseReq.getVillageId())
                .orElseThrow(() -> new NotFoundException(
                        "Village with id " + surveyResponseReq.getVillageId() + " not found"));

        Survey survey = surveyRepo.findById(surveyResponseReq.getSurveyId())
                .orElseThrow(() -> new NotFoundException(
                        "Survey Type with id " + surveyResponseReq.getSurveyId() + " not found"));

        UniqueSurvey uniqueSurvey = uniqueSurveyRepo.findBySurveyIdAndIsActive(surveyResponseReq.getResponseId(), true)
                .orElseThrow(() -> new NotFoundException(
                        "Survey Record with id " + surveyResponseReq.getResponseId() + " not found"));

        Response response = new Response();
        response.setUser(user);
        response.setVillage(village);
        response.setSurvey(survey);
        response.setResponseId(uniqueSurvey);
        response.setActive(true);
        response = responseRepo.save(response);
        uniqueSurveyRepo.save(uniqueSurvey);
        Set<Response> userResponses = user.getResponses();
        userResponses.add(response);
        userRepo.save(user);
        Set<Response> villageResponses = village.getSurveyResponse();
        villageResponses.add(response);
        villageRepo.save(village);
        Set<Response> surveyResponse = survey.getResponses();
        surveyResponse.add(response);
        surveyRepo.save(survey);

        Set<ResponseRecord> responseRecords = new HashSet<>();

        for (AnswerRes answerRes : surveyResponseReq.getAnswerResList()) {
            ResponseRecord responseRecord = new ResponseRecord();
            Field field = fieldRepo.findById(answerRes.getFieldId())
                    .orElseThrow(() -> new NotFoundException("Field with id " + answerRes.getFieldId() + " not found"));
            Section section = field.getSection();
            responseRecord.setResponse(response);
            responseRecord.setField(field);
            responseRecord.setSection(section);
            responseRecord.setCounter(answerRes.getCounter());
            responseRecord = responseRecordRepo.save(responseRecord);

            Set<ResponseRecord> sectionResponses = section.getResponseRecords();
            sectionResponses.add(responseRecord);
            section.setResponseRecords(sectionResponses);
            sectionRepo.save(section);
            Set<ResponseRecord> fieldResponses = field.getResponseRecords();
            fieldResponses.add(responseRecord);
            field.setResponseRecords(fieldResponses);
            fieldRepo.save(field);
            Set<AnswerOption> answers = new HashSet<>();

            for (String answer : answerRes.getAnswerList()) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setOptionName(answer);
                answerOption.setResponseRecord(responseRecord);
                answers.add(answerOption);
                optionRepo.save(answerOption);

            }
            responseRecord.setAnswers(answers);
            responseRecords.add(responseRecord);

            responseRecordRepo.save(responseRecord);
        }

        response.setResponseRecords(responseRecords);
        responseRepo.save(response);
        return "Response Stored";
    }

    public SurveyRecordsListResponse getResponses(String surveyId, String villageId) {
        Survey survey = surveyRepo.findById(surveyId)
                .orElseThrow(() -> new NotFoundException("Survey with id " + surveyId + " Not Found"));
        List<Response> responses;
        if (villageId != null) {
            Village village = villageRepo.findById(villageId)
                    .orElseThrow(() -> new NotFoundException("Villaage with id " + villageId + " Not Found"));
            responses = responseRepo.findAllBySurveyAndVillage(survey, village).stream()
                    .filter((response) -> response.getActive() == true).toList();
        } else {
            responses = responseRepo.findAllBySurvey(survey).stream().filter((response) -> response.getActive() == true)
                    .toList();
        }
        SurveyRecordsListResponse surveyRecordsListResponses = new SurveyRecordsListResponse();
        Map<Integer, Integer> yearResponses = new HashMap<>();
        for (Response response : responses) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(response.getDate());

            int year = calendar.get(Calendar.YEAR);
            yearResponses.put(year, yearResponses.getOrDefault(year, 0) + 1);
        }
        surveyRecordsListResponses.setYear_responses(yearResponses);
        surveyRecordsListResponses.setSurveyId(surveyId);
        surveyRecordsListResponses.setVillageId(villageId);
        return surveyRecordsListResponses;
    }

    public String deleteResponse(String id) {
        Response response = responseRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Response with id " + id + " Not Found"));
        response.setActive(false);
        responseRepo.save(response);
        UniqueSurvey uniqueSurvey = response.getResponseId();
        uniqueSurvey.setIsActive(false);
        uniqueSurveyRepo.save(uniqueSurvey);
        String surveyId = uniqueSurvey.getSurveyId();
        Survey survey = response.getSurvey();
        NextId nextId = nextIdRepo.findBySurveyId(survey.getId()).get();
        Map<String, Integer> nextIds = nextId.getNextId();

        if (survey.getSurveyName().contains("House")) {
            nextIds.put(surveyId.substring(0, 7), nextIds.getOrDefault(surveyId.substring(0, 7), 1) - 1);

        } else {
            nextIds.put(surveyId.substring(0, 8), nextIds.getOrDefault(surveyId.substring(0, 8), 1) - 1);

        }
        nextId.setNextId(nextIds);
        nextIdRepo.save(nextId);
        return "Deleted";
    }

    public VerifyResponse verify(VerifyRequest verifyRequest) {
        Survey survey = surveyRepo.findById(verifyRequest.getSurveyId()).orElseThrow(
                () -> new NotFoundException("Survey with id " + verifyRequest.getSurveyId() + " Not Found"));
        UniqueSurvey uniqueSurvey = new UniqueSurvey();

        Village village = villageRepo.findById(verifyRequest.getVillageId()).orElseThrow(
                () -> new NotFoundException("Village with id " + verifyRequest.getVillageId() + " Not Found"));
        if (survey.getSurveyName().contains("House")) {
            List<UniqueSurvey> uniqueSurveyResponses = uniqueSurveyRepo.findAllByAadharNoOrRationNoOrMobileNo(
                    verifyRequest.getAadharNo(), verifyRequest.getRationNo(), verifyRequest.getMobileNo());
            uniqueSurveyResponses = uniqueSurveyResponses.stream().filter(response -> response.getIsActive() == true)
                    .toList();
            if (uniqueSurveyResponses.size() == 0) {
                NextId nextId = nextIdRepo.findBySurveyId(survey.getId()).orElseGet(() -> {
                    NextId newNextId = new NextId();
                    newNextId.setSurveyId(survey.getId());
                    return nextIdRepo.save(newNextId);
                });
                String id = "SAPHS" + village.getVillageNum() + verifyRequest.getWardNo();
                Map<String, Integer> nextIds = nextId.getNextId();
                if (nextIds == null) {
                    nextIds = new HashMap<>();
                }
                int nextIdValue = nextIds.getOrDefault(id, 0) + 1;
                nextIds.put(id, nextIdValue);
                nextId.setNextId(nextIds);
                nextIdRepo.save(nextId);
                uniqueSurvey.setSurveyId(id + "%04d".formatted(nextIdValue));
                uniqueSurvey.setAadharNo(verifyRequest.getAadharNo());
                uniqueSurvey.setMobileNo(verifyRequest.getMobileNo());
                uniqueSurvey.setHeadName(verifyRequest.getHeadName());
                uniqueSurvey.setRationNo(verifyRequest.getRationNo());
                uniqueSurvey.setCardType(verifyRequest.getCardType());
                uniqueSurvey.setWardNo(verifyRequest.getWardNo());
                uniqueSurvey.setVillageId(village.getId());
                uniqueSurvey.setGramPanchayatCode(verifyRequest.getGramPanchayatCode());
                uniqueSurvey.setGramPanchayatName(verifyRequest.getGramPanchayatName());

            } else {
                UniqueSurvey uniqueSurvey2 = uniqueSurveyResponses.get(0);
                Response response = responseRepo.findByResponseId(uniqueSurvey2).orElse(null);
                if (response == null) {
                    return VerifyResponse.builder()
                            .first(true)
                            .surveyId(uniqueSurvey2.getSurveyId()).build();
                }
                return VerifyResponse.builder()
                        .first(false)
                        .surveyId(uniqueSurveyResponses.stream().map(UniqueSurvey::getSurveyId).toList().get(0))
                        .build();
            }
        } else {
            NextId nextId = nextIdRepo.findBySurveyId(survey.getId()).orElseGet(() -> {
                NextId newNextId = new NextId();
                newNextId.setSurveyId(survey.getId());
                return nextIdRepo.save(newNextId);
            });
            String id = "SAPVS" + verifyRequest.getGramPanchayatCode();
            Map<String, Integer> nextIds = nextId.getNextId();
            if (nextIds == null) {
                nextIds = new HashMap<>();
            }
            int nextIdValue = nextIds.getOrDefault(id, 0) + 1;
            nextIds.put(id, nextIdValue);
            nextId.setNextId(nextIds);
            nextIdRepo.save(nextId);
            uniqueSurvey.setSurveyId(id + "%03d".formatted(nextIdValue));
            uniqueSurvey.setGramPanchayatName(verifyRequest.getGramPanchayatName());
            uniqueSurvey.setGramPanchayatCode(verifyRequest.getGramPanchayatCode());
            uniqueSurvey.setVillageId(village.getId());
        }
        uniqueSurveyRepo.save(uniqueSurvey);
        return VerifyResponse.builder()
                .first(true)
                .surveyId(uniqueSurvey.getSurveyId()).build();
    }
}
