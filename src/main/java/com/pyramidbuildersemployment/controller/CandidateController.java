package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.User;
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
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
@CrossOrigin
public class CandidateController {



    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ProffesionService proffesionService;

    @Autowired
    private UserServiceImpl userServiceImpl;


    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }




// This shows Empty form in the browser
   /* @GetMapping("/user/candidate-register")
    public String showAdminCandidateRegistrationForm(Model model) {
        List<Profession> professions = proffesionService.getAllProffessions();
        model.addAttribute("professions", professions);
        model.addAttribute("candidateDTO", new CandidateDTO());
        return "candidate-register";
    }*/
    @GetMapping("/user/candidate-register")
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



    // WAS  @PostMapping("/candidate-register-process")
    @PostMapping("/user/candidate-register-process")
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
//         if (user.getRoles().contains("ROLE_ADMIN")){
//
//             return "redirect:/candidate-list";
//         }
        // return "redirect:client/candidate-register";
        return "redirect:/candidate-list";
    }



    @GetMapping("/user/candidate-list")
    public String candidateList(Model model) {
        List<Candidate> candidatesList = candidateService.getAllCandidates();
        model.addAttribute("candidates",candidatesList);
        return "candidate-list";
    }


//    @GetMapping("/candidate-list")
//    public String candidateList(Model model) {
//        return "redirect:candidate-register";
//    }



    @GetMapping("/candidates-all") // change this whatever you want the path to be
        public List<Candidate> getAllCandidates() {
            return candidateService.getAllCandidates();
        }


    @RequestMapping(value = "/candidate-delete/{id}", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})

      //  @DeleteMapping(path = "candidate-delete/{id}")
        public ResponseEntity<String> deleteCandidate(@PathVariable long id) {

            // delete address from DB
            candidateService.deleteCandidate(id);
            System.out.println(id);
            return new ResponseEntity<String>("Candidate deleted successfully!.", HttpStatus.OK);
        }






}

