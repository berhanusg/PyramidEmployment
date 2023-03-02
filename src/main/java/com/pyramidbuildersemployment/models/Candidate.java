package com.pyramidbuildersemployment.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tblcandidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstname;
    private String middlename;
    private String lastname;
    private String gender;
    private String telephone;
    private String email;
    @Column(name = "months")
    private String numberOfMonths;
    @Column(name = "years")
    private String numberOfYears;
    private String experiencedescription;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    public String getEducation_level() {
        return education_level;
    }

    public void setEducation_level(String education_level) {
        this.education_level = education_level;
    }

    private String education_level;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession professionId;

    public Profession getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Profession professionId) {
        this.professionId = professionId;
    }



//    public Experience getExperienceId() {
//        return experienceId;
//    }
//
//    public void setExperienceId(Experience experienceId) {
//        this.experienceId = experienceId;
//    }
//
//    @OneToOne
//    @JoinColumn(name = "experience_id")
//    private Experience experienceId;

//    @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;





    public long getCandidateById() {
        return id;
    }


    }


