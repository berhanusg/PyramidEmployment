package com.pyramidbuildersemployment.service;

//import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;

import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobListingServiceImpl implements JobListingService{


    @Autowired
    public JobListingRepoInterface jobListingRepoInterface;

    public JobListingServiceImpl(JobListingRepoInterface jobListingRepoInterface) {
        this.jobListingRepoInterface = jobListingRepoInterface;
    }
    @Override
    public List<JobListing> getAlljoblistings() {
        return (List<JobListing>) jobListingRepoInterface.findAll();
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
        jobListingRepoInterface.deleteById(id);
    }

    public JobListing registerJoblisting(JobListing jobListing) {
        return jobListingRepoInterface.save(jobListing);
    }
}
