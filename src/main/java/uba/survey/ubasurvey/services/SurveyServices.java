package uba.survey.ubasurvey.services;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.core.io.ByteArrayResource;
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

import java.lang.reflect.Field;
import java.util.*;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    private final ExcelService<VillageRequest> villageRequestExcelService;
    private final ExcelService<HouseholdRequest> householdSurveyExcelService;

    public String handleVillageSurvey(VillageRequest villageRequest) {
        VillageSurvey villageSurvey = new VillageSurvey();
        villageSurvey.setSurveyorName(villageRequest.getSurveyorName());
        villageSurvey.setRespondentName(villageRequest.getRespondentName());
        villageSurvey.setDateOfSurvey(new Date());
        villageSurvey.setVillageId(villageRequest.getVillageId());
        villageSurvey.setNameOfTheVillage(villageRequest.getNameOfTheVillage());
        villageSurvey.setGramPanchayat(villageRequest.getGramPanchayat());
        villageSurvey.setNumberOfWards(villageRequest.getNumberOfWards());
        villageSurvey.setNumberOfHamlets(villageRequest.getNumberOfHamlets());
        villageSurvey.setBlock(villageRequest.getBlock());
        villageSurvey.setDistrict(villageRequest.getDistrict());
        villageSurvey.setState(villageRequest.getState());
        villageSurvey.setLokSabhaConstituency(villageRequest.getLokSabhaConstituency());
        villageSurvey.setDistanceFromDistrictHQ(villageRequest.getDistanceFromDistrictHQ());
        villageSurvey.setAreaOfVillageAcres(villageRequest.getAreaOfVillageAcres());
        villageSurvey.setArableLandAgricultureAreaAcres(villageRequest.getArableLandAgricultureAreaAcres());
        villageSurvey.setForestAreaAcre(villageRequest.getForestAreaAcre());
        villageSurvey.setHousingAbadiAreaAcres(villageRequest.getHousingAbadiAreaAcres());
        villageSurvey.setAreaUnderWaterBodiesAcres(villageRequest.getAreaUnderWaterBodiesAcres());
        villageSurvey.setCommonLandsAreaAcres(villageRequest.getCommonLandsAreaAcres());
        villageSurvey.setAveragePerCapitaLandHoldingAcre(villageRequest.getAveragePerCapitaLandHoldingAcre());
        villageSurvey.setWasteLandAcres(villageRequest.getWasteLandAcres());
        villageSurvey.setWaterTableFeet(villageRequest.getWaterTableFeet());

// ... (previous code)

// 2.a) Primary Schools (Govt.) located in Village
        villageSurvey.setPrimarySchoolsGovtLocatedInVillage(villageRequest.getPrimarySchoolsGovtLocatedInVillage());
        villageSurvey.setPrimarySchoolsGovtNumbersInsideVillage(villageRequest.getPrimarySchoolsGovtNumbersInsideVillage());
        villageSurvey.setPrimarySchoolsGovtDistanceOutsideNearestCentre(villageRequest.getPrimarySchoolsGovtDistanceOutsideNearestCentre());

// 2.b) Primary Schools (Private) located in village
        villageSurvey.setPrimarySchoolsPrivateLocatedInVillage(villageRequest.getPrimarySchoolsPrivateLocatedInVillage());
        villageSurvey.setPrimarySchoolsPrivateNumbersInsideVillage(villageRequest.getPrimarySchoolsPrivateNumbersInsideVillage());
        villageSurvey.setPrimarySchoolsPrivateDistanceOutsideNearestCentre(villageRequest.getPrimarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.c) Middle Schools (Govt.) located in village
        villageSurvey.setMiddleSchoolsGovtLocatedInVillage(villageRequest.getMiddleSchoolsGovtLocatedInVillage());
        villageSurvey.setMiddleSchoolsGovtNumbersInsideVillage(villageRequest.getMiddleSchoolsGovtNumbersInsideVillage());
        villageSurvey.setMiddleSchoolsGovtDistanceOutsideNearestCentre(villageRequest.getMiddleSchoolsGovtDistanceOutsideNearestCentre());

// 2.d) Middle Schools (Private) located in village
        villageSurvey.setMiddleSchoolsPrivateLocatedInVillage(villageRequest.getMiddleSchoolsPrivateLocatedInVillage());
        villageSurvey.setMiddleSchoolsPrivateNumbersInsideVillage(villageRequest.getMiddleSchoolsPrivateNumbersInsideVillage());
        villageSurvey.setMiddleSchoolsPrivateDistanceOutsideNearestCentre(villageRequest.getMiddleSchoolsPrivateDistanceOutsideNearestCentre());

// 2.e) Secondary Schools (Govt.) located in village
        villageSurvey.setSecondarySchoolsGovtLocatedInVillage(villageRequest.getSecondarySchoolsGovtLocatedInVillage());
        villageSurvey.setSecondarySchoolsGovtNumbersInsideVillage(villageRequest.getSecondarySchoolsGovtNumbersInsideVillage());
        villageSurvey.setSecondarySchoolsGovtDistanceOutsideNearestCentre(villageRequest.getSecondarySchoolsGovtDistanceOutsideNearestCentre());

// 2.f) Secondary Schools (Private) located in village
        villageSurvey.setSecondarySchoolsPrivateLocatedInVillage(villageRequest.getSecondarySchoolsPrivateLocatedInVillage());
        villageSurvey.setSecondarySchoolsPrivateNumbersInsideVillage(villageRequest.getSecondarySchoolsPrivateNumbersInsideVillage());
        villageSurvey.setSecondarySchoolsPrivateDistanceOutsideNearestCentre(villageRequest.getSecondarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.g) ITI Diploma Institutes (Govt.) located in village
        villageSurvey.setItiDiplomaInstitutesGovtLocatedInVillage(villageRequest.getItiDiplomaInstitutesGovtLocatedInVillage());
        villageSurvey.setItiDiplomaInstitutesGovtNumbersInsideVillage(villageRequest.getItiDiplomaInstitutesGovtNumbersInsideVillage());
        villageSurvey.setItiDiplomaInstitutesGovtDistanceOutsideNearestCentre(villageRequest.getItiDiplomaInstitutesGovtDistanceOutsideNearestCentre());

// 2.h) ITI Diploma Institutes (Private) located in village
        villageSurvey.setItiDiplomaInstitutesPrivateLocatedInVillage(villageRequest.getItiDiplomaInstitutesPrivateLocatedInVillage());
        villageSurvey.setItiDiplomaInstitutesPrivateNumbersInsideVillage(villageRequest.getItiDiplomaInstitutesPrivateNumbersInsideVillage());
        villageSurvey.setItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre(villageRequest.getItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre());

// 2.i) Colleges (Govt.) located in village
        villageSurvey.setCollegesGovtLocatedInVillage(villageRequest.getCollegesGovtLocatedInVillage());
        villageSurvey.setCollegesGovtNumbersInsideVillage(villageRequest.getCollegesGovtNumbersInsideVillage());
        villageSurvey.setCollegesGovtDistanceOutsideNearestCentre(villageRequest.getCollegesGovtDistanceOutsideNearestCentre());

// 2.j) Colleges (Private) located in village
        villageSurvey.setCollegesPrivateLocatedInVillage(villageRequest.getCollegesPrivateLocatedInVillage());
        villageSurvey.setCollegesPrivateNumbersInsideVillage(villageRequest.getCollegesPrivateNumbersInsideVillage());
        villageSurvey.setCollegesPrivateDistanceOutsideNearestCentre(villageRequest.getCollegesPrivateDistanceOutsideNearestCentre());

// 2.k) Banks / ATM located in village
        villageSurvey.setBanksAtmLocatedInVillage(villageRequest.getBanksAtmLocatedInVillage());
        villageSurvey.setBanksInsideVillageNumbers(villageRequest.getBanksInsideVillageNumbers());
        villageSurvey.setAtmInsideVillageNumbers(villageRequest.getAtmInsideVillageNumbers());
        villageSurvey.setBanksAtmDistanceOutsideNearestCentre(villageRequest.getBanksAtmDistanceOutsideNearestCentre());

// 2.l) Primary Health Centres located in village
        villageSurvey.setPrimaryHealthCentresLocatedInVillage(villageRequest.getPrimaryHealthCentresLocatedInVillage());
        villageSurvey.setPrimaryHealthCentresNumbersInsideVillage(villageRequest.getPrimaryHealthCentresNumbersInsideVillage());
        villageSurvey.setPrimaryHealthCentresDistanceOutsideNearestCentre(villageRequest.getPrimaryHealthCentresDistanceOutsideNearestCentre());

// 2.m) Civil Hospital located in village
        villageSurvey.setCivilHospitalLocatedInVillage(villageRequest.getCivilHospitalLocatedInVillage());
        villageSurvey.setCivilHospitalNumbersInsideVillage(villageRequest.getCivilHospitalNumbersInsideVillage());
        villageSurvey.setCivilHospitalDistanceOutsideNearestCentre(villageRequest.getCivilHospitalDistanceOutsideNearestCentre());

// 2.n) SHG’s in village
        villageSurvey.setShgsInVillage(villageRequest.getShgsInVillage());
        villageSurvey.setShgsNumbersInsideVillage(villageRequest.getShgsNumbersInsideVillage());
        villageSurvey.setShgsDistanceOutsideNearestCentre(villageRequest.getShgsDistanceOutsideNearestCentre());

// 2.o) NGO’s in village
        villageSurvey.setNgosInVillage(villageRequest.getNgosInVillage());
        villageSurvey.setNgosNumbersInsideVillage(villageRequest.getNgosNumbersInsideVillage());
        villageSurvey.setNgosDistanceOutsideNearestCentre(villageRequest.getNgosDistanceOutsideNearestCentre());

// 2.p) Jan Aushadhi Yojana Kendra located in village
        villageSurvey.setJanAushadhiYojanaKendraLocatedInVillage(villageRequest.getJanAushadhiYojanaKendraLocatedInVillage());
        villageSurvey.setJanAushadhiYojanaKendraNumbersInsideVillage(villageRequest.getJanAushadhiYojanaKendraNumbersInsideVillage());
        villageSurvey.setJanAushadhiYojanaKendraDistanceOutsideNearestCentre(villageRequest.getJanAushadhiYojanaKendraDistanceOutsideNearestCentre());

// 2.q) Post Office located in village
        villageSurvey.setPostOfficeLocatedInVillage(villageRequest.getPostOfficeLocatedInVillage());
        villageSurvey.setPostOfficeNumbersInsideVillage(villageRequest.getPostOfficeNumbersInsideVillage());
        villageSurvey.setPostOfficeDistanceOutsideNearestCentre(villageRequest.getPostOfficeDistanceOutsideNearestCentre());

// 2.r) Gas agencies located in village
        villageSurvey.setGasAgenciesLocatedInVillage(villageRequest.getGasAgenciesLocatedInVillage());
        villageSurvey.setGasAgenciesNumbersInsideVillage(villageRequest.getGasAgenciesNumbersInsideVillage());
        villageSurvey.setGasAgenciesDistanceOutsideNearestCentre(villageRequest.getGasAgenciesDistanceOutsideNearestCentre());

// 2.s) Training Centres located in village
        villageSurvey.setTrainingCentresLocatedInVillage(villageRequest.getTrainingCentresLocatedInVillage());
        villageSurvey.setTrainingCentresName(villageRequest.getTrainingCentresName());
        villageSurvey.setTrainingCentresNumbersInsideVillage(villageRequest.getTrainingCentresNumbersInsideVillage());
        villageSurvey.setTrainingCentresDistanceOutsideNearestCentre(villageRequest.getTrainingCentresDistanceOutsideNearestCentre());

// 2.t) Electricity Office located in village
        villageSurvey.setElectricityOfficeLocatedInVillage(villageRequest.getElectricityOfficeLocatedInVillage());
        villageSurvey.setElectricityOfficeNumbersInsideVillage(villageRequest.getElectricityOfficeNumbersInsideVillage());
        villageSurvey.setElectricityOfficeDistanceOutsideNearestCentre(villageRequest.getElectricityOfficeDistanceOutsideNearestCentre());

// 2.u) Anganwadi Kendra located in village
        villageSurvey.setAnganwadiKendraLocatedInVillage(villageRequest.getAnganwadiKendraLocatedInVillage());
        villageSurvey.setAnganwadiKendraNumbersInsideVillage(villageRequest.getAnganwadiKendraNumbersInsideVillage());
        villageSurvey.setAnganwadiKendraDistanceOutsideNearestCentre(villageRequest.getAnganwadiKendraDistanceOutsideNearestCentre());

// 2.v) Petrol Pumps in village
        villageSurvey.setPetrolPumpsInVillage(villageRequest.getPetrolPumpsInVillage());
        villageSurvey.setPetrolPumpsNumbersInsideVillage(villageRequest.getPetrolPumpsNumbersInsideVillage());
        villageSurvey.setPetrolPumpsDistanceOutsideNearestCentre(villageRequest.getPetrolPumpsDistanceOutsideNearestCentre());

// 2.w) Kisan Sewa Kendra in village
        villageSurvey.setKisanSewaKendraInVillage(villageRequest.getKisanSewaKendraInVillage());
        villageSurvey.setKisanSewaKendraNumbersInsideVillage(villageRequest.getKisanSewaKendraNumbersInsideVillage());
        villageSurvey.setKisanSewaKendraDistanceOutsideNearestCentre(villageRequest.getKisanSewaKendraDistanceOutsideNearestCentre());

// 2.x) Krishi Mandi in village
        villageSurvey.setKrishiMandiInVillage(villageRequest.getKrishiMandiInVillage());
        villageSurvey.setKrishiMandiNumbersInsideVillage(villageRequest.getKrishiMandiNumbersInsideVillage());
        villageSurvey.setKrishiMandiDistanceOutsideNearestCentre(villageRequest.getKrishiMandiDistanceOutsideNearestCentre());

// 2.y) Fare Price Shop in village
        villageSurvey.setFarePriceShopInVillage(villageRequest.getFarePriceShopInVillage());
        villageSurvey.setFarePriceShopNumbersInsideVillage(villageRequest.getFarePriceShopNumbersInsideVillage());
        villageSurvey.setFarePriceShopDistanceOutsideNearestCentre(villageRequest.getFarePriceShopDistanceOutsideNearestCentre());

// 2.z) Milk Cooperative/Collection Centre in village
        villageSurvey.setMilkCooperativeInVillage(villageRequest.getMilkCooperativeInVillage());
        villageSurvey.setMilkCooperativeNumbersInsideVillage(villageRequest.getMilkCooperativeNumbersInsideVillage());
        villageSurvey.setMilkCooperativeDistanceOutsideNearestCentre(villageRequest.getMilkCooperativeDistanceOutsideNearestCentre());

// 2.aa) Railway Station in village
        villageSurvey.setRailwayStationInVillage(villageRequest.getRailwayStationInVillage());
        villageSurvey.setRailwayStationNumbersInsideVillage(villageRequest.getRailwayStationNumbersInsideVillage());
        villageSurvey.setRailwayStationDistanceOutsideNearestCentre(villageRequest.getRailwayStationDistanceOutsideNearestCentre());

// 2.ab) Bus Stop in village
        villageSurvey.setBusStopInVillage(villageRequest.getBusStopInVillage());
        villageSurvey.setBusStopNumbersInsideVillage(villageRequest.getBusStopNumbersInsideVillage());
        villageSurvey.setBusStopDistanceOutsideNearestCentre(villageRequest.getBusStopDistanceOutsideNearestCentre());

// 2.ac) Veterinary Care Centre in village
        villageSurvey.setVeterinaryCareCentreInVillage(villageRequest.getVeterinaryCareCentreInVillage());
        villageSurvey.setVeterinaryCareCentreNumbersInsideVillage(villageRequest.getVeterinaryCareCentreNumbersInsideVillage());
        villageSurvey.setVeterinaryCareCentreDistanceOutsideNearestCentre(villageRequest.getVeterinaryCareCentreDistanceOutsideNearestCentre());

// 2.ad) Sports Facility/Grounds in village
        villageSurvey.setSportsFacilityInVillage(villageRequest.getSportsFacilityInVillage());
        villageSurvey.setSportsFacilityNumbersInsideVillage(villageRequest.getSportsFacilityNumbersInsideVillage());
        villageSurvey.setSportsFacilityDistanceOutsideNearestCentre(villageRequest.getSportsFacilityDistanceOutsideNearestCentre());

// 2.ae) Number of common sanitation complexes in village
        villageSurvey.setCommonSanitationComplexesInVillage(villageRequest.getCommonSanitationComplexesInVillage());
        villageSurvey.setCommonSanitationComplexesNumbersInsideVillage(villageRequest.getCommonSanitationComplexesNumbersInsideVillage());
        villageSurvey.setCommonSanitationComplexesDistanceOutsideNearestCentre(villageRequest.getCommonSanitationComplexesDistanceOutsideNearestCentre());

// 3. Village Connectivity (Roads)
// 3.a) Distance of the Village from the nearest Highway/Major Dist. Road (in km)
        villageSurvey.setDistanceFromNearestHighway(villageRequest.getDistanceFromNearestHighway());

// 3.b) Is the village connected to the above by a pacca road?
        villageSurvey.setVillageConnectedByPaccaRoad(villageRequest.getVillageConnectedByPaccaRoad());

// If yes, details of the Approach Road/Connecting Road
// 3.b.i) Length of the Road (in km)
        villageSurvey.setPaccaRoadLength(villageRequest.getPaccaRoadLength());

// 3.b.ii) Year of construction
        villageSurvey.setPaccaRoadYearOfConstruction(villageRequest.getPaccaRoadYearOfConstruction());

// 3.b.iii) Scheme under which constructed
        villageSurvey.setPaccaRoadConstructionScheme(villageRequest.getPaccaRoadConstructionScheme());

// 3.b.iv) Present Status (complete/incomplete)
        villageSurvey.setPaccaRoadStatus(villageRequest.getPaccaRoadStatus());

// 3.c) Length of Internal roads (inside village/hamlets)
// i) kachha (kms) ii) pakka (kms) iii) Total (kms)
        villageSurvey.setIntegerernalRoadsKachhaLength(villageRequest.getIntegerernalRoadsKachhaLength());
        villageSurvey.setIntegerernalRoadsPakkaLength(villageRequest.getIntegerernalRoadsPakkaLength());
        villageSurvey.setIntegerernalRoadsTotalLength(villageRequest.getIntegerernalRoadsTotalLength());

// 3.d) What is the mode of transport available?
        villageSurvey.setModeOfTransport(villageRequest.getModeOfTransport());

// If any other mode of transport, then specify
        villageSurvey.setOtherModeOfTransport(villageRequest.getOtherModeOfTransport());

// 3.e) Frequency of the available mode of transport
// Frequent Not Frequent only two times a day Any other
        villageSurvey.setTransportFrequency(villageRequest.getTransportFrequency());
        villageSurvey.setOtherTransportFrequency(villageRequest.getOtherTransportFrequency());

// 4. Land, Forest & Horticultural Profile
// 4.a) Type of Forest
        villageSurvey.setTypeOfForest(villageRequest.getTypeOfForest());

// 4.b) Community Forest (Acre)
        villageSurvey.setCommunityForestAcre(villageRequest.getCommunityForestAcre());

// 4.c) Government Forest (Acre)
        villageSurvey.setGovernmentForestAcre(villageRequest.getGovernmentForestAcre());

// 4.d) Main Forest Trees and Shrub Species
        villageSurvey.setMainForestTreesAndShrubSpecies(villageRequest.getMainForestTreesAndShrubSpecies());

// 4.e) Energy Plantation
        villageSurvey.setEnergyPlantation(villageRequest.getEnergyPlantation());

// If Yes, which species (Top 3) and area (in acre)
        villageSurvey.setEnergyPlantationSpeciesTop1(villageRequest.getEnergyPlantationSpeciesTop1());
        villageSurvey.setEnergyPlantationAreaTop1(villageRequest.getEnergyPlantationAreaTop1());
        villageSurvey.setEnergyPlantationSpeciesTop2(villageRequest.getEnergyPlantationSpeciesTop2());
        villageSurvey.setEnergyPlantationAreaTop2(villageRequest.getEnergyPlantationAreaTop2());
        villageSurvey.setEnergyPlantationSpeciesTop3(villageRequest.getEnergyPlantationSpeciesTop3());
        villageSurvey.setEnergyPlantationAreaTop3(villageRequest.getEnergyPlantationAreaTop3());

        villageSurvey.setStreetLightCFLLED(villageRequest.getStreetLightCFLLED());
        villageSurvey.setStreetLightCFLLEDDuration(villageRequest.getStreetLightCFLLEDDuration());
        villageSurvey.setStreetLightTubeLight(villageRequest.getStreetLightTubeLight());
        villageSurvey.setStreetLightTubeLightDuration(villageRequest.getStreetLightTubeLightDuration());



        villageSurvey.setComments(villageRequest.getComments());

//5 a
// Initialize PanchayatOffice object
        PanchayatOffice panchayatOffice = new PanchayatOffice();

// Set values for Electrical Appliances in Panchayat office
        panchayatOffice.setCflLed(villageRequest.getPanchayatOfficeCflLed());
        panchayatOffice.setFan(villageRequest.getPanchayatOfficeFan());
        panchayatOffice.setDesertCooler(villageRequest.getPanchayatOfficeDesertCooler());
        panchayatOffice.setTv(villageRequest.getPanchayatOfficeTv());
        panchayatOffice.setRefrigerator(villageRequest.getPanchayatOfficeRefrigerator());
        panchayatOffice.setMusicSystem(villageRequest.getPanchayatOfficeMusicSystem());
        panchayatOffice.setElectricMotorPump(villageRequest.getPanchayatOfficeElectricMotorPump());
        panchayatOffice.setHeater(villageRequest.getPanchayatOfficeHeater());
        panchayatOffice.setElectricIron(villageRequest.getPanchayatOfficeElectricIron());
        panchayatOffice.setAirConditioner(villageRequest.getPanchayatOfficeAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Panchayat office
        panchayatOffice.setCflLedDuration(villageRequest.getPanchayatOfficeCflLedDuration());
        panchayatOffice.setFanDuration(villageRequest.getPanchayatOfficeFanDuration());
        panchayatOffice.setDesertCoolerDuration(villageRequest.getPanchayatOfficeDesertCoolerDuration());
        panchayatOffice.setTvDuration(villageRequest.getPanchayatOfficeTvDuration());
        panchayatOffice.setRefrigeratorDuration(villageRequest.getPanchayatOfficeRefrigeratorDuration());
        panchayatOffice.setMusicSystemDuration(villageRequest.getPanchayatOfficeMusicSystemDuration());
        panchayatOffice.setElectricMotorPumpDuration(villageRequest.getPanchayatOfficeElectricMotorPumpDuration());
        panchayatOffice.setHeaterDuration(villageRequest.getPanchayatOfficeHeaterDuration());
        panchayatOffice.setElectricIronDuration(villageRequest.getPanchayatOfficeElectricIronDuration());
        panchayatOffice.setAirConditionerDuration(villageRequest.getPanchayatOfficeAirConditionerDuration());
        panchayatOfficeRepo.save(panchayatOffice);
// Initialize Dispensary object
        Dispensary dispensary = new Dispensary();

// Set values for Electrical Appliances in Dispensary
        dispensary.setCflLed(villageRequest.getDispensaryCflLed());
        dispensary.setFan(villageRequest.getDispensaryFan());
        dispensary.setDesertCooler(villageRequest.getDispensaryDesertCooler());
        dispensary.setTv(villageRequest.getDispensaryTv());
        dispensary.setRefrigerator(villageRequest.getDispensaryRefrigerator());
        dispensary.setMusicSystem(villageRequest.getDispensaryMusicSystem());
        dispensary.setElectricMotorPump(villageRequest.getDispensaryElectricMotorPump());
        dispensary.setHeater(villageRequest.getDispensaryHeater());
        dispensary.setElectricIron(villageRequest.getDispensaryElectricIron());
        dispensary.setAirConditioner(villageRequest.getDispensaryAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dispensary
        dispensary.setCflLedDuration(villageRequest.getDispensaryCflLedDuration());
        dispensary.setFanDuration(villageRequest.getDispensaryFanDuration());
        dispensary.setDesertCoolerDuration(villageRequest.getDispensaryDesertCoolerDuration());
        dispensary.setTvDuration(villageRequest.getDispensaryTvDuration());
        dispensary.setRefrigeratorDuration(villageRequest.getDispensaryRefrigeratorDuration());
        dispensary.setMusicSystemDuration(villageRequest.getDispensaryMusicSystemDuration());
        dispensary.setElectricMotorPumpDuration(villageRequest.getDispensaryElectricMotorPumpDuration());
        dispensary.setHeaterDuration(villageRequest.getDispensaryHeaterDuration());
        dispensary.setElectricIronDuration(villageRequest.getDispensaryElectricIronDuration());
        dispensary.setAirConditionerDuration(villageRequest.getDispensaryAirConditionerDuration());
        dispensaryRepo.save(dispensary);
// Initialize CommunityHall object
        CommunityHall communityHall = new CommunityHall();

// Set values for Electrical Appliances in Community Hall
        communityHall.setCflLed(villageRequest.getCommunityHallCflLed());
        communityHall.setFan(villageRequest.getCommunityHallFan());
        communityHall.setDesertCooler(villageRequest.getCommunityHallDesertCooler());
        communityHall.setTv(villageRequest.getCommunityHallTv());
        communityHall.setRefrigerator(villageRequest.getCommunityHallRefrigerator());
        communityHall.setMusicSystem(villageRequest.getCommunityHallMusicSystem());
        communityHall.setElectricMotorPump(villageRequest.getCommunityHallElectricMotorPump());
        communityHall.setHeater(villageRequest.getCommunityHallHeater());
        communityHall.setElectricIron(villageRequest.getCommunityHallElectricIron());
        communityHall.setAirConditioner(villageRequest.getCommunityHallAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Community Hall
        communityHall.setCflLedDuration(villageRequest.getCommunityHallCflLedDuration());
        communityHall.setFanDuration(villageRequest.getCommunityHallFanDuration());
        communityHall.setDesertCoolerDuration(villageRequest.getCommunityHallDesertCoolerDuration());
        communityHall.setTvDuration(villageRequest.getCommunityHallTvDuration());
        communityHall.setRefrigeratorDuration(villageRequest.getCommunityHallRefrigeratorDuration());
        communityHall.setMusicSystemDuration(villageRequest.getCommunityHallMusicSystemDuration());
        communityHall.setElectricMotorPumpDuration(villageRequest.getCommunityHallElectricMotorPumpDuration());
        communityHall.setHeaterDuration(villageRequest.getCommunityHallHeaterDuration());
        communityHall.setElectricIronDuration(villageRequest.getCommunityHallElectricIronDuration());
        communityHall.setAirConditionerDuration(villageRequest.getCommunityHallAirConditionerDuration());
        communityHallRepo.save(communityHall);
// Return a message or perform further actions
// Initialize Dharamashala object
        Dharamashala dharamashala = new Dharamashala();

// Set values for Electrical Appliances in Dharamashala
        dharamashala.setCflLed(villageRequest.getDharamashalaCflLed());
        dharamashala.setFan(villageRequest.getDharamashalaFan());
        dharamashala.setDesertCooler(villageRequest.getDharamashalaDesertCooler());
        dharamashala.setTv(villageRequest.getDharamashalaTv());
        dharamashala.setRefrigerator(villageRequest.getDharamashalaRefrigerator());
        dharamashala.setMusicSystem(villageRequest.getDharamashalaMusicSystem());
        dharamashala.setElectricMotorPump(villageRequest.getDharamashalaElectricMotorPump());
        dharamashala.setHeater(villageRequest.getDharamashalaHeater());
        dharamashala.setElectricIron(villageRequest.getDharamashalaElectricIron());
        dharamashala.setAirConditioner(villageRequest.getDharamashalaAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dharamashala
        dharamashala.setCflLedDuration(villageRequest.getDharamashalaCflLedDuration());
        dharamashala.setFanDuration(villageRequest.getDharamashalaFanDuration());
        dharamashala.setDesertCoolerDuration(villageRequest.getDharamashalaDesertCoolerDuration());
        dharamashala.setTvDuration(villageRequest.getDharamashalaTvDuration());
        dharamashala.setRefrigeratorDuration(villageRequest.getDharamashalaRefrigeratorDuration());
        dharamashala.setMusicSystemDuration(villageRequest.getDharamashalaMusicSystemDuration());
        dharamashala.setElectricMotorPumpDuration(villageRequest.getDharamashalaElectricMotorPumpDuration());
        dharamashala.setHeaterDuration(villageRequest.getDharamashalaHeaterDuration());
        dharamashala.setElectricIronDuration(villageRequest.getDharamashalaElectricIronDuration());
        dharamashala.setAirConditionerDuration(villageRequest.getDharamashalaAirConditionerDuration());
        dharamashalaRepo.save(dharamashala);
// Similar initialization for other categories (Social Organisations, Training cum Production Centres, Other Areas)

// Initialize SocialOrganisations object
        SocialOrganisations socialOrganisations = new SocialOrganisations();
// Set values for Electrical Appliances in Social Organisations
        socialOrganisations.setCflLed(villageRequest.getSocialOrganisationsCflLed());
        socialOrganisations.setFan(villageRequest.getSocialOrganisationsFan());
        socialOrganisations.setDesertCooler(villageRequest.getSocialOrganisationsDesertCooler());
        socialOrganisations.setTv(villageRequest.getSocialOrganisationsTv());
        socialOrganisations.setRefrigerator(villageRequest.getSocialOrganisationsRefrigerator());
        socialOrganisations.setMusicSystem(villageRequest.getSocialOrganisationsMusicSystem());
        socialOrganisations.setElectricMotorPump(villageRequest.getSocialOrganisationsElectricMotorPump());
        socialOrganisations.setHeater(villageRequest.getSocialOrganisationsHeater());
        socialOrganisations.setElectricIron(villageRequest.getSocialOrganisationsElectricIron());
        socialOrganisations.setAirConditioner(villageRequest.getSocialOrganisationsAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Social Organisations
        socialOrganisations.setCflLedDuration(villageRequest.getSocialOrganisationsCflLedDuration());
        socialOrganisations.setFanDuration(villageRequest.getSocialOrganisationsFanDuration());
        socialOrganisations.setDesertCoolerDuration(villageRequest.getSocialOrganisationsDesertCoolerDuration());
        socialOrganisations.setTvDuration(villageRequest.getSocialOrganisationsTvDuration());
        socialOrganisations.setRefrigeratorDuration(villageRequest.getSocialOrganisationsRefrigeratorDuration());
        socialOrganisations.setMusicSystemDuration(villageRequest.getSocialOrganisationsMusicSystemDuration());
        socialOrganisations.setElectricMotorPumpDuration(villageRequest.getSocialOrganisationsElectricMotorPumpDuration());
        socialOrganisations.setHeaterDuration(villageRequest.getSocialOrganisationsHeaterDuration());
        socialOrganisations.setElectricIronDuration(villageRequest.getSocialOrganisationsElectricIronDuration());
        socialOrganisations.setAirConditionerDuration(villageRequest.getSocialOrganisationsAirConditionerDuration());
        socialOrganisationsRepo.save(socialOrganisations);
// Initialize Tpc object
// Initialize TrainingProductionCentres object
        TrainingProductionCentres tpc = new TrainingProductionCentres();

// Set values for Electrical Appliances in Training cum Production Centres
        tpc.setCflLed(villageRequest.getTpcCflLed());
        tpc.setFan(villageRequest.getTpcFan());
        tpc.setDesertCooler(villageRequest.getTpcDesertCooler());
        tpc.setTv(villageRequest.getTpcTv());
        tpc.setRefrigerator(villageRequest.getTpcRefrigerator());
        tpc.setMusicSystem(villageRequest.getTpcMusicSystem());
        tpc.setElectricMotorPump(villageRequest.getTpcElectricMotorPump());
        tpc.setHeater(villageRequest.getTpcHeater());
        tpc.setElectricIron(villageRequest.getTpcElectricIron());
        tpc.setAirConditioner(villageRequest.getTpcAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Training cum Production Centres
        tpc.setCflLedDuration(villageRequest.getTpcCflLedDuration());
        tpc.setFanDuration(villageRequest.getTpcFanDuration());
        tpc.setDesertCoolerDuration(villageRequest.getTpcDesertCoolerDuration());
        tpc.setTvDuration(villageRequest.getTpcTvDuration());
        tpc.setRefrigeratorDuration(villageRequest.getTpcRefrigeratorDuration());
        tpc.setMusicSystemDuration(villageRequest.getTpcMusicSystemDuration());
        tpc.setElectricMotorPumpDuration(villageRequest.getTpcElectricMotorPumpDuration());
        tpc.setHeaterDuration(villageRequest.getTpcHeaterDuration());
        tpc.setElectricIronDuration(villageRequest.getTpcElectricIronDuration());
        tpc.setAirConditionerDuration(villageRequest.getTpcAirConditionerDuration());
        trainingProductionCentresRepo.save(tpc);
        // Initialize OtherAreas object
        OtherAreas otherAreas = new OtherAreas();

        // Set values for Electrical Appliances in Other Areas

        otherAreas.setCflLed(villageRequest.getOtherAreasCflLed());
        otherAreas.setFan(villageRequest.getOtherAreasFan());
        otherAreas.setDesertCooler(villageRequest.getOtherAreasDesertCooler());
        otherAreas.setTv(villageRequest.getOtherAreasTv());
        otherAreas.setRefrigerator(villageRequest.getOtherAreasRefrigerator());
        otherAreas.setMusicSystem(villageRequest.getOtherAreasMusicSystem());
        otherAreas.setElectricMotorPump(villageRequest.getOtherAreasElectricMotorPump());
        otherAreas.setHeater(villageRequest.getOtherAreasHeater());
        otherAreas.setElectricIron(villageRequest.getOtherAreasElectricIron());
        otherAreas.setAirConditioner(villageRequest.getOtherAreasAirConditioner());

        // Set values for Working duration/day (in hours) of Electrical Appliances in Other Areas
        otherAreas.setCflLedDuration(villageRequest.getOtherAreasCflLedDuration());
        otherAreas.setFanDuration(villageRequest.getOtherAreasFanDuration());
        otherAreas.setDesertCoolerDuration(villageRequest.getOtherAreasDesertCoolerDuration());
        otherAreas.setTvDuration(villageRequest.getOtherAreasTvDuration());
        otherAreas.setRefrigeratorDuration(villageRequest.getOtherAreasRefrigeratorDuration());
        otherAreas.setMusicSystemDuration(villageRequest.getOtherAreasMusicSystemDuration());
        otherAreas.setElectricMotorPumpDuration(villageRequest.getOtherAreasElectricMotorPumpDuration());
        otherAreas.setHeaterDuration(villageRequest.getOtherAreasHeaterDuration());
        otherAreas.setElectricIronDuration(villageRequest.getOtherAreasElectricIronDuration());
        otherAreas.setAirConditionerDuration(villageRequest.getOtherAreasAirConditionerDuration());
        otherAreasRepo.save(otherAreas);

        villageSurvey.setPanchayatOfficeId(panchayatOffice.getId());
        villageSurvey.setDispensaryId(dispensary.getId());
        villageSurvey.setDharamashalaId(dharamashala.getId());
        villageSurvey.setTPCId(tpc.getId());
        villageSurvey.setCommunityHallId(communityHall.getId());
        villageSurvey.setOtherAreasElectricalAppliances(villageRequest.getOtherAreasElectricalAppliances());

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

    public VillageRequest convertVillageToDto(VillageSurvey villageSur){
        VillageRequest villageRequest = new VillageRequest();
        villageRequest.setSurveyorName(villageSur.getSurveyorName());
        villageRequest.setRespondentName(villageSur.getRespondentName());
        villageRequest.setDateOfSurvey(villageSur.getDateOfSurvey());
        villageRequest.setVillageId(villageSur.getVillageId());
        villageRequest.setNameOfTheVillage(villageSur.getNameOfTheVillage());
        villageRequest.setGramPanchayat(villageSur.getGramPanchayat());
        villageRequest.setNumberOfWards(villageSur.getNumberOfWards());
        villageRequest.setNumberOfHamlets(villageSur.getNumberOfHamlets());
        villageRequest.setBlock(villageSur.getBlock());
        villageRequest.setDistrict(villageSur.getDistrict());
        villageRequest.setState(villageSur.getState());
        villageRequest.setLokSabhaConstituency(villageSur.getLokSabhaConstituency());
        villageRequest.setDistanceFromDistrictHQ(villageSur.getDistanceFromDistrictHQ());
        villageRequest.setAreaOfVillageAcres(villageSur.getAreaOfVillageAcres());
        villageRequest.setArableLandAgricultureAreaAcres(villageSur.getArableLandAgricultureAreaAcres());
        villageRequest.setForestAreaAcre(villageSur.getForestAreaAcre());
        villageRequest.setHousingAbadiAreaAcres(villageSur.getHousingAbadiAreaAcres());
        villageRequest.setAreaUnderWaterBodiesAcres(villageSur.getAreaUnderWaterBodiesAcres());
        villageRequest.setCommonLandsAreaAcres(villageSur.getCommonLandsAreaAcres());
        villageRequest.setAveragePerCapitaLandHoldingAcre(villageSur.getAveragePerCapitaLandHoldingAcre());
        villageRequest.setWasteLandAcres(villageSur.getWasteLandAcres());
        villageRequest.setWaterTableFeet(villageSur.getWaterTableFeet());


// 2.a) Primary Schools (Govt.) located in Village
        villageRequest.setPrimarySchoolsGovtLocatedInVillage(villageSur.getPrimarySchoolsGovtLocatedInVillage());
        villageRequest.setPrimarySchoolsGovtNumbersInsideVillage(villageSur.getPrimarySchoolsGovtNumbersInsideVillage());
        villageRequest.setPrimarySchoolsGovtDistanceOutsideNearestCentre(villageSur.getPrimarySchoolsGovtDistanceOutsideNearestCentre());

// 2.b) Primary Schools (Private) located in village
        villageRequest.setPrimarySchoolsPrivateLocatedInVillage(villageSur.getPrimarySchoolsPrivateLocatedInVillage());
        villageRequest.setPrimarySchoolsPrivateNumbersInsideVillage(villageSur.getPrimarySchoolsPrivateNumbersInsideVillage());
        villageRequest.setPrimarySchoolsPrivateDistanceOutsideNearestCentre(villageSur.getPrimarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.c) Middle Schools (Govt.) located in village
        villageRequest.setMiddleSchoolsGovtLocatedInVillage(villageSur.getMiddleSchoolsGovtLocatedInVillage());
        villageRequest.setMiddleSchoolsGovtNumbersInsideVillage(villageSur.getMiddleSchoolsGovtNumbersInsideVillage());
        villageRequest.setMiddleSchoolsGovtDistanceOutsideNearestCentre(villageSur.getMiddleSchoolsGovtDistanceOutsideNearestCentre());

// 2.d) Middle Schools (Private) located in village
        villageRequest.setMiddleSchoolsPrivateLocatedInVillage(villageSur.getMiddleSchoolsPrivateLocatedInVillage());
        villageRequest.setMiddleSchoolsPrivateNumbersInsideVillage(villageSur.getMiddleSchoolsPrivateNumbersInsideVillage());
        villageRequest.setMiddleSchoolsPrivateDistanceOutsideNearestCentre(villageSur.getMiddleSchoolsPrivateDistanceOutsideNearestCentre());

// 2.e) Secondary Schools (Govt.) located in village
        villageRequest.setSecondarySchoolsGovtLocatedInVillage(villageSur.getSecondarySchoolsGovtLocatedInVillage());
        villageRequest.setSecondarySchoolsGovtNumbersInsideVillage(villageSur.getSecondarySchoolsGovtNumbersInsideVillage());
        villageRequest.setSecondarySchoolsGovtDistanceOutsideNearestCentre(villageSur.getSecondarySchoolsGovtDistanceOutsideNearestCentre());

// 2.f) Secondary Schools (Private) located in village
        villageRequest.setSecondarySchoolsPrivateLocatedInVillage(villageSur.getSecondarySchoolsPrivateLocatedInVillage());
        villageRequest.setSecondarySchoolsPrivateNumbersInsideVillage(villageSur.getSecondarySchoolsPrivateNumbersInsideVillage());
        villageRequest.setSecondarySchoolsPrivateDistanceOutsideNearestCentre(villageSur.getSecondarySchoolsPrivateDistanceOutsideNearestCentre());

// 2.g) ITI Diploma Institutes (Govt.) located in village
        villageRequest.setItiDiplomaInstitutesGovtLocatedInVillage(villageSur.getItiDiplomaInstitutesGovtLocatedInVillage());
        villageRequest.setItiDiplomaInstitutesGovtNumbersInsideVillage(villageSur.getItiDiplomaInstitutesGovtNumbersInsideVillage());
        villageRequest.setItiDiplomaInstitutesGovtDistanceOutsideNearestCentre(villageSur.getItiDiplomaInstitutesGovtDistanceOutsideNearestCentre());

// 2.h) ITI Diploma Institutes (Private) located in village
        villageRequest.setItiDiplomaInstitutesPrivateLocatedInVillage(villageSur.getItiDiplomaInstitutesPrivateLocatedInVillage());
        villageRequest.setItiDiplomaInstitutesPrivateNumbersInsideVillage(villageSur.getItiDiplomaInstitutesPrivateNumbersInsideVillage());
        villageRequest.setItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre(villageSur.getItiDiplomaInstitutesPrivateDistanceOutsideNearestCentre());

// 2.i) Colleges (Govt.) located in village
        villageRequest.setCollegesGovtLocatedInVillage(villageSur.getCollegesGovtLocatedInVillage());
        villageRequest.setCollegesGovtNumbersInsideVillage(villageSur.getCollegesGovtNumbersInsideVillage());
        villageRequest.setCollegesGovtDistanceOutsideNearestCentre(villageSur.getCollegesGovtDistanceOutsideNearestCentre());

// 2.j) Colleges (Private) located in village
        villageRequest.setCollegesPrivateLocatedInVillage(villageSur.getCollegesPrivateLocatedInVillage());
        villageRequest.setCollegesPrivateNumbersInsideVillage(villageSur.getCollegesPrivateNumbersInsideVillage());
        villageRequest.setCollegesPrivateDistanceOutsideNearestCentre(villageSur.getCollegesPrivateDistanceOutsideNearestCentre());

// 2.k) Banks / ATM located in village
        villageRequest.setBanksAtmLocatedInVillage(villageSur.getBanksAtmLocatedInVillage());
        villageRequest.setBanksInsideVillageNumbers(villageSur.getBanksInsideVillageNumbers());
        villageRequest.setAtmInsideVillageNumbers(villageSur.getAtmInsideVillageNumbers());
        villageRequest.setBanksAtmDistanceOutsideNearestCentre(villageSur.getBanksAtmDistanceOutsideNearestCentre());

// 2.l) Primary Health Centres located in village
        villageRequest.setPrimaryHealthCentresLocatedInVillage(villageSur.getPrimaryHealthCentresLocatedInVillage());
        villageRequest.setPrimaryHealthCentresNumbersInsideVillage(villageSur.getPrimaryHealthCentresNumbersInsideVillage());
        villageRequest.setPrimaryHealthCentresDistanceOutsideNearestCentre(villageSur.getPrimaryHealthCentresDistanceOutsideNearestCentre());

// 2.m) Civil Hospital located in village
        villageRequest.setCivilHospitalLocatedInVillage(villageSur.getCivilHospitalLocatedInVillage());
        villageRequest.setCivilHospitalNumbersInsideVillage(villageSur.getCivilHospitalNumbersInsideVillage());
        villageRequest.setCivilHospitalDistanceOutsideNearestCentre(villageSur.getCivilHospitalDistanceOutsideNearestCentre());

// 2.n) SHG’s in village
        villageRequest.setShgsInVillage(villageSur.getShgsInVillage());
        villageRequest.setShgsNumbersInsideVillage(villageSur.getShgsNumbersInsideVillage());
        villageRequest.setShgsDistanceOutsideNearestCentre(villageSur.getShgsDistanceOutsideNearestCentre());

// 2.o) NGO’s in village
        villageRequest.setNgosInVillage(villageSur.getNgosInVillage());
        villageRequest.setNgosNumbersInsideVillage(villageSur.getNgosNumbersInsideVillage());
        villageRequest.setNgosDistanceOutsideNearestCentre(villageSur.getNgosDistanceOutsideNearestCentre());

// 2.p) Jan Aushadhi Yojana Kendra located in village
        villageRequest.setJanAushadhiYojanaKendraLocatedInVillage(villageSur.getJanAushadhiYojanaKendraLocatedInVillage());
        villageRequest.setJanAushadhiYojanaKendraNumbersInsideVillage(villageSur.getJanAushadhiYojanaKendraNumbersInsideVillage());
        villageRequest.setJanAushadhiYojanaKendraDistanceOutsideNearestCentre(villageSur.getJanAushadhiYojanaKendraDistanceOutsideNearestCentre());

// 2.q) Post Office located in village
        villageRequest.setPostOfficeLocatedInVillage(villageSur.getPostOfficeLocatedInVillage());
        villageRequest.setPostOfficeNumbersInsideVillage(villageSur.getPostOfficeNumbersInsideVillage());
        villageRequest.setPostOfficeDistanceOutsideNearestCentre(villageSur.getPostOfficeDistanceOutsideNearestCentre());

// 2.r) Gas agencies located in village
        villageRequest.setGasAgenciesLocatedInVillage(villageSur.getGasAgenciesLocatedInVillage());
        villageRequest.setGasAgenciesNumbersInsideVillage(villageSur.getGasAgenciesNumbersInsideVillage());
        villageRequest.setGasAgenciesDistanceOutsideNearestCentre(villageSur.getGasAgenciesDistanceOutsideNearestCentre());

// 2.s) Training Centres located in village
        villageRequest.setTrainingCentresLocatedInVillage(villageSur.getTrainingCentresLocatedInVillage());
        villageRequest.setTrainingCentresName(villageSur.getTrainingCentresName());
        villageRequest.setTrainingCentresNumbersInsideVillage(villageSur.getTrainingCentresNumbersInsideVillage());
        villageRequest.setTrainingCentresDistanceOutsideNearestCentre(villageSur.getTrainingCentresDistanceOutsideNearestCentre());

// 2.t) Electricity Office located in village
        villageRequest.setElectricityOfficeLocatedInVillage(villageSur.getElectricityOfficeLocatedInVillage());
        villageRequest.setElectricityOfficeNumbersInsideVillage(villageSur.getElectricityOfficeNumbersInsideVillage());
        villageRequest.setElectricityOfficeDistanceOutsideNearestCentre(villageSur.getElectricityOfficeDistanceOutsideNearestCentre());

// 2.u) Anganwadi Kendra located in village
        villageRequest.setAnganwadiKendraLocatedInVillage(villageSur.getAnganwadiKendraLocatedInVillage());
        villageRequest.setAnganwadiKendraNumbersInsideVillage(villageSur.getAnganwadiKendraNumbersInsideVillage());
        villageRequest.setAnganwadiKendraDistanceOutsideNearestCentre(villageSur.getAnganwadiKendraDistanceOutsideNearestCentre());

// 2.v) Petrol Pumps in village
        villageRequest.setPetrolPumpsInVillage(villageSur.getPetrolPumpsInVillage());
        villageRequest.setPetrolPumpsNumbersInsideVillage(villageSur.getPetrolPumpsNumbersInsideVillage());
        villageRequest.setPetrolPumpsDistanceOutsideNearestCentre(villageSur.getPetrolPumpsDistanceOutsideNearestCentre());

// 2.w) Kisan Sewa Kendra in village
        villageRequest.setKisanSewaKendraInVillage(villageSur.getKisanSewaKendraInVillage());
        villageRequest.setKisanSewaKendraNumbersInsideVillage(villageSur.getKisanSewaKendraNumbersInsideVillage());
        villageRequest.setKisanSewaKendraDistanceOutsideNearestCentre(villageSur.getKisanSewaKendraDistanceOutsideNearestCentre());

// 2.x) Krishi Mandi in village
        villageRequest.setKrishiMandiInVillage(villageSur.getKrishiMandiInVillage());
        villageRequest.setKrishiMandiNumbersInsideVillage(villageSur.getKrishiMandiNumbersInsideVillage());
        villageRequest.setKrishiMandiDistanceOutsideNearestCentre(villageSur.getKrishiMandiDistanceOutsideNearestCentre());

// 2.y) Fare Price Shop in village
        villageRequest.setFarePriceShopInVillage(villageSur.getFarePriceShopInVillage());
        villageRequest.setFarePriceShopNumbersInsideVillage(villageSur.getFarePriceShopNumbersInsideVillage());
        villageRequest.setFarePriceShopDistanceOutsideNearestCentre(villageSur.getFarePriceShopDistanceOutsideNearestCentre());

// 2.z) Milk Cooperative/Collection Centre in village
        villageRequest.setMilkCooperativeInVillage(villageSur.getMilkCooperativeInVillage());
        villageRequest.setMilkCooperativeNumbersInsideVillage(villageSur.getMilkCooperativeNumbersInsideVillage());
        villageRequest.setMilkCooperativeDistanceOutsideNearestCentre(villageSur.getMilkCooperativeDistanceOutsideNearestCentre());

// 2.aa) Railway Station in village
        villageRequest.setRailwayStationInVillage(villageSur.getRailwayStationInVillage());
        villageRequest.setRailwayStationNumbersInsideVillage(villageSur.getRailwayStationNumbersInsideVillage());
        villageRequest.setRailwayStationDistanceOutsideNearestCentre(villageSur.getRailwayStationDistanceOutsideNearestCentre());

// 2.ab) Bus Stop in village
        villageRequest.setBusStopInVillage(villageSur.getBusStopInVillage());
        villageRequest.setBusStopNumbersInsideVillage(villageSur.getBusStopNumbersInsideVillage());
        villageRequest.setBusStopDistanceOutsideNearestCentre(villageSur.getBusStopDistanceOutsideNearestCentre());

// 2.ac) Veterinary Care Centre in village
        villageRequest.setVeterinaryCareCentreInVillage(villageSur.getVeterinaryCareCentreInVillage());
        villageRequest.setVeterinaryCareCentreNumbersInsideVillage(villageSur.getVeterinaryCareCentreNumbersInsideVillage());
        villageRequest.setVeterinaryCareCentreDistanceOutsideNearestCentre(villageSur.getVeterinaryCareCentreDistanceOutsideNearestCentre());

// 2.ad) Sports Facility/Grounds in village
        villageRequest.setSportsFacilityInVillage(villageSur.getSportsFacilityInVillage());
        villageRequest.setSportsFacilityNumbersInsideVillage(villageSur.getSportsFacilityNumbersInsideVillage());
        villageRequest.setSportsFacilityDistanceOutsideNearestCentre(villageSur.getSportsFacilityDistanceOutsideNearestCentre());

// 2.ae) Number of common sanitation complexes in village
        villageRequest.setCommonSanitationComplexesInVillage(villageSur.getCommonSanitationComplexesInVillage());
        villageRequest.setCommonSanitationComplexesNumbersInsideVillage(villageSur.getCommonSanitationComplexesNumbersInsideVillage());
        villageRequest.setCommonSanitationComplexesDistanceOutsideNearestCentre(villageSur.getCommonSanitationComplexesDistanceOutsideNearestCentre());

// 3. Village Connectivity (Roads)
// 3.a) Distance of the Village from the nearest Highway/Major Dist. Road (in km)
        villageRequest.setDistanceFromNearestHighway(villageSur.getDistanceFromNearestHighway());

// 3.b) Is the village connected to the above by a pacca road?
        villageRequest.setVillageConnectedByPaccaRoad(villageSur.getVillageConnectedByPaccaRoad());

// If yes, details of the Approach Road/Connecting Road
// 3.b.i) Length of the Road (in km)
        villageRequest.setPaccaRoadLength(villageSur.getPaccaRoadLength());

// 3.b.ii) Year of construction
        villageRequest.setPaccaRoadYearOfConstruction(villageSur.getPaccaRoadYearOfConstruction());

// 3.b.iii) Scheme under which constructed
        villageRequest.setPaccaRoadConstructionScheme(villageSur.getPaccaRoadConstructionScheme());

// 3.b.iv) Present Status (complete/incomplete)
        villageRequest.setPaccaRoadStatus(villageSur.getPaccaRoadStatus());

// 3.c) Length of Internal roads (inside village/hamlets)
// i) kachha (kms) ii) pakka (kms) iii) Total (kms)
        villageRequest.setIntegerernalRoadsKachhaLength(villageSur.getIntegerernalRoadsKachhaLength());
        villageRequest.setIntegerernalRoadsPakkaLength(villageSur.getIntegerernalRoadsPakkaLength());
        villageRequest.setIntegerernalRoadsTotalLength(villageSur.getIntegerernalRoadsTotalLength());

// 3.d) What is the mode of transport available?
        villageRequest.setModeOfTransport(villageSur.getModeOfTransport());

// If any other mode of transport, then specify
        villageRequest.setOtherModeOfTransport(villageSur.getOtherModeOfTransport());

// 3.e) Frequency of the available mode of transport
// Frequent Not Frequent only two times a day Any other
        villageRequest.setTransportFrequency(villageSur.getTransportFrequency());
        villageRequest.setOtherTransportFrequency(villageSur.getOtherTransportFrequency());

// 4. Land, Forest & Horticultural Profile
// 4.a) Type of Forest
        villageRequest.setTypeOfForest(villageSur.getTypeOfForest());

// 4.b) Community Forest (Acre)
        villageRequest.setCommunityForestAcre(villageSur.getCommunityForestAcre());

// 4.c) Government Forest (Acre)
        villageRequest.setGovernmentForestAcre(villageSur.getGovernmentForestAcre());

// 4.d) Main Forest Trees and Shrub Species
        villageRequest.setMainForestTreesAndShrubSpecies(villageSur.getMainForestTreesAndShrubSpecies());

// 4.e) Energy Plantation
        villageRequest.setEnergyPlantation(villageSur.getEnergyPlantation());

// If Yes, which species (Top 3) and area (in acre)
        villageRequest.setEnergyPlantationSpeciesTop1(villageSur.getEnergyPlantationSpeciesTop1());
        villageRequest.setEnergyPlantationAreaTop1(villageSur.getEnergyPlantationAreaTop1());
        villageRequest.setEnergyPlantationSpeciesTop2(villageSur.getEnergyPlantationSpeciesTop2());
        villageRequest.setEnergyPlantationAreaTop2(villageSur.getEnergyPlantationAreaTop2());
        villageRequest.setEnergyPlantationSpeciesTop3(villageSur.getEnergyPlantationSpeciesTop3());
        villageRequest.setEnergyPlantationAreaTop3(villageSur.getEnergyPlantationAreaTop3());

        villageRequest.setStreetLightCFLLED(villageSur.getStreetLightCFLLED());
        villageRequest.setStreetLightCFLLEDDuration(villageSur.getStreetLightCFLLEDDuration());
        villageRequest.setStreetLightTubeLight(villageSur.getStreetLightTubeLight());
        villageRequest.setStreetLightTubeLightDuration(villageSur.getStreetLightTubeLightDuration());

        villageRequest.setComments(villageSur.getComments());

//5 a
        PanchayatOffice panchayatOffice = panchayatOfficeRepo.findById(villageSur.getPanchayatOfficeId())
                .orElseThrow(()->new NotFoundException("Panchayat Not Found with id"+ villageSur.getPanchayatOfficeId()));

        villageRequest.setPanchayatOfficeCflLed(panchayatOffice.getCflLed());
        villageRequest.setPanchayatOfficeFan(panchayatOffice.getFan());
        villageRequest.setPanchayatOfficeDesertCooler(panchayatOffice.getDesertCooler());
        villageRequest.setPanchayatOfficeTv(panchayatOffice.getTv());
        villageRequest.setPanchayatOfficeRefrigerator(panchayatOffice.getRefrigerator());
        villageRequest.setPanchayatOfficeMusicSystem(panchayatOffice.getMusicSystem());
        villageRequest.setPanchayatOfficeElectricMotorPump(panchayatOffice.getElectricMotorPump());
        villageRequest.setPanchayatOfficeHeater(panchayatOffice.getHeater());
        villageRequest.setPanchayatOfficeElectricIron(panchayatOffice.getElectricIron());
        villageRequest.setPanchayatOfficeAirConditioner(panchayatOffice.getAirConditioner());

// Working duration/day (in hours) of Electrical Appliances in Panchayat office
        villageRequest.setPanchayatOfficeCflLedDuration(panchayatOffice.getCflLedDuration());
        villageRequest.setPanchayatOfficeFanDuration(panchayatOffice.getFanDuration());
        villageRequest.setPanchayatOfficeDesertCoolerDuration(panchayatOffice.getDesertCoolerDuration());
        villageRequest.setPanchayatOfficeTvDuration(panchayatOffice.getTvDuration());
        villageRequest.setPanchayatOfficeRefrigeratorDuration(panchayatOffice.getRefrigeratorDuration());
        villageRequest.setPanchayatOfficeMusicSystemDuration(panchayatOffice.getMusicSystemDuration());
        villageRequest.setPanchayatOfficeElectricMotorPumpDuration(panchayatOffice.getElectricMotorPumpDuration());
        villageRequest.setPanchayatOfficeHeaterDuration(panchayatOffice.getHeaterDuration());
        villageRequest.setPanchayatOfficeElectricIronDuration(panchayatOffice.getElectricIronDuration());
        villageRequest.setPanchayatOfficeAirConditionerDuration(panchayatOffice.getAirConditionerDuration());


        Dispensary dispensary = dispensaryRepo.findById(villageSur.getDispensaryId())
                .orElseThrow(() -> new NotFoundException("Dispensary Not Found with id" + villageSur.getDispensaryId()));

// Set values for Electrical Appliances in Dispensary
        villageRequest.setDispensaryCflLed(dispensary.getCflLed());
        villageRequest.setDispensaryFan(dispensary.getFan());
        villageRequest.setDispensaryDesertCooler(dispensary.getDesertCooler());
        villageRequest.setDispensaryTv(dispensary.getTv());
        villageRequest.setDispensaryRefrigerator(dispensary.getRefrigerator());
        villageRequest.setDispensaryMusicSystem(dispensary.getMusicSystem());
        villageRequest.setDispensaryElectricMotorPump(dispensary.getElectricMotorPump());
        villageRequest.setDispensaryHeater(dispensary.getHeater());
        villageRequest.setDispensaryElectricIron(dispensary.getElectricIron());
        villageRequest.setDispensaryAirConditioner(dispensary.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dispensary
        villageRequest.setDispensaryCflLedDuration(dispensary.getCflLedDuration());
        villageRequest.setDispensaryFanDuration(dispensary.getFanDuration());
        villageRequest.setDispensaryDesertCoolerDuration(dispensary.getDesertCoolerDuration());
        villageRequest.setDispensaryTvDuration(dispensary.getTvDuration());
        villageRequest.setDispensaryRefrigeratorDuration(dispensary.getRefrigeratorDuration());
        villageRequest.setDispensaryMusicSystemDuration(dispensary.getMusicSystemDuration());
        villageRequest.setDispensaryElectricMotorPumpDuration(dispensary.getElectricMotorPumpDuration());
        villageRequest.setDispensaryHeaterDuration(dispensary.getHeaterDuration());
        villageRequest.setDispensaryElectricIronDuration(dispensary.getElectricIronDuration());
        villageRequest.setDispensaryAirConditionerDuration(dispensary.getAirConditionerDuration());

// Initialize CommunityHall object

        CommunityHall communityHall = communityHallRepo.findById(villageSur.getCommunityHallId())
                .orElseThrow(() -> new NotFoundException("CommunityHall Not Found with id" + villageSur.getCommunityHallId()));

// Set values for Electrical Appliances in Community Hall
        villageRequest.setCommunityHallCflLed(communityHall.getCflLed());
        villageRequest.setCommunityHallFan(communityHall.getFan());
        villageRequest.setCommunityHallDesertCooler(communityHall.getDesertCooler());
        villageRequest.setCommunityHallTv(communityHall.getTv());
        villageRequest.setCommunityHallRefrigerator(communityHall.getRefrigerator());
        villageRequest.setCommunityHallMusicSystem(communityHall.getMusicSystem());
        villageRequest.setCommunityHallElectricMotorPump(communityHall.getElectricMotorPump());
        villageRequest.setCommunityHallHeater(communityHall.getHeater());
        villageRequest.setCommunityHallElectricIron(communityHall.getElectricIron());
        villageRequest.setCommunityHallAirConditioner(communityHall.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Community Hall
        villageRequest.setCommunityHallCflLedDuration(communityHall.getCflLedDuration());
        villageRequest.setCommunityHallFanDuration(communityHall.getFanDuration());
        villageRequest.setCommunityHallDesertCoolerDuration(communityHall.getDesertCoolerDuration());
        villageRequest.setCommunityHallTvDuration(communityHall.getTvDuration());
        villageRequest.setCommunityHallRefrigeratorDuration(communityHall.getRefrigeratorDuration());
        villageRequest.setCommunityHallMusicSystemDuration(communityHall.getMusicSystemDuration());
        villageRequest.setCommunityHallElectricMotorPumpDuration(communityHall.getElectricMotorPumpDuration());
        villageRequest.setCommunityHallHeaterDuration(communityHall.getHeaterDuration());
        villageRequest.setCommunityHallElectricIronDuration(communityHall.getElectricIronDuration());
        villageRequest.setCommunityHallAirConditionerDuration(communityHall.getAirConditionerDuration());


// Initialize Dharamashala object
        Dharamashala dharamashala = dharamashalaRepo.findById(villageSur.getDharamashalaId())
                .orElseThrow(() -> new NotFoundException("Dharamashala Not Found with id " + villageSur.getDharamashalaId()));

// Set values for Electrical Appliances in Dharamashala
        villageRequest.setDharamashalaCflLed(dharamashala.getCflLed());
        villageRequest.setDharamashalaFan(dharamashala.getFan());
        villageRequest.setDharamashalaDesertCooler(dharamashala.getDesertCooler());
        villageRequest.setDharamashalaTv(dharamashala.getTv());
        villageRequest.setDharamashalaRefrigerator(dharamashala.getRefrigerator());
        villageRequest.setDharamashalaMusicSystem(dharamashala.getMusicSystem());
        villageRequest.setDharamashalaElectricMotorPump(dharamashala.getElectricMotorPump());
        villageRequest.setDharamashalaHeater(dharamashala.getHeater());
        villageRequest.setDharamashalaElectricIron(dharamashala.getElectricIron());
        villageRequest.setDharamashalaAirConditioner(dharamashala.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Dharamashala
        villageRequest.setDharamashalaCflLedDuration(dharamashala.getCflLedDuration());
        villageRequest.setDharamashalaFanDuration(dharamashala.getFanDuration());
        villageRequest.setDharamashalaDesertCoolerDuration(dharamashala.getDesertCoolerDuration());
        villageRequest.setDharamashalaTvDuration(dharamashala.getTvDuration());
        villageRequest.setDharamashalaRefrigeratorDuration(dharamashala.getRefrigeratorDuration());
        villageRequest.setDharamashalaMusicSystemDuration(dharamashala.getMusicSystemDuration());
        villageRequest.setDharamashalaElectricMotorPumpDuration(dharamashala.getElectricMotorPumpDuration());
        villageRequest.setDharamashalaHeaterDuration(dharamashala.getHeaterDuration());
        villageRequest.setDharamashalaElectricIronDuration(dharamashala.getElectricIronDuration());
        villageRequest.setDharamashalaAirConditionerDuration(dharamashala.getAirConditionerDuration());


        // Initialize SocialOrganisations object
        SocialOrganisations socialOrganisations = socialOrganisationsRepo.findById(villageSur.getSocialOrganisationsId())
                .orElseThrow(() -> new NotFoundException("Social Orginasation Not Found with id " + villageSur.getSocialOrganisationsId()));

// Set values for Electrical Appliances in Social Organisations
        villageRequest.setSocialOrganisationsCflLed(socialOrganisations.getCflLed());
        villageRequest.setSocialOrganisationsFan(socialOrganisations.getFan());
        villageRequest.setSocialOrganisationsDesertCooler(socialOrganisations.getDesertCooler());
        villageRequest.setSocialOrganisationsTv(socialOrganisations.getTv());
        villageRequest.setSocialOrganisationsRefrigerator(socialOrganisations.getRefrigerator());
        villageRequest.setSocialOrganisationsMusicSystem(socialOrganisations.getMusicSystem());
        villageRequest.setSocialOrganisationsElectricMotorPump(socialOrganisations.getElectricMotorPump());
        villageRequest.setSocialOrganisationsHeater(socialOrganisations.getHeater());
        villageRequest.setSocialOrganisationsElectricIron(socialOrganisations.getElectricIron());
        villageRequest.setSocialOrganisationsAirConditioner(socialOrganisations.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Social Organisations
        villageRequest.setSocialOrganisationsCflLedDuration(socialOrganisations.getCflLedDuration());
        villageRequest.setSocialOrganisationsFanDuration(socialOrganisations.getFanDuration());
        villageRequest.setSocialOrganisationsDesertCoolerDuration(socialOrganisations.getDesertCoolerDuration());
        villageRequest.setSocialOrganisationsTvDuration(socialOrganisations.getTvDuration());
        villageRequest.setSocialOrganisationsRefrigeratorDuration(socialOrganisations.getRefrigeratorDuration());
        villageRequest.setSocialOrganisationsMusicSystemDuration(socialOrganisations.getMusicSystemDuration());
        villageRequest.setSocialOrganisationsElectricMotorPumpDuration(socialOrganisations.getElectricMotorPumpDuration());
        villageRequest.setSocialOrganisationsHeaterDuration(socialOrganisations.getHeaterDuration());
        villageRequest.setSocialOrganisationsElectricIronDuration(socialOrganisations.getElectricIronDuration());
        villageRequest.setSocialOrganisationsAirConditionerDuration(socialOrganisations.getAirConditionerDuration());

        // Initialize TrainingProductionCentres object
        TrainingProductionCentres trainingProductionCentres = trainingProductionCentresRepo.findById(villageSur.getTPCId())
                .orElseThrow(() -> new NotFoundException("Training Production Centres Not Found with id " + villageSur.getTPCId()));

// Set values for Electrical Appliances in Training cum Production Centres
        villageRequest.setTpcCflLed(trainingProductionCentres.getCflLed());
        villageRequest.setTpcFan(trainingProductionCentres.getFan());
        villageRequest.setTpcDesertCooler(trainingProductionCentres.getDesertCooler());
        villageRequest.setTpcTv(trainingProductionCentres.getTv());
        villageRequest.setTpcRefrigerator(trainingProductionCentres.getRefrigerator());
        villageRequest.setTpcMusicSystem(trainingProductionCentres.getMusicSystem());
        villageRequest.setTpcElectricMotorPump(trainingProductionCentres.getElectricMotorPump());
        villageRequest.setTpcHeater(trainingProductionCentres.getHeater());
        villageRequest.setTpcElectricIron(trainingProductionCentres.getElectricIron());
        villageRequest.setTpcAirConditioner(trainingProductionCentres.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Training cum Production Centres
        villageRequest.setTpcCflLedDuration(trainingProductionCentres.getCflLedDuration());
        villageRequest.setTpcFanDuration(trainingProductionCentres.getFanDuration());
        villageRequest.setTpcDesertCoolerDuration(trainingProductionCentres.getDesertCoolerDuration());
        villageRequest.setTpcTvDuration(trainingProductionCentres.getTvDuration());
        villageRequest.setTpcRefrigeratorDuration(trainingProductionCentres.getRefrigeratorDuration());
        villageRequest.setTpcMusicSystemDuration(trainingProductionCentres.getMusicSystemDuration());
        villageRequest.setTpcElectricMotorPumpDuration(trainingProductionCentres.getElectricMotorPumpDuration());
        villageRequest.setTpcHeaterDuration(trainingProductionCentres.getHeaterDuration());
        villageRequest.setTpcElectricIronDuration(trainingProductionCentres.getElectricIronDuration());
        villageRequest.setTpcAirConditionerDuration(trainingProductionCentres.getAirConditionerDuration());

        /// Initialize OtherAreas object
        OtherAreas otherAreas = otherAreasRepo.findById(villageSur.getOtherAreasId())
                .orElseThrow(() -> new NotFoundException("Other Areas Not Found with id " + villageSur.getOtherAreasId()));

// Set values for Electrical Appliances in Other Areas
        villageRequest.setOtherAreasCflLed(otherAreas.getCflLed());
        villageRequest.setOtherAreasFan(otherAreas.getFan());
        villageRequest.setOtherAreasDesertCooler(otherAreas.getDesertCooler());
        villageRequest.setOtherAreasTv(otherAreas.getTv());
        villageRequest.setOtherAreasRefrigerator(otherAreas.getRefrigerator());
        villageRequest.setOtherAreasMusicSystem(otherAreas.getMusicSystem());
        villageRequest.setOtherAreasElectricMotorPump(otherAreas.getElectricMotorPump());
        villageRequest.setOtherAreasHeater(otherAreas.getHeater());
        villageRequest.setOtherAreasElectricIron(otherAreas.getElectricIron());
        villageRequest.setOtherAreasAirConditioner(otherAreas.getAirConditioner());

// Set values for Working duration/day (in hours) of Electrical Appliances in Other Areas
        villageRequest.setOtherAreasCflLedDuration(otherAreas.getCflLedDuration());
        villageRequest.setOtherAreasFanDuration(otherAreas.getFanDuration());
        villageRequest.setOtherAreasDesertCoolerDuration(otherAreas.getDesertCoolerDuration());
        villageRequest.setOtherAreasTvDuration(otherAreas.getTvDuration());
        villageRequest.setOtherAreasRefrigeratorDuration(otherAreas.getRefrigeratorDuration());
        villageRequest.setOtherAreasMusicSystemDuration(otherAreas.getMusicSystemDuration());
        villageRequest.setOtherAreasElectricMotorPumpDuration(otherAreas.getElectricMotorPumpDuration());
        villageRequest.setOtherAreasHeaterDuration(otherAreas.getHeaterDuration());
        villageRequest.setOtherAreasElectricIronDuration(otherAreas.getElectricIronDuration());
        villageRequest.setOtherAreasAirConditionerDuration(otherAreas.getAirConditionerDuration());

        villageRequest.setOtherAreasElectricalAppliances(villageSur.getOtherAreasElectricalAppliances());


        return villageRequest;
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

    public ByteArrayResource createExcel(String survey)  {
        try {
            if (Objects.equals(survey, "village")) {
                List<VillageSurvey> sortedList = villageSurveyRepo.findAll().stream()
                        .sorted(Comparator.comparing(VillageSurvey::getDateOfSurvey).reversed())
                        .toList();
                return villageRequestExcelService.createExcel(sortedList.stream().map(this::convertVillageToDto).toList());
            } else {
                List<HouseholdSurvey> householdSurveys = householdSurveyRepo.findAll().stream()
                        .sorted(Comparator.comparing(HouseholdSurvey::getDateOfSurvey).reversed())
                        .toList();
                return householdSurveyExcelService.createExcel(householdSurveys.stream().map(this::convertHouseholdToDto).toList());
            }
        }
        catch (Exception e){
            throw new APIException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
