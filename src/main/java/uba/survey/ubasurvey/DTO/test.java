package uba.survey.ubasurvey.DTO;

import lombok.RequiredArgsConstructor;
import org.webjars.NotFoundException;
import uba.survey.ubasurvey.entity.householdSurvey.*;
import uba.survey.ubasurvey.repository.householdSurvey.*;
import uba.survey.ubasurvey.repository.villageSurvey.*;

import java.lang.reflect.Field;

@RequiredArgsConstructor
public class test {

    public HouseholdRequest convertHouseholdToDto(HouseholdSurvey householdSurvey) {

        HouseholdRequest householdRequest = new HouseholdRequest();

// Set values for members of the household req DTO
        householdRequest.setFilledByName(householdSurvey.getFilledByName());
        householdRequest.setDateOfSurvey(householdSurvey.getDateOfSurvey());

// Set values for General Information
        householdRequest.setVillage(householdSurvey.getVillage());
        householdRequest.setGramPanchayat(householdSurvey.getGramPanchayat());
        householdRequest.setWardNo(householdSurvey.getWardNo());
        householdRequest.setBlock(householdSurvey.getBlock());
        householdRequest.setDistrict(householdSurvey.getDistrict());
        householdRequest.setState(householdSurvey.getState());

// Set values for Respondent’s Profile
        householdRequest.setRespondentName(householdSurvey.getRespondentName());
        householdRequest.setGender(householdSurvey.getGender());
        householdRequest.setAge(householdSurvey.getAge());
        householdRequest.setRelationshipWithHead(householdSurvey.getRelationshipWithHead());
        householdRequest.setContactNumber(householdSurvey.getContactNumber());

// Set values for General Household Information
        householdRequest.setHeadOfHouseholdName(householdSurvey.getHeadOfHouseholdName());
        householdRequest.setHeadGender(householdSurvey.getHeadGender());
        householdRequest.setNumberOfFamilyMembers(householdSurvey.getNumberOfFamilyMembers());
        householdRequest.setCategory(householdSurvey.getCategory());
        householdRequest.setPovertyStatus(householdSurvey.getPovertyStatus());
        householdRequest.setOwnHouse(householdSurvey.getOwnHouse());
        householdRequest.setTypeOfHouse(householdSurvey.getTypeOfHouse());
        householdRequest.setToilet(householdSurvey.getToilet());
        householdRequest.setDrainageLinkedToHouse(householdSurvey.getDrainageLinkedToHouse());
        householdRequest.setWasteCollectionSystem(householdSurvey.getWasteCollectionSystem());
        householdRequest.setCompostPit(householdSurvey.getCompostPit());
        householdRequest.setBioGasPlant(householdSurvey.getBioGasPlant());

        for (FamilyMember familyMember : householdSurvey.getMembers()){
            FamilyMemberReq familyMemberReq = new FamilyMemberReq();

            Field[] reqFields = FamilyMemberReq.class.getDeclaredFields();

            for (Field reqField : reqFields) {
                reqField.setAccessible(true);

                try {
                    Field familyField = FamilyMember.class.getDeclaredField(reqField.getName());
                    familyField.setAccessible(true);

                    // Set the value from familyMemberReq to familyMember
                    familyField.set(familyMember, reqField.get(familyMemberReq));
                } catch (NoSuchFieldException e) {
                    // Handle the case where the fields don't match
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // Handle the case where accessing the field is not allowed
                    e.printStackTrace();
                }
            }
        }

// 4. Migration Status in a family
        householdRequest.setFamilyMigratesForWork(householdSurvey.getFamilyMigratesForWork());
        householdRequest.setNumberOfFamilyMembersMigrated(householdSurvey.getNumberOfFamilyMembersMigrated());
        householdRequest.setFamilyMigrationDuration(householdSurvey.getFamilyMigrationDuration());
        householdRequest.setFamilyMigrationYears(householdSurvey.getFamilyMigrationYears());

// 5. Information of Government Schemes
        householdRequest.setPmJanDhanYojanaBeneficiaryIndividuals(householdSurvey.getPmJanDhanYojanaBeneficiaryIndividuals());
        householdRequest.setSukanyaSamridhiYojanaBeneficiaryIndividuals(householdSurvey.getSukanyaSamridhiYojanaBeneficiaryIndividuals());
        householdRequest.setMudraYojanaBeneficiaryIndividuals(householdSurvey.getMudraYojanaBeneficiaryIndividuals());
        householdRequest.setPmJivanJyotiBimaYojanaBeneficiaryIndividuals(householdSurvey.getPmJivanJyotiBimaYojanaBeneficiaryIndividuals());
        householdRequest.setPmSurakshaBimaYojanaBeneficiaryIndividuals(householdSurvey.getPmSurakshaBimaYojanaBeneficiaryIndividuals());
        householdRequest.setAtalPensionYojanaBeneficiaryIndividuals(householdSurvey.getAtalPensionYojanaBeneficiaryIndividuals());
        householdRequest.setKaushalVikasYojanaBeneficiaryIndividuals(householdSurvey.getKaushalVikasYojanaBeneficiaryIndividuals());
        householdRequest.setJananiSurakshaYojanaBeneficiaryIndividuals(householdSurvey.getJananiSurakshaYojanaBeneficiaryIndividuals());
        householdRequest.setFasalBimaYojanaBeneficiaryHousehold(householdSurvey.getFasalBimaYojanaBeneficiaryHousehold());
        householdRequest.setKisanCreditCardBeneficiaryHousehold(householdSurvey.getKisanCreditCardBeneficiaryHousehold());
        householdRequest.setKrishiSinchaiYojanaBeneficiaryHousehold(householdSurvey.getKrishiSinchaiYojanaBeneficiaryHousehold());
        householdRequest.setSwachhBharatMissionToiletBeneficiaryHousehold(householdSurvey.getSwachhBharatMissionToiletBeneficiaryHousehold());
        householdRequest.setSoilHealthCardBeneficiaryHousehold(householdSurvey.getSoilHealthCardBeneficiaryHousehold());
        householdRequest.setPmUjjwalaYojanaBeneficiaryHousehold(householdSurvey.getPmUjjwalaYojanaBeneficiaryHousehold());
        householdRequest.setPmAwasYojanaBeneficiaryHousehold(householdSurvey.getPmAwasYojanaBeneficiaryHousehold());

// 6. Source of Water (Distance from source in km)

        householdRequest.setPipedWaterAtHome(householdSurvey.getPipedWaterAtHome());
        householdRequest.setDistanceFromPipedWater(householdSurvey.getDistanceFromPipedWater());

        householdRequest.setCommunityWaterTap(householdSurvey.getCommunityWaterTap());
        householdRequest.setDistanceFromCommunityWaterTap(householdSurvey.getDistanceFromCommunityWaterTap());

        householdRequest.setHandPump(householdSurvey.getHandPump());
        householdRequest.setPublic_privateHandPump(householdSurvey.getPublic_privateHandPump());
        householdRequest.setDistanceFromHandPump(householdSurvey.getDistanceFromHandPump());

        householdRequest.setOpenWell(householdSurvey.getOpenWell());
        householdRequest.setPublic_privateOpenWell(householdSurvey.getPublic_privateOpenWell());
        householdRequest.setDistanceFromOpenWell(householdSurvey.getDistanceFromOpenWell());

        householdRequest.setCommunityWaterStorage(householdSurvey.getCommunityWaterStorage());
        householdRequest.setIndividualWaterStorage(householdSurvey.getIndividualWaterStorage());

        householdRequest.setOtherWaterSource(householdSurvey.getOtherWaterSource());
        householdRequest.setOtherWaterSourceName(householdSurvey.getOtherWaterSourceName());
        householdRequest.setDistanceFromOtherWaterSource(householdSurvey.getDistanceFromOtherWaterSource());

// 7. Source of Energy and Power

        householdRequest.setElectricityConnectionToHousehold(householdSurvey.getElectricityConnectionToHousehold());

        householdRequest.setElectricityAvailabilityPerDay(householdSurvey.getElectricityAvailabilityPerDay());

        householdRequest.setLightingSource(householdSurvey.getLightingSource());
        householdRequest.setCookingSource(householdSurvey.getCookingSource());
        householdRequest.setChullahType(householdSurvey.getChullahType());
        for (AppliancesUsed appliancesUsed: householdSurvey.getAppliancesAndDuration()){
            AppliancesUsedReq appliancesUsedReq = new AppliancesUsedReq();
            appliancesUsedReq.setApplianceDuration(appliancesUsed.getApplianceDuration());
            appliancesUsedReq.setApplianceName(appliancesUsed.getApplianceName());

        }
        // 8. Land Details
        householdRequest.setTotalLand(householdSurvey.getTotalLand());
        householdRequest.setCultivableArea(householdSurvey.getCultivableArea());
        householdRequest.setIrrigatedArea(householdSurvey.getIrrigatedArea());
        householdRequest.setUnirrigatedArea(householdSurvey.getUnirrigatedArea());
        householdRequest.setBarrenWastelandArea(householdSurvey.getBarrenWastelandArea());
        householdRequest.setUncultivableArea(householdSurvey.getUncultivableArea());

// 9. Agricultural Inputs
        householdRequest.setUseChemicalFertilizers(householdSurvey.getUseChemicalFertilizers());
        householdRequest.setChemicalFertilizersUsage(householdSurvey.getChemicalFertilizersUsage());

        householdRequest.setUseChemicalInsecticides(householdSurvey.getUseChemicalInsecticides());
        householdRequest.setChemicalInsecticidesUsage(householdSurvey.getChemicalInsecticidesUsage());

        householdRequest.setUseChemicalWeedicide(householdSurvey.getUseChemicalWeedicide());
        householdRequest.setChemicalWeedicideUsage(householdSurvey.getChemicalWeedicideUsage());

        householdRequest.setUseOrganicManures(householdSurvey.getUseOrganicManures());
        householdRequest.setOrganicManuresUsage(householdSurvey.getOrganicManuresUsage());

        householdRequest.setIrrigationSource(householdSurvey.getIrrigationSource());
        householdRequest.setIrrigationSystem(householdSurvey.getIrrigationSystem());
        for (CropDetails cropDetails: householdSurvey.getCropDetails()){
            CropDetailsReq cropDetailsReq = new CropDetailsReq();
            cropDetailsReq.setAreaUnderCrop(cropDetails.getAreaUnderCrop());
            cropDetailsReq.setCrop(cropDetails.getCrop());
            cropDetailsReq.setProductivityCrop(cropDetails.getProductivityCrop());
        }
        // 11. Livestocks
        householdRequest.setCows(householdSurvey.getCows());
        householdRequest.setBuffalos(householdSurvey.getBuffalos());
        householdRequest.setGoatsSheeps(householdSurvey.getGoatsSheeps());
        householdRequest.setCalves(householdSurvey.getCalves());
        householdRequest.setBullocks(householdSurvey.getBullocks());
        householdRequest.setPoultryDucks(householdSurvey.getPoultryDucks());
        householdRequest.setOthersLivestock(householdSurvey.getOthersLivestock());

// 11.2 Shelter for Livestock
        householdRequest.setShelter(householdSurvey.getShelter());

// 11.3 Average Daily Production of Milk (Litres)
        householdRequest.setAverageDailyMilkProduction(householdSurvey.getAverageDailyMilkProduction());

// 11.4 Animal Waste/Cow Dung (in Kg.)
        householdRequest.setAnimalWasteCowDung(householdSurvey.getAnimalWasteCowDung());

// 12. Major problems in the village (Top 3)
        householdRequest.setTopProblem1(householdSurvey.getTopProblem1());
        householdRequest.setTopProblem2(householdSurvey.getTopProblem2());
        householdRequest.setTopProblem3(householdSurvey.getTopProblem3());

// Suggestions for Problems
        householdRequest.setSuggestionsForProblems(householdSurvey.getSuggestionsForProblems());

        return householdRequest;
    }

}
