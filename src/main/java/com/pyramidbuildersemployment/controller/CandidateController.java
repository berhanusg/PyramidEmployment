package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.*;
import lombok.Lombok;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@CrossOrigin
public class CandidateController {


    private CandidateService candidateService;
    private ProffesionService proffesionService;



    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }





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
    @PostMapping("/candidate-register")
    public String registerCandidate(@ModelAttribute("candidateDTO") @Valid CandidateDTO candidateDTO, BindingResult bindingResult, Model model) {
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
        Profession objProfession = proffesionService.getProfessionById(candidateDTO.getProfessionId());

        // setprofession
        candidate.setNumberOfMonths(candidateDTO.getNumberOfMonths());
        candidate.setNumberOfYears(candidateDTO.getNumberOfYears());
        candidate.setExperiencedescription(candidateDTO.getExperiencedescription());

        candidate.setStreet(candidateDTO.getStreet());
        candidate.setCity(candidateDTO.getCity());
        candidate.setState(candidateDTO.getState());
        candidate.setZip(candidateDTO.getZip());
        candidate.setCountry(candidateDTO.getCountry());
        model.addAttribute("candidateDTO", new CandidateDTO());
        model.addAttribute("candidates", candidateService.registerCandidate(candidate));


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


        @GetMapping(path = "/candidate/{id}")
        public ResponseEntity<Candidate> getCandidateById(@PathVariable long id) {
            Candidate candidate = candidateService.getCandidateById(id);

            if (candidate != null) {
                // send a 200 status code with the user object as the response body
                return ResponseEntity.ok(candidate);
            } else {
                return ResponseEntity.notFound().build();
            }

        }

        @PostMapping("/{candidates}")
        public ResponseEntity<Candidate> registerCandidat(@RequestBody Candidate candidate) {

            candidate = candidateService.saveAll(candidate);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidate);

        }

        @PutMapping(path = "candidate/{id}")
        public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate, @PathVariable long id) {

            if (candidate.getCandidateById() == id) {
                candidate = candidateService.updateCandidate(candidate);
                if (candidate != null) {
                    return ResponseEntity.ok(candidate);
                } else {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }

        }
        @DeleteMapping(path = "candidate/{id}")
        public ResponseEntity<String> deleteAddress(@PathVariable long id) {

            // delete address from DB
            candidateService.deleteCandidate(id);

            return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
        }






}

