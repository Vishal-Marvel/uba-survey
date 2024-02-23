package uba.survey.ubasurvey.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.*;

@Data
@Entity
public class Response {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private Survey survey;

    @ManyToOne
    private User user;

    private Date date = new Date();

    @ManyToOne
    private Village village;

    @OneToOne
    private UniqueSurvey responseId;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ResponseRecord> responseRecords = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response response)) return false;
        return Objects.equals(getId(), response.getId()) && Objects.equals(getSurvey(), response.getSurvey()) && Objects.equals(getVillage(), response.getVillage()) && Objects.equals(getResponseRecords(), response.getResponseRecords());
    }

    @Override
    public String toString() {
        return "Response{" +
                "id='" + id + '\'' +
                ", survey=" + survey.getSurveyName() +
                ", user=" + user.getUserName() +
                ", date=" + date.toString() +
                ", village=" + village.getVillageName() +
                ", responseRecords=" + responseRecords +
                '}';
    }

    @Override
    public int hashCode() {
        return getSurvey().hashCode();
    }


}
