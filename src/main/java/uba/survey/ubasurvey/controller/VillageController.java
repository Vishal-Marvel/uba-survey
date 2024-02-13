package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.DTO.VillageAddRequest;
import uba.survey.ubasurvey.DTO.VillageListResponse;
import uba.survey.ubasurvey.entity.Village;
import uba.survey.ubasurvey.repository.VillageRepo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/village")
public class VillageController {
    private final VillageRepo villageRepo;

    @PreAuthorize("hasRole('ROLE_USER')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    public ResponseEntity<MiscResponse> addVillage(@RequestBody VillageAddRequest villageAddRequest){
        Village village = new Village();
        village.setVillageName(villageAddRequest.getVillageName());
        villageRepo.save(village);
        return ResponseEntity.ok(MiscResponse.builder().response("Village Added").build());
    }

    @GetMapping
    public ResponseEntity<VillageListResponse> getVillages(){
        List<Village> villageList = villageRepo.findAll();
        VillageListResponse response = new VillageListResponse();
        response.setVillages(villageList.stream().collect(Collectors.toMap(Village::getId, Village::getVillageName)));
        return ResponseEntity.ok(response);
    }

}
