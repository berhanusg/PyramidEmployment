package com.pyramidbuildersemployment.models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleName name;

    // Getters and setters

    public enum RoleName {
        ROLE_USER,
        ROLE_HIRING_COMPANY,
        ROLE_JOB_SEEKER,
        ROLE_ADMIN
    }

}
    // constructors, getters, setters, etc.



