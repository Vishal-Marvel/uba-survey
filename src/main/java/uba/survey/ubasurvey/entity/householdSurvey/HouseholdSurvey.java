package uba.survey.ubasurvey.entity.householdSurvey;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Entity
@Data
public class HouseholdSurvey {
    @Id
    private String id = UUID.randomUUID().toString();
    // Schedule Filled by (Name)
    private String filledByName;

    // Date of Survey
    private Date dateOfSurvey;

    // General Information
    private String village;
    private String gramPanchayat;
    private String wardNo;
    private String block;
    private String district;
    private String state;

    // 1. Respondent’s Profile
    private String respondentName;
    private String gender;
    private Integer age;
    private String relationshipWithHead;
    private String contactNumber;

    // 2. General Household Information
    private String headOfHouseholdName;
    private String headGender;
    private Integer numberOfFamilyMembers;
    private String category;
    private String povertyStatus;
    private Boolean ownHouse;
    private String typeOfHouse;
    private String toilet;
    private String drainageLinkedToHouse;
    private String wasteCollectionSystem;
    private String compostPit;
    private String bioGasPlant;

    // 3. Family Member Information
    @ManyToMany(fetch = FetchType.EAGER)
    // Eager loading allows the roles to be loaded during the UserDetails extraction
    @JoinTable(name = "survey_members", joinColumns = @JoinColumn(name = "survey_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"))
    private Set<FamilyMember> members = new HashSet<>();

    // 4. Migration Status in a family
    private Boolean familyMigratesForWork;
    private Integer numberOfFamilyMembersMigrated;
    private String familyMigrationDuration;
    private String familyMigrationYears;

    // 5. Information of Government Schemes

    // 5.1 PM Jan Dhan Yojana - Beneficiary Individuals (In Number)
    private Integer pmJanDhanYojanaBeneficiaryIndividuals;

    // 5.2 Sukanya Samridhi Yojana - Beneficiary Individuals (In Number)
    private Integer sukanyaSamridhiYojanaBeneficiaryIndividuals;

    // 5.3 Mudra Yojana - Beneficiary Individuals (In Number)
    private Integer mudraYojanaBeneficiaryIndividuals;

    // 5.4 PM Jivan Jyoti Bima Yojana - Beneficiary Individuals (In Number)
    private Integer pmJivanJyotiBimaYojanaBeneficiaryIndividuals;

    // 5.5 PM Suraksha Bima Yojana - Beneficiary Individuals (In Number)
    private Integer pmSurakshaBimaYojanaBeneficiaryIndividuals;

    // 5.6 Atal pension Yojana - Beneficiary Individuals (In Number)
    private Integer atalPensionYojanaBeneficiaryIndividuals;

    // 5.7 Kaushal Vikas Yojana - Beneficiary Individuals (In Number)
    private Integer kaushalVikasYojanaBeneficiaryIndividuals;

    // 5.8 Janani Suraksha Yojana - Beneficiary Individuals (In Number)
    private Integer jananiSurakshaYojanaBeneficiaryIndividuals;

    // 5.9 Fasal Bima Yojana - Beneficiary Household
    private Boolean fasalBimaYojanaBeneficiaryHousehold;

    // 5.10 Kisan Credit Card - Beneficiary Household
    private Boolean kisanCreditCardBeneficiaryHousehold;

    // 5.11 Krishi Sinchai Yojana - Beneficiary Household
    private Boolean krishiSinchaiYojanaBeneficiaryHousehold;

    // 5.12 Swachh Bharat Mission Toilet - Beneficiary Household
    private Boolean swachhBharatMissionToiletBeneficiaryHousehold;

    // 5.13 Soil Health Card - Beneficiary Household
    private Boolean soilHealthCardBeneficiaryHousehold;

    // 5.14 PM Ujjwala Yojana - Beneficiary Household
    private Boolean pmUjjwalaYojanaBeneficiaryHousehold;

    // 5.15 PM Awas Yojana - Beneficiary Household
    private Boolean pmAwasYojanaBeneficiaryHousehold;

    // 6. Source of Water (Distance from source in km)

    // 6.1 Piped Water at Home
    private Boolean pipedWaterAtHome;
    private Double distanceFromPipedWater; // in km

    // 6.2 Community water tap
    private Boolean communityWaterTap;
    private Double distanceFromCommunityWaterTap; // in km

