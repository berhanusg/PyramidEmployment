package com.pyramidbuildersemployment.service;

//import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.JobListing;

import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
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

//    public List<JobListing> searchJobListings(String searchCriteria, String searchValue, Double salary) {
//        List<JobListing> jobListings= new ArrayList<>();
//
//        switch (searchCriteria) {
//            case "jobTitle":
//                 jobListings=jobListingRepoInterface.findByJobTitleContainingIgnoreCase((String) searchValue);
//                //jobListings.add(jobListingRepoInterface.findByJobTitleContainingIgnoreCase((String) searchValue));
//                break;
//            case "salary":
//                jobListings = jobListingRepoInterface.findBySalaryGreaterThanEqual(Double.parseDouble(searchValue));
//                break;
//            case "location":
//                jobListings = jobListingRepoInterface.findByLocationContainingIgnoreCase((String) searchValue);
//                break;
//            default:
//                // handle unknown search criteria
//                break;
//        }
//
//        return jobListings;
//    }
public List<JobListing> searchJobListings(String jobTitle, String location, Double salary) {
    List<JobListing> jobListings = new ArrayList<>();

    // Build the query based on the selected search criteria
    if (jobTitle != null && !jobTitle.isEmpty()) {
        jobListings = jobListingRepoInterface.findByJobTitleContainingIgnoreCase(jobTitle);
    }
    if (location != null && !location.isEmpty()) {
        if (jobListings.isEmpty()) {
            jobListings = jobListingRepoInterface.findByLocationContainingIgnoreCase(location);
        } else {
            jobListings.retainAll(jobListingRepoInterface.findByLocationContainingIgnoreCase(location));
        }
    }
    if (salary != null) {
        if (jobListings.isEmpty()) {
            jobListings = jobListingRepoInterface.findBySalaryGreaterThanEqual(salary);
        } else {
            jobListings.retainAll(jobListingRepoInterface.findBySalaryGreaterThanEqual(salary));
        }
    }

    return jobListings;
}

}
