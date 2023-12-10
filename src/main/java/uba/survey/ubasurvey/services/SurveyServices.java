package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import uba.survey.ubasurvey.DTO.*;
import uba.survey.ubasurvey.entity.householdSurvey.AppliancesUsed;
import uba.survey.ubasurvey.entity.householdSurvey.CropDetails;
import uba.survey.ubasurvey.entity.householdSurvey.FamilyMember;
import uba.survey.ubasurvey.entity.householdSurvey.HouseholdSurvey;
import uba.survey.ubasurvey.entity.villageSurvey.*;
import uba.survey.ubasurvey.exceptions.APIException;
import uba.survey.ubasurvey.repository.householdSurvey.AppliancesUsedRepo;
import uba.survey.ubasurvey.repository.householdSurvey.CropDetailsRepo;
import uba.survey.ubasurvey.repository.householdSurvey.FamilyMemberRepo;
import uba.survey.ubasurvey.repository.householdSurvey.HouseholdSurveyRepo;
import uba.survey.ubasurvey.repository.villageSurvey.*;
import uba.survey.ubasurvey.specifications.HouseholdSurveySpecification;
import uba.survey.ubasurvey.specifications.VillageSurveySpecification;

import java.util.*;
import java.util.List;
import java.util.Comparator;

@Service
@RequiredArgsConstructor

public class SurveyServices {
    private final CommunityHallRepo communityHallRepo;
    private final DharamashalaRepo dharamashalaRepo;
    private final DispensaryRepo dispensaryRepo;
    private final OtherAreasRepo otherAreasRepo;
    private final PanchayatOfficeRepo panchayatOfficeRepo;
    private final SocialOrganisationsRepo socialOrganisationsRepo;
    private final TrainingProductionCentresRepo trainingProductionCentresRepo;
    private final VillageSurveyRepo villageSurveyRepo;
    private final AppliancesUsedRepo appliancesUsedRepo;
    private final CropDetailsRepo cropDetailsRepo;
    private final FamilyMemberRepo familyMemberRepo;
    private final HouseholdSurveyRepo householdSurveyRepo;

    private final ExcelService<VillageSurveyRequest> villageRequestExcelService;
    private final ExcelService<HouseholdRequest> householdSurveyExcelService;

