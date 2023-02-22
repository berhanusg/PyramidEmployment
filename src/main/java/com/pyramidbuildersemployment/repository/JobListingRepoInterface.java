package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import org.springframework.data.repository.CrudRepository;

public interface JobListingRepoInterface extends CrudRepository<JobListing, Long > {
    
}
