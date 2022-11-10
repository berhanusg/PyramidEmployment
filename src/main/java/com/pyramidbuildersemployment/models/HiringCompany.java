package com.pyramidbuildersemployment.models;

import javax.persistence.*;


@Entity
@Table(name ="Hiringcompany")
public class HiringCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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

    public HiringCompany(){
        super();
        this.contactpersonfname ="";
        this.contactpersonlname ="";
        this.hiringcompanyemail ="";
        this.webSite ="";
        this.hiringCompanyName ="";

    }

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
