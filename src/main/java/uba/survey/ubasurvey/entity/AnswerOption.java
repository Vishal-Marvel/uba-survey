package uba.survey.ubasurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
public class AnswerOption {
    @Id
    private String id = UUID.randomUUID().toString();
    private String optionName;

    private Date date = new Date();

    @ManyToOne
    private Field field;
    @ManyToOne
    private ResponseRecord responseRecord;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerOption that = (AnswerOption) o;
        return Objects.equals(id, that.id) && Objects.equals(optionName, that.optionName) && Objects.equals(field, that.field);
    }

    @Override
    public String toString() {
        return "DropdownOption{" +
                "id='" + id + '\'' +
                ", optionName='" + optionName + '\'' +
                '}';
    }
}
