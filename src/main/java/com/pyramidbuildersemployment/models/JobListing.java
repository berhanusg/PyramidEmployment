package com.pyramidbuildersemployment.models;
/*
This feature allows recruiters to post job vacancies on the site,
including job descriptions, requirements, and contact information.

 */

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
    private String jobTitle;
    private String jobDescription;
    private String location;
    private Double salary;
    private String vacancy; // number of openings

/*
the JobListing class has a List<Profession> field called professions.
This field is mapped to the Profession entity using the @OneToMany annotation,
which specifies that JobListing is the owning side of the relationship
 and that Profession is the inverse side.
The mappedBy attribute is used to specify the field on the inverse
 side that maps back to the owning side.
With this setup, we can add professions to a job
 listing by creating Profession objects and adding them to
 the professions list on the JobListing object.
 */
//    @ManyToOne
//    @JoinColumn(name = "experience_id")
//    private Experience experienceid;
@OneToMany(mappedBy = "jobListing", cascade = CascadeType.ALL)
private List<Profession> professions;

    @ManyToOne
    @JoinColumn(name = "hiringcompany_id", nullable = false)
    private HiringCompany hiringCompany;

    public JobListing(String jobTitle, String jobDescription, Double salary, String location) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.salary = salary;
        this.location = location;
    }
}
    // constructor, getters and setters

