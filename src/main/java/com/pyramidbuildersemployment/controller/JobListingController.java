package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@CrossOrigin
public class JobListingController {
    @Autowired
    private JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }


    @GetMapping("/joblisting/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("joblisting", new JobListing());
        return "joblisting-registration-form";
    }

    @PostMapping("/joblisting/register")
    public String registerJoblisting(@ModelAttribute("joblisting") JobListing jobListing) {
        // Call the service method to save the candidate and address to the database
        jobListingService.registerJoblisting(jobListing);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping("/joblisting") // change this whatever you want the path to be
    public List<JobListingService> getAllJoblistings() {
        return jobListingService.getAllAlljoblistings();
    }


    @GetMapping(path = "joblisting/{id}")
    public ResponseEntity<JobListing> getJoblistingById(@PathVariable long id) {
        JobListing jobListing = jobListingService.getJobListingById(id);

        if (jobListing != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(jobListing);
        } else {
            return ResponseEntity.notFound().build();
        }

    }


// THis is where Experience iD would have been useful to pull out the candidates that have relevant experience
//    @PutMapping(path = "joblisting/{id}")
//    public ResponseEntity<JobListing> updateProfession(@RequestBody JobListing jobListing, @PathVariable long id) {
//
//
//        if (jobListing.getExperienceid().equals(id)) {
//            jobListing = jobListingService.updateJoblisting(jobListing);
//            if (jobListing != null) {
//                return ResponseEntity.ok(jobListing);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//
//    }
    @DeleteMapping(path = "joblisting/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {

        // delete address from DB
        jobListingService.deleteJobListing(id);

        return new ResponseEntity<String>(" The Job Listed  deleted successfully!.", HttpStatus.OK);
    }


}
