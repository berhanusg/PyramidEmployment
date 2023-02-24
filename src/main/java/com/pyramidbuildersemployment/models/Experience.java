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
    private long id;

    @ManyToOne
    @JoinColumn(name = "candidateid")
    private Candidate candidate;



    @Column(name = "profession_id")
    private String professionid;

   // private List<Candidate> Candidate;
   @ManyToOne
   private Experience experience;

//    public Experience(){
//
//        super();
//        this.id=0;
//        this.Candidate = new ArrayList<>();
//        this.proffessionid= new ArrayList<>();
//
//
//    }

}
