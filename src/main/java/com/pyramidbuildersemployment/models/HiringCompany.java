package com.pyramidbuildersemployment.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="Hiringcompany")
public class HiringCompany {


    /*
   @OneToMany with mappedBy attribute indicates a one-to-many relationship between two entities.
   In this case, the HiringCompany entity has a one-to-many relationship with the Address entity,
   meaning a single HiringCompany entity can be associated with multiple Address entities.
    The mappedBy attribute is used to indicate the name of the association field in the
     Address entity that owns the relationship.
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "contactpersonfname")
    private String contactpersonfname;
    @Column(name = "contactpersonlname")
    private String contactpersonlname;
    @Column(name = "hiringcompanyemail")
    private String hiringcompanyemail;
    @Column(name = "webSite")
    private String webSite;
    @Column(name = "hiringCompanyName")
    private String hiringCompanyName;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

//    @ManyToOne
//    @JoinColumn(name = "job_listing_id")
//    private JobListing jobListingId;

// a HiringCompany can be associated with multiple JobListing
    @OneToMany(mappedBy = "hiringCompany", cascade = CascadeType.ALL)
    private List<JobListing> jobListings;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;


    public void addJobListing(JobListing jobListing) {
        jobListings.add(jobListing);
        jobListing.setHiringCompany(this);
    }
}

