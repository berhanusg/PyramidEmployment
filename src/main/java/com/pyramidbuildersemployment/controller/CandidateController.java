package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@CrossOrigin
public class CandidateController {


    private CandidateService candidateService;
    private ProffesionService proffesionService;
//    private ExperienceService  experienceService;

    private AddressService  addressService;
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


//    @GetMapping("/candidate/register")
//    public String showJobSeekerRegistrationForm(Model model) {
//        model.addAttribute("candidate", new Candidate());
//        return "candidate-registration-form";
//    }
//


//    @PostMapping("/candidate/register")
//    public String registerCandidate(@ModelAttribute("candidate") Candidate candidate) {
//        // Call the service method to save the candidate and address to the database
//        candidateService.registerCandidate(candidate);
//
//        // Redirect to a success page
//        return "redirect:/success";
//    }
/*
This method creates a new Candidate entity and sets its properties based
 on the values in the CandidateDTO object. It also creates a new Address
  entity and sets its properties based on the values in the CandidateDTO object.
Then, it saves the Address entity to the database and sets the foreign
 key in the Candidate entity to the ID of the newly saved Address entity.
Finally, it saves the Candidate entity to the database and redirects the user to the candidate list page.


 */
    @PostMapping("/candidate-save")
    public String saveCandidate(@ModelAttribute("candidate") CandidateDTO candidateDTO) {
        // create new Candidate entity
        Candidate candidate = new Candidate();
        candidate.setId(candidateDTO.getId());
        candidate.setFirstname(candidateDTO.getFirstname());
        candidate.setMiddlename(candidateDTO.getMiddlename());
        candidate.setLastname(candidateDTO.getLastname());
        candidate.setGender(candidateDTO.getGender());
        candidate.setTelephone(candidateDTO.getTelephone());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setEducation_level(candidateDTO.getEducationLevel());
        candidate.setProfessionId(proffesionService.getProfessionById(candidateDTO.getProfessionId()));
        candidate.setNumberOfMonths(candidateDTO.getNumberOfMonths());
        candidate.setNumberOfYears(candidateDTO.getNumberOfYears());
        candidate.setExperiencedescription(candidateDTO.getExperiencedescription());
       // replaced it by adding the number of months and years with experience description attribute in the candidate model and the candidateDTO
        //candidate.setExperienceId(experienceService.getExperienceById(candidateDTO.getExperienceId())); will delete experience model

        // create new Address entity
        Address address = new Address();
        address.setStreet(candidateDTO.getStreet());
        address.setCity(candidateDTO.getCity());
        address.setState(candidateDTO.getState());
        address.setZip(candidateDTO.getZip());
        address.setCountry(candidateDTO.getCountry());

        // save Address entity and set foreign key in Candidate entity
        addressService.registerAddress(address);
        candidate.setAddress(address);

        // save Candidate entity
        candidateService.registerCandidate(candidate);

        return "redirect:/candidate/list";
    }
    @GetMapping("/candidate-register")
    public String registerCandidate(Model model) {
        model.addAttribute("candidateDTO", new CandidateDTO());
        model.addAttribute("professions", proffesionService.getAllProffessions());

        return "candidate-register";
    }

    @GetMapping("/candidates-all") // change this whatever you want the path to be
        public List<CandidateService> getAllCandidates() {
            return candidateService.getAllCandidates();
        }


        @GetMapping(path = "/candidate-{id}")
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

