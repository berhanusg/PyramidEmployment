package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.JobListingDTO;
import com.pyramidbuildersemployment.dto.ProffesionDTO;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.ProffesionService;
import com.pyramidbuildersemployment.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    CandidateService candidateService;
    @Autowired
    ProffesionService proffesionService;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    JobListingService jobListingService;

    JobListingDTO jobListingDTO;

    @GetMapping("/user/login-client")
    public String showClientLogin(Model model) {
        return "loginclient";
    }



    @GetMapping("/{controller}")
    public String redirectToController(@PathVariable String controller, @RequestParam(required = false)
    String jobTitle, @RequestParam(required = false) String location) {
        System.out.println(controller);
        switch ("THis is the value passed " + controller) {

            case "candidate-register":
                return "redirect:/user/candidate-register";
            case "/user-joblisting-list":
                return "redirect:/user-joblisting-list";

            case "/user/jobsearch":   // "candidate/search":
                return "redirect: /user/jobsearch ";
            default:
                return "home";
        }
    }
    @GetMapping("/jobsearch")
  //@PostMapping ("/jobsearch")

    @RequestMapping(value = "/jobsearch", method = {RequestMethod.GET, RequestMethod.POST})
    public String lookUpForJob(@RequestParam(required = false) String jobTitle,
                               @RequestParam(required = false) String location,
                               @RequestParam(required = false) Double salary,
                               Model model) {
        if (jobTitle != null || location != null || salary != null) {

            // Search was submitted, so process the search request
            List<JobListing> jobListings = jobListingService.searchJobListings(jobTitle, location, salary);
            model.addAttribute("jobListing", jobListings);
            return "jobsearchresult"; // the name of search results template
        } else {
            // Search form is being displayed
            model.addAttribute("joblistingDTO", new JobListingDTO());
            return "/jobsearch";
        }
    }

    @PostMapping("/jobListings")
    public String searchJobListings(@RequestParam(required = false) String jobTitle,
                                    @RequestParam(required = false) String location,
                                    @RequestParam(required = false) Double salary,
                                    Model model) {
        List<JobListing> jobListings = jobListingService.searchJobListings(jobTitle, location, salary);
        model.addAttribute("jobListings", jobListings);
        model.addAttribute("jobTitle", jobTitle);
        model.addAttribute("location", location);
        model.addAttribute("salary", salary);
        return "jobsearchresult"; // the name of search results template
    }


}





