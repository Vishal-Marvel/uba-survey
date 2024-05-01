package uba.survey.ubasurvey.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Entity
@Data
public class NextId {
    @Id
    private String id = UUID.randomUUID().toString();
    private String surveyId;

    @ElementCollection
    @CollectionTable(name = "next_id_map_table")
    @MapKeyColumn(name = "survey_Id")
    @Column(name = "next_Id")
    private Map<String, Integer> nextId ;
}
