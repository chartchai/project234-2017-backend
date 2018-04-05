package camt.se234.project.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class User {
    @Id
    Long id;
    String username;
    String password;
    String role;
}
