package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepoInterface extends CrudRepository<Address, Long > {
    
}
