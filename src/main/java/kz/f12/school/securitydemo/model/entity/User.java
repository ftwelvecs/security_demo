package kz.f12.school.securitydemo.model.entity;

import kz.f12.school.securitydemo.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "auth", name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_active")
    private Boolean isActive;

}
