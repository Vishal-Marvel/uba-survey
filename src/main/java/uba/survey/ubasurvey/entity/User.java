package uba.survey.ubasurvey.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id = UUID.randomUUID().toString();
    private String userName;
    private String email;
    private String password;
    private UserRole role;
}
