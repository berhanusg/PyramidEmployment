package com.pyramidbuildersemployment.DAO;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.HiringCompany;
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
    private EntityManager entityManager;

    public HiringCompany findById(long id) {
        return entityManager.find(HiringCompany.class, id);
    }

    public List<HiringCompany> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<HiringCompany> cq = cb.createQuery(HiringCompany.class);
        Root<HiringCompany> root = cq.from(HiringCompany.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public HiringCompany save(HiringCompany hiringCompany) {
        entityManager.persist(hiringCompany);
        return hiringCompany;
    }

    public HiringCompany update(HiringCompany hiringCompany) {
        return entityManager.merge(hiringCompany);
    }

    public void delete(HiringCompany hiringCompany) {
        entityManager.remove(hiringCompany);
    }

}
