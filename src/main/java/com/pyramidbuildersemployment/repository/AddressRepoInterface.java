package com.pyramidbuildersemployment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pyramidbuildersemployment.models.Address;

import java.util.Optional;

@Repository
public interface AddressRepoInterface extends JpaRepository<Address, Long > {
    void deleteAddressById(Long id);

    Optional<Address> findAddressById(Long id);
}
