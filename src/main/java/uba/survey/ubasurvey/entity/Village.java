package uba.survey.ubasurvey.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Entity
@Data

@NoArgsConstructor
public class Village {
    @Id
    private String id = UUID.randomUUID().toString();
    private String villageName;
    private Integer villageNum;
    private String state;
    private String district;
    @ElementCollection
    @CollectionTable(name = "gram_panchayat")
    @MapKeyColumn(name = "gram_panchayat_name")
    @Column(name = "gram_panchayat_code")
    private Map<String, String> gramPanchyat;
    private String blockName;
    private String blockCode;
    private String collegeName;
    private Integer wardNo;
    private String villageCode;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Response> surveyResponse = new HashSet<>();

    public Village(String villageName) {
        this.villageName = villageName;
    }
}
