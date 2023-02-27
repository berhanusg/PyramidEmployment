package com.pyramidbuildersemployment.models;

import lombok.Data;
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
    @OneToMany(mappedBy = "hiringCompany")
    private List<Address> addresses;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long hiringcompany_id;

    @Column (name= "contactpersonfname")
    private String contactpersonfname;
    @Column (name= "contactpersonlname")
    private String contactpersonlname;
    @Column (name= "hiringcompanyemail")
    private String hiringcompanyemail;

    @Column (name = "webSite")
    private String webSite;
    @Column (name ="hiringCompanyName")
    private String hiringCompanyName;

    private String email ;

    @ManyToOne
    @JoinColumn(name = "job_listing_id")
    private JobListing jobListing;


//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;



    private String getcontactpersonfname(){

        return contactpersonfname;

    }
   private void setcontactpersonfname(String contactpersonfname){
       this.contactpersonfname =contactpersonfname;
   }
    private String getcontactpersonlname(){

        return contactpersonlname;

    }
    private void setcontactpersonlname(String contactpersonlname){
        this.contactpersonfname =contactpersonfname;
    }

}
