package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.CandidateDTO;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.CandidateRepoInterface;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.JobListingService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

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

///user/candidate-register-process

    // WAS  @PostMapping("/candidate-register-process")

    @PostMapping("/user/candidate-register")
    public String registerCandidate(
            @ModelAttribute("candidateDTO") @Valid CandidateDTO candidateDTO,
            BindingResult bindingResult,
            Model model,
            Principal principal,
            RedirectAttributes redirectAttributes) throws ChangeSetPersister.NotFoundException, IOException {

        if (bindingResult.hasErrors()) {
            return "candidate-register";
        }

        if (candidateDTO.getFirstname() == null) {
            return "candidate-register";
        }

        Candidate candidate = handleFileUpload(candidateDTO, redirectAttributes);

        if (candidate == null) {
            return "candidate-register";
        }

        candidate.setFirstname(candidateDTO.getFirstname());
        candidate.setMiddlename(candidateDTO.getMiddlename());
        candidate.setLastname(candidateDTO.getLastname());
        candidate.setGender(candidateDTO.getGender());
        candidate.setTelephone(candidateDTO.getTelephone());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setEducationLevel(candidateDTO.getEducationLevel());
        candidate.setNumberOfMonths(candidateDTO.getNumberOfMonths());
        candidate.setNumberOfYears(candidateDTO.getNumberOfYears());
        candidate.setExperiencedescription(candidateDTO.getExperiencedescription());

        candidate.setStreet(candidateDTO.getStreet());
        candidate.setCity(candidateDTO.getCity());
        candidate.setState(candidateDTO.getState());
        candidate.setZip(candidateDTO.getZip());
        candidate.setCountry(candidateDTO.getCountry());
        candidate.setLinkedin(candidateDTO.getLinkedin());
        candidate.setFacebook(candidateDTO.getFacebook());
        candidate.setYoutube(candidateDTO.getYoutube());

        User user = userServiceImpl.findByEmail(principal.getName());
        candidateService.registerCandidate(candidate);

        model.addAttribute("candidateDTO", candidateDTO);

        return "redirect:/user/user-joblisting-list";
    }

    @Autowired
    private JobListingService jobListingService;
    @Autowired
    private CandidateRepoInterface candidateRepoInterface;

    @GetMapping("/user/user-joblisting-list")
    public String listJobs(Model model) {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);
        return "user-joblisting-list";
    }


    @GetMapping("/user/candidate-list")
    public String candidateList(Model model) {
        List<Candidate> candidatesList = candidateService.getAllCandidates();
        model.addAttribute("candidates", candidatesList);
        return "candidate-list";
    }




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


  //  @PostMapping("/user/candidate-register")
  @Transactional
  public Candidate handleFileUpload(@ModelAttribute CandidateDTO candidateDTO,
                                    RedirectAttributes redirectAttributes) throws IOException {
      MultipartFile resumeFile = candidateDTO.getResumeFile();

      if (resumeFile.isEmpty()) {
          redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
          return null;
      }

      String originalFilename = resumeFile.getOriginalFilename().toLowerCase();
      if (!originalFilename.endsWith(".pdf") && !originalFilename.endsWith(".doc") && !originalFilename.endsWith(".docx")) {
          redirectAttributes.addFlashAttribute("message", "Invalid file type. Please upload a PDF or Word file.");
          return null;
      }

      if (resumeFile.getSize() > 5000000) {
          redirectAttributes.addFlashAttribute("message", "File is too large. Please upload a file of size less than 5 MB.");
          return null;
      }

      byte[] bytes = resumeFile.getBytes();

      Candidate candidate = new Candidate();
      candidate.setResume(bytes);

      return candidate;
  }

}


