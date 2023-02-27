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

    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "gender")
    private String gender;

    @Column(name ="telephone")
    private String telephone;

    @Column(name = "email")
    private String email;
    @Column(name = "education_level")
    private String education_level;
//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    private Address address;


    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
    @OneToOne
    @JoinColumn(name = "experience_id")
    private Experience experience;

    @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tblcandidate_address",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Address candidate;*/


//    @OneToOne
//    @JoinColumn(name = "address_id")
//    private Address address;

    private long  getId(){
        return id;
    }
    private void setId(long id){
        this.id = id;
    }



    private String getFirstName(){
        return firstname;
    }
    private void setFirstname( String firstName)
    {
        this.firstname = firstName;

    }
    private String getMiddlename(){
        return middlename;
    }
    private void setMiddlename( String middlename)
    {
        this.middlename = middlename;

    }
    private String getLastname(){
        return lastname;
    }
    private void setlastName( String LastName)
    {
        this.lastname = LastName;

    }
    private String getGender(){
        return gender;
    }
    private void setgender( String gender)
    {
        this.gender = gender;

    }
    private String getEmail(){
        return email;
    }
    private void setEmail( String email)
    {
        this.email = email;

    }
    private String getTelephone(){
        return telephone;
    }
    private void setTelephone( String telephone)
    {
        this.telephone = telephone;

    }
    private String getEducation(){
        return education_level;
    }
    private void setEducationLevel( String educationLevel)
    {
        this.education_level = educationLevel;

    }

    public long getCandidateById() {
        return id;
    }


    }


