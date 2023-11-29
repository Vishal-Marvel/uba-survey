package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.HouseholdRequest;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.DTO.VillageRequest;
import uba.survey.ubasurvey.services.SurveyServices;

@RestController
@RequestMapping("/api/survey")
@RequiredArgsConstructor
public class SurveyController {
    private final SurveyServices services;

    @Hidden
    @PostMapping("/village-survey")
    public ResponseEntity<MiscResponse> addVillageSurvey(@RequestBody VillageRequest villageRequest){
        String response = services.handleVillageSurvey(villageRequest);
        return ResponseEntity.ok(MiscResponse.builder().response(response).build());
    }

    @Hidden
    @PostMapping("/household-survey")
    public ResponseEntity<MiscResponse> addHouseHoldSurvey(@RequestBody HouseholdRequest householdRequest){
        String response = services.handleHouseholdSurvey(householdRequest);
        return ResponseEntity.ok(MiscResponse.builder().response(response).build());
    }


}
