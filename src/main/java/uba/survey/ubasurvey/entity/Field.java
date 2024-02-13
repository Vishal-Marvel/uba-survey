package uba.survey.ubasurvey.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
public class Field {
    @Id
    private String id = UUID.randomUUID().toString();
    private String fieldType;
    private String question;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<AnswerOption> answerOptions = new HashSet<>();

    @ManyToOne
    private Section section;


    @OneToMany(cascade = CascadeType.ALL)
    private Set<Field> subFields;

    @ManyToOne
    private Field parentField;

    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] image;

    @OneToOne
    private Field yesField;

    @OneToOne
    private Field noField;

    @OneToMany
    private Set<ResponseRecord> responseRecords;



    @Override
    public int hashCode(){

        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(id, field.id) && Objects.equals(fieldType, field.fieldType) && Objects.equals(answerOptions, field.answerOptions) && Objects.equals(section, field.section) && Objects.equals(subFields, field.subFields) && Objects.equals(parentField, field.parentField) && Arrays.equals(image, field.image) && Objects.equals(yesField, field.yesField) && Objects.equals(noField, field.noField);
    }

    @Override
    public String toString() {
        return "Field{" +
                "id='" + id + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", question='" + question + '\'' +
                '}';
    }
}
