package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.JobListing;

import java.util.List;

public interface JobListingService {
    List<JobListingService> getAllAlljoblistings();

    JobListing getJobListingById(long id);

    JobListing saveAll(JobListing jobListing);

    JobListing updateCandidate(JobListing jobListing);

    void deleteJobListing(long id);
}
