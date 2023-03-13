package com.pyramidbuildersemployment.DAO;

//
//import com.pyramidbuildersemployment.models.Candidate;
//import com.pyramidbuildersemployment.models.Experience;
//import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
//import com.pyramidbuildersemployment.repository.ExperienceRepoInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Repository
//@Transactional
//public class ExperienceDAO {
//
//
//    @Autowired
//    private ExperienceRepoInterface experienceRepo;
//
//    public Experience findById(long id) {
//        return experienceRepo.findById(id).orElse(null);
//    }
//
//    public List<Experience> findAll() {
//        return (List<Experience>) experienceRepo.findAll();
//    }
//
//    public Experience save(Experience experience) {
//        return experienceRepo.save(experience);
//    }
//
//    public Experience update(Experience experience) {
//        return experienceRepo.save(experience);
//    }
//
//    public void delete(Experience experience) {
//        experienceRepo.delete(experience);
//    }
//}
//
