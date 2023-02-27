package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.JobListingServiceImpl;
import com.pyramidbuildersemployment.service.ProfessionServiceImpl;
import com.pyramidbuildersemployment.service.ProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class JobListingController {
    @Autowired
    private JobListingServiceImpl jobListingServiceImpl;

    public JobListingController(JobListingServiceImpl jobListingServiceImpl) {
        this.jobListingServiceImpl = jobListingServiceImpl;
    }


    @GetMapping("/joblisting/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("joblisting", new JobListing());
        return "joblisting-registration-form";
    }

    @PostMapping("/joblisting/register")
    public String registerCandidate(@ModelAttribute("joblisting") JobListing jobListing) {
        // Call the service method to save the candidate and address to the database
        jobListingServiceImpl.registerJoblisting(jobListing);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping() // change this whatever you want the path to be
    public List<JobListingService> getAllProffesions() {
        return jobListingServiceImpl.getAllAlljoblistings();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<JobListing> getCandidateById(@PathVariable long id) {
        JobListing jobListing = jobListingServiceImpl.getJobListingById(id);

        if (jobListing != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(jobListing);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{joblisting}")
    public ResponseEntity<JobListing> registerCandidat(@RequestBody JobListing jobListing) {

        jobListing = jobListingServiceImpl.saveAll(jobListing);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobListing);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<JobListing> updateProfession(@RequestBody JobListing jobListing, @PathVariable long id) {


        if (jobListing.getExperienceid().equals(id)) {
            jobListing = jobListingServiceImpl.updateJoblisting(jobListing);
            if (jobListing != null) {
                return ResponseEntity.ok(jobListing);
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
        jobListingServiceImpl.deleteJobListing(id);

        return new ResponseEntity<String>(" The Job Listed  deleted successfully!.", HttpStatus.OK);
    }


}
