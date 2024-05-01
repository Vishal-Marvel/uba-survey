package uba.survey.ubasurvey.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Section {
    @Id
    private String id = UUID.randomUUID().toString();
    private String sectionName;
    private Date date = new Date();

    @OneToMany
    private Set<Field> fields = new HashSet<>();

    @OneToMany
    private Set<ResponseRecord> responseRecords = new HashSet<>();

    @ManyToOne
    private Survey survey;

    private Boolean isActive = true;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Section{" +
                "id='" + id + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", fields length = " + fields.size() +
                ", survey=" + survey.getSurveyName() +
                '}';
    }
}
