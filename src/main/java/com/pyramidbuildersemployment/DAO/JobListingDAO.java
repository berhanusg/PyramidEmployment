package com.pyramidbuildersemployment.DAO;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
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
    private EntityManager entityManager;

    public JobListing findById(long id) {
        return entityManager.find(JobListing.class, id);
    }

    public List<JobListing> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<JobListing> cq = cb.createQuery(JobListing.class);
        Root<JobListing> root = cq.from(JobListing.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public JobListing save(JobListing jobLIsting) {
        entityManager.persist(jobLIsting);
        return jobLIsting;
    }

    public JobListing update(JobListing jobLIsting) {
        return entityManager.merge(jobLIsting);
    }

    public void delete(JobListing jobLIsting) {
        entityManager.remove(jobLIsting);
    }
}
