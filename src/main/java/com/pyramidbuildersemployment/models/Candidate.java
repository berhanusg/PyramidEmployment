package com.pyramidbuildersemployment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "candidates")
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
    private String educationLevel;
    // Add latitude and longitude fields
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

//    @Column(name = "resume_link")
    @Lob
    private byte[] resume;// The @Lob annotation tells Hibernate that the field should be mapped to a BLOB column in the database.
    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "youtube")
    private String youtube;


    // Add getters and setters for the new fields


    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    // ... (existing getters and setters)
}
