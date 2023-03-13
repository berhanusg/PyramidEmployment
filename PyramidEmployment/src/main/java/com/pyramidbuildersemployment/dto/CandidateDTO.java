package com.pyramidbuildersemployment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

 /*
 This DTO includes all of the fields from the
  Candidate and Address entities that need to be displayed on the form.

*/


@Getter
@Setter
@NoArgsConstructor
public class CandidateDTO {
        private Long id;
        private String firstname;
        private String middlename;
        private String lastname;
        private String gender;
        private String telephone;
        private String email;
        private String educationLevel;
        private Long professionId;
        private String numberOfMonths;
        private String numberOfYears;
        private String experiencedescription;
        private String street;
        private String city;
        private String state;
        private String zip;
        private String country;

        // getters and setters
    }


