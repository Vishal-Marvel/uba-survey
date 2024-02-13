package uba.survey.ubasurvey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.AddSectonReq;
import uba.survey.ubasurvey.DTO.AddSurveyReq;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.entity.Section;
import uba.survey.ubasurvey.entity.Survey;
import uba.survey.ubasurvey.exceptions.NotFoundException;
import uba.survey.ubasurvey.repository.SectionRepo;
import uba.survey.ubasurvey.repository.SurveyRepo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MiscController {
    private final SectionRepo sectionRepo;
    private final SurveyRepo surveyRepo;
    @PostMapping("/section")
    public ResponseEntity<MiscResponse> addSection(@RequestBody AddSectonReq addSectonReq){
        Section section = new Section();
        section.setSectionName(addSectonReq.getSectionName());
        Survey survey = surveyRepo.findById(addSectonReq.getSurvey()).orElseThrow(() -> new NotFoundException("Survey With id " + addSectonReq.getSurvey() +
                " Not Found"));
        section.setSurvey(survey);
        Set<Section> sections = survey.getSections();
        sections.add(section);
        survey.setSections(sections);
        surveyRepo.save(survey);
        sectionRepo.save(section);
        return ResponseEntity.ok(MiscResponse.builder().response(section.getId()).build());
    }
    @PostMapping("/survey")
    public ResponseEntity<MiscResponse> addSurvey(@RequestBody AddSurveyReq addSurveyReq){
        Survey survey = new Survey();
        survey.setSurveyName(addSurveyReq.getSurveyName());
        surveyRepo.save(survey);
        return ResponseEntity.ok(MiscResponse.builder().response("Survey Added "+ survey.getId()).build());
    }

    @GetMapping("/survey")
    public ResponseEntity<Map<String, String>> getSurveys(){
        List<Survey>  surveys = surveyRepo.findAll();
        return ResponseEntity.ok(surveys.stream()
                .collect(Collectors.toMap(Survey::getId, Survey::getSurveyName)));
    }

    @GetMapping("/section")
    public ResponseEntity<List<String>> getSections(
            @RequestParam(name = "survey") String surveyId
    ){
        Survey survey = surveyRepo.findById(surveyId).orElseThrow(() -> new NotFoundException("Survey With id " + surveyId +
                " Not Found"));
        List<Section> sections = sectionRepo.findAllBySurvey(survey);
        return ResponseEntity.ok(sections.stream().map(Section::getSectionName).toList());
    }
}
