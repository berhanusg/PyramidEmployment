package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserJobListingController {
    private JobListingService jobListingService;
    @GetMapping("/user-joblisting-list")
    public String listJobs(Model model)
    {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);

        return  "joblisting-list";
    }

}
