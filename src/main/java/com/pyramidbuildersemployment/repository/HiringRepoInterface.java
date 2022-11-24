package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.HiringCompany;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HiringRepoInterface extends JpaRepository<HiringCompany, Long> {

    void deleteHiringById(Long id);

    Optional<HiringCompany> findHiringById(Long id);
}
