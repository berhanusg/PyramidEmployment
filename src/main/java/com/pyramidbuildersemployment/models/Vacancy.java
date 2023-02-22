package com.pyramidbuildersemployment.models;


import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name ="Vacancy")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long
            id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
