package com.pyramidbuildersemployment.models;
/*
This feature allows recruiters to post job vacancies on the site,
including job descriptions, requirements, and contact information.

 */
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name ="joblisting")
public class JobListing {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

}
