package uba.survey.ubasurvey.entity.villagesurvey;

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
    private Integer cflLedDuration;
    private Integer fanDuration;
    private Integer desertCoolerDuration;
    private Integer tvDuration;
    private Integer refrigeratorDuration;
    private Integer musicSystemDuration;
    private Integer electricMotorPumpDuration;
    private Integer heaterDuration;
    private Integer electricIronDuration;
    private Integer airConditionerDuration;


}
