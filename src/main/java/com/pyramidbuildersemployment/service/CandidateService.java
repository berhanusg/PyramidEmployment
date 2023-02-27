package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;

import java.util.List;

public interface CandidateService {

    public List<CandidateService> getAllCandidates();

    public Candidate getCandidateById(long id);

    public Candidate saveAll(Candidate candidate);

    public Candidate updateCandidate(Candidate candidate);
    public void deleteCandidate(long id);
    public Candidate registerCandidate(Candidate candidate);
}
