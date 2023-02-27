package com.pyramidbuildersemployment.DAO;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.repository.ExperienceRepoInterface;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
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
public class HiringCompanyDAO {



    @Autowired
    private HiringRepoInterface hiringRepo;

    public HiringCompany findById(long id) {
        return hiringRepo.findById(id).orElse(null);
    }

    public List<HiringCompany> findAll() {
        return (List<HiringCompany>) hiringRepo.findAll();
    }

    public HiringCompany save(HiringCompany hiringCompany) {
        return hiringRepo.save(hiringCompany);
    }

    public HiringCompany update(HiringCompany hiringCompany) {
        return hiringRepo.save(hiringCompany);
    }

    public void delete(HiringCompany hiringCompany) {
        hiringRepo.delete(hiringCompany);
    }
}

