package uba.survey.ubasurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;


@Data
@Entity
public class ResponseRecord {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private Response response;

    @ManyToOne
    private Section section;

    @ManyToOne
    private Field field;

    private Integer counter;

    @OneToMany
    private Set<AnswerOption> answers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResponseRecord that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getResponse(), that.getResponse()) && Objects.equals(getSection(), that.getSection()) && Objects.equals(getField(), that.getField()) && Objects.equals(getAnswers(), that.getAnswers());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "ResponseRecord{" +
                "id='" + id + '\'' +
                ", field=" + field.getQuestion() +
                ", answers=" + answers +
                '}';
    }
}
