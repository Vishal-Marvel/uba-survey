package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.*;
import uba.survey.ubasurvey.services.FieldService;

import java.io.IOException;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/field")
public class FieldController {
    private final FieldService fieldService;

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_ASSIST')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<MiscResponse> addField(@ModelAttribute AddFieldRequest addFieldRequest) throws IOException {
        return ResponseEntity.ok(MiscResponse.builder().response(fieldService.addField(null, addFieldRequest)).build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<MiscResponse> deleteField(@PathVariable String id){
        fieldService.deleteField(id);
        return ResponseEntity.ok(MiscResponse.builder().response("Deleted").build());
    }

    @GetMapping("/{survey}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_ADMIN_ASSIST')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<SurveyQuestionResponse> getFieldsList (@PathVariable String survey){
        return ResponseEntity.ok(fieldService.getFields(survey));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER', 'ROLE_ADMIN_ASSIST')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Map<String, String>> getFields(
            @RequestParam(name = "section") String survey
    )
    {
        return ResponseEntity.ok(fieldService.getSectionFields(survey));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_ASSIST')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/{id}")
    public ResponseEntity<MiscResponse> updateField(@PathVariable String id, @ModelAttribute AddFieldRequest updateFieldReq) throws IOException {
        return ResponseEntity.ok(MiscResponse.builder().response(fieldService.updateField(id, updateFieldReq)).build());
    }

    @GetMapping("/details/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<FieldResponseDTO> fetchField(@PathVariable String id) {
        return ResponseEntity.ok(fieldService.getField(id));
    }



}
