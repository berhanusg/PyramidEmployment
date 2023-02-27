package com.pyramidbuildersemployment.DAO;



import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
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
        private CandidateRepoInterface candidateRepo;

        public Candidate findById(long id) {
            return candidateRepo.findById(id).orElse(null);
        }

        public List<Candidate> findAll() {
            return (List<Candidate>) candidateRepo.findAll();
        }

        public Candidate save(Candidate candidate) {
            return candidateRepo.save(candidate);
        }

        public Candidate update(Candidate candidate) {
            return candidateRepo.save(candidate);
        }

        public void delete(Candidate candidate) {
            candidateRepo.delete(candidate);
        }
    }


