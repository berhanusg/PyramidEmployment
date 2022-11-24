package com.pyramidbuildersemployment.repository;

import java.util.List;
import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepoInterface extends CrudRepository<Candidate, Long > {

    void deleteCandidateById(Long id);

    Optional<Candidate> findCandidateById(Long id);

    public List <Candidate> findAllCandidates();
}
