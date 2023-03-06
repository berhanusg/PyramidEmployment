package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;

import java.util.List;

public interface CandidateService {

     List<Candidate> getAllCandidates();

     Candidate getCandidateById(long id);


     Candidate saveAll(Candidate candidate);

     Candidate updateCandidate(Candidate candidate);
     void deleteCandidate(long id);
     Candidate registerCandidate(Candidate candidate);
}
