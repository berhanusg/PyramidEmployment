package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.JobListing;

import java.util.List;

public interface JobListingService {
    List<JobListingService> getAllAlljoblistings();

    JobListing getJobListingById(long id);

    JobListing saveAll(JobListing jobListing);

    JobListing updateJoblisting(JobListing jobListing);

    void deleteJobListing(long id);
     JobListing registerJoblisting(JobListing jobListing);
}
