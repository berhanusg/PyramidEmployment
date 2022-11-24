package com.pyramidbuildersemployment.repository.service;

import com.pyramidbuildersemployment.repository.AddressRepoInterface;
import com.pyramidbuildersemployment.repository.ExperienceRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExperienceServiceRepoImplement  {

    private final ExperienceRepoInterface experienceRepo;
    @Autowired
    public ExperienceServiceRepoImplement(ExperienceRepoInterface experienceRepo) {
        this.experienceRepo= experienceRepo;
    }

}
