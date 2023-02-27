package com.pyramidbuildersemployment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {


    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

}
