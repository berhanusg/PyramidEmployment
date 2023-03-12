package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;

import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
import com.pyramidbuildersemployment.repository.JobListingRepoInterface;
import com.pyramidbuildersemployment.repository.ProffessionRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CandidateServiceImpl implements CandidateService{

    @Autowired
    private  CandidateRepoInterface candidateReepointerface;

    @Autowired
    private ProffessionRepoInterface proffessionRepoInterface;


    public CandidateServiceImpl(CandidateRepoInterface candidateReepointerface) {
        this.candidateReepointerface = candidateReepointerface;
    }

    public CandidateServiceImpl() {

    }

    @Override
    public List<Candidate> getAllCandidates() {
        return (List<Candidate>) candidateReepointerface.findAll();
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
       deleteCandidate(id);
    }

    public Candidate registerCandidate(Candidate candidate) {
        return candidateReepointerface.save(candidate);
    }

    @Autowired
    private JobListingRepoInterface jobListingRepoInterface;


}


