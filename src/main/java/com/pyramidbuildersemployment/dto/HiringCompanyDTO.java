package com.pyramidbuildersemployment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
@Getter
@Setter
@NoArgsConstructor
public class HiringCompanyDTO {
    private Long id;
    private String contactpersonfname;
    private String contactpersonlname;
    private String hiringcompanyemail;
    private String webSite;
    private String hiringCompanyName;
    private String email ;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private Long jobListingId;
}
