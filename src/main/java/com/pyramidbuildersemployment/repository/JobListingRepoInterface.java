package com.pyramidbuildersemployment.repository;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface JobListingRepoInterface extends CrudRepository<JobListing, Long > {
//
//
//
//    @Query("SELECT j FROM JobListing j WHERE j.salary >= :salary")
//    List<String> findBySalaryGreaterThanEqual(@Param("salary") Double salary);
//
//    @Query("SELECT j FROM JobListing j WHERE LOWER(j.jobTitle) LIKE %:jobTitle%")
//    List<JobListing> findByJobTitleContainingIgnoreCase(@Param("jobTitle") String jobTitle);
//
//    @Query("SELECT j FROM JobListing j WHERE LOWER(j.location) LIKE %:location%")
//    List<JobListing> findByLocationContainingIgnoreCase(@Param("location") String location);

    @Repository
    public interface JobListingRepoInterface extends CrudRepository<JobListing, Long> {

        @Query("SELECT j FROM JobListing j WHERE j.salary >= :salary")
        List<JobListing> findBySalaryGreaterThanEqual(@Param("salary") Double salary);

        @Query("SELECT j FROM JobListing j WHERE LOWER(j.jobTitle) LIKE %:jobTitle%")
        List<JobListing> findByJobTitleContainingIgnoreCase(@Param("jobTitle") String jobTitle);

        @Query("SELECT j FROM JobListing j WHERE LOWER(j.location) LIKE %:location%")
        List<JobListing> findByLocationContainingIgnoreCase(@Param("location") String location);

    }




