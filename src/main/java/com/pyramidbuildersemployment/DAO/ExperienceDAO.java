package com.pyramidbuildersemployment.DAO;


import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Experience;
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
public class ExperienceDAO {


    @Autowired
    private EntityManager entityManager;

    public Experience findById(long id) {
        return entityManager.find(Experience.class, id);
    }

    public List<Experience> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Experience> cq = cb.createQuery(Experience.class);
        Root<Experience> root = cq.from(Experience.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public Experience save(Experience experience) {
        entityManager.persist(experience);
        return experience;
    }

    public Experience update(Experience experience) {
        return entityManager.merge(experience);
    }

    public void delete(Experience experience) {
        entityManager.remove(experience);
    }


}