    public String handleVillageSurvey(VillageSurveyRequest villageSurveyRequest) {
        VillageSurvey villageSurvey = new VillageSurvey();
        villageSurvey.setSurveyorName(villageSurveyRequest.getSurveyorName());
        villageSurvey.setRespondentName(villageSurveyRequest.getRespondentName());
        villageSurvey.setDateOfSurvey(new Date());
        villageSurvey.setVillageId(villageSurveyRequest.getVillageId());
        villageSurvey.setNameOfTheVillage(villageSurveyRequest.getNameOfTheVillage());
        villageSurvey.setGramPanchayat(villageSurveyRequest.getGramPanchayat());
        villageSurvey.setNumberOfWards(villageSurveyRequest.getNumberOfWards());
        villageSurvey.setNumberOfHamlets(villageSurveyRequest.getNumberOfHamlets());
        villageSurvey.setBlock(villageSurveyRequest.getBlock());
        villageSurvey.setDistrict(villageSurveyRequest.getDistrict());
        villageSurvey.setState(villageSurveyRequest.getState());
        villageSurvey.setLokSabhaConstituency(villageSurveyRequest.getLokSabhaConstituency());
        villageSurvey.setDistanceFromDistrictHQ(villageSurveyRequest.getDistanceFromDistrictHQ());
        villageSurvey.setAreaOfVillageAcres(villageSurveyRequest.getAreaOfVillageAcres());
        villageSurvey.setArableLandAgricultureAreaAcres(villageSurveyRequest.getArableLandAgricultureAreaAcres());
        villageSurvey.setForestAreaAcre(villageSurveyRequest.getForestAreaAcre());
        villageSurvey.setHousingAbadiAreaAcres(villageSurveyRequest.getHousingAbadiAreaAcres());
        villageSurvey.setAreaUnderWaterBodiesAcres(villageSurveyRequest.getAreaUnderWaterBodiesAcres());
        villageSurvey.setCommonLandsAreaAcres(villageSurveyRequest.getCommonLandsAreaAcres());
        villageSurvey.setAveragePerCapitaLandHoldingAcre(villageSurveyRequest.getAveragePerCapitaLandHoldingAcre());
        villageSurvey.setWasteLandAcres(villageSurveyRequest.getWasteLandAcres());
        villageSurvey.setWaterTableFeet(villageSurveyRequest.getWaterTableFeet());

// ... (previous code)

// 2.a) Primary Schools (Govt.) located in Village
        villageSurvey.setPrimarySchoolsGovtLocatedInVillage(villageSurveyRequest.getPrimarySchoolsGovtLocatedInVillage());
        villageSurvey.setPrimarySchoolsGovtNumbersInsideVillage(villageSurveyRequest.getPrimarySchoolsGovtNumbersInsideVillage());
        villageSurvey.setPrimarySchoolsGovtDistanceOutsideNearestCentre(villageSurveyRequest.getPrimarySchoolsGovtDistanceOutsideNearestCentre());

// 2.b) Primary Schools (Private) located in village
        villageSurvey.setPrimarySchoolsPrivateLocatedInVillage(villageSurveyRequest.getPrimarySchoolsPrivateLocatedInVillage());
        villageSurvey.setPrimarySchoolsPrivateNumbersInsideVillage(villageSurveyRequest.getPrimarySchoolsPrivateNumbersInsideVillage());
        villageSurvey.setPrimarySchoolsPrivateDistanceOutsideNearestCentre(villageSurveyRequest.getPrimarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.c) Middle Schools (Govt.) located in village
        villageSurvey.setMiddleSchoolsGovtLocatedInVillage(villageSurveyRequest.getMiddleSchoolsGovtLocatedInVillage());
        villageSurvey.setMiddleSchoolsGovtNumbersInsideVillage(villageSurveyRequest.getMiddleSchoolsGovtNumbersInsideVillage());
        villageSurvey.setMiddleSchoolsGovtDistanceOutsideNearestCentre(villageSurveyRequest.getMiddleSchoolsGovtDistanceOutsideNearestCentre());

// 2.d) Middle Schools (Private) located in village
        villageSurvey.setMiddleSchoolsPrivateLocatedInVillage(villageSurveyRequest.getMiddleSchoolsPrivateLocatedInVillage());
        villageSurvey.setMiddleSchoolsPrivateNumbersInsideVillage(villageSurveyRequest.getMiddleSchoolsPrivateNumbersInsideVillage());
        villageSurvey.setMiddleSchoolsPrivateDistanceOutsideNearestCentre(villageSurveyRequest.getMiddleSchoolsPrivateDistanceOutsideNearestCentre());

// 2.e) Secondary Schools (Govt.) located in village
        villageSurvey.setSecondarySchoolsGovtLocatedInVillage(villageSurveyRequest.getSecondarySchoolsGovtLocatedInVillage());
        villageSurvey.setSecondarySchoolsGovtNumbersInsideVillage(villageSurveyRequest.getSecondarySchoolsGovtNumbersInsideVillage());
        villageSurvey.setSecondarySchoolsGovtDistanceOutsideNearestCentre(villageSurveyRequest.getSecondarySchoolsGovtDistanceOutsideNearestCentre());

// 2.f) Secondary Schools (Private) located in village
        villageSurvey.setSecondarySchoolsPrivateLocatedInVillage(villageSurveyRequest.getSecondarySchoolsPrivateLocatedInVillage());
        villageSurvey.setSecondarySchoolsPrivateNumbersInsideVillage(villageSurveyRequest.getSecondarySchoolsPrivateNumbersInsideVillage());
        villageSurvey.setSecondarySchoolsPrivateDistanceOutsideNearestCentre(villageSurveyRequest.getSecondarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.g) ITI Diploma Institutes (Govt.) located in village
        villageSurvey.setItiDiplomaInstitutesGovtLocatedInVillage(villageSurveyRequest.getItiDiplomaInstitutesGovtLocatedInVillage());
        villageSurvey.setItiDiplomaInstitutesGovtNumbersInsideVillage(villageSurveyRequest.getItiDiplomaInstitutesGovtNumbersInsideVillage());
        villageSurvey.setItiDiplomaInstitutesGovtDistanceOutsideNearestCentre(villageSurveyRequest.getItiDiplomaInstitutesGovtDistanceOutsideNearestCentre());

// 2.h) ITI Diploma Institutes (Private) located in village
        villageSurvey.setItiDiplomaInstitutesPrivateLocatedInVillage(villageSurveyRequest.getItiDiplomaInstitutesPrivateLocatedInVillage());
        villageSurvey.setItiDiplomaInstitutesPrivateNumbersInsideVillage(villageSurveyRequest.getItiDiplomaInstitutesPrivateNumbersInsideVillage());
        villageSurvey.setItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre(villageSurveyRequest.getItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre());

// 2.i) Colleges (Govt.) located in village
        villageSurvey.setCollegesGovtLocatedInVillage(villageSurveyRequest.getCollegesGovtLocatedInVillage());
        villageSurvey.setCollegesGovtNumbersInsideVillage(villageSurveyRequest.getCollegesGovtNumbersInsideVillage());
        villageSurvey.setCollegesGovtDistanceOutsideNearestCentre(villageSurveyRequest.getCollegesGovtDistanceOutsideNearestCentre());

// 2.j) Colleges (Private) located in village
        villageSurvey.setCollegesPrivateLocatedInVillage(villageSurveyRequest.getCollegesPrivateLocatedInVillage());
        villageSurvey.setCollegesPrivateNumbersInsideVillage(villageSurveyRequest.getCollegesPrivateNumbersInsideVillage());
        villageSurvey.setCollegesPrivateDistanceOutsideNearestCentre(villageSurveyRequest.getCollegesPrivateDistanceOutsideNearestCentre());

// 2.k) Banks / ATM located in village
        villageSurvey.setBanksAtmLocatedInVillage(villageSurveyRequest.getBanksAtmLocatedInVillage());
        villageSurvey.setBanksInsideVillageNumbers(villageSurveyRequest.getBanksInsideVillageNumbers());
        villageSurvey.setAtmInsideVillageNumbers(villageSurveyRequest.getAtmInsideVillageNumbers());
        villageSurvey.setBanksAtmDistanceOutsideNearestCentre(villageSurveyRequest.getBanksAtmDistanceOutsideNearestCentre());

// 2.l) Primary Health Centres located in village
        villageSurvey.setPrimaryHealthCentresLocatedInVillage(villageSurveyRequest.getPrimaryHealthCentresLocatedInVillage());
        villageSurvey.setPrimaryHealthCentresNumbersInsideVillage(villageSurveyRequest.getPrimaryHealthCentresNumbersInsideVillage());
        villageSurvey.setPrimaryHealthCentresDistanceOutsideNearestCentre(villageSurveyRequest.getPrimaryHealthCentresDistanceOutsideNearestCentre());

// 2.m) Civil Hospital located in village
        villageSurvey.setCivilHospitalLocatedInVillage(villageSurveyRequest.getCivilHospitalLocatedInVillage());
        villageSurvey.setCivilHospitalNumbersInsideVillage(villageSurveyRequest.getCivilHospitalNumbersInsideVillage());
        villageSurvey.setCivilHospitalDistanceOutsideNearestCentre(villageSurveyRequest.getCivilHospitalDistanceOutsideNearestCentre());

// 2.n) SHG’s in village
        villageSurvey.setShgsInVillage(villageSurveyRequest.getShgsInVillage());
        villageSurvey.setShgsNumbersInsideVillage(villageSurveyRequest.getShgsNumbersInsideVillage());
        villageSurvey.setShgsDistanceOutsideNearestCentre(villageSurveyRequest.getShgsDistanceOutsideNearestCentre());

// 2.o) NGO’s in village
        villageSurvey.setNgosInVillage(villageSurveyRequest.getNgosInVillage());
        villageSurvey.setNgosNumbersInsideVillage(villageSurveyRequest.getNgosNumbersInsideVillage());
        villageSurvey.setNgosDistanceOutsideNearestCentre(villageSurveyRequest.getNgosDistanceOutsideNearestCentre());

// 2.p) Jan Aushadhi Yojana Kendra located in village
        villageSurvey.setJanAushadhiYojanaKendraLocatedInVillage(villageSurveyRequest.getJanAushadhiYojanaKendraLocatedInVillage());
        villageSurvey.setJanAushadhiYojanaKendraNumbersInsideVillage(villageSurveyRequest.getJanAushadhiYojanaKendraNumbersInsideVillage());
        villageSurvey.setJanAushadhiYojanaKendraDistanceOutsideNearestCentre(villageSurveyRequest.getJanAushadhiYojanaKendraDistanceOutsideNearestCentre());

// 2.q) Post Office located in village
        villageSurvey.setPostOfficeLocatedInVillage(villageSurveyRequest.getPostOfficeLocatedInVillage());
        villageSurvey.setPostOfficeNumbersInsideVillage(villageSurveyRequest.getPostOfficeNumbersInsideVillage());
        villageSurvey.setPostOfficeDistanceOutsideNearestCentre(villageSurveyRequest.getPostOfficeDistanceOutsideNearestCentre());

// 2.r) Gas agencies located in village
        villageSurvey.setGasAgenciesLocatedInVillage(villageSurveyRequest.getGasAgenciesLocatedInVillage());
        villageSurvey.setGasAgenciesNumbersInsideVillage(villageSurveyRequest.getGasAgenciesNumbersInsideVillage());
        villageSurvey.setGasAgenciesDistanceOutsideNearestCentre(villageSurveyRequest.getGasAgenciesDistanceOutsideNearestCentre());

// 2.s) Training Centres located in village
        villageSurvey.setTrainingCentresLocatedInVillage(villageSurveyRequest.getTrainingCentresLocatedInVillage());
        villageSurvey.setTrainingCentresName(villageSurveyRequest.getTrainingCentresName());
        villageSurvey.setTrainingCentresNumbersInsideVillage(villageSurveyRequest.getTrainingCentresNumbersInsideVillage());
        villageSurvey.setTrainingCentresDistanceOutsideNearestCentre(villageSurveyRequest.getTrainingCentresDistanceOutsideNearestCentre());

// 2.t) Electricity Office located in village
        villageSurvey.setElectricityOfficeLocatedInVillage(villageSurveyRequest.getElectricityOfficeLocatedInVillage());
        villageSurvey.setElectricityOfficeNumbersInsideVillage(villageSurveyRequest.getElectricityOfficeNumbersInsideVillage());
        villageSurvey.setElectricityOfficeDistanceOutsideNearestCentre(villageSurveyRequest.getElectricityOfficeDistanceOutsideNearestCentre());

// 2.u) Anganwadi Kendra located in village
        villageSurvey.setAnganwadiKendraLocatedInVillage(villageSurveyRequest.getAnganwadiKendraLocatedInVillage());
        villageSurvey.setAnganwadiKendraNumbersInsideVillage(villageSurveyRequest.getAnganwadiKendraNumbersInsideVillage());
        villageSurvey.setAnganwadiKendraDistanceOutsideNearestCentre(villageSurveyRequest.getAnganwadiKendraDistanceOutsideNearestCentre());

// 2.v) Petrol Pumps in village
        villageSurvey.setPetrolPumpsInVillage(villageSurveyRequest.getPetrolPumpsInVillage());
        villageSurvey.setPetrolPumpsNumbersInsideVillage(villageSurveyRequest.getPetrolPumpsNumbersInsideVillage());
        villageSurvey.setPetrolPumpsDistanceOutsideNearestCentre(villageSurveyRequest.getPetrolPumpsDistanceOutsideNearestCentre());

// 2.w) Kisan Sewa Kendra in village
        villageSurvey.setKisanSewaKendraInVillage(villageSurveyRequest.getKisanSewaKendraInVillage());
        villageSurvey.setKisanSewaKendraNumbersInsideVillage(villageSurveyRequest.getKisanSewaKendraNumbersInsideVillage());
        villageSurvey.setKisanSewaKendraDistanceOutsideNearestCentre(villageSurveyRequest.getKisanSewaKendraDistanceOutsideNearestCentre());

// 2.x) Krishi Mandi in village
        villageSurvey.setKrishiMandiInVillage(villageSurveyRequest.getKrishiMandiInVillage());
        villageSurvey.setKrishiMandiNumbersInsideVillage(villageSurveyRequest.getKrishiMandiNumbersInsideVillage());
        villageSurvey.setKrishiMandiDistanceOutsideNearestCentre(villageSurveyRequest.getKrishiMandiDistanceOutsideNearestCentre());

// 2.y) Fare Price Shop in village
        villageSurvey.setFarePriceShopInVillage(villageSurveyRequest.getFarePriceShopInVillage());
        villageSurvey.setFarePriceShopNumbersInsideVillage(villageSurveyRequest.getFarePriceShopNumbersInsideVillage());
        villageSurvey.setFarePriceShopDistanceOutsideNearestCentre(villageSurveyRequest.getFarePriceShopDistanceOutsideNearestCentre());

// 2.z) Milk Cooperative/Collection Centre in village
        villageSurvey.setMilkCooperativeInVillage(villageSurveyRequest.getMilkCooperativeInVillage());
        villageSurvey.setMilkCooperativeNumbersInsideVillage(villageSurveyRequest.getMilkCooperativeNumbersInsideVillage());
        villageSurvey.setMilkCooperativeDistanceOutsideNearestCentre(villageSurveyRequest.getMilkCooperativeDistanceOutsideNearestCentre());

// 2.aa) Railway Station in village
        villageSurvey.setRailwayStationInVillage(villageSurveyRequest.getRailwayStationInVillage());
        villageSurvey.setRailwayStationNumbersInsideVillage(villageSurveyRequest.getRailwayStationNumbersInsideVillage());
        villageSurvey.setRailwayStationDistanceOutsideNearestCentre(villageSurveyRequest.getRailwayStationDistanceOutsideNearestCentre());

// 2.ab) Bus Stop in village
        villageSurvey.setBusStopInVillage(villageSurveyRequest.getBusStopInVillage());
        villageSurvey.setBusStopNumbersInsideVillage(villageSurveyRequest.getBusStopNumbersInsideVillage());
        villageSurvey.setBusStopDistanceOutsideNearestCentre(villageSurveyRequest.getBusStopDistanceOutsideNearestCentre());

// 2.ac) Veterinary Care Centre in village
        villageSurvey.setVeterinaryCareCentreInVillage(villageSurveyRequest.getVeterinaryCareCentreInVillage());
        villageSurvey.setVeterinaryCareCentreNumbersInsideVillage(villageSurveyRequest.getVeterinaryCareCentreNumbersInsideVillage());
        villageSurvey.setVeterinaryCareCentreDistanceOutsideNearestCentre(villageSurveyRequest.getVeterinaryCareCentreDistanceOutsideNearestCentre());

// 2.ad) Sports Facility/Grounds in village
        villageSurvey.setSportsFacilityInVillage(villageSurveyRequest.getSportsFacilityInVillage());
        villageSurvey.setSportsFacilityNumbersInsideVillage(villageSurveyRequest.getSportsFacilityNumbersInsideVillage());
        villageSurvey.setSportsFacilityDistanceOutsideNearestCentre(villageSurveyRequest.getSportsFacilityDistanceOutsideNearestCentre());

// 2.ae) Number of common sanitation complexes in village
        villageSurvey.setCommonSanitationComplexesInVillage(villageSurveyRequest.getCommonSanitationComplexesInVillage());
        villageSurvey.setCommonSanitationComplexesNumbersInsideVillage(villageSurveyRequest.getCommonSanitationComplexesNumbersInsideVillage());
        villageSurvey.setCommonSanitationComplexesDistanceOutsideNearestCentre(villageSurveyRequest.getCommonSanitationComplexesDistanceOutsideNearestCentre());

// 3. Village Connectivity (Roads)
// 3.a) Distance of the Village from the nearest Highway/Major Dist. Road (in km)
        villageSurvey.setDistanceFromNearestHighway(villageSurveyRequest.getDistanceFromNearestHighway());

// 3.b) Is the village connected to the above by a pacca road?
        villageSurvey.setVillageConnectedByPaccaRoad(villageSurveyRequest.getVillageConnectedByPaccaRoad());

// If yes, details of the Approach Road/Connecting Road
// 3.b.i) Length of the Road (in km)
        villageSurvey.setPaccaRoadLength(villageSurveyRequest.getPaccaRoadLength());

// 3.b.ii) Year of construction
        villageSurvey.setPaccaRoadYearOfConstruction(villageSurveyRequest.getPaccaRoadYearOfConstruction());

// 3.b.iii) Scheme under which constructed
        villageSurvey.setPaccaRoadConstructionScheme(villageSurveyRequest.getPaccaRoadConstructionScheme());

// 3.b.iv) Present Status (complete/incomplete)
        villageSurvey.setPaccaRoadStatus(villageSurveyRequest.getPaccaRoadStatus());

// 3.c) Length of Internal roads (inside village/hamlets)
// i) kachha (kms) ii) pakka (kms) iii) Total (kms)
        villageSurvey.setIntegerernalRoadsKachhaLength(villageSurveyRequest.getIntegerernalRoadsKachhaLength());
        villageSurvey.setIntegerernalRoadsPakkaLength(villageSurveyRequest.getIntegerernalRoadsPakkaLength());
        villageSurvey.setIntegerernalRoadsTotalLength(villageSurveyRequest.getIntegerernalRoadsTotalLength());

// 3.d) What is the mode of transport available?
        villageSurvey.setModeOfTransport(villageSurveyRequest.getModeOfTransport());

// If any other mode of transport, then specify
        villageSurvey.setOtherModeOfTransport(villageSurveyRequest.getOtherModeOfTransport());

// 3.e) Frequency of the available mode of transport
// Frequent Not Frequent only two times a day Any other
        villageSurvey.setTransportFrequency(villageSurveyRequest.getTransportFrequency());
        villageSurvey.setOtherTransportFrequency(villageSurveyRequest.getOtherTransportFrequency());

// 4. Land, Forest & Horticultural Profile
// 4.a) Type of Forest
        villageSurvey.setTypeOfForest(villageSurveyRequest.getTypeOfForest());

// 4.b) Community Forest (Acre)
        villageSurvey.setCommunityForestAcre(villageSurveyRequest.getCommunityForestAcre());

// 4.c) Government Forest (Acre)
        villageSurvey.setGovernmentForestAcre(villageSurveyRequest.getGovernmentForestAcre());

// 4.d) Main Forest Trees and Shrub Species
        villageSurvey.setMainForestTreesAndShrubSpecies(villageSurveyRequest.getMainForestTreesAndShrubSpecies());

// 4.e) Energy Plantation
        villageSurvey.setEnergyPlantation(villageSurveyRequest.getEnergyPlantation());

// If Yes, which species (Top 3) and area (in acre)
        villageSurvey.setEnergyPlantationSpeciesTop1(villageSurveyRequest.getEnergyPlantationSpeciesTop1());
        villageSurvey.setEnergyPlantationAreaTop1(villageSurveyRequest.getEnergyPlantationAreaTop1());
        villageSurvey.setEnergyPlantationSpeciesTop2(villageSurveyRequest.getEnergyPlantationSpeciesTop2());
        villageSurvey.setEnergyPlantationAreaTop2(villageSurveyRequest.getEnergyPlantationAreaTop2());
        villageSurvey.setEnergyPlantationSpeciesTop3(villageSurveyRequest.getEnergyPlantationSpeciesTop3());
        villageSurvey.setEnergyPlantationAreaTop3(villageSurveyRequest.getEnergyPlantationAreaTop3());

        villageSurvey.setStreetLightCFLLED(villageSurveyRequest.getStreetLightCFLLED());
        villageSurvey.setStreetLightCFLLEDDuration(villageSurveyRequest.getStreetLightCFLLEDDuration());
        villageSurvey.setStreetLightTubeLight(villageSurveyRequest.getStreetLightTubeLight());
        villageSurvey.setStreetLightTubeLightDuration(villageSurveyRequest.getStreetLightTubeLightDuration());



        villageSurvey.setComments(villageSurveyRequest.getComments());

//5 a
// Initialize PanchayatOffice object
        PanchayatOffice panchayatOffice = new PanchayatOffice();

// Set values for Electrical Appliances in Panchayat office
        panchayatOffice.setCflLed(villageSurveyRequest.getPanchayatOfficeCflLed());
        panchayatOffice.setFan(villageSurveyRequest.getPanchayatOfficeFan());
        panchayatOffice.setDesertCooler(villageSurveyRequest.getPanchayatOfficeDesertCooler());
        panchayatOffice.setTv(villageSurveyRequest.getPanchayatOfficeTv());
        panchayatOffice.setRefrigerator(villageSurveyRequest.getPanchayatOfficeRefrigerator());
        panchayatOffice.setMusicSystem(villageSurveyRequest.getPanchayatOfficeMusicSystem());
        panchayatOffice.setElectricMotorPump(villageSurveyRequest.getPanchayatOfficeElectricMotorPump());
        panchayatOffice.setHeater(villageSurveyRequest.getPanchayatOfficeHeater());
        panchayatOffice.setElectricIron(villageSurveyRequest.getPanchayatOfficeElectricIron());
        panchayatOffice.setAirConditioner(villageSurveyRequest.getPanchayatOfficeAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Panchayat office
        panchayatOffice.setCflLedDuration(villageSurveyRequest.getPanchayatOfficeCflLedDuration());
        panchayatOffice.setFanDuration(villageSurveyRequest.getPanchayatOfficeFanDuration());
        panchayatOffice.setDesertCoolerDuration(villageSurveyRequest.getPanchayatOfficeDesertCoolerDuration());
        panchayatOffice.setTvDuration(villageSurveyRequest.getPanchayatOfficeTvDuration());
        panchayatOffice.setRefrigeratorDuration(villageSurveyRequest.getPanchayatOfficeRefrigeratorDuration());
        panchayatOffice.setMusicSystemDuration(villageSurveyRequest.getPanchayatOfficeMusicSystemDuration());
        panchayatOffice.setElectricMotorPumpDuration(villageSurveyRequest.getPanchayatOfficeElectricMotorPumpDuration());
        panchayatOffice.setHeaterDuration(villageSurveyRequest.getPanchayatOfficeHeaterDuration());
        panchayatOffice.setElectricIronDuration(villageSurveyRequest.getPanchayatOfficeElectricIronDuration());
        panchayatOffice.setAirConditionerDuration(villageSurveyRequest.getPanchayatOfficeAirConditionerDuration());
        panchayatOfficeRepo.save(panchayatOffice);
// Initialize Dispensary object
        Dispensary dispensary = new Dispensary();

// Set values for Electrical Appliances in Dispensary
        dispensary.setCflLed(villageSurveyRequest.getDispensaryCflLed());
        dispensary.setFan(villageSurveyRequest.getDispensaryFan());
        dispensary.setDesertCooler(villageSurveyRequest.getDispensaryDesertCooler());
        dispensary.setTv(villageSurveyRequest.getDispensaryTv());
        dispensary.setRefrigerator(villageSurveyRequest.getDispensaryRefrigerator());
        dispensary.setMusicSystem(villageSurveyRequest.getDispensaryMusicSystem());
        dispensary.setElectricMotorPump(villageSurveyRequest.getDispensaryElectricMotorPump());
        dispensary.setHeater(villageSurveyRequest.getDispensaryHeater());
        dispensary.setElectricIron(villageSurveyRequest.getDispensaryElectricIron());
        dispensary.setAirConditioner(villageSurveyRequest.getDispensaryAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dispensary
        dispensary.setCflLedDuration(villageSurveyRequest.getDispensaryCflLedDuration());
        dispensary.setFanDuration(villageSurveyRequest.getDispensaryFanDuration());
        dispensary.setDesertCoolerDuration(villageSurveyRequest.getDispensaryDesertCoolerDuration());
        dispensary.setTvDuration(villageSurveyRequest.getDispensaryTvDuration());
        dispensary.setRefrigeratorDuration(villageSurveyRequest.getDispensaryRefrigeratorDuration());
        dispensary.setMusicSystemDuration(villageSurveyRequest.getDispensaryMusicSystemDuration());
        dispensary.setElectricMotorPumpDuration(villageSurveyRequest.getDispensaryElectricMotorPumpDuration());
        dispensary.setHeaterDuration(villageSurveyRequest.getDispensaryHeaterDuration());
        dispensary.setElectricIronDuration(villageSurveyRequest.getDispensaryElectricIronDuration());
        dispensary.setAirConditionerDuration(villageSurveyRequest.getDispensaryAirConditionerDuration());
        dispensaryRepo.save(dispensary);
// Initialize CommunityHall object
        CommunityHall communityHall = new CommunityHall();

// Set values for Electrical Appliances in Community Hall
        communityHall.setCflLed(villageSurveyRequest.getCommunityHallCflLed());
        communityHall.setFan(villageSurveyRequest.getCommunityHallFan());
        communityHall.setDesertCooler(villageSurveyRequest.getCommunityHallDesertCooler());
        communityHall.setTv(villageSurveyRequest.getCommunityHallTv());
        communityHall.setRefrigerator(villageSurveyRequest.getCommunityHallRefrigerator());
        communityHall.setMusicSystem(villageSurveyRequest.getCommunityHallMusicSystem());
        communityHall.setElectricMotorPump(villageSurveyRequest.getCommunityHallElectricMotorPump());
        communityHall.setHeater(villageSurveyRequest.getCommunityHallHeater());
        communityHall.setElectricIron(villageSurveyRequest.getCommunityHallElectricIron());
        communityHall.setAirConditioner(villageSurveyRequest.getCommunityHallAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Community Hall
        communityHall.setCflLedDuration(villageSurveyRequest.getCommunityHallCflLedDuration());
        communityHall.setFanDuration(villageSurveyRequest.getCommunityHallFanDuration());
        communityHall.setDesertCoolerDuration(villageSurveyRequest.getCommunityHallDesertCoolerDuration());
        communityHall.setTvDuration(villageSurveyRequest.getCommunityHallTvDuration());
        communityHall.setRefrigeratorDuration(villageSurveyRequest.getCommunityHallRefrigeratorDuration());
        communityHall.setMusicSystemDuration(villageSurveyRequest.getCommunityHallMusicSystemDuration());
        communityHall.setElectricMotorPumpDuration(villageSurveyRequest.getCommunityHallElectricMotorPumpDuration());
        communityHall.setHeaterDuration(villageSurveyRequest.getCommunityHallHeaterDuration());
        communityHall.setElectricIronDuration(villageSurveyRequest.getCommunityHallElectricIronDuration());
        communityHall.setAirConditionerDuration(villageSurveyRequest.getCommunityHallAirConditionerDuration());
        communityHallRepo.save(communityHall);
// Return a message or perform further actions
// Initialize Dharamashala object
        Dharamashala dharamashala = new Dharamashala();

// Set values for Electrical Appliances in Dharamashala
        dharamashala.setCflLed(villageSurveyRequest.getDharamashalaCflLed());
        dharamashala.setFan(villageSurveyRequest.getDharamashalaFan());
        dharamashala.setDesertCooler(villageSurveyRequest.getDharamashalaDesertCooler());
        dharamashala.setTv(villageSurveyRequest.getDharamashalaTv());
        dharamashala.setRefrigerator(villageSurveyRequest.getDharamashalaRefrigerator());
        dharamashala.setMusicSystem(villageSurveyRequest.getDharamashalaMusicSystem());
        dharamashala.setElectricMotorPump(villageSurveyRequest.getDharamashalaElectricMotorPump());
        dharamashala.setHeater(villageSurveyRequest.getDharamashalaHeater());
        dharamashala.setElectricIron(villageSurveyRequest.getDharamashalaElectricIron());
        dharamashala.setAirConditioner(villageSurveyRequest.getDharamashalaAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dharamashala
        dharamashala.setCflLedDuration(villageSurveyRequest.getDharamashalaCflLedDuration());
        dharamashala.setFanDuration(villageSurveyRequest.getDharamashalaFanDuration());
        dharamashala.setDesertCoolerDuration(villageSurveyRequest.getDharamashalaDesertCoolerDuration());
        dharamashala.setTvDuration(villageSurveyRequest.getDharamashalaTvDuration());
        dharamashala.setRefrigeratorDuration(villageSurveyRequest.getDharamashalaRefrigeratorDuration());
        dharamashala.setMusicSystemDuration(villageSurveyRequest.getDharamashalaMusicSystemDuration());
        dharamashala.setElectricMotorPumpDuration(villageSurveyRequest.getDharamashalaElectricMotorPumpDuration());
        dharamashala.setHeaterDuration(villageSurveyRequest.getDharamashalaHeaterDuration());
        dharamashala.setElectricIronDuration(villageSurveyRequest.getDharamashalaElectricIronDuration());
        dharamashala.setAirConditionerDuration(villageSurveyRequest.getDharamashalaAirConditionerDuration());
        dharamashalaRepo.save(dharamashala);
// Similar initialization for other categories (Social Organisations, Training cum Production Centres, Other Areas)

// Initialize SocialOrganisations object
        SocialOrganisations socialOrganisations = new SocialOrganisations();
// Set values for Electrical Appliances in Social Organisations
        socialOrganisations.setCflLed(villageSurveyRequest.getSocialOrganisationsCflLed());
        socialOrganisations.setFan(villageSurveyRequest.getSocialOrganisationsFan());
        socialOrganisations.setDesertCooler(villageSurveyRequest.getSocialOrganisationsDesertCooler());
        socialOrganisations.setTv(villageSurveyRequest.getSocialOrganisationsTv());
        socialOrganisations.setRefrigerator(villageSurveyRequest.getSocialOrganisationsRefrigerator());
        socialOrganisations.setMusicSystem(villageSurveyRequest.getSocialOrganisationsMusicSystem());
        socialOrganisations.setElectricMotorPump(villageSurveyRequest.getSocialOrganisationsElectricMotorPump());
        socialOrganisations.setHeater(villageSurveyRequest.getSocialOrganisationsHeater());
        socialOrganisations.setElectricIron(villageSurveyRequest.getSocialOrganisationsElectricIron());
        socialOrganisations.setAirConditioner(villageSurveyRequest.getSocialOrganisationsAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Social Organisations
        socialOrganisations.setCflLedDuration(villageSurveyRequest.getSocialOrganisationsCflLedDuration());
        socialOrganisations.setFanDuration(villageSurveyRequest.getSocialOrganisationsFanDuration());
        socialOrganisations.setDesertCoolerDuration(villageSurveyRequest.getSocialOrganisationsDesertCoolerDuration());
        socialOrganisations.setTvDuration(villageSurveyRequest.getSocialOrganisationsTvDuration());
        socialOrganisations.setRefrigeratorDuration(villageSurveyRequest.getSocialOrganisationsRefrigeratorDuration());
        socialOrganisations.setMusicSystemDuration(villageSurveyRequest.getSocialOrganisationsMusicSystemDuration());
        socialOrganisations.setElectricMotorPumpDuration(villageSurveyRequest.getSocialOrganisationsElectricMotorPumpDuration());
        socialOrganisations.setHeaterDuration(villageSurveyRequest.getSocialOrganisationsHeaterDuration());
        socialOrganisations.setElectricIronDuration(villageSurveyRequest.getSocialOrganisationsElectricIronDuration());
        socialOrganisations.setAirConditionerDuration(villageSurveyRequest.getSocialOrganisationsAirConditionerDuration());
        socialOrganisationsRepo.save(socialOrganisations);
// Initialize Tpc object
// Initialize TrainingProductionCentres object
        TrainingProductionCentres tpc = new TrainingProductionCentres();

// Set values for Electrical Appliances in Training cum Production Centres
        tpc.setCflLed(villageSurveyRequest.getTpcCflLed());
        tpc.setFan(villageSurveyRequest.getTpcFan());
        tpc.setDesertCooler(villageSurveyRequest.getTpcDesertCooler());
        tpc.setTv(villageSurveyRequest.getTpcTv());
        tpc.setRefrigerator(villageSurveyRequest.getTpcRefrigerator());
        tpc.setMusicSystem(villageSurveyRequest.getTpcMusicSystem());
        tpc.setElectricMotorPump(villageSurveyRequest.getTpcElectricMotorPump());
        tpc.setHeater(villageSurveyRequest.getTpcHeater());
        tpc.setElectricIron(villageSurveyRequest.getTpcElectricIron());
        tpc.setAirConditioner(villageSurveyRequest.getTpcAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Training cum Production Centres
        tpc.setCflLedDuration(villageSurveyRequest.getTpcCflLedDuration());
        tpc.setFanDuration(villageSurveyRequest.getTpcFanDuration());
        tpc.setDesertCoolerDuration(villageSurveyRequest.getTpcDesertCoolerDuration());
        tpc.setTvDuration(villageSurveyRequest.getTpcTvDuration());
        tpc.setRefrigeratorDuration(villageSurveyRequest.getTpcRefrigeratorDuration());
        tpc.setMusicSystemDuration(villageSurveyRequest.getTpcMusicSystemDuration());
        tpc.setElectricMotorPumpDuration(villageSurveyRequest.getTpcElectricMotorPumpDuration());
        tpc.setHeaterDuration(villageSurveyRequest.getTpcHeaterDuration());
        tpc.setElectricIronDuration(villageSurveyRequest.getTpcElectricIronDuration());
        tpc.setAirConditionerDuration(villageSurveyRequest.getTpcAirConditionerDuration());
        trainingProductionCentresRepo.save(tpc);
        // Initialize OtherAreas object
        OtherAreas otherAreas = new OtherAreas();

        // Set values for Electrical Appliances in Other Areas

        otherAreas.setCflLed(villageSurveyRequest.getOtherAreasCflLed());
        otherAreas.setFan(villageSurveyRequest.getOtherAreasFan());
        otherAreas.setDesertCooler(villageSurveyRequest.getOtherAreasDesertCooler());
        otherAreas.setTv(villageSurveyRequest.getOtherAreasTv());
        otherAreas.setRefrigerator(villageSurveyRequest.getOtherAreasRefrigerator());
        otherAreas.setMusicSystem(villageSurveyRequest.getOtherAreasMusicSystem());
        otherAreas.setElectricMotorPump(villageSurveyRequest.getOtherAreasElectricMotorPump());
        otherAreas.setHeater(villageSurveyRequest.getOtherAreasHeater());
        otherAreas.setElectricIron(villageSurveyRequest.getOtherAreasElectricIron());
        otherAreas.setAirConditioner(villageSurveyRequest.getOtherAreasAirConditioner());

        // Set values for Working duration/day (in hours) of Electrical Appliances in Other Areas
        otherAreas.setCflLedDuration(villageSurveyRequest.getOtherAreasCflLedDuration());
        otherAreas.setFanDuration(villageSurveyRequest.getOtherAreasFanDuration());
        otherAreas.setDesertCoolerDuration(villageSurveyRequest.getOtherAreasDesertCoolerDuration());
        otherAreas.setTvDuration(villageSurveyRequest.getOtherAreasTvDuration());
        otherAreas.setRefrigeratorDuration(villageSurveyRequest.getOtherAreasRefrigeratorDuration());
        otherAreas.setMusicSystemDuration(villageSurveyRequest.getOtherAreasMusicSystemDuration());
        otherAreas.setElectricMotorPumpDuration(villageSurveyRequest.getOtherAreasElectricMotorPumpDuration());
        otherAreas.setHeaterDuration(villageSurveyRequest.getOtherAreasHeaterDuration());
        otherAreas.setElectricIronDuration(villageSurveyRequest.getOtherAreasElectricIronDuration());
        otherAreas.setAirConditionerDuration(villageSurveyRequest.getOtherAreasAirConditionerDuration());
        otherAreasRepo.save(otherAreas);

        villageSurvey.setPanchayatOfficeId(panchayatOffice.getId());
        villageSurvey.setDispensaryId(dispensary.getId());
        villageSurvey.setDharamashalaId(dharamashala.getId());
        villageSurvey.setTPCId(tpc.getId());
        villageSurvey.setCommunityHallId(communityHall.getId());
        villageSurvey.setOtherAreasElectricalAppliances(villageSurveyRequest.getOtherAreasElectricalAppliances());

        villageSurvey.setOtherAreasId(otherAreas.getId());
        villageSurvey.setSocialOrganisationsId(socialOrganisations.getId());

        villageSurveyRepo.save(villageSurvey);
        return "VillageSurvey object initialized successfully.";
    }

    public String handleHouseholdSurvey(HouseholdRequest householdRequest) {
        // Assuming householdRequest is an instance of HouseholdRequest

        HouseholdSurvey householdSurvey = new HouseholdSurvey();

// Set values for members of the household req DTO
        householdSurvey.setFilledByName(householdRequest.getFilledByName());
        householdSurvey.setDateOfSurvey(new Date());

// Set values for General Information
        householdSurvey.setVillage(householdRequest.getVillage());
        householdSurvey.setGramPanchayat(householdRequest.getGramPanchayat());
        householdSurvey.setWardNo(householdRequest.getWardNo());
        householdSurvey.setBlock(householdRequest.getBlock());
        householdSurvey.setDistrict(householdRequest.getDistrict());
        householdSurvey.setState(householdRequest.getState());

// Set values for Respondent’s Profile
        householdSurvey.setRespondentName(householdRequest.getRespondentName());
        householdSurvey.setGender(householdRequest.getGender());
        householdSurvey.setAge(householdRequest.getAge());
        householdSurvey.setRelationshipWithHead(householdRequest.getRelationshipWithHead());
        householdSurvey.setContactNumber(householdRequest.getContactNumber());

// Set values for General Household Information
        householdSurvey.setHeadOfHouseholdName(householdRequest.getHeadOfHouseholdName());
        householdSurvey.setHeadGender(householdRequest.getHeadGender());
        householdSurvey.setNumberOfFamilyMembers(householdRequest.getNumberOfFamilyMembers());
        householdSurvey.setCategory(householdRequest.getCategory());
        householdSurvey.setPovertyStatus(householdRequest.getPovertyStatus());
        householdSurvey.setOwnHouse(householdRequest.getOwnHouse());
        householdSurvey.setTypeOfHouse(householdRequest.getTypeOfHouse());
        householdSurvey.setToilet(householdRequest.getToilet());
        householdSurvey.setDrainageLinkedToHouse(householdRequest.getDrainageLinkedToHouse());
        householdSurvey.setWasteCollectionSystem(householdRequest.getWasteCollectionSystem());
        householdSurvey.setCompostPit(householdRequest.getCompostPit());
        householdSurvey.setBioGasPlant(householdRequest.getBioGasPlant());

        for (FamilyMemberReq familyMemberReq : householdRequest.getMembers()){
            FamilyMember familyMember = new FamilyMember();

            familyMember.setName(familyMemberReq.getName());
            familyMember.setAge(familyMemberReq.getAge());
            familyMember.setGender(familyMemberReq.getGender());
            familyMember.setEducationLevel(familyMemberReq.getEducationLevel());
            familyMember.setGoingToAWCSchoolCollege(familyMemberReq.getGoingToAWCSchoolCollege());
            familyMember.setAadharCard(familyMemberReq.getAadharCard());
            familyMember.setBankAccount(familyMemberReq.getBankAccount());
            familyMember.setComputerLiterate(familyMemberReq.getComputerLiterate());
            familyMember.setSocialSecurityPension(familyMemberReq.getSocialSecurityPension());
            familyMember.setMajorHealthProblems(familyMemberReq.getMajorHealthProblems());
            familyMember.setMNREGAJobCard(familyMemberReq.getMNREGAJobCard());
            familyMember.setInSelfHelpGroups(familyMemberReq.getInSelfHelpGroups());
            familyMember.setOccupation(familyMemberReq.getOccupation());
            familyMemberRepo.save(familyMember);
            householdSurvey.getMembers().add(familyMember);

        }
// 4. Migration Status in a family
        householdSurvey.setFamilyMigratesForWork(householdRequest.getFamilyMigratesForWork());
        householdSurvey.setNumberOfFamilyMembersMigrated(householdRequest.getNumberOfFamilyMembersMigrated());
        householdSurvey.setFamilyMigrationDuration(householdRequest.getFamilyMigrationDuration());
        householdSurvey.setFamilyMigrationYears(householdRequest.getFamilyMigrationYears());

// 5. Information of Government Schemes
        householdSurvey.setPmJanDhanYojanaBeneficiaryIndividuals(householdRequest.getPmJanDhanYojanaBeneficiaryIndividuals());
        householdSurvey.setSukanyaSamridhiYojanaBeneficiaryIndividuals(householdRequest.getSukanyaSamridhiYojanaBeneficiaryIndividuals());
        householdSurvey.setMudraYojanaBeneficiaryIndividuals(householdRequest.getMudraYojanaBeneficiaryIndividuals());
        householdSurvey.setPmJivanJyotiBimaYojanaBeneficiaryIndividuals(householdRequest.getPmJivanJyotiBimaYojanaBeneficiaryIndividuals());
        householdSurvey.setPmSurakshaBimaYojanaBeneficiaryIndividuals(householdRequest.getPmSurakshaBimaYojanaBeneficiaryIndividuals());
        householdSurvey.setAtalPensionYojanaBeneficiaryIndividuals(householdRequest.getAtalPensionYojanaBeneficiaryIndividuals());
        householdSurvey.setKaushalVikasYojanaBeneficiaryIndividuals(householdRequest.getKaushalVikasYojanaBeneficiaryIndividuals());
        householdSurvey.setJananiSurakshaYojanaBeneficiaryIndividuals(householdRequest.getJananiSurakshaYojanaBeneficiaryIndividuals());
        householdSurvey.setFasalBimaYojanaBeneficiaryHousehold(householdRequest.getFasalBimaYojanaBeneficiaryHousehold());
        householdSurvey.setKisanCreditCardBeneficiaryHousehold(householdRequest.getKisanCreditCardBeneficiaryHousehold());
        householdSurvey.setKrishiSinchaiYojanaBeneficiaryHousehold(householdRequest.getKrishiSinchaiYojanaBeneficiaryHousehold());
        householdSurvey.setSwachhBharatMissionToiletBeneficiaryHousehold(householdRequest.getSwachhBharatMissionToiletBeneficiaryHousehold());
        householdSurvey.setSoilHealthCardBeneficiaryHousehold(householdRequest.getSoilHealthCardBeneficiaryHousehold());
        householdSurvey.setPmUjjwalaYojanaBeneficiaryHousehold(householdRequest.getPmUjjwalaYojanaBeneficiaryHousehold());
        householdSurvey.setPmAwasYojanaBeneficiaryHousehold(householdRequest.getPmAwasYojanaBeneficiaryHousehold());

// 6. Source of Water (Distance from source in km)

        householdSurvey.setPipedWaterAtHome(householdRequest.getPipedWaterAtHome());
        householdSurvey.setDistanceFromPipedWater(householdRequest.getDistanceFromPipedWater());

        householdSurvey.setCommunityWaterTap(householdRequest.getCommunityWaterTap());
        householdSurvey.setDistanceFromCommunityWaterTap(householdRequest.getDistanceFromCommunityWaterTap());

        householdSurvey.setHandPump(householdRequest.getHandPump());
        householdSurvey.setPublic_privateHandPump(householdRequest.getPublic_privateHandPump());
        householdSurvey.setDistanceFromHandPump(householdRequest.getDistanceFromHandPump());

        householdSurvey.setOpenWell(householdRequest.getOpenWell());
        householdSurvey.setPublic_privateOpenWell(householdRequest.getPublic_privateOpenWell());
        householdSurvey.setDistanceFromOpenWell(householdRequest.getDistanceFromOpenWell());

        householdSurvey.setCommunityWaterStorage(householdRequest.getCommunityWaterStorage());
        householdSurvey.setIndividualWaterStorage(householdRequest.getIndividualWaterStorage());

        householdSurvey.setOtherWaterSource(householdRequest.getOtherWaterSource());
        householdSurvey.setOtherWaterSourceName(householdRequest.getOtherWaterSourceName());
        householdSurvey.setDistanceFromOtherWaterSource(householdRequest.getDistanceFromOtherWaterSource());

// 7. Source of Energy and Power

        householdSurvey.setElectricityConnectionToHousehold(householdRequest.getElectricityConnectionToHousehold());

        householdSurvey.setElectricityAvailabilityPerDay(householdRequest.getElectricityAvailabilityPerDay());

        householdSurvey.setLightingSource(householdRequest.getLightingSource());
        householdSurvey.setCookingSource(householdRequest.getCookingSource());
        householdSurvey.setChullahType(householdRequest.getChullahType());
        for (AppliancesUsedReq appliancesUsedReq: householdRequest.getAppliancesAndDuration()){
            AppliancesUsed appliancesUsed = new AppliancesUsed();
            appliancesUsed.setApplianceDuration(appliancesUsedReq.getApplianceDuration());
            appliancesUsed.setApplianceName(appliancesUsedReq.getApplianceName());
            appliancesUsedRepo.save(appliancesUsed);
            householdSurvey.getAppliancesAndDuration().add(appliancesUsed);
        }
        // 8. Land Details
        householdSurvey.setTotalLand(householdRequest.getTotalLand());
        householdSurvey.setCultivableArea(householdRequest.getCultivableArea());
        householdSurvey.setIrrigatedArea(householdRequest.getIrrigatedArea());
        householdSurvey.setUnirrigatedArea(householdRequest.getUnirrigatedArea());
        householdSurvey.setBarrenWastelandArea(householdRequest.getBarrenWastelandArea());
        householdSurvey.setUncultivableArea(householdRequest.getUncultivableArea());

// 9. Agricultural Inputs
        householdSurvey.setUseChemicalFertilizers(householdRequest.getUseChemicalFertilizers());
        householdSurvey.setChemicalFertilizersUsage(householdRequest.getChemicalFertilizersUsage());

        householdSurvey.setUseChemicalInsecticides(householdRequest.getUseChemicalInsecticides());
        householdSurvey.setChemicalInsecticidesUsage(householdRequest.getChemicalInsecticidesUsage());

        householdSurvey.setUseChemicalWeedicide(householdRequest.getUseChemicalWeedicide());
        householdSurvey.setChemicalWeedicideUsage(householdRequest.getChemicalWeedicideUsage());

        householdSurvey.setUseOrganicManures(householdRequest.getUseOrganicManures());
        householdSurvey.setOrganicManuresUsage(householdRequest.getOrganicManuresUsage());

        householdSurvey.setIrrigationSource(householdRequest.getIrrigationSource());
        householdSurvey.setIrrigationSystem(householdRequest.getIrrigationSystem());
        for (CropDetailsReq cropDetailsReq: householdRequest.getCropDetails()){
            CropDetails cropDetails = new CropDetails();
            cropDetails.setAreaUnderCrop(cropDetailsReq.getAreaUnderCrop());
            cropDetails.setCrop(cropDetailsReq.getCrop());
            cropDetails.setProductivityCrop(cropDetailsReq.getProductivityCrop());
            cropDetailsRepo.save(cropDetails);
            householdSurvey.getCropDetails().add(cropDetails);
        }
        // 11. Livestocks
        householdSurvey.setCows(householdRequest.getCows());
        householdSurvey.setBuffalos(householdRequest.getBuffalos());
        householdSurvey.setGoatsSheeps(householdRequest.getGoatsSheeps());
        householdSurvey.setCalves(householdRequest.getCalves());
        householdSurvey.setBullocks(householdRequest.getBullocks());
        householdSurvey.setPoultryDucks(householdRequest.getPoultryDucks());
        householdSurvey.setOthersLivestock(householdRequest.getOthersLivestock());

// 11.2 Shelter for Livestock
        householdSurvey.setShelter(householdRequest.getShelter());

// 11.3 Average Daily Production of Milk (Litres)
        householdSurvey.setAverageDailyMilkProduction(householdRequest.getAverageDailyMilkProduction());

// 11.4 Animal Waste/Cow Dung (in Kg.)
        householdSurvey.setAnimalWasteCowDung(householdRequest.getAnimalWasteCowDung());

// 12. Major problems in the village (Top 3)
        householdSurvey.setTopProblem1(householdRequest.getTopProblem1());
        householdSurvey.setTopProblem2(householdRequest.getTopProblem2());
        householdSurvey.setTopProblem3(householdRequest.getTopProblem3());

// Suggestions for Problems
        householdSurvey.setSuggestionsForProblems(householdRequest.getSuggestionsForProblems());

        householdSurveyRepo.save(householdSurvey);
        return "Houldhold survey Added";
    }

    public VillageSurveyRequest convertVillageToDto(VillageSurvey villageSur){
        VillageSurveyRequest villageSurveyRequest = new VillageSurveyRequest();
        villageSurveyRequest.setSurveyorName(villageSur.getSurveyorName());
        villageSurveyRequest.setRespondentName(villageSur.getRespondentName());
        villageSurveyRequest.setDateOfSurvey(villageSur.getDateOfSurvey());
        villageSurveyRequest.setVillageId(villageSur.getVillageId());
        villageSurveyRequest.setNameOfTheVillage(villageSur.getNameOfTheVillage());
        villageSurveyRequest.setGramPanchayat(villageSur.getGramPanchayat());
        villageSurveyRequest.setNumberOfWards(villageSur.getNumberOfWards());
        villageSurveyRequest.setNumberOfHamlets(villageSur.getNumberOfHamlets());
        villageSurveyRequest.setBlock(villageSur.getBlock());
        villageSurveyRequest.setDistrict(villageSur.getDistrict());
        villageSurveyRequest.setState(villageSur.getState());
        villageSurveyRequest.setLokSabhaConstituency(villageSur.getLokSabhaConstituency());
        villageSurveyRequest.setDistanceFromDistrictHQ(villageSur.getDistanceFromDistrictHQ());
        villageSurveyRequest.setAreaOfVillageAcres(villageSur.getAreaOfVillageAcres());
        villageSurveyRequest.setArableLandAgricultureAreaAcres(villageSur.getArableLandAgricultureAreaAcres());
        villageSurveyRequest.setForestAreaAcre(villageSur.getForestAreaAcre());
        villageSurveyRequest.setHousingAbadiAreaAcres(villageSur.getHousingAbadiAreaAcres());
        villageSurveyRequest.setAreaUnderWaterBodiesAcres(villageSur.getAreaUnderWaterBodiesAcres());
        villageSurveyRequest.setCommonLandsAreaAcres(villageSur.getCommonLandsAreaAcres());
        villageSurveyRequest.setAveragePerCapitaLandHoldingAcre(villageSur.getAveragePerCapitaLandHoldingAcre());
        villageSurveyRequest.setWasteLandAcres(villageSur.getWasteLandAcres());
        villageSurveyRequest.setWaterTableFeet(villageSur.getWaterTableFeet());


// 2.a) Primary Schools (Govt.) located in Village
        villageSurveyRequest.setPrimarySchoolsGovtLocatedInVillage(villageSur.getPrimarySchoolsGovtLocatedInVillage());
        villageSurveyRequest.setPrimarySchoolsGovtNumbersInsideVillage(villageSur.getPrimarySchoolsGovtNumbersInsideVillage());
        villageSurveyRequest.setPrimarySchoolsGovtDistanceOutsideNearestCentre(villageSur.getPrimarySchoolsGovtDistanceOutsideNearestCentre());

// 2.b) Primary Schools (Private) located in village
        villageSurveyRequest.setPrimarySchoolsPrivateLocatedInVillage(villageSur.getPrimarySchoolsPrivateLocatedInVillage());
        villageSurveyRequest.setPrimarySchoolsPrivateNumbersInsideVillage(villageSur.getPrimarySchoolsPrivateNumbersInsideVillage());
        villageSurveyRequest.setPrimarySchoolsPrivateDistanceOutsideNearestCentre(villageSur.getPrimarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.c) Middle Schools (Govt.) located in village
        villageSurveyRequest.setMiddleSchoolsGovtLocatedInVillage(villageSur.getMiddleSchoolsGovtLocatedInVillage());
        villageSurveyRequest.setMiddleSchoolsGovtNumbersInsideVillage(villageSur.getMiddleSchoolsGovtNumbersInsideVillage());
        villageSurveyRequest.setMiddleSchoolsGovtDistanceOutsideNearestCentre(villageSur.getMiddleSchoolsGovtDistanceOutsideNearestCentre());

// 2.d) Middle Schools (Private) located in village
        villageSurveyRequest.setMiddleSchoolsPrivateLocatedInVillage(villageSur.getMiddleSchoolsPrivateLocatedInVillage());
        villageSurveyRequest.setMiddleSchoolsPrivateNumbersInsideVillage(villageSur.getMiddleSchoolsPrivateNumbersInsideVillage());
        villageSurveyRequest.setMiddleSchoolsPrivateDistanceOutsideNearestCentre(villageSur.getMiddleSchoolsPrivateDistanceOutsideNearestCentre());

// 2.e) Secondary Schools (Govt.) located in village
        villageSurveyRequest.setSecondarySchoolsGovtLocatedInVillage(villageSur.getSecondarySchoolsGovtLocatedInVillage());
        villageSurveyRequest.setSecondarySchoolsGovtNumbersInsideVillage(villageSur.getSecondarySchoolsGovtNumbersInsideVillage());
        villageSurveyRequest.setSecondarySchoolsGovtDistanceOutsideNearestCentre(villageSur.getSecondarySchoolsGovtDistanceOutsideNearestCentre());

// 2.f) Secondary Schools (Private) located in village
        villageSurveyRequest.setSecondarySchoolsPrivateLocatedInVillage(villageSur.getSecondarySchoolsPrivateLocatedInVillage());
        villageSurveyRequest.setSecondarySchoolsPrivateNumbersInsideVillage(villageSur.getSecondarySchoolsPrivateNumbersInsideVillage());
        villageSurveyRequest.setSecondarySchoolsPrivateDistanceOutsideNearestCentre(villageSur.getSecondarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.g) ITI Diploma Institutes (Govt.) located in village
        villageSurveyRequest.setItiDiplomaInstitutesGovtLocatedInVillage(villageSur.getItiDiplomaInstitutesGovtLocatedInVillage());
        villageSurveyRequest.setItiDiplomaInstitutesGovtNumbersInsideVillage(villageSur.getItiDiplomaInstitutesGovtNumbersInsideVillage());
        villageSurveyRequest.setItiDiplomaInstitutesGovtDistanceOutsideNearestCentre(villageSur.getItiDiplomaInstitutesGovtDistanceOutsideNearestCentre());

// 2.h) ITI Diploma Institutes (Private) located in village
        villageSurveyRequest.setItiDiplomaInstitutesPrivateLocatedInVillage(villageSur.getItiDiplomaInstitutesPrivateLocatedInVillage());
        villageSurveyRequest.setItiDiplomaInstitutesPrivateNumbersInsideVillage(villageSur.getItiDiplomaInstitutesPrivateNumbersInsideVillage());
        villageSurveyRequest.setItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre(villageSur.getItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre());

// 2.i) Colleges (Govt.) located in village
        villageSurveyRequest.setCollegesGovtLocatedInVillage(villageSur.getCollegesGovtLocatedInVillage());
        villageSurveyRequest.setCollegesGovtNumbersInsideVillage(villageSur.getCollegesGovtNumbersInsideVillage());
        villageSurveyRequest.setCollegesGovtDistanceOutsideNearestCentre(villageSur.getCollegesGovtDistanceOutsideNearestCentre());

// 2.j) Colleges (Private) located in village
        villageSurveyRequest.setCollegesPrivateLocatedInVillage(villageSur.getCollegesPrivateLocatedInVillage());
        villageSurveyRequest.setCollegesPrivateNumbersInsideVillage(villageSur.getCollegesPrivateNumbersInsideVillage());
        villageSurveyRequest.setCollegesPrivateDistanceOutsideNearestCentre(villageSur.getCollegesPrivateDistanceOutsideNearestCentre());

// 2.k) Banks / ATM located in village
        villageSurveyRequest.setBanksAtmLocatedInVillage(villageSur.getBanksAtmLocatedInVillage());
        villageSurveyRequest.setBanksInsideVillageNumbers(villageSur.getBanksInsideVillageNumbers());
        villageSurveyRequest.setAtmInsideVillageNumbers(villageSur.getAtmInsideVillageNumbers());
        villageSurveyRequest.setBanksAtmDistanceOutsideNearestCentre(villageSur.getBanksAtmDistanceOutsideNearestCentre());

// 2.l) Primary Health Centres located in village
        villageSurveyRequest.setPrimaryHealthCentresLocatedInVillage(villageSur.getPrimaryHealthCentresLocatedInVillage());
        villageSurveyRequest.setPrimaryHealthCentresNumbersInsideVillage(villageSur.getPrimaryHealthCentresNumbersInsideVillage());
        villageSurveyRequest.setPrimaryHealthCentresDistanceOutsideNearestCentre(villageSur.getPrimaryHealthCentresDistanceOutsideNearestCentre());

// 2.m) Civil Hospital located in village
        villageSurveyRequest.setCivilHospitalLocatedInVillage(villageSur.getCivilHospitalLocatedInVillage());
        villageSurveyRequest.setCivilHospitalNumbersInsideVillage(villageSur.getCivilHospitalNumbersInsideVillage());
        villageSurveyRequest.setCivilHospitalDistanceOutsideNearestCentre(villageSur.getCivilHospitalDistanceOutsideNearestCentre());

// 2.n) SHG’s in village
        villageSurveyRequest.setShgsInVillage(villageSur.getShgsInVillage());
        villageSurveyRequest.setShgsNumbersInsideVillage(villageSur.getShgsNumbersInsideVillage());
        villageSurveyRequest.setShgsDistanceOutsideNearestCentre(villageSur.getShgsDistanceOutsideNearestCentre());

// 2.o) NGO’s in village
        villageSurveyRequest.setNgosInVillage(villageSur.getNgosInVillage());
        villageSurveyRequest.setNgosNumbersInsideVillage(villageSur.getNgosNumbersInsideVillage());
        villageSurveyRequest.setNgosDistanceOutsideNearestCentre(villageSur.getNgosDistanceOutsideNearestCentre());

// 2.p) Jan Aushadhi Yojana Kendra located in village
        villageSurveyRequest.setJanAushadhiYojanaKendraLocatedInVillage(villageSur.getJanAushadhiYojanaKendraLocatedInVillage());
        villageSurveyRequest.setJanAushadhiYojanaKendraNumbersInsideVillage(villageSur.getJanAushadhiYojanaKendraNumbersInsideVillage());
        villageSurveyRequest.setJanAushadhiYojanaKendraDistanceOutsideNearestCentre(villageSur.getJanAushadhiYojanaKendraDistanceOutsideNearestCentre());

// 2.q) Post Office located in village
        villageSurveyRequest.setPostOfficeLocatedInVillage(villageSur.getPostOfficeLocatedInVillage());
        villageSurveyRequest.setPostOfficeNumbersInsideVillage(villageSur.getPostOfficeNumbersInsideVillage());
        villageSurveyRequest.setPostOfficeDistanceOutsideNearestCentre(villageSur.getPostOfficeDistanceOutsideNearestCentre());

// 2.r) Gas agencies located in village
        villageSurveyRequest.setGasAgenciesLocatedInVillage(villageSur.getGasAgenciesLocatedInVillage());
        villageSurveyRequest.setGasAgenciesNumbersInsideVillage(villageSur.getGasAgenciesNumbersInsideVillage());
        villageSurveyRequest.setGasAgenciesDistanceOutsideNearestCentre(villageSur.getGasAgenciesDistanceOutsideNearestCentre());

// 2.s) Training Centres located in village
        villageSurveyRequest.setTrainingCentresLocatedInVillage(villageSur.getTrainingCentresLocatedInVillage());
        villageSurveyRequest.setTrainingCentresName(villageSur.getTrainingCentresName());
        villageSurveyRequest.setTrainingCentresNumbersInsideVillage(villageSur.getTrainingCentresNumbersInsideVillage());
        villageSurveyRequest.setTrainingCentresDistanceOutsideNearestCentre(villageSur.getTrainingCentresDistanceOutsideNearestCentre());

// 2.t) Electricity Office located in village
        villageSurveyRequest.setElectricityOfficeLocatedInVillage(villageSur.getElectricityOfficeLocatedInVillage());
        villageSurveyRequest.setElectricityOfficeNumbersInsideVillage(villageSur.getElectricityOfficeNumbersInsideVillage());
        villageSurveyRequest.setElectricityOfficeDistanceOutsideNearestCentre(villageSur.getElectricityOfficeDistanceOutsideNearestCentre());

// 2.u) Anganwadi Kendra located in village
        villageSurveyRequest.setAnganwadiKendraLocatedInVillage(villageSur.getAnganwadiKendraLocatedInVillage());
        villageSurveyRequest.setAnganwadiKendraNumbersInsideVillage(villageSur.getAnganwadiKendraNumbersInsideVillage());
        villageSurveyRequest.setAnganwadiKendraDistanceOutsideNearestCentre(villageSur.getAnganwadiKendraDistanceOutsideNearestCentre());

// 2.v) Petrol Pumps in village
        villageSurveyRequest.setPetrolPumpsInVillage(villageSur.getPetrolPumpsInVillage());
        villageSurveyRequest.setPetrolPumpsNumbersInsideVillage(villageSur.getPetrolPumpsNumbersInsideVillage());
        villageSurveyRequest.setPetrolPumpsDistanceOutsideNearestCentre(villageSur.getPetrolPumpsDistanceOutsideNearestCentre());

// 2.w) Kisan Sewa Kendra in village
        villageSurveyRequest.setKisanSewaKendraInVillage(villageSur.getKisanSewaKendraInVillage());
        villageSurveyRequest.setKisanSewaKendraNumbersInsideVillage(villageSur.getKisanSewaKendraNumbersInsideVillage());
        villageSurveyRequest.setKisanSewaKendraDistanceOutsideNearestCentre(villageSur.getKisanSewaKendraDistanceOutsideNearestCentre());

// 2.x) Krishi Mandi in village
        villageSurveyRequest.setKrishiMandiInVillage(villageSur.getKrishiMandiInVillage());
        villageSurveyRequest.setKrishiMandiNumbersInsideVillage(villageSur.getKrishiMandiNumbersInsideVillage());
        villageSurveyRequest.setKrishiMandiDistanceOutsideNearestCentre(villageSur.getKrishiMandiDistanceOutsideNearestCentre());

// 2.y) Fare Price Shop in village
        villageSurveyRequest.setFarePriceShopInVillage(villageSur.getFarePriceShopInVillage());
        villageSurveyRequest.setFarePriceShopNumbersInsideVillage(villageSur.getFarePriceShopNumbersInsideVillage());
        villageSurveyRequest.setFarePriceShopDistanceOutsideNearestCentre(villageSur.getFarePriceShopDistanceOutsideNearestCentre());

// 2.z) Milk Cooperative/Collection Centre in village
        villageSurveyRequest.setMilkCooperativeInVillage(villageSur.getMilkCooperativeInVillage());
        villageSurveyRequest.setMilkCooperativeNumbersInsideVillage(villageSur.getMilkCooperativeNumbersInsideVillage());
        villageSurveyRequest.setMilkCooperativeDistanceOutsideNearestCentre(villageSur.getMilkCooperativeDistanceOutsideNearestCentre());

// 2.aa) Railway Station in village
        villageSurveyRequest.setRailwayStationInVillage(villageSur.getRailwayStationInVillage());
        villageSurveyRequest.setRailwayStationNumbersInsideVillage(villageSur.getRailwayStationNumbersInsideVillage());
        villageSurveyRequest.setRailwayStationDistanceOutsideNearestCentre(villageSur.getRailwayStationDistanceOutsideNearestCentre());

// 2.ab) Bus Stop in village
        villageSurveyRequest.setBusStopInVillage(villageSur.getBusStopInVillage());
        villageSurveyRequest.setBusStopNumbersInsideVillage(villageSur.getBusStopNumbersInsideVillage());
        villageSurveyRequest.setBusStopDistanceOutsideNearestCentre(villageSur.getBusStopDistanceOutsideNearestCentre());

// 2.ac) Veterinary Care Centre in village
        villageSurveyRequest.setVeterinaryCareCentreInVillage(villageSur.getVeterinaryCareCentreInVillage());
        villageSurveyRequest.setVeterinaryCareCentreNumbersInsideVillage(villageSur.getVeterinaryCareCentreNumbersInsideVillage());
        villageSurveyRequest.setVeterinaryCareCentreDistanceOutsideNearestCentre(villageSur.getVeterinaryCareCentreDistanceOutsideNearestCentre());

// 2.ad) Sports Facility/Grounds in village
        villageSurveyRequest.setSportsFacilityInVillage(villageSur.getSportsFacilityInVillage());
        villageSurveyRequest.setSportsFacilityNumbersInsideVillage(villageSur.getSportsFacilityNumbersInsideVillage());
        villageSurveyRequest.setSportsFacilityDistanceOutsideNearestCentre(villageSur.getSportsFacilityDistanceOutsideNearestCentre());

// 2.ae) Number of common sanitation complexes in village
        villageSurveyRequest.setCommonSanitationComplexesInVillage(villageSur.getCommonSanitationComplexesInVillage());
        villageSurveyRequest.setCommonSanitationComplexesNumbersInsideVillage(villageSur.getCommonSanitationComplexesNumbersInsideVillage());
        villageSurveyRequest.setCommonSanitationComplexesDistanceOutsideNearestCentre(villageSur.getCommonSanitationComplexesDistanceOutsideNearestCentre());

// 3. Village Connectivity (Roads)
// 3.a) Distance of the Village from the nearest Highway/Major Dist. Road (in km)
        villageSurveyRequest.setDistanceFromNearestHighway(villageSur.getDistanceFromNearestHighway());

// 3.b) Is the village connected to the above by a pacca road?
        villageSurveyRequest.setVillageConnectedByPaccaRoad(villageSur.getVillageConnectedByPaccaRoad());

// If yes, details of the Approach Road/Connecting Road
// 3.b.i) Length of the Road (in km)
        villageSurveyRequest.setPaccaRoadLength(villageSur.getPaccaRoadLength());

// 3.b.ii) Year of construction
        villageSurveyRequest.setPaccaRoadYearOfConstruction(villageSur.getPaccaRoadYearOfConstruction());

// 3.b.iii) Scheme under which constructed
        villageSurveyRequest.setPaccaRoadConstructionScheme(villageSur.getPaccaRoadConstructionScheme());

// 3.b.iv) Present Status (complete/incomplete)
        villageSurveyRequest.setPaccaRoadStatus(villageSur.getPaccaRoadStatus());

// 3.c) Length of Internal roads (inside village/hamlets)
// i) kachha (kms) ii) pakka (kms) iii) Total (kms)
        villageSurveyRequest.setIntegerernalRoadsKachhaLength(villageSur.getIntegerernalRoadsKachhaLength());
        villageSurveyRequest.setIntegerernalRoadsPakkaLength(villageSur.getIntegerernalRoadsPakkaLength());
        villageSurveyRequest.setIntegerernalRoadsTotalLength(villageSur.getIntegerernalRoadsTotalLength());

// 3.d) What is the mode of transport available?
        villageSurveyRequest.setModeOfTransport(villageSur.getModeOfTransport());

// If any other mode of transport, then specify
        villageSurveyRequest.setOtherModeOfTransport(villageSur.getOtherModeOfTransport());

// 3.e) Frequency of the available mode of transport
// Frequent Not Frequent only two times a day Any other
        villageSurveyRequest.setTransportFrequency(villageSur.getTransportFrequency());
        villageSurveyRequest.setOtherTransportFrequency(villageSur.getOtherTransportFrequency());

// 4. Land, Forest & Horticultural Profile
// 4.a) Type of Forest
        villageSurveyRequest.setTypeOfForest(villageSur.getTypeOfForest());

// 4.b) Community Forest (Acre)
        villageSurveyRequest.setCommunityForestAcre(villageSur.getCommunityForestAcre());

// 4.c) Government Forest (Acre)
        villageSurveyRequest.setGovernmentForestAcre(villageSur.getGovernmentForestAcre());

// 4.d) Main Forest Trees and Shrub Species
        villageSurveyRequest.setMainForestTreesAndShrubSpecies(villageSur.getMainForestTreesAndShrubSpecies());

// 4.e) Energy Plantation
        villageSurveyRequest.setEnergyPlantation(villageSur.getEnergyPlantation());

// If Yes, which species (Top 3) and area (in acre)
        villageSurveyRequest.setEnergyPlantationSpeciesTop1(villageSur.getEnergyPlantationSpeciesTop1());
        villageSurveyRequest.setEnergyPlantationAreaTop1(villageSur.getEnergyPlantationAreaTop1());
        villageSurveyRequest.setEnergyPlantationSpeciesTop2(villageSur.getEnergyPlantationSpeciesTop2());
        villageSurveyRequest.setEnergyPlantationAreaTop2(villageSur.getEnergyPlantationAreaTop2());
        villageSurveyRequest.setEnergyPlantationSpeciesTop3(villageSur.getEnergyPlantationSpeciesTop3());
        villageSurveyRequest.setEnergyPlantationAreaTop3(villageSur.getEnergyPlantationAreaTop3());

        villageSurveyRequest.setStreetLightCFLLED(villageSur.getStreetLightCFLLED());
        villageSurveyRequest.setStreetLightCFLLEDDuration(villageSur.getStreetLightCFLLEDDuration());
        villageSurveyRequest.setStreetLightTubeLight(villageSur.getStreetLightTubeLight());
        villageSurveyRequest.setStreetLightTubeLightDuration(villageSur.getStreetLightTubeLightDuration());

        villageSurveyRequest.setComments(villageSur.getComments());

//5 a
        PanchayatOffice panchayatOffice = panchayatOfficeRepo.findById(villageSur.getPanchayatOfficeId())
                .orElseThrow(()->new NotFoundException("Panchayat Not Found with id"+ villageSur.getPanchayatOfficeId()));

        villageSurveyRequest.setPanchayatOfficeCflLed(panchayatOffice.getCflLed());
        villageSurveyRequest.setPanchayatOfficeFan(panchayatOffice.getFan());
        villageSurveyRequest.setPanchayatOfficeDesertCooler(panchayatOffice.getDesertCooler());
        villageSurveyRequest.setPanchayatOfficeTv(panchayatOffice.getTv());
        villageSurveyRequest.setPanchayatOfficeRefrigerator(panchayatOffice.getRefrigerator());
        villageSurveyRequest.setPanchayatOfficeMusicSystem(panchayatOffice.getMusicSystem());
        villageSurveyRequest.setPanchayatOfficeElectricMotorPump(panchayatOffice.getElectricMotorPump());
        villageSurveyRequest.setPanchayatOfficeHeater(panchayatOffice.getHeater());
        villageSurveyRequest.setPanchayatOfficeElectricIron(panchayatOffice.getElectricIron());
        villageSurveyRequest.setPanchayatOfficeAirConditioner(panchayatOffice.getAirConditioner());

// Working duration/day (in hours) of Electrical Appliances in Panchayat office
        villageSurveyRequest.setPanchayatOfficeCflLedDuration(panchayatOffice.getCflLedDuration());
        villageSurveyRequest.setPanchayatOfficeFanDuration(panchayatOffice.getFanDuration());
        villageSurveyRequest.setPanchayatOfficeDesertCoolerDuration(panchayatOffice.getDesertCoolerDuration());
        villageSurveyRequest.setPanchayatOfficeTvDuration(panchayatOffice.getTvDuration());
        villageSurveyRequest.setPanchayatOfficeRefrigeratorDuration(panchayatOffice.getRefrigeratorDuration());
        villageSurveyRequest.setPanchayatOfficeMusicSystemDuration(panchayatOffice.getMusicSystemDuration());
        villageSurveyRequest.setPanchayatOfficeElectricMotorPumpDuration(panchayatOffice.getElectricMotorPumpDuration());
        villageSurveyRequest.setPanchayatOfficeHeaterDuration(panchayatOffice.getHeaterDuration());
        villageSurveyRequest.setPanchayatOfficeElectricIronDuration(panchayatOffice.getElectricIronDuration());
        villageSurveyRequest.setPanchayatOfficeAirConditionerDuration(panchayatOffice.getAirConditionerDuration());


        Dispensary dispensary = dispensaryRepo.findById(villageSur.getDispensaryId())
                .orElseThrow(() -> new NotFoundException("Dispensary Not Found with id" + villageSur.getDispensaryId()));

// Set values for Electrical Appliances in Dispensary
        villageSurveyRequest.setDispensaryCflLed(dispensary.getCflLed());
        villageSurveyRequest.setDispensaryFan(dispensary.getFan());
        villageSurveyRequest.setDispensaryDesertCooler(dispensary.getDesertCooler());
        villageSurveyRequest.setDispensaryTv(dispensary.getTv());
        villageSurveyRequest.setDispensaryRefrigerator(dispensary.getRefrigerator());
        villageSurveyRequest.setDispensaryMusicSystem(dispensary.getMusicSystem());
        villageSurveyRequest.setDispensaryElectricMotorPump(dispensary.getElectricMotorPump());
        villageSurveyRequest.setDispensaryHeater(dispensary.getHeater());
        villageSurveyRequest.setDispensaryElectricIron(dispensary.getElectricIron());
        villageSurveyRequest.setDispensaryAirConditioner(dispensary.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dispensary
        villageSurveyRequest.setDispensaryCflLedDuration(dispensary.getCflLedDuration());
        villageSurveyRequest.setDispensaryFanDuration(dispensary.getFanDuration());
        villageSurveyRequest.setDispensaryDesertCoolerDuration(dispensary.getDesertCoolerDuration());
        villageSurveyRequest.setDispensaryTvDuration(dispensary.getTvDuration());
        villageSurveyRequest.setDispensaryRefrigeratorDuration(dispensary.getRefrigeratorDuration());
        villageSurveyRequest.setDispensaryMusicSystemDuration(dispensary.getMusicSystemDuration());
        villageSurveyRequest.setDispensaryElectricMotorPumpDuration(dispensary.getElectricMotorPumpDuration());
        villageSurveyRequest.setDispensaryHeaterDuration(dispensary.getHeaterDuration());
        villageSurveyRequest.setDispensaryElectricIronDuration(dispensary.getElectricIronDuration());
        villageSurveyRequest.setDispensaryAirConditionerDuration(dispensary.getAirConditionerDuration());

// Initialize CommunityHall object

        CommunityHall communityHall = communityHallRepo.findById(villageSur.getCommunityHallId())
                .orElseThrow(() -> new NotFoundException("CommunityHall Not Found with id" + villageSur.getCommunityHallId()));

// Set values for Electrical Appliances in Community Hall
        villageSurveyRequest.setCommunityHallCflLed(communityHall.getCflLed());
        villageSurveyRequest.setCommunityHallFan(communityHall.getFan());
        villageSurveyRequest.setCommunityHallDesertCooler(communityHall.getDesertCooler());
        villageSurveyRequest.setCommunityHallTv(communityHall.getTv());
        villageSurveyRequest.setCommunityHallRefrigerator(communityHall.getRefrigerator());
        villageSurveyRequest.setCommunityHallMusicSystem(communityHall.getMusicSystem());
        villageSurveyRequest.setCommunityHallElectricMotorPump(communityHall.getElectricMotorPump());
        villageSurveyRequest.setCommunityHallHeater(communityHall.getHeater());
        villageSurveyRequest.setCommunityHallElectricIron(communityHall.getElectricIron());
        villageSurveyRequest.setCommunityHallAirConditioner(communityHall.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Community Hall
        villageSurveyRequest.setCommunityHallCflLedDuration(communityHall.getCflLedDuration());
        villageSurveyRequest.setCommunityHallFanDuration(communityHall.getFanDuration());
        villageSurveyRequest.setCommunityHallDesertCoolerDuration(communityHall.getDesertCoolerDuration());
        villageSurveyRequest.setCommunityHallTvDuration(communityHall.getTvDuration());
        villageSurveyRequest.setCommunityHallRefrigeratorDuration(communityHall.getRefrigeratorDuration());
        villageSurveyRequest.setCommunityHallMusicSystemDuration(communityHall.getMusicSystemDuration());
        villageSurveyRequest.setCommunityHallElectricMotorPumpDuration(communityHall.getElectricMotorPumpDuration());
        villageSurveyRequest.setCommunityHallHeaterDuration(communityHall.getHeaterDuration());
        villageSurveyRequest.setCommunityHallElectricIronDuration(communityHall.getElectricIronDuration());
        villageSurveyRequest.setCommunityHallAirConditionerDuration(communityHall.getAirConditionerDuration());


// Initialize Dharamashala object
        Dharamashala dharamashala = dharamashalaRepo.findById(villageSur.getDharamashalaId())
                .orElseThrow(() -> new NotFoundException("Dharamashala Not Found with id " + villageSur.getDharamashalaId()));

// Set values for Electrical Appliances in Dharamashala
        villageSurveyRequest.setDharamashalaCflLed(dharamashala.getCflLed());
        villageSurveyRequest.setDharamashalaFan(dharamashala.getFan());
        villageSurveyRequest.setDharamashalaDesertCooler(dharamashala.getDesertCooler());
        villageSurveyRequest.setDharamashalaTv(dharamashala.getTv());
        villageSurveyRequest.setDharamashalaRefrigerator(dharamashala.getRefrigerator());
        villageSurveyRequest.setDharamashalaMusicSystem(dharamashala.getMusicSystem());
        villageSurveyRequest.setDharamashalaElectricMotorPump(dharamashala.getElectricMotorPump());
        villageSurveyRequest.setDharamashalaHeater(dharamashala.getHeater());
        villageSurveyRequest.setDharamashalaElectricIron(dharamashala.getElectricIron());
        villageSurveyRequest.setDharamashalaAirConditioner(dharamashala.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dharamashala
        villageSurveyRequest.setDharamashalaCflLedDuration(dharamashala.getCflLedDuration());
        villageSurveyRequest.setDharamashalaFanDuration(dharamashala.getFanDuration());
        villageSurveyRequest.setDharamashalaDesertCoolerDuration(dharamashala.getDesertCoolerDuration());
        villageSurveyRequest.setDharamashalaTvDuration(dharamashala.getTvDuration());
        villageSurveyRequest.setDharamashalaRefrigeratorDuration(dharamashala.getRefrigeratorDuration());
        villageSurveyRequest.setDharamashalaMusicSystemDuration(dharamashala.getMusicSystemDuration());
        villageSurveyRequest.setDharamashalaElectricMotorPumpDuration(dharamashala.getElectricMotorPumpDuration());
        villageSurveyRequest.setDharamashalaHeaterDuration(dharamashala.getHeaterDuration());
        villageSurveyRequest.setDharamashalaElectricIronDuration(dharamashala.getElectricIronDuration());
        villageSurveyRequest.setDharamashalaAirConditionerDuration(dharamashala.getAirConditionerDuration());


        // Initialize SocialOrganisations object
        SocialOrganisations socialOrganisations = socialOrganisationsRepo.findById(villageSur.getSocialOrganisationsId())
                .orElseThrow(() -> new NotFoundException("Social Orginasation Not Found with id " + villageSur.getSocialOrganisationsId()));

// Set values for Electrical Appliances in Social Organisations
        villageSurveyRequest.setSocialOrganisationsCflLed(socialOrganisations.getCflLed());
        villageSurveyRequest.setSocialOrganisationsFan(socialOrganisations.getFan());
        villageSurveyRequest.setSocialOrganisationsDesertCooler(socialOrganisations.getDesertCooler());
        villageSurveyRequest.setSocialOrganisationsTv(socialOrganisations.getTv());
        villageSurveyRequest.setSocialOrganisationsRefrigerator(socialOrganisations.getRefrigerator());
        villageSurveyRequest.setSocialOrganisationsMusicSystem(socialOrganisations.getMusicSystem());
        villageSurveyRequest.setSocialOrganisationsElectricMotorPump(socialOrganisations.getElectricMotorPump());
        villageSurveyRequest.setSocialOrganisationsHeater(socialOrganisations.getHeater());
        villageSurveyRequest.setSocialOrganisationsElectricIron(socialOrganisations.getElectricIron());
        villageSurveyRequest.setSocialOrganisationsAirConditioner(socialOrganisations.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Social Organisations
        villageSurveyRequest.setSocialOrganisationsCflLedDuration(socialOrganisations.getCflLedDuration());
        villageSurveyRequest.setSocialOrganisationsFanDuration(socialOrganisations.getFanDuration());
        villageSurveyRequest.setSocialOrganisationsDesertCoolerDuration(socialOrganisations.getDesertCoolerDuration());
        villageSurveyRequest.setSocialOrganisationsTvDuration(socialOrganisations.getTvDuration());
        villageSurveyRequest.setSocialOrganisationsRefrigeratorDuration(socialOrganisations.getRefrigeratorDuration());
        villageSurveyRequest.setSocialOrganisationsMusicSystemDuration(socialOrganisations.getMusicSystemDuration());
        villageSurveyRequest.setSocialOrganisationsElectricMotorPumpDuration(socialOrganisations.getElectricMotorPumpDuration());
        villageSurveyRequest.setSocialOrganisationsHeaterDuration(socialOrganisations.getHeaterDuration());
        villageSurveyRequest.setSocialOrganisationsElectricIronDuration(socialOrganisations.getElectricIronDuration());
        villageSurveyRequest.setSocialOrganisationsAirConditionerDuration(socialOrganisations.getAirConditionerDuration());

        // Initialize TrainingProductionCentres object
        TrainingProductionCentres trainingProductionCentres = trainingProductionCentresRepo.findById(villageSur.getTPCId())
                .orElseThrow(() -> new NotFoundException("Training Production Centres Not Found with id " + villageSur.getTPCId()));

// Set values for Electrical Appliances in Training cum Production Centres
        villageSurveyRequest.setTpcCflLed(trainingProductionCentres.getCflLed());
        villageSurveyRequest.setTpcFan(trainingProductionCentres.getFan());
        villageSurveyRequest.setTpcDesertCooler(trainingProductionCentres.getDesertCooler());
        villageSurveyRequest.setTpcTv(trainingProductionCentres.getTv());
        villageSurveyRequest.setTpcRefrigerator(trainingProductionCentres.getRefrigerator());
        villageSurveyRequest.setTpcMusicSystem(trainingProductionCentres.getMusicSystem());
        villageSurveyRequest.setTpcElectricMotorPump(trainingProductionCentres.getElectricMotorPump());
        villageSurveyRequest.setTpcHeater(trainingProductionCentres.getHeater());
        villageSurveyRequest.setTpcElectricIron(trainingProductionCentres.getElectricIron());
        villageSurveyRequest.setTpcAirConditioner(trainingProductionCentres.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Training cum Production Centres
        villageSurveyRequest.setTpcCflLedDuration(trainingProductionCentres.getCflLedDuration());
        villageSurveyRequest.setTpcFanDuration(trainingProductionCentres.getFanDuration());
        villageSurveyRequest.setTpcDesertCoolerDuration(trainingProductionCentres.getDesertCoolerDuration());
        villageSurveyRequest.setTpcTvDuration(trainingProductionCentres.getTvDuration());
        villageSurveyRequest.setTpcRefrigeratorDuration(trainingProductionCentres.getRefrigeratorDuration());
        villageSurveyRequest.setTpcMusicSystemDuration(trainingProductionCentres.getMusicSystemDuration());
        villageSurveyRequest.setTpcElectricMotorPumpDuration(trainingProductionCentres.getElectricMotorPumpDuration());
        villageSurveyRequest.setTpcHeaterDuration(trainingProductionCentres.getHeaterDuration());
        villageSurveyRequest.setTpcElectricIronDuration(trainingProductionCentres.getElectricIronDuration());
        villageSurveyRequest.setTpcAirConditionerDuration(trainingProductionCentres.getAirConditionerDuration());

        /// Initialize OtherAreas object
        OtherAreas otherAreas = otherAreasRepo.findById(villageSur.getOtherAreasId())
                .orElseThrow(() -> new NotFoundException("Other Areas Not Found with id " + villageSur.getOtherAreasId()));

// Set values for Electrical Appliances in Other Areas
        villageSurveyRequest.setOtherAreasCflLed(otherAreas.getCflLed());
        villageSurveyRequest.setOtherAreasFan(otherAreas.getFan());
        villageSurveyRequest.setOtherAreasDesertCooler(otherAreas.getDesertCooler());
        villageSurveyRequest.setOtherAreasTv(otherAreas.getTv());
        villageSurveyRequest.setOtherAreasRefrigerator(otherAreas.getRefrigerator());
        villageSurveyRequest.setOtherAreasMusicSystem(otherAreas.getMusicSystem());
        villageSurveyRequest.setOtherAreasElectricMotorPump(otherAreas.getElectricMotorPump());
        villageSurveyRequest.setOtherAreasHeater(otherAreas.getHeater());
        villageSurveyRequest.setOtherAreasElectricIron(otherAreas.getElectricIron());
        villageSurveyRequest.setOtherAreasAirConditioner(otherAreas.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Other Areas
        villageSurveyRequest.setOtherAreasCflLedDuration(otherAreas.getCflLedDuration());
        villageSurveyRequest.setOtherAreasFanDuration(otherAreas.getFanDuration());
        villageSurveyRequest.setOtherAreasDesertCoolerDuration(otherAreas.getDesertCoolerDuration());
        villageSurveyRequest.setOtherAreasTvDuration(otherAreas.getTvDuration());
        villageSurveyRequest.setOtherAreasRefrigeratorDuration(otherAreas.getRefrigeratorDuration());
        villageSurveyRequest.setOtherAreasMusicSystemDuration(otherAreas.getMusicSystemDuration());
        villageSurveyRequest.setOtherAreasElectricMotorPumpDuration(otherAreas.getElectricMotorPumpDuration());
        villageSurveyRequest.setOtherAreasHeaterDuration(otherAreas.getHeaterDuration());
        villageSurveyRequest.setOtherAreasElectricIronDuration(otherAreas.getElectricIronDuration());
        villageSurveyRequest.setOtherAreasAirConditionerDuration(otherAreas.getAirConditionerDuration());

        villageSurveyRequest.setOtherAreasElectricalAppliances(villageSur.getOtherAreasElectricalAppliances());


        return villageSurveyRequest;
    }

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
            familyMemberReq.setName(familyMember.getName());
            familyMemberReq.setAge(familyMember.getAge());
            familyMemberReq.setGender(familyMember.getGender());
            familyMemberReq.setEducationLevel(familyMember.getEducationLevel());
            familyMemberReq.setGoingToAWCSchoolCollege(familyMember.getGoingToAWCSchoolCollege());
            familyMemberReq.setAadharCard(familyMember.getAadharCard());
            familyMemberReq.setBankAccount(familyMember.getBankAccount());
            familyMemberReq.setComputerLiterate(familyMember.getComputerLiterate());
            familyMemberReq.setSocialSecurityPension(familyMember.getSocialSecurityPension());
            familyMemberReq.setMajorHealthProblems(familyMember.getMajorHealthProblems());
            familyMemberReq.setMNREGAJobCard(familyMember.getMNREGAJobCard());
            familyMemberReq.setInSelfHelpGroups(familyMember.getInSelfHelpGroups());
            familyMemberReq.setOccupation(familyMember.getOccupation());


            householdRequest.getMembers().add(familyMemberReq);
        }
        householdRequest.setMembers(
                householdRequest.getMembers().stream().sorted(Comparator.comparing(FamilyMemberReq::getAge)).toList()
        );

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
            householdRequest.getAppliancesAndDuration().add(appliancesUsedReq);

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
            householdRequest.getCropDetails().add(cropDetailsReq);
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

    public ByteArrayResource createExcel(ExcelQueryObject queryObject)  {
        try {
            if (Objects.equals(queryObject.getSurvey(), "village")) {
                Specification<VillageSurvey> specification = VillageSurveySpecification.filterByQueryObject(queryObject);
                List<VillageSurvey> sorted = villageSurveyRepo
                        .findAll(specification)
                        .stream()
                        .sorted(Comparator.comparing(VillageSurvey::getDateOfSurvey).reversed())
                        .toList();

                return villageRequestExcelService.createExcel(sorted.stream().map(this::convertVillageToDto).toList());
            } else {
                Specification<HouseholdSurvey> specification = HouseholdSurveySpecification.filterByQueryObject(queryObject);

                List<HouseholdSurvey> householdSurveys = householdSurveyRepo
                        .findAll(specification)
                        .stream()
                        .sorted(Comparator.comparing(HouseholdSurvey::getDateOfSurvey).reversed())
                        .toList();
                return householdSurveyExcelService.createExcel(householdSurveys.stream().map(this::convertHouseholdToDto).toList());
            }
        }
        catch (Exception e){
            throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public CountResponse getCount() {
        List<VillageSurvey> villageSurveys = villageSurveyRepo.findAll();
        List<HouseholdSurvey> householdSurveys = householdSurveyRepo.findAll();
        CountResponse countResponse = new CountResponse();
        countResponse.setHouseholdSurveyCount(householdSurveys.size());
        countResponse.setVillageSurveyCount(villageSurveys.size());
        return countResponse;
    }
}
