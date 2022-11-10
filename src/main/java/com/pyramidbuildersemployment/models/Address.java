package com.pyramidbuildersemployment.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table (name = "tbladdress")
public class Address {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
    
    @ManyToOne
	@JoinColumn(name = "candidateid")
	private List<Candidate> candidate;

    @ManyToOne
	@JoinColumn(name = "hiringcompanyid")
	private List<HiringCompany> hiringcompanyid;
    
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

    private List<HiringCompany> hiringCompany;
    
    public Address(){

        super();
        this.id=0;
        this.candidate =new ArrayList<>();
        this.hiringcompanyid=new ArrayList<>();
        this.street ="";
        this.city ="";
        this.state="";
        this.country ="";
       

    }
    
 
    // //private long  getId(){
    // //return id;
    // //}
    // private void setId(long id){
    //     this.id = id;
    // }  
    public List<Candidate> getCandidate() {
            return candidate;
    }
    public void setCandidate(List<Candidate> candidate) {
            this.candidate = candidate;
    }

    public void setHiringCompany(List<HiringCompany> hiringCompany) {
            this.hiringcompanyid = hiringCompany;
    }
    public List<HiringCompany> getHiringCompanies() {
            return hiringCompany;
    }
    
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
