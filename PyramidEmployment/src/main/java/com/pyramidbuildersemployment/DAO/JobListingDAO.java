package com.pyramidbuildersemployment.DAO;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JobListingDAO {

    @Autowired
    private JobListingRepoInterface jobListingRepo;

    public JobListing findById(long id) {
        return jobListingRepo.findById(id).orElse(null);
    }

    public List<JobListing> findAll() {
        return (List<JobListing>) jobListingRepo.findAll();
    }

    public JobListing save(JobListing jobListing) {
        return jobListingRepo.save(jobListing);
    }

    public JobListing update(JobListing jobListing) {
        return jobListingRepo.save(jobListing);
    }

    public void delete(JobListing jobListing) {
        jobListingRepo.delete(jobListing);
    }
}
