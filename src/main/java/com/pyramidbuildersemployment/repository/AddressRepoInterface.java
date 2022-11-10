package com.pyramidbuildersemployment.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pyramidbuildersemployment.models.Address;

@Repository
public interface AddressRepoInterface extends CrudRepository<Address, Long > {
    
}
