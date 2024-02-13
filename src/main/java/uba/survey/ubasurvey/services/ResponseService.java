package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import uba.survey.ubasurvey.DTO.AnswerRes;
import uba.survey.ubasurvey.DTO.SurveyRecordsListResponse;
import uba.survey.ubasurvey.DTO.SurveyResponseReq;
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

    public String storeResponse(SurveyResponseReq surveyResponseReq) {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(id)
                .orElseThrow(() -> new NotFoundException("User with email " + id + " not found"));

        Village village = villageRepo.findById(surveyResponseReq.getVillageId())
                .orElseThrow(() -> new NotFoundException("Village with id " + surveyResponseReq.getVillageId() + " not found"));

        Survey survey = surveyRepo.findById(surveyResponseReq.getSurveyId())
                .orElseThrow(() -> new NotFoundException("Survey with id " + surveyResponseReq.getSurveyId() + " not found"));

        Response response = new Response();
        response.setUser(user);
        response.setVillage(village);
        response.setSurvey(survey);

        response = responseRepo.save(response);

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

            if (Objects.equals(field.getFieldType(), "ID")) {
                AnswerOption answerOption = new AnswerOption();
                answerOption.setResponseRecord(responseRecord);
                NextId nextId = nextIdRepo.findBySurveyId(survey.getId());
                answerOption.setOptionName(nextId.getNextId());
                answers.add(answerOption);
                int nextIdValue = Integer.parseInt(nextId.getNextId())+1;
                nextId.setNextId(Integer.toString(nextIdValue));
                optionRepo.save(answerOption);
            }
            else {
                for (String answer : answerRes.getAnswerList()) {
                    AnswerOption answerOption = new AnswerOption();
                    answerOption.setOptionName(answer);
                    answerOption.setResponseRecord(responseRecord);
                    answers.add(answerOption);
                    optionRepo.save(answerOption);

                }
                responseRecord.setAnswers(answers);
                responseRecords.add(responseRecord);
            }
            responseRecordRepo.save(responseRecord);
        }

        response.setResponseRecords(responseRecords);
        responseRepo.save(response);
        return "Response Stored";
    }

    public SurveyRecordsListResponse getResponses(String surveyId, String villageId) {
        Survey survey = surveyRepo.findById(surveyId).orElseThrow(()->new NotFoundException("Survey with id " + surveyId + " Not Found"));
        List<Response> responses;
        if (villageId!=null) {
            Village village = villageRepo.findById(villageId).orElseThrow(() -> new NotFoundException("Villaage with id " + villageId + " Not Found"));
            responses = responseRepo.findAllBySurveyAndVillage(survey, village);
        }else{
            responses = responseRepo.findAllBySurvey(survey);
        }
        SurveyRecordsListResponse surveyRecordsListResponses = new SurveyRecordsListResponse();
        Map<Integer, Integer> yearResponses = new HashMap<>();
        for(Response response : responses) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(response.getDate());

            int year = calendar.get(Calendar.YEAR);
            yearResponses.put(year, yearResponses.getOrDefault(year, 0)+1);
        }
        surveyRecordsListResponses.setYear_responses(yearResponses);
        surveyRecordsListResponses.setSurveyId(surveyId);
        surveyRecordsListResponses.setVillageId(villageId);
        return surveyRecordsListResponses;
    }



}
