package uba.survey.ubasurvey.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data

@NoArgsConstructor
public class Village {
    @Id
    private String id = UUID.randomUUID().toString();
    private String villageName;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Response> surveyResponse = new HashSet<>();

    public Village(String villageName) {
        this.villageName = villageName;
    }
}
