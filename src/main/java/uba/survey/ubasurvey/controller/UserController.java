package uba.survey.ubasurvey.controller;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.AuthenticationResponse;
import uba.survey.ubasurvey.DTO.CreateUserReq;
import uba.survey.ubasurvey.DTO.LoginRequest;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.services.UserServices;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<MiscResponse> createUesr(@RequestBody CreateUserReq createUserReq){
        String response = userServices.createUser(createUserReq);
        return ResponseEntity.ok(MiscResponse.builder().response(response).build());
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userServices.authenticate(loginRequest));
    }
}
