package com.pyramidbuildersemployment.models;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

 @Getter
 @Setter
 @NoArgsConstructor
@Entity
@Table (name = "tbladdress")
public class Address {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

    @OneToOne//(mappedBy = "candidate")
    private Candidate candidate;

   /* @ManyToOne
    @JoinColumn(name = "hiring_company_id")
    private List<HiringCompany> hiringcompanyid;*/

    @Column(name = "street")
	private String street;
    @Column(name = "city")
	private String city;

    @Column(name = "state")
	private String state;
    @Column(name = "zip")
	private String zip;
    @Column(name = "country")
	private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hiring_company_id")
    private HiringCompany hiringCompany;



    private String getstreet(){
        return street;
    }
    private void setStreet( String street)
    {
        this.street = street;

    }
    private String getCity(){
        return city;
    }
    private void setCity( String city)
    {
        this.street = city;

    }
    private String getState(){
        return state;
    }
    private void setState( String state)
    {
        this.state = state;

    }
    private String getZip(){
        return zip;
    }
    private void setZip( String zip)
    {
        this.zip = zip;

    }
    private String getCountry(){
        return country;
    }
    private void setCountry( String country)
    {
        this.country = country;

    }


    public long getAddressById() {
        return 0;
    }





    
    
}
