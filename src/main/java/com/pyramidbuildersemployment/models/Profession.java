package com.pyramidbuildersemployment.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name ="proffession")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;


//
//    @ManyToOne
//    @JoinColumn(name = "experience_id")
//    private Experience experienceid;
    private String ProfessionName;
    private String industry;

    /*

    In the Profession class, we add a field
    to hold the reference to the owning JobListing and a
     @ManyToOne annotation to specify the relationship:
     */
    @ManyToOne
    @JoinColumn(name = "joblisting_id")
    private JobListing jobListing;




    @OneToMany(mappedBy = "profession", cascade = CascadeType.ALL)
    private List<Candidate> candidates;

}



    // constructor, getters and setters

