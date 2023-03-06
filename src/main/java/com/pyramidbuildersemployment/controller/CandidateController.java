package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.*;
import lombok.Lombok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@CrossOrigin
public class CandidateController {



    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ProffesionService proffesionService;



    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }




// This shows Empty form in the browser
    @GetMapping("/candidate-register")
    public String showCandidateRegistrationForm(Model model) {
        List<Profession> professions = proffesionService.getAllProffessions();
        model.addAttribute("professions", professions);
        model.addAttribute("candidateDTO", new CandidateDTO());
        return "candidate-register";
    }


    /*

 Step 2- THis method is used to Register New Candidate
The method creates a new Candidate entity and sets its properties based
 on the values in the CandidateDTO object. It also creates a new Address
  entity and sets its properties based on the values in the CandidateDTO object.
Then, it saves the Address entity to the database and sets the foreign
 key in the Candidate entity to the ID of the newly saved Address entity.
Finally, it saves the Candidate entity to the database and redirects the user to the candidate list page.


 */

    @Override
    public String toString() {
        String firstname = null;
        String lastname =null;
        String email =null;
        String professionId =null;
        String numberOfYears =null ;
        long id =0;
        return "CandidateDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", professionId=" + professionId +
                ", numberOfYears=" + numberOfYears +
                '}';
    }


    // WAS  @PostMapping("/candidate-register-process")
    @PostMapping("/candidate-register")
    public String registerCandidate(@ModelAttribute("candidateDTO") @Valid CandidateDTO candidateDTO, BindingResult bindingResult, Model model) throws ChangeSetPersister.NotFoundException {
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


//        Long professionId = candidateDTO.getProfessionId();
//        Profession profession = (Profession) proffesionService.getProfessionById(professionId);
//        candidate.setProfessionId(profession);

//        try {
//            Long professionId = candidateDTO.getProfessionId();
//
//
//            System.out.println(professionId);
//            Profession profession = proffesionService.getProfessionById(professionId);
//            candidate.setProfessionId(profession);
//
//
//        } catch (NoSuchElementException e) {
//            // handle the case where the profession is not found
//            throw new ChangeSetPersister.NotFoundException();
//        }
//




//         Long professionId = candidateDTO.getProfessionId();
//          Profession profession = proffesionService.getProfessionById(professionId);
//          candidate.setProfessionId(profession);


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
        model.addAttribute("candidateDTO", candidateDTO);

        candidateService.registerCandidate(candidate);
        return "redirect:/candidate-list";
    }



    @GetMapping("/candidate-list")
    public String candidateList(Model model) {
        List<Candidate> candidatesList = candidateService.getAllCandidates();
        model.addAttribute("candidates",candidatesList);
        return "candidate-list";
    }





    @GetMapping("/candidates-all") // change this whatever you want the path to be
        public List<Candidate> getAllCandidates() {
            return candidateService.getAllCandidates();
        }



        @DeleteMapping(path = "candidate/{id}")
        public ResponseEntity<String> deleteAddress(@PathVariable long id) {

            // delete address from DB
            candidateService.deleteCandidate(id);

            return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
        }






}

