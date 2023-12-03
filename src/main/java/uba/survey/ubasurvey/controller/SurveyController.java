package uba.survey.ubasurvey.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.HouseholdRequest;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.DTO.VillageSurveyRequest;
import uba.survey.ubasurvey.services.SurveyServices;

import java.util.Objects;


@RestController
@RequestMapping("/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyServices surveyServices;

    @PostMapping("/village-survey")
    public ResponseEntity<MiscResponse> addVillageSurvey(@RequestBody VillageSurveyRequest villageSurveyRequest){
        String response = surveyServices.handleVillageSurvey(villageSurveyRequest);
        return ResponseEntity.ok(MiscResponse.builder().response(response).build());
    }

    @PostMapping("/household-survey")
    public ResponseEntity<MiscResponse> addHouseHoldSurvey(@RequestBody HouseholdRequest householdRequest){
        String response = surveyServices.handleHouseholdSurvey(householdRequest);
        return ResponseEntity.ok(MiscResponse.builder().response(response).build());
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(
            @RequestParam(value = "survey") String survey
    ){
        HttpHeaders headers = new HttpHeaders();
        String fileName;
        if (Objects.equals(survey, "village")){
            fileName = "Village.xlsx";
        }else{
            fileName = "HouseHold.xlsx";
        }

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(mediaType)
                .body(surveyServices.createExcel(survey));
    }


}
