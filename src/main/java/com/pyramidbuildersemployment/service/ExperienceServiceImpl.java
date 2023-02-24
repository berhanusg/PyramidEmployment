package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.repository.ExperienceRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExperienceServiceImpl implements ExperienceService {




   @Autowired
   private  ExperienceRepoInterface experienceRepointerface;

    public ExperienceServiceImpl(ExperienceRepoInterface experienceRepointerface) {
        this.experienceRepointerface = experienceRepointerface;
    }

    @Override
    public List<ExperienceService> getAllAllexperiencs() {
        return null;
    }

    @Override
    public Experience getExperienceById(long id) {
        return null;
    }

    @Override
    public Experience saveAll(Experience expereince) {
        return null;
    }

    @Override
    public Experience updateExperience(Experience experience) {
        return null;
    }

    @Override
    public void deleteExperience(long id) {

    }
}
