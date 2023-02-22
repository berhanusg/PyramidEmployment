package com.pyramidbuildersemployment.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="joblisting")
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

}
