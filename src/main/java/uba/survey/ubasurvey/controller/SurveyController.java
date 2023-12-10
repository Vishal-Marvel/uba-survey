package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.*;
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

    @GetMapping("/count")
    public ResponseEntity<CountResponse> getSurveysCount(){
        return ResponseEntity.ok(surveyServices.getCount());
    }

    @PutMapping("/download")
    @SecurityRequirement(name = "Bearer Authentication")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<Resource> download(@RequestBody ExcelQueryObject queryObject){
        HttpHeaders headers = new HttpHeaders();
        String fileName;
        if (Objects.equals(queryObject.getSurvey(), "village")){
            fileName = "Village.xlsx";
        }else{
            fileName = "HouseHold.xlsx";
        }

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+fileName);
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(mediaType)
                .body(surveyServices.createExcel(queryObject));
    }


}
