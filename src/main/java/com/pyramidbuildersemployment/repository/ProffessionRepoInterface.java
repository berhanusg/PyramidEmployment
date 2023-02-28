package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Profession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProffessionRepoInterface extends CrudRepository<Profession, Long> {
    
}
