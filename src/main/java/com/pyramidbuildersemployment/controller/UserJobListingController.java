package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserJobListingController {

    @Autowired
    private JobListingService jobListingService;
    @GetMapping("/user/user-joblisting-list")
    public String listJobs(Model model)
    {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);

        return  "user-joblisting-list";
    }


    @Autowired
    private CandidateService candidateService;

    @GetMapping("/user/search")
    public String searchJobListings(   Model model)
                                 //   @RequestParam String searchValue,
//                                    public String searchJobListings(@RequestParam String searchCriteria,
//                                    //   @RequestParam String searchValue,
                                   {

       // List<JobListing> jobListings = candidateService.searchJobListings(searchCriteria, searchValue);
       // List<JobListing> jobListings = candidateService.searchJobListings(searchCriteria, searchValue);
     //   model.addAttribute("jobListings", //jobListings);

        return "searchforjobs";
    }

    @RequestMapping(value = "/user/search-joblisting", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showSearchResult(@RequestParam String searchValue, @RequestParam String searchCriteria,ModelAndView modelAndView){


        List <JobListing> joblisting = candidateService.searchJobListings(searchCriteria,searchValue);

        modelAndView = new ModelAndView("/jobListing");
       // modelAndView.addObject("searchValue", searchValue);
        modelAndView.addObject("jobListing", joblisting);

        return modelAndView;
    }


}
