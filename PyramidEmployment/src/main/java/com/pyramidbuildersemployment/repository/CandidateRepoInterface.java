package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepoInterface extends CrudRepository<Candidate, Long > {
    
}
