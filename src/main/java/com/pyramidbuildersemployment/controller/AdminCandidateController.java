package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.ProffesionService;
import com.pyramidbuildersemployment.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCandidateController {

    @Autowired
    private CandidateService candidateService;


    @Autowired
    private ProffesionService proffesionService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/candidate-list")
    public String candidateList(Model model) {
        List<Candidate> candidatesList = candidateService.getAllCandidates();

        model.addAttribute("candidates",candidatesList);
        return "candidate-list";
    }


    @RequestMapping(value = "/candidate-delete/{id}", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

    //  @DeleteMapping(path = "candidate-delete/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable long id) {

        // delete address from DB
        candidateService.deleteCandidate(id);
        System.out.println(id);
        return new ResponseEntity<String>("Candidate deleted successfully!.", HttpStatus.OK);
    }


    //@PostMapping("/user/candidate-register-process")
    @PostMapping("/candidate-register")
    public String registerCandidate(@ModelAttribute("candidateDTO") @Valid CandidateDTO candidateDTO, BindingResult bindingResult, Model model, Principal principal ) throws ChangeSetPersister.NotFoundException {
        if (bindingResult.hasErrors()) {
            return "candidate-register";
        }

        // add null check for address
        if (candidateDTO.getFirstname() == null) {
            // handle null name error
            return "candidate-register";
        }
        // create new Candidate entity
        Candidate candidate = new Candidate();
        //  candidate.setId(candidateDTO.getId());
        candidate.setFirstname(candidateDTO.getFirstname());
        candidate.setMiddlename(candidateDTO.getMiddlename());
        candidate.setLastname(candidateDTO.getLastname());
        candidate.setGender(candidateDTO.getGender());
        candidate.setTelephone(candidateDTO.getTelephone());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setEducation_level(candidateDTO.getEducationLevel());



        candidate.setNumberOfMonths(candidateDTO.getNumberOfMonths());
        candidate.setNumberOfYears(candidateDTO.getNumberOfYears());
        candidate.setExperiencedescription(candidateDTO.getExperiencedescription());

        candidate.setStreet(candidateDTO.getStreet());
        candidate.setCity(candidateDTO.getCity());
        candidate.setState(candidateDTO.getState());
        candidate.setZip(candidateDTO.getZip());
        candidate.setCountry(candidateDTO.getCountry());
//        model.addAttribute("candidateDTO", new CandidateDTO());
//        model.addAttribute("candidates", candidateService.registerCandidate(candidate));
        candidateService.registerCandidate(candidate);
        model.addAttribute("candidateDTO", candidateDTO);
        User user = userServiceImpl.findByEmail(principal.getName());

        return "redirect:/candidate-list";
    }


}
