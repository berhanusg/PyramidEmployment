package com.pyramidbuildersemployment.models;

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



    /*
     @ManyToOne with @JoinColumn annotation indicates a many-to-one relationship between two entities.
     In this case, the HiringCompany entity has a many-to-one relationship with the Address entity,
     meaning many Address entities can be associated with a single HiringCompany entity.
      The @JoinColumn annotation is used to specify the
    foreign key column in the Address table that refers to the primary key column of the HiringCompany table.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hiring_company_id")
    private HiringCompany hiringCompany;




    public long getAddressById() {
        return  id;
    }





    
    
}
