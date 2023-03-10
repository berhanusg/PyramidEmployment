package com.pyramidbuildersemployment.service;

//import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobListingService {
    List<JobListing> getAlljoblistings();

    JobListing getJobListingById(long id);

    JobListing saveAll(JobListing jobListing);

    JobListing updateJoblisting(JobListing jobListing);

    void deleteJobListing(long id);
     JobListing registerJoblisting(JobListing jobListing);

}
