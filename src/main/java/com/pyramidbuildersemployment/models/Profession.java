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
@Table(name ="proffession")
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private List<Experience> experienceid;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
