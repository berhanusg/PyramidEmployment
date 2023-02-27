package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;

import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private final CandidateRepoInterface candidateReepointerface;



    public CandidateServiceImpl(CandidateRepoInterface candidateReepointerface) {
        this.candidateReepointerface = candidateReepointerface;
    }

    @Override
    public List<CandidateService> getAllCandidates() {
        return null;
    }

    @Override
    public Candidate getCandidateById(long id) {
        return null;
    }

    @Override
    public Candidate saveAll(Candidate candidate) {
        return null;
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return null;
    }

    @Override
    public void deleteCandidate(long id) {

    }

    public Candidate registerCandidate(Candidate candidate) {
        return candidateReepointerface.save(candidate);
    }
}
