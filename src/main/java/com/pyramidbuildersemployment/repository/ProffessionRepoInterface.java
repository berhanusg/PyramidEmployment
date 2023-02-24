package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Profession;
import org.springframework.data.repository.CrudRepository;

public interface ProffessionRepoInterface extends CrudRepository<Profession, Long> {
    
}
