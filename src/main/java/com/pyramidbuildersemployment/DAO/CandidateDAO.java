package com.pyramidbuildersemployment.DAO;



import com.pyramidbuildersemployment.models.Candidate;
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
public class CandidateDAO {

    @Autowired
    private EntityManager entityManager;

    public Candidate findById(long id) {
        return entityManager.find(Candidate.class, id);
    }

    public List<Candidate> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Candidate> cq = cb.createQuery(Candidate.class);
        Root<Candidate> root = cq.from(Candidate.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    public Candidate save(Candidate candidate) {
        entityManager.persist(candidate);
        return candidate;
    }

    public Candidate update(Candidate candidate) {
        return entityManager.merge(candidate);
    }

    public void delete(Candidate candidate) {
        entityManager.remove(candidate);
    }
}
