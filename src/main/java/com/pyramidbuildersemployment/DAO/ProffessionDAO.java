package com.pyramidbuildersemployment.DAO;



import com.pyramidbuildersemployment.models.Profession;
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
    private EntityManager entityManager;

    public Profession findById(long id) {
        return entityManager.find(Profession.class, id);
    }

    public List<Profession> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Profession> cq = cb.createQuery(Profession.class);
        Root<Profession> root = cq.from(Profession.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public Profession save(Profession profession) {
        entityManager.persist(profession);
        return profession;
    }

    public Profession update(Profession profession) {
        return entityManager.merge(profession);
    }

    public void delete(Profession profession) {
        entityManager.remove(profession);
    }
}
