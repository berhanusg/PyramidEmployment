package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.HiringCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringRepoInterface extends CrudRepository<HiringCompany, Long > {
}
