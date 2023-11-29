package uba.survey.ubasurvey.entity.villageSurvey;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Dharamashala {
    @Id
    private String id = UUID.randomUUID().toString();
    // 5.e) Electrical Appliances in Dharamashala:
    // *Electrical Appliances:
    private Integer cflLed;
    private Integer fan;
    private Integer desertCooler;
    private Integer tv;
    private Integer refrigerator;
    private Integer musicSystem;
    private Integer electricMotorPump;
    private Integer heater;
    private Integer electricIron;
    private Integer airConditioner;

    // Working duration/day (in hours) of Electrical Appliances in Panchayat office
    private Double cflLedDuration;
    private Double fanDuration;
    private Double desertCoolerDuration;
    private Double tvDuration;
    private Double refrigeratorDuration;
    private Double musicSystemDuration;
    private Double electricMotorPumpDuration;
    private Double heaterDuration;
    private Double electricIronDuration;
    private Double airConditionerDuration;


}
