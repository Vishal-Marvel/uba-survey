package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.AddFieldRequest;
import uba.survey.ubasurvey.DTO.FieldResponse;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.DTO.SurveyQuestionResponse;
import uba.survey.ubasurvey.services.FieldService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/field")
public class FieldController {
    private final FieldService fieldService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<MiscResponse> addField(@ModelAttribute AddFieldRequest addFieldRequest) throws IOException {
        return ResponseEntity.ok(MiscResponse.builder().response(fieldService.addField(addFieldRequest)).build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<MiscResponse> deleteField(@PathVariable String id){
        fieldService.deleteField(id);
        return ResponseEntity.ok(MiscResponse.builder().response("Deleted").build());
    }

    @GetMapping("/{survey}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<SurveyQuestionResponse> getFieldsList (@PathVariable String survey){
        return ResponseEntity.ok(fieldService.getFields(survey));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Map<String, String>> getFields(@RequestParam(name = "section") String survey){
        return ResponseEntity.ok(fieldService.getSectionFields(survey));
    }




}
