package com.pyramidbuildersemployment.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.pyramidbuildersemployment.models.Candidate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pyramidbuildersemployment.models.Candidate;



public class CandidateServiceTest {

    @Autowired
    private CandidateServiceImpl candidateServiceImpl;

    @Test
    public void testGetAllCandidates() {
        List<Candidate> candidates = candidateServiceImpl.getAllCandidates();
        assertNotNull(candidates);
        assertEquals(10, candidates.size()); // expected size of candidate list
    }
}
