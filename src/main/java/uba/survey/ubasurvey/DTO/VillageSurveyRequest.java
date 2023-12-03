package uba.survey.ubasurvey.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class VillageSurveyRequest {
    private String surveyorName;
    private String respondentName;
    private Date dateOfSurvey;
    // Basic Information:
    private Integer villageId;
    private String nameOfTheVillage;
    private String gramPanchayat;
    private Integer numberOfWards;
    private Integer numberOfHamlets;
    private String block;
    private String district;
    private String state;
    private String lokSabhaConstituency;
    private Double distanceFromDistrictHQ;
    private Double areaOfVillageAcres;
    private Double arableLandAgricultureAreaAcres;
    private Double forestAreaAcre;
    private Double housingAbadiAreaAcres;
    private Double areaUnderWaterBodiesAcres;
    private Double commonLandsAreaAcres;
    private Double averagePerCapitaLandHoldingAcre;
    private Double wasteLandAcres;
    private Double waterTableFeet;

    // 2.a) Primary Schools (Govt.) located in Village
    private Boolean primarySchoolsGovtLocatedInVillage;
    private Integer primarySchoolsGovtNumbersInsideVillage;
    private Double primarySchoolsGovtDistanceOutsideNearestCentre;

    // 2.b) Primary Schools (Private) located in village
    private Boolean primarySchoolsPrivateLocatedInVillage;
    private Integer primarySchoolsPrivateNumbersInsideVillage;
    private Double primarySchoolsPrivateDistanceOutsideNearestCentre;

    // 2.c) Middle Schools (Govt.) located in village
    private Boolean middleSchoolsGovtLocatedInVillage;
    private Integer middleSchoolsGovtNumbersInsideVillage;
    private Double middleSchoolsGovtDistanceOutsideNearestCentre;

    // 2.d) Middle Schools (Private) located in village
    private Boolean middleSchoolsPrivateLocatedInVillage;
    private Integer middleSchoolsPrivateNumbersInsideVillage;
    private Double middleSchoolsPrivateDistanceOutsideNearestCentre;

    // 2.e) Secondary Schools (Govt.) located in village
    private Boolean secondarySchoolsGovtLocatedInVillage;
    private Integer secondarySchoolsGovtNumbersInsideVillage;
    private Double secondarySchoolsGovtDistanceOutsideNearestCentre;

    // 2.f) Secondary Schools (Private) located in village
    private Boolean secondarySchoolsPrivateLocatedInVillage;
    private Integer secondarySchoolsPrivateNumbersInsideVillage;
    private Double secondarySchoolsPrivateDistanceOutsideNearestCentre;

    // 2.g) ITI Diploma Institutes (Govt.) located in village
    private Boolean itiDiplomaInstitutesGovtLocatedInVillage;
    private Integer itiDiplomaInstitutesGovtNumbersInsideVillage;
    private Double itiDiplomaInstitutesGovtDistanceOutsideNearestCentre;

    // 2.h) ITI Diploma Institutes (Private) located in village
    private Boolean itiDiplomaInstitutesPrivateLocatedInVillage;
    private Integer itiDiplomaInstitutesPrivateNumbersInsideVillage;
    private Double itiDiplomaInstitutesPrivateDistanceOutsideNearestCentre;

    // 2.i) Colleges (Govt.) located in village
    private Boolean collegesGovtLocatedInVillage;
    private Integer collegesGovtNumbersInsideVillage;
    private Double collegesGovtDistanceOutsideNearestCentre;

    // 2.j) Colleges (Private) located in village
    private Boolean collegesPrivateLocatedInVillage;
    private Integer collegesPrivateNumbersInsideVillage;
    private Double collegesPrivateDistanceOutsideNearestCentre;

    // 2.k) Banks / ATM located in village
    private Boolean banksAtmLocatedInVillage;
    private Integer banksInsideVillageNumbers;
    private Integer atmInsideVillageNumbers;
    private Double banksAtmDistanceOutsideNearestCentre;

    // 2.l) Primary Health Centres located in village
    private Boolean primaryHealthCentresLocatedInVillage;
    private Integer primaryHealthCentresNumbersInsideVillage;
    private Double primaryHealthCentresDistanceOutsideNearestCentre;

    // 2.m) Civil Hospital located in village
    private Boolean civilHospitalLocatedInVillage;
    private Integer civilHospitalNumbersInsideVillage;
    private Double civilHospitalDistanceOutsideNearestCentre;

    // 2.n) SHG’s in village
    private Boolean shgsInVillage;
    private Integer shgsNumbersInsideVillage;
    private Double shgsDistanceOutsideNearestCentre;

    // 2.o) NGO’s in village
    private Boolean ngosInVillage;
    private Integer ngosNumbersInsideVillage;
    private Double ngosDistanceOutsideNearestCentre;

    // 2.p) Jan Aushadhi Yojana Kendra located in village
    private Boolean janAushadhiYojanaKendraLocatedInVillage;
    private Integer janAushadhiYojanaKendraNumbersInsideVillage;
    private Double janAushadhiYojanaKendraDistanceOutsideNearestCentre;

    // 2.q) Post Office located in village
    private Boolean postOfficeLocatedInVillage;
    private Integer postOfficeNumbersInsideVillage;
    private Double postOfficeDistanceOutsideNearestCentre;

    // 2.r) Gas agencies located in village
    private Boolean gasAgenciesLocatedInVillage;
    private Integer gasAgenciesNumbersInsideVillage;
    private Double gasAgenciesDistanceOutsideNearestCentre;

    // 2.s) Training Centres located in village
    private Boolean trainingCentresLocatedInVillage;
    private String trainingCentresName;
    private Integer trainingCentresNumbersInsideVillage;
    private Double trainingCentresDistanceOutsideNearestCentre;

    // 2.t) Electricity Office located in village
    private Boolean electricityOfficeLocatedInVillage;
    private Integer electricityOfficeNumbersInsideVillage;
    private Double electricityOfficeDistanceOutsideNearestCentre;

    // 2.u) Anganwadi Kendra located in village
    private Boolean anganwadiKendraLocatedInVillage;
    private Integer anganwadiKendraNumbersInsideVillage;
    private Double anganwadiKendraDistanceOutsideNearestCentre;

    // 2.v) Petrol Pumps in village
    private Boolean petrolPumpsInVillage;
    private Integer petrolPumpsNumbersInsideVillage;
    private Double petrolPumpsDistanceOutsideNearestCentre;

    // 2.w) Kisan Sewa Kendra in village
    private Boolean kisanSewaKendraInVillage;
    private Integer kisanSewaKendraNumbersInsideVillage;
    private Double kisanSewaKendraDistanceOutsideNearestCentre;

    // 2.x) Krishi Mandi in village
    private Boolean krishiMandiInVillage;
    private Integer krishiMandiNumbersInsideVillage;
    private Double krishiMandiDistanceOutsideNearestCentre;

    // 2.y) Fare Price Shop in village
    private Boolean farePriceShopInVillage;
    private Integer farePriceShopNumbersInsideVillage;
    private Double farePriceShopDistanceOutsideNearestCentre;

    // 2.z) Milk Cooperative/Collection Centre in village
    private Boolean milkCooperativeInVillage;
    private Integer milkCooperativeNumbersInsideVillage;
    private Double milkCooperativeDistanceOutsideNearestCentre;

    // 2.aa) Railway Station in village
    private Boolean railwayStationInVillage;
    private Integer railwayStationNumbersInsideVillage;
    private Double railwayStationDistanceOutsideNearestCentre;

    // 2.ab) Bus Stop in village
    private Boolean busStopInVillage;
    private Integer busStopNumbersInsideVillage;
    private Double busStopDistanceOutsideNearestCentre;

    // 2.ac) Veterinary Care Centre in village
    private Boolean veterinaryCareCentreInVillage;
    private Integer veterinaryCareCentreNumbersInsideVillage;
    private Double veterinaryCareCentreDistanceOutsideNearestCentre;

    // 2.ad) Sports Facility/Grounds in village
    private Boolean sportsFacilityInVillage;
    private Integer sportsFacilityNumbersInsideVillage;
    private Double sportsFacilityDistanceOutsideNearestCentre;

    // 2.ae) Number of common sanitation complexes in village
    private Boolean commonSanitationComplexesInVillage;
    private Integer commonSanitationComplexesNumbersInsideVillage;
    private Double commonSanitationComplexesDistanceOutsideNearestCentre;

    // 3. Village Connectivity (Roads)
    // 3.a) Distance of the Village from the nearest Highway/Major Dist. Road (in km)
    private Double distanceFromNearestHighway;

    // 3.b) Is the village connected to the above by a pacca road?
    private Boolean villageConnectedByPaccaRoad;

    // If yes, details of the Approach Road/Connecting Road
    // 3.b.i) Length of the Road (in km)
    private Double paccaRoadLength;

    // 3.b.ii) Year of construction
    private Integer paccaRoadYearOfConstruction;

    // 3.b.iii) Scheme under which constructed
    private String paccaRoadConstructionScheme;

    // 3.b.iv) Present Status (complete/incomplete)
    private String paccaRoadStatus;

    // 3.c) Length of Integerernal roads (inside village/hamlets)
    // i) kachha (kms) ii) pakka (kms) iii) Total (kms)
    private Double IntegerernalRoadsKachhaLength;
    private Double IntegerernalRoadsPakkaLength;
    private Double IntegerernalRoadsTotalLength;

    // 3.d) What is the mode of transport available?
    private String modeOfTransport;

    // If any other mode of transport, then specify
    private String otherModeOfTransport;

    // 3.e) Frequency of the available mode of transport
    // Frequent Not Frequent only two times a day Any other
    private String transportFrequency;
    private String otherTransportFrequency;

    // 4. Land, Forest & Horticultural Profile
    // 4.a) Type of Forest
    private String typeOfForest; // Reserved, Protected, Open

    // 4.b) Community Forest (Acre)
    private Double communityForestAcre;

    // 4.c) Government Forest (Acre)
    private Double governmentForestAcre;

    // 4.d) Main Forest Trees and Shrub Species
    private String mainForestTreesAndShrubSpecies;

    // 4.e) Energy Plantation
    private Boolean energyPlantation;

    // If Yes, which species (Top 3) and area (in acre)
    private String energyPlantationSpeciesTop1;
    private Double energyPlantationAreaTop1;

    private String energyPlantationSpeciesTop2;
    private Double energyPlantationAreaTop2;

    private String energyPlantationSpeciesTop3;
    private Double energyPlantationAreaTop3;

    // 5. Common Village Electricity Requirements

    // 5.a) Electrical Appliances in Panchayat office:
    private Integer panchayatOfficeCflLed;
    private Integer panchayatOfficeFan;
    private Integer panchayatOfficeDesertCooler;
    private Integer panchayatOfficeTv;
    private Integer panchayatOfficeRefrigerator;
    private Integer panchayatOfficeMusicSystem;
    private Integer panchayatOfficeElectricMotorPump;
    private Integer panchayatOfficeHeater;
    private Integer panchayatOfficeElectricIron;
    private Integer panchayatOfficeAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Panchayat office
    private Double panchayatOfficeCflLedDuration;
    private Double panchayatOfficeFanDuration;
    private Double panchayatOfficeDesertCoolerDuration;
    private Double panchayatOfficeTvDuration;
    private Double panchayatOfficeRefrigeratorDuration;
    private Double panchayatOfficeMusicSystemDuration;
    private Double panchayatOfficeElectricMotorPumpDuration;
    private Double panchayatOfficeHeaterDuration;
    private Double panchayatOfficeElectricIronDuration;
    private Double panchayatOfficeAirConditionerDuration;


    // 5.b) Electrical Appliances in Dispensary:
    private Integer dispensaryCflLed;
    private Integer dispensaryFan;
    private Integer dispensaryDesertCooler;
    private Integer dispensaryTv;
    private Integer dispensaryRefrigerator;
    private Integer dispensaryMusicSystem;
    private Integer dispensaryElectricMotorPump;
    private Integer dispensaryHeater;
    private Integer dispensaryElectricIron;
    private Integer dispensaryAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Dispensary
    private Double dispensaryCflLedDuration;
    private Double dispensaryFanDuration;
    private Double dispensaryDesertCoolerDuration;
    private Double dispensaryTvDuration;
    private Double dispensaryRefrigeratorDuration;
    private Double dispensaryMusicSystemDuration;
    private Double dispensaryElectricMotorPumpDuration;
    private Double dispensaryHeaterDuration;
    private Double dispensaryElectricIronDuration;
    private Double dispensaryAirConditionerDuration;

    // 5.c) Electrical Appliances in Community Halls:
    private Integer communityHallCflLed;
    private Integer communityHallFan;
    private Integer communityHallDesertCooler;
    private Integer communityHallTv;
    private Integer communityHallRefrigerator;
    private Integer communityHallMusicSystem;
    private Integer communityHallElectricMotorPump;
    private Integer communityHallHeater;
    private Integer communityHallElectricIron;
    private Integer communityHallAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Community Hall
    private Double communityHallCflLedDuration;
    private Double communityHallFanDuration;
    private Double communityHallDesertCoolerDuration;
    private Double communityHallTvDuration;
    private Double communityHallRefrigeratorDuration;
    private Double communityHallMusicSystemDuration;
    private Double communityHallElectricMotorPumpDuration;
    private Double communityHallHeaterDuration;
    private Double communityHallElectricIronDuration;
    private Double communityHallAirConditionerDuration;


    // 5.d) Streetlights
    private Integer streetLightCFLLEDDuration;
    private Boolean streetLightCFLLED;
    private Boolean streetLightTubeLight;
    private Integer streetLightTubeLightDuration;

    // 5.e) Electrical Appliances in Dharamashala:
    // Appliances in Dharamashala
    private Integer dharamashalaCflLed;
    private Integer dharamashalaFan;
    private Integer dharamashalaDesertCooler;
    private Integer dharamashalaTv;
    private Integer dharamashalaRefrigerator;
    private Integer dharamashalaMusicSystem;
    private Integer dharamashalaElectricMotorPump;
    private Integer dharamashalaHeater;
    private Integer dharamashalaElectricIron;
    private Integer dharamashalaAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Dharamashala
    private Double dharamashalaCflLedDuration;
    private Double dharamashalaFanDuration;
    private Double dharamashalaDesertCoolerDuration;
    private Double dharamashalaTvDuration;
    private Double dharamashalaRefrigeratorDuration;
    private Double dharamashalaMusicSystemDuration;
    private Double dharamashalaElectricMotorPumpDuration;
    private Double dharamashalaHeaterDuration;
    private Double dharamashalaElectricIronDuration;
    private Double dharamashalaAirConditionerDuration;

    // 5.f) Electrical Appliances in Social Organisations (Youth/Mahila Clubs):
    private Integer socialOrganisationsCflLed;
    private Integer socialOrganisationsFan;
    private Integer socialOrganisationsDesertCooler;
    private Integer socialOrganisationsTv;
    private Integer socialOrganisationsRefrigerator;
    private Integer socialOrganisationsMusicSystem;
    private Integer socialOrganisationsElectricMotorPump;
    private Integer socialOrganisationsHeater;
    private Integer socialOrganisationsElectricIron;
    private Integer socialOrganisationsAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Social Organisations (Youth/Mahila Clubs)
    private Double socialOrganisationsCflLedDuration;
    private Double socialOrganisationsFanDuration;
    private Double socialOrganisationsDesertCoolerDuration;
    private Double socialOrganisationsTvDuration;
    private Double socialOrganisationsRefrigeratorDuration;
    private Double socialOrganisationsMusicSystemDuration;
    private Double socialOrganisationsElectricMotorPumpDuration;
    private Double socialOrganisationsHeaterDuration;
    private Double socialOrganisationsElectricIronDuration;
    private Double socialOrganisationsAirConditionerDuration;

    // 5.g) Electrical Appliances in Training cum Production Centres:
    // Appliances in Training cum Production Centres (TPC)
    private Integer tpcCflLed;
    private Integer tpcFan;
    private Integer tpcDesertCooler;
    private Integer tpcTv;
    private Integer tpcRefrigerator;
    private Integer tpcMusicSystem;
    private Integer tpcElectricMotorPump;
    private Integer tpcHeater;
    private Integer tpcElectricIron;
    private Integer tpcAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Training cum Production Centres (TPC)
    private Double tpcCflLedDuration;
    private Double tpcFanDuration;
    private Double tpcDesertCoolerDuration;
    private Double tpcTvDuration;
    private Double tpcRefrigeratorDuration;
    private Double tpcMusicSystemDuration;
    private Double tpcElectricMotorPumpDuration;
    private Double tpcHeaterDuration;
    private Double tpcElectricIronDuration;
    private Double tpcAirConditionerDuration;

    // 5.h) Electrical Appliances in other areas:
    private Boolean otherAreasElectricalAppliances;
    // Appliances in Other Areas
    private Integer otherAreasCflLed;
    private Integer otherAreasFan;
    private Integer otherAreasDesertCooler;
    private Integer otherAreasTv;
    private Integer otherAreasRefrigerator;
    private Integer otherAreasMusicSystem;
    private Integer otherAreasElectricMotorPump;
    private Integer otherAreasHeater;
    private Integer otherAreasElectricIron;
    private Integer otherAreasAirConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Other Areas
    private Double otherAreasCflLedDuration;
    private Double otherAreasFanDuration;
    private Double otherAreasDesertCoolerDuration;
    private Double otherAreasTvDuration;
    private Double otherAreasRefrigeratorDuration;
    private Double otherAreasMusicSystemDuration;
    private Double otherAreasElectricMotorPumpDuration;
    private Double otherAreasHeaterDuration;
    private Double otherAreasElectricIronDuration;
    private Double otherAreasAirConditionerDuration;

    private String comments;
}
