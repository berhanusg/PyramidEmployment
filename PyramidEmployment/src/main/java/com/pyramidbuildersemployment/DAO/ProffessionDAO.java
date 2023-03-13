package com.pyramidbuildersemployment.DAO;



import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import com.pyramidbuildersemployment.repository.ProffessionRepoInterface;
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
public class ProffessionDAO {



    @Autowired
    private ProffessionRepoInterface professionRepo;

    public Profession findById(long id) {
        return professionRepo.findById(id).orElse(null);
    }

    public List<Profession> findAll() {
        return (List<Profession>) professionRepo.findAll();
    }

    public Profession save(Profession profession) {
        return professionRepo.save(profession);
    }

    public Profession update(Profession profession) {
        return professionRepo.save(profession);
    }

    public void delete(Profession profession) {
        professionRepo.delete(profession);
    }
}