package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.service.AddressService;
import com.pyramidbuildersemployment.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class CandidateController {




        private CandidateService candidateService;

        public CandidateController(CandidateService candidateService) {
            this.candidateService = candidateService;
        }

        @GetMapping() // change this whatever you want the path to be
        public List<CandidateService> getAllCandidates() {
            return candidateService.getAllCandidates();
        }


        @GetMapping(path = "/{id}")
        public ResponseEntity<Candidate> getCandidateById(@PathVariable long id) {
            Candidate candidate = candidateService.getCandidateById(id);

            if (candidate != null) {
                // send a 200 status code with the user object as the response body
                return ResponseEntity.ok(candidate);
            } else {
                return ResponseEntity.notFound().build();
            }

        }

        @PostMapping()
        public ResponseEntity<Candidate> registerCandidat(@RequestBody Candidate candidate) {

            candidate = candidateService.saveAll(candidate);
            return ResponseEntity.status(HttpStatus.CREATED).body(candidate);

        }

        @PutMapping(path = "/{id}")
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
        @DeleteMapping(path = "/{id}")
        public ResponseEntity<String> deleteAddress(@PathVariable long id) {

            // delete address from DB
            candidateService.deleteCandidate(id);

            return new ResponseEntity<String>("Address deleted successfully!.", HttpStatus.OK);
        }



    }

