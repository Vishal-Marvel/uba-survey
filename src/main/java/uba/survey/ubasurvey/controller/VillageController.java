package uba.survey.ubasurvey.controller;

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

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/villaag")
public class VillageController {
    private final VillageRepo villageRepo;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<MiscResponse> addVillage(@RequestBody VillageAddRequest villageAddRequest){
        Village village = new Village();
        village.setVillageName(villageAddRequest.getVillageName());
        villageRepo.save(village);
        return ResponseEntity.ok(MiscResponse.builder().response("Village Added").build());
    }

    @GetMapping("/list")
    public ResponseEntity<VillageListResponse> villages(){
        List<Village> villageList = villageRepo.findAll();
        VillageListResponse response = new VillageListResponse();
        response.setVillages(villageList.stream().map(Village::getVillageName).toList());
        return ResponseEntity.ok(response);
    }

}
