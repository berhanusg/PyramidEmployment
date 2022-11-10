package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.service.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/Candidate")


public class CandidateController {

    private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
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
    
}
