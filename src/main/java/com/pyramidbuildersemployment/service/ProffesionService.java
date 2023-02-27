package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;

import java.util.List;

public interface ProffesionService {


     List<ProffesionService> getAllProffessions();

     Profession getProfessionById(long id);

    Profession saveAll(Profession profession);

     Profession updateProfession(Profession profession);
     void deleteProffession(long id);
     Profession registerProfession(Profession profession);

}
