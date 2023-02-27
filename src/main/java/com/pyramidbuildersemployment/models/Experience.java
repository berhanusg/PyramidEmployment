package com.pyramidbuildersemployment.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table (name= "tblexperience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long experienceid;
    @Column(name = "description")
    private String experiencedescription;
    @Column(name = "months")
    private String numberOfMonths;
    @Column(name = "years")
    private String numberOfYears;
    @ManyToOne
    @JoinColumn(name = "candidateid")
    private Candidate candidate;



    @Column(name = "profession_id")
    private String professionid;

   // private List<Candidate> Candidate;
   @ManyToOne
   private Experience experience;



}
