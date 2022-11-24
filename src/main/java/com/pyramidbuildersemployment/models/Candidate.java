package com.pyramidbuildersemployment.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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



    private List<Candidate> Candidate;

    public Candidate(){

        super();
        this.id=0;
        this.firstname= "";
        this.middlename ="";
        this.lastname="";
        this.gender ="";
        this.email ="";
        this.telephone ="";
        this.education_level="";
    }

    

    public Candidate(long id, String firstname, String middlename, String lastname, String gender, String telephone,
            String email, String education_level) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.education_level = education_level;
    }



    public Candidate(String firstname, String middlename, String lastname, String gender, String telephone,
            String email, String education_level) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.gender = gender;
        this.telephone = telephone;
        this.email = email;
        this.education_level = education_level;
    }



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

