package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.HiringCompanyNullException;
import com.pyramidbuildersemployment.dto.JobListingDTO;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.HiringCompanyServiceImpl;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.ProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
@Controller
@CrossOrigin
public class JobListingController {
    @Autowired
    private JobListingService jobListingService;

    @Autowired
    HiringCompanyServiceImpl hiringCompanyServiceImpl;
    @Autowired
    private ProffesionService professionService;
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
    Finally, the method calls the jobListingService method of the HiringCompanyService
    to save the HiringCompany entity to the database.
     It then adds the hiringCompanyDTO object to the model and redirects
     to the "joblisting-list" view to display a list of all registered hiring companies.

     */
    @PostMapping("/joblisting-registerprocess")
    public String registerJoblisting(@ModelAttribute("jobListingDTO") @Valid JobListingDTO jobListingDTO, BindingResult bindingResult, Model model) {

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

        return "joblisting-list";
    }
/*
This code creates a GET endpoint at the URL path "/joblisting-list"
 that retrieves a list of all the job lised in the database using the
 getAllAlljoblistings(); method from the jobListingService.class, adds
 the list to the model with the attribute name "joblisting",
and returns the Thymeleaf view name "joblistinglist". The view is expected to
 render the list of joblisting
 joblisting-list
 */
    @GetMapping("/user/joblisting-list")
    public String listJobs(Model model)
    {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);

        return  "joblisting-list";
    }


    @RequestMapping(value = "/edit-joblisting/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showEditJobListingForm(@PathVariable(name="id") Long id) {
        JobListing jobListing = jobListingService.getJobListingById(id);

        ModelAndView modelAndView = new ModelAndView("jobListing-edit");
        modelAndView.addObject("id", id);
        modelAndView.addObject("jobListing", jobListing);
        System.out.println(id);
        return modelAndView;
    }



    @RequestMapping(value = "/update-jobListing", method = {RequestMethod.GET, RequestMethod.POST})

    public String updateJobListing(@ModelAttribute("jobListing") JobListing jobListing) {
        jobListingService.registerJoblisting(jobListing);
        return "redirect:/joblisting-list";
    }

    @GetMapping("/joblisting-candidates/{id}")
    public String getJobListingCandidates(@PathVariable("id") Long jobListingId, Model model) {
        // Retrieve job listing from the database using jobListingId
        JobListing jobListing = jobListingService.getJobListingById(jobListingId);
        // Retrieve the list of candidates with the specific job qualification
       Profession profession = professionService.getProfessionById(jobListingId);
        model.addAttribute("candidates" /* List of candidates with the specific job qualification */);
        return "candidates_list";
    }



        @PostMapping("/create")
        public ResponseEntity<JobListing> createJobListing(@RequestParam Long hiringCompanyId) {
            try {
                hiringCompanyServiceImpl.CreateJobListing(hiringCompanyId);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } catch (HiringCompanyNullException ex) {
                // handle exception...
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }



