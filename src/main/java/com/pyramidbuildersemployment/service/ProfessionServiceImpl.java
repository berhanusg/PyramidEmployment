package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;

import com.pyramidbuildersemployment.repository.ProffessionRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfessionServiceImpl implements ProffesionService {

   @Autowired
    ProffessionRepoInterface proffessionRepoInterface;

    ProfessionServiceImpl(ProffessionRepoInterface  proffessionRepoInterface){

        this.proffessionRepoInterface = proffessionRepoInterface;
    }
    @Override
    public List<Profession> getAllProffessions() {
        return (List<Profession>) proffessionRepoInterface.findAll();
    }

    @Override
    public Profession getProfessionById(long id) {
        return null;
    }

    @Override
    public Profession saveAll(Profession profession) {
        return null;
    }

    @Override
    public Profession updateProfession(Profession profession) {
        return null;
    }

    @Override
    public void deleteProffession(long id) {

    }
    public Profession registerProfession(Profession profession) {
        return proffessionRepoInterface.save(profession);
    }
}
