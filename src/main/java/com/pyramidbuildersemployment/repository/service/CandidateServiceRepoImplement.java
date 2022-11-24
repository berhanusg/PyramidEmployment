package com.pyramidbuildersemployment.repository.service;
import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
import com.pyramidbuildersemployment.repository.exception.addressNotFoundException;
import com.pyramidbuildersemployment.repository.exception.candidateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceRepoImplement {
    private final  CandidateRepoInterface candidateRepo;
    @Autowired
    public CandidateServiceRepoImplement(CandidateRepoInterface candidateRepo) {
        this.candidateRepo = candidateRepo;
    }


    public Candidate addCandidate (Candidate candidate){
       return  candidateRepo.save(candidate);

    }

    public List<Candidate> findAllCandidate() {

        return candidateRepo.findAllCandidates();
    }

    public Candidate updateCandidate(Candidate candidate) {

        if (candidateRepo.findById(candidate.getCandidateById()).isPresent()) {
            candidateRepo.save(candidate);

            Optional<Candidate> candidateOpt = candidateRepo.findById(candidate.getCandidateById());
            if (candidateOpt.isPresent())
                return candidateOpt.get();
        }
        return null;
    }
        public Candidate findCandidatesBYId(Long id){

            return candidateRepo.findCandidateById(id)
                    .orElseThrow(()->new candidateNotFoundException("address by id" + id + " was not found"));
        }

    public void deleteCandidate(Long id){

        candidateRepo.deleteCandidateById(id);
    }


    }


