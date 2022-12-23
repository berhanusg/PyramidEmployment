package com.pyramidbuildersemployment.models;

//import javax.persistence.*;
//import java.util.*;
//
//@Entity
//@Table (name= "tblexperience")
//public class Experience {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private long id;
//
//    @ManyToOne
//    @JoinColumn(name = "candidateid")
//    private List<Candidate> candidate;
//
//    @ManyToOne
//    @JoinColumn(name = "proffessionid")
//    private List<Profession> proffessionid;
//
//    @Column(name = "experienceperiod")
//    private String experienceperiod;
//
//    private List<Candidate> Candidate;
//    private List<Experience> experience;
//
//    public Experience(){
//
//        super();
//        this.id=0;
//        this.Candidate = new ArrayList<>();
//        this.proffessionid= new ArrayList<>();
//
//
//    }
//    private String getExperienceperiod(){
//        return experienceperiod;
//    }
//    private void setExperienceperiod( String experienceperiod)
//    {
//        this.experienceperiod = experienceperiod;
//
//    }
//
//    public List<Candidate> getCandidate() {
//        return candidate;
//    }
//
//    public void setCandidate(List<Candidate> pets) {
//        this.candidate = candidate;
//    }
//
//    public List<Experience> getExperience(){return experience;}
//
//    public void setExperience(List<Experience> experience) {
//        this.experience = experience;
//    }
//}
