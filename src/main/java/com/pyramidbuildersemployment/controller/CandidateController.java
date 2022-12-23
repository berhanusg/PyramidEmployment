//package  com.pyramidbuildersemployment.controller;
//
//import com.pyramidbuildersemployment.models.Candidate;
//import com.pyramidbuildersemployment.service.CandidateServiceRepoImplement;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin
//@RequestMapping("/Candidate")
//
//
//public class CandidateController {
//
//    private CandidateServiceRepoImplement candidateServiceRepoImplement;
//
//    public CandidateController(CandidateServiceRepoImplement candidateServiceRepoImplement) {
//        this.candidateServiceRepoImplement = candidateServiceRepoImplement;
//    }
//
//    @GetMapping(path = "/{id}")
//    public ResponseEntity<Candidate> getCandidateById(@PathVariable long id) {
//        Candidate candidate = candidateServiceRepoImplement.findCandidatesBYId(id);
//
//        if (candidate != null) {
//            // send a 200 status code with the user object as the response body
//            return ResponseEntity.ok(candidate);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//}
