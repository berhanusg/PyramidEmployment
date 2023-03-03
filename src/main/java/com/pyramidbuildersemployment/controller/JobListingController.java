package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.JobListingDTO;
import com.pyramidbuildersemployment.dto.ProffesionDTO;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class JobListingController {
    @Autowired
    private JobListingService jobListingService;

    public JobListingController(JobListingService jobListingService) {
        this.jobListingService = jobListingService;
    }


    // Display the registrationform to the user
    @GetMapping("/joblisting-register")
    public String showJobListingRegisterForm(Model model) {
        model.addAttribute("jobListingDTO", new JobListingDTO());

        return "joblisting-register";
    }

// the method recieves  form data as a JobListingDTO object,
// which is annotated with @Valid to enable data validation, and with @ModelAttribute to bind the data to the model.
    // It also receives a BindingResult object to store any validation errors that occur during the data binding process.
    /*
    Finally, the method calls the jobListingService method of the HiringCompanyService to save the HiringCompany entity to the database.
     It then adds the hiringCompanyDTO object to the model and redirects to the "joblisting-list" view to display a list of all registered hiring companies.

     */
    @PostMapping("/joblisting-register")
    public String registerProfession(@ModelAttribute("jobListingDTO") @Valid JobListingDTO jobListingDTO, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "joblisting-register";
        }

        // create new joblisting entity
        JobListing jobListing = new JobListing();
        jobListing.setId(jobListingDTO.getId());
        jobListing.setJobTitle(jobListingDTO.getJobTitle());
        jobListing.setJobDescription(jobListingDTO.getJobDescription());
        jobListing.setLocation(jobListingDTO.getLocation());
        jobListing.setSalary(jobListingDTO.getSalary());
        jobListing.setVacancy(jobListingDTO.getVacancy());
        model.addAttribute("jobListingService", jobListingService);

        jobListingService.registerJoblisting(jobListing);

        return "redirect:/joblisting-list";
    }
/*
This code creates a GET endpoint at the URL path "/joblisting-list"
 that retrieves a list of all the job lised in the database using the
 getAllAlljoblistings(); method from the jobListingService.class, adds
 the list to the model with the attribute name "joblisting",
and returns the Thymeleaf view name "joblistinglist". The view is expected to
 render the list of joblisting
 */
    @GetMapping("/joblisting-list")
    public String listJobs(Model model)
    {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);

        return  "joblisting-list";
    }





//    @GetMapping("/joblisting/register")
//    public String showJobSeekerRegistrationForm(Model model) {
//        model.addAttribute("joblisting", new JobListing());
//        return "joblisting-registration-form";
//    }
//
//    @PostMapping("/joblisting/register")
//    public String registerJoblisting(@ModelAttribute("joblisting") JobListing jobListing) {
//        // Call the service method to save the candidate and address to the database
//        jobListingService.registerJoblisting(jobListing);
//
//        // Redirect to a success page
//        return "redirect:/success";
//    }
//
//
//    @GetMapping("/joblisting") // change this whatever you want the path to be
//    public List<JobListing> getAllJoblistings() {
//        return jobListingService.getAllAlljoblistings();
//    }
//
//
//    @GetMapping(path = "joblisting/{id}")
//    public ResponseEntity<JobListing> getJoblistingById(@PathVariable long id) {
//        JobListing jobListing = jobListingService.getJobListingById(id);
//
//        if (jobListing != null) {
//            // send a 200 status code with the user object as the response body
//            return ResponseEntity.ok(jobListing);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//
//// THis is where Experience iD would have been useful to pull out the candidates that have relevant experience
////    @PutMapping(path = "joblisting/{id}")
////    public ResponseEntity<JobListing> updateProfession(@RequestBody JobListing jobListing, @PathVariable long id) {
////
////
////        if (jobListing.getExperienceid().equals(id)) {
////            jobListing = jobListingService.updateJoblisting(jobListing);
////            if (jobListing != null) {
////                return ResponseEntity.ok(jobListing);
////            } else {
////                return ResponseEntity.badRequest().build();
////            }
////        } else {
////            return ResponseEntity.status(HttpStatus.CONFLICT).build();
////        }
////
////    }
//    @DeleteMapping(path = "joblisting/{id}")
//    public ResponseEntity<String> deleteAddress(@PathVariable long id) {
//
//        // delete address from DB
//        jobListingService.deleteJobListing(id);
//
//        return new ResponseEntity<String>(" The Job Listed  deleted successfully!.", HttpStatus.OK);
//    }


}
