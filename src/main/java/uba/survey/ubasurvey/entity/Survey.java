package uba.survey.ubasurvey.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class Survey {
    @Id
    private String id = UUID.randomUUID().toString();
    private String surveyName;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Section> sections = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Response> responses = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Survey survey)) return false;
        return Objects.equals(getId(), survey.getId()) && Objects.equals(getSurveyName(), survey.getSurveyName()) && Objects.equals(getSections(), survey.getSections());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id='" + id + '\'' +
                ", surveyName='" + surveyName + '\'' +
                ", sections length=" + sections.size() +
                ", responses length=" + responses.size() +
                '}';
    }
}