    // 6.3 Hand Pump (Public / Private)
    private Boolean handPump;
    private String public_privateHandPump; // differentiate between public and private hand pumps
    private Double distanceFromHandPump; // in km

    // 6.4 Open Well (Public / Private)
    private Boolean openWell;
    private String public_privateOpenWell; // differentiate between public and private open wells
    private Double distanceFromOpenWell; // in km

    // 6.5 Mode of Water Storage (Community/Individual)
    private Boolean communityWaterStorage;
    private Boolean individualWaterStorage;

    // 6.6 Any other source (Mention)
    private Boolean otherWaterSource;
    private String otherWaterSourceName;
    private Double distanceFromOtherWaterSource; // in km

    // 7. Source of Energy and Power

    // 7.1 Electricity Connection to Household
    private Boolean electricityConnectionToHousehold;

    // 7.2 Electricity Availability per day (hours)
    private Integer electricityAvailabilityPerDay; // in hours

    // 7.3 Lighting
    private String LightingSource; // Mention, if any other

    // 7.4 Cooking
    private String CookingSource; // Mention, if any other

    // 7.5 If cooking in Chullah
    private String chullahType;
    //Appliances
    @ManyToMany(fetch = FetchType.EAGER)
    // Eager loading allows the roles to be loaded during the UserDetails extraction
    @JoinTable(name = "survey_appliances", joinColumns = @JoinColumn(name = "survey_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appliance_id", referencedColumnName = "id"))
    private Set<AppliancesUsed> appliancesAndDuration = new HashSet<>();

    // 8. Landholding Information (in Acres)

    // 8.1 Total Land
    private Double totalLand; // in acres

    // 8.2 Cultivable Area
    private Double cultivableArea; // in acres

    // 8.3 Irrigated Area
    private Double irrigatedArea; // in acres

    // 8.4 Unirrigated Area
    private Double unirrigatedArea; // in acres

    // 8.5 Barren/Wasteland Area
    private Double barrenWastelandArea; // in acres

    // 8.6 Uncultivable Area
    private Double uncultivableArea; // in acres


    // 9. Agricultural Inputs

    // 9.1 Do you use Chemical Fertilizers?
    private Boolean useChemicalFertilizers;

    // If Yes, Usage in (Kg/Acre)
    private Double chemicalFertilizersUsage; // in Kg/Acre

    // 9.2 Do you use Chemical Insecticides?
    private Boolean useChemicalInsecticides;

    // If Yes, Usage in (Kg/Acre)
    private Double chemicalInsecticidesUsage; // in Kg/Acre

    // 9.3 Do you use Chemical Weedicide?
    private Boolean useChemicalWeedicide;

    // If Yes, Usage in (Kg/Acre)
    private Double chemicalWeedicideUsage; // in Kg/Acre

    // 9.4 Do You use organic Manures?
    private Boolean useOrganicManures;

    // If Yes, Usage in (Kg/Acre)
    private Double organicManuresUsage; // in Kg/Acre

    // 9.5 Irrigation
    private String IrrigationSource; // Mention, if any other

    // 9.6 Irrigation System
    private String IrrigationSystem;


    // 10. Agricultural Produce in a normal year (Top 5)
    @ManyToMany(fetch = FetchType.EAGER)
    // Eager loading allows the roles to be loaded during the UserDetails extraction
    @JoinTable(name = "survey_crops", joinColumns = @JoinColumn(name = "survey_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "crop_id", referencedColumnName = "id"))
    private Set<CropDetails> cropDetails = new HashSet<>();

    // 11. Livestock Numbers (in numbers)

    // 11.1 Livestocks
    private Integer cows;
    private Integer buffalos;
    private Integer goatsSheeps;
    private Integer calves;
    private Integer bullocks;
    private Integer poultryDucks;
    private Integer othersLivestock;

    // 11.2 Shelter for Livestock
    private String Shelter;

    // 11.3 Average Daily Production of Milk (Litres)
    private Double averageDailyMilkProduction; // in litres

    // 11.4 Animal Waste/Cow Dung (in Kg.)
    private Double animalWasteCowDung; // in kg

    // 12. Major problems in the village (Top 3)
    private String topProblem1;
    private String topProblem2;
    private String topProblem3;
    private String suggestionsForProblems;

}
