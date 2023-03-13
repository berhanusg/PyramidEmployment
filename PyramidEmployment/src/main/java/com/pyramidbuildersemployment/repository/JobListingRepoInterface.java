package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobListingRepoInterface extends CrudRepository<JobListing, Long > {

    List<JobListing> findBySalaryGreaterThanEqual(double parseDouble);
    List<JobListing> findByJobTitleContainingIgnoreCase(String jobTitle);

    List<JobListing> findBySalaryGreaterThanEqual(Double salary);
    List<JobListing> findByLocationContainingIgnoreCase(String location);



    }


