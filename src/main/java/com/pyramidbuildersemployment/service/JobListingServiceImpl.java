package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.JobListing;

import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class JobListingServiceImpl implements JobListingService{


    @Autowired
    public JobListingRepoInterface jobListingRepoInterface;

    public JobListingServiceImpl(JobListingRepoInterface jobListingRepoInterface) {
        this.jobListingRepoInterface = jobListingRepoInterface;
    }
    @Override
    public List<JobListingService> getAllAlljoblistings() {
        return null;
    }

    @Override
    public JobListing getJobListingById(long id) {
        return null;
    }

    @Override
    public JobListing saveAll(JobListing jobListing) {
        return null;
    }

    @Override
    public JobListing updateJoblisting(JobListing jobListing) {
        return null;
    }

    @Override
    public void deleteJobListing(long id) {

    }

    public JobListing registerJoblisting(JobListing jobListing) {
        return jobListingRepoInterface.save(jobListing);
    }
}
