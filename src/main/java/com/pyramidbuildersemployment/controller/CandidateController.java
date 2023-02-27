package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.service.AddressService;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class CandidateController {


    private CandidateService candidateService;
       // @Autowired
       // private CandidateService candidateService;
        @Autowired
       // private CandidateServiceImpl candidateServiceImpl;

//    public CandidateController(CandidateServiceImpl candidateServiceImpl) {
//        this.candidateServiceImpl = candidateServiceImpl;
   // }
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }


    @GetMapping("/candidate/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        return "candidate-registration-form";
    }



    @PostMapping("/candidate/register")
    public String registerCandidate(@ModelAttribute("candidate") Candidate candidate) {
        // Call the service method to save the candidate and address to the database
        candidateService.registerCandidate(candidate);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping("/candidates") // change this whatever you want the path to be
        public List<CandidateService> getAllCandidates() {
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
            // System.out.println("test");
            // return new ResponseEntity<Customer>(customerService.updateCustomer(customer),
            // HttpStatus.OK);

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

