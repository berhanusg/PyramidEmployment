package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.dto.ProffesionDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;

import com.pyramidbuildersemployment.repository.ProffessionRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        return proffessionRepoInterface.findById(id).get();
    }






    @Override
    public Profession saveAll(Profession profession) {
        return null;
    }

    @Override

    //public Profession updateProfession(Profession profession, Long id) {
    public Profession updateProfession(Profession profession, Long id) {
        // Get the existing Profession entity by ID
       Profession objprofession = proffessionRepoInterface.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profession not found with id " + id));
        profession.setProfessionName(objprofession.getProfessionName());
        return proffessionRepoInterface.save(objprofession);
    }
    public Profession updateProfession(Long id, ProffesionDTO professionDTO) {
        // Get the existing Profession entity by ID
        Profession profession = proffessionRepoInterface.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profession not found with id " + id));

        // Update the properties of the Profession entity
        profession.setProfessionName(professionDTO.getProfessionName());
        //profession.setIndustry(professionDTO.getIndustry());
        System.out.println(profession);
        // Save the updated Profession entity to the database
        return proffessionRepoInterface.save(profession);
    }



    @Override
    public void deleteProffession(long id) {

    }
    public Profession registerProfession(Profession profession) {
        return proffessionRepoInterface.save(profession);
    }
}
