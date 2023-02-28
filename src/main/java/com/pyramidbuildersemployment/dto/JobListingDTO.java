package com.pyramidbuildersemployment.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JobListingDTO {
    private String jobTitle;
    private String jobDescription;
    private String location;
    private Double salary;
    private String vacancy;
}
