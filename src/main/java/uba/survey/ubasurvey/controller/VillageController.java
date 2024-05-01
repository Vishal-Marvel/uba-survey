package uba.survey.ubasurvey.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uba.survey.ubasurvey.DTO.MiscResponse;
import uba.survey.ubasurvey.DTO.VillageAddRequest;
import uba.survey.ubasurvey.DTO.VillageListResponse;
import uba.survey.ubasurvey.DTO.VillageResponse;
import uba.survey.ubasurvey.entity.Village;
import uba.survey.ubasurvey.exceptions.NotFoundException;
import uba.survey.ubasurvey.repository.VillageRepo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/village")
public class VillageController {
    private final VillageRepo villageRepo;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN_ASSIST', 'ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    public ResponseEntity<MiscResponse> addVillage(@RequestBody VillageAddRequest villageAddRequest) {
        Village village = new Village();
        village.setVillageName(villageAddRequest.getVillageName());
        village.setVillageCode(villageAddRequest.getVillageCode());
        village.setVillageNum(villageAddRequest.getVillageNum());
        village.setState(villageAddRequest.getState());
        village.setDistrict(villageAddRequest.getDistrict());
        village.setGramPanchyat(villageAddRequest.getGramPanchyat());
        village.setBlockName(villageAddRequest.getBlockName());
        village.setBlockCode(villageAddRequest.getBlockCode());
        village.setCollegeName(villageAddRequest.getCollegeName());
        village.setWardNo(villageAddRequest.getWardNo());

        villageRepo.save(village);
        return ResponseEntity.ok(MiscResponse.builder().response("Village Added").build());
    }

    @GetMapping
    public ResponseEntity<VillageListResponse> getVillages() {
        List<Village> villageList = villageRepo.findAll();
        VillageListResponse response = new VillageListResponse();
        response.setVillages(villageList.stream().collect(Collectors.toMap(Village::getId, Village::getVillageName)));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillageResponse> getVillage(@PathVariable String id) {
        Village village = villageRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Village with id= " + id + " not found"));
        return ResponseEntity.ok(VillageResponse.builder()
                .id(village.getId())
                .villageName(village.getVillageName())
                .villageCode(village.getVillageCode())
                .villageNum(village.getVillageNum())
                .district(village.getDistrict())
                .blockCode(village.getBlockCode())
                .blockName(village.getBlockName())
                .collegeName(village.getCollegeName())
                .wardNo(village.getWardNo())
                .state(village.getState())
                .gramPanchyat(village.getGramPanchyat())
                .build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<VillageResponse>> getAllVillage() {
        List<Village> villages = villageRepo.findAll();
        return ResponseEntity.ok(villages.stream().map((village) -> {
            return VillageResponse.builder()
                    .id(village.getId())
                    .villageName(village.getVillageName())
                    .villageCode(village.getVillageCode())
                    .villageNum(village.getVillageNum())
                    .district(village.getDistrict())
                    .blockCode(village.getBlockCode())
                    .blockName(village.getBlockName())
                    .collegeName(village.getCollegeName())
                    .wardNo(village.getWardNo())
                    .state(village.getState())
                    .gramPanchyat(village.getGramPanchyat())
                    .build();
        }).collect(Collectors.toList()));
    }
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN_ASSIST', 'ROLE_ADMIN')")
    @SecurityRequirement(name = "Bearer Authentication")
    @PutMapping("/{id}")
    public ResponseEntity<MiscResponse> updateVillage(@PathVariable String id,
            @RequestBody Map<String, String> gramPanchayat) {
        Village village = villageRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Village with id= " + id + " not found"));
        village.setGramPanchyat(gramPanchayat);
        villageRepo.save(village);
        return ResponseEntity.ok(MiscResponse.builder().response("Village Updated").build());

    }

}
