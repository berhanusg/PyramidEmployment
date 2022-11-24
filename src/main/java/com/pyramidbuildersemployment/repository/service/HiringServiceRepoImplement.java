package com.pyramidbuildersemployment.repository.service;

import com.pyramidbuildersemployment.repository.ExperienceRepoInterface;
import com.pyramidbuildersemployment.repository.HiringRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiringServiceRepoImplement {
    private final HiringRepoInterface hiringRepo;
    @Autowired
    public HiringServiceRepoImplement(HiringRepoInterface hiringRepo) {
        this.hiringRepo= hiringRepo;
    }

}
