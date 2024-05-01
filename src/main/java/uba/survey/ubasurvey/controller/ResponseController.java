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
import uba.survey.ubasurvey.services.ResponseService;
import uba.survey.ubasurvey.services.SurveyServices;

import java.util.Objects;

@RestController
@RequestMapping("/api/response")
@RequiredArgsConstructor
public class ResponseController {
    private final ResponseService responseService;
    private final SurveyServices surveyServices;

    @PreAuthorize("hasRole('ROLE_USER')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    public ResponseEntity<MiscResponse> storeResponse(@RequestBody SurveyResponseReq surveyResponseReq) {
        return ResponseEntity
                .ok(MiscResponse.builder().response(responseService.storeResponse(surveyResponseReq)).build());

    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN_ASSIST', 'ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<SurveyRecordsListResponse> getResponses(
            @RequestParam(name = "survey") String surveyId,
            @RequestParam(name = "village", required = false) String villageId) {
        return ResponseEntity.ok(responseService.getResponses(surveyId, villageId));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMIN_ASSIST')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/download")
    public ResponseEntity<Resource> download(@RequestBody ExcelQueryObject queryObject) {
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Report.xlsx");
        MediaType mediaType = MediaType.APPLICATION_OCTET_STREAM;

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(mediaType)
                .body(surveyServices.createExcel(queryObject));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping("/verify")
    public ResponseEntity<VerifyResponse> verify(@RequestBody VerifyRequest verifyRequest) {
        return ResponseEntity.ok(responseService.verify(verifyRequest));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        return ResponseEntity.ok(responseService.deleteResponse(id));
    }

}
