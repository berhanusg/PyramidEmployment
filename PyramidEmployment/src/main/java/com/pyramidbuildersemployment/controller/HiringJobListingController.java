package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.HiringCompanyDTO;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.HiringCompanyService;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HiringJobListingController {

    @Autowired
    private HiringCompanyService hiringCompanyService;

    @Autowired
    private JobListingService jobListingService;


    @GetMapping("/hiringcompanyregister")
    public String registerHiringCompanies(Model model) {
        List<HiringCompany> hiringcompanyList = hiringCompanyService.getAllAllHiringCompanies();

        model.addAttribute("hiringCompanyDTO", new HiringCompanyDTO());

        return "/clients/hiringcompany-register";
    }
    @GetMapping("/clientsjoblisting-register")
    public String listJobs(Model model)
    {
        List<JobListing> listOfJobs = jobListingService.getAlljoblistings();

        model.addAttribute("joblistingList", listOfJobs);

        return  "/clients/joblisting-register";
    }


    @PostMapping("/hiringCompanyRegister")
    public String registerHiringCompany(@ModelAttribute("hiringCompanyDTO") @Valid HiringCompanyDTO hiringCompanyDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "clients/hiringcompany-register";
        }

        // add null check for address
        if (hiringCompanyDTO.getHiringCompanyName() == null) {
            // handle null name error
            return "clients/hiringcompany-register";
        }
        // create new HiringCompany entity
        HiringCompany hiringCompany = new HiringCompany();

        hiringCompany.setHiringCompanyName(hiringCompanyDTO.getHiringCompanyName());
        hiringCompany.setContactpersonfname(hiringCompanyDTO.getContactpersonfname());
        hiringCompany.setContactpersonlname(hiringCompanyDTO.getContactpersonlname());
        hiringCompany.setHiringcompanyemail(hiringCompanyDTO.getEmail());
        hiringCompany.setCity(hiringCompanyDTO.getCity());
        hiringCompany.setState(hiringCompanyDTO.getState());
        hiringCompany.setCountry(hiringCompanyDTO.getCountry());
        hiringCompany.setZip(hiringCompanyDTO.getZip());
        hiringCompany.setWebSite(hiringCompanyDTO.getWebSite());
        hiringCompany.setStreet(hiringCompanyDTO.getStreet());
//        Long jobListingId = hiringCompanyDTO.getJobListingId();
//        JobListing joblisting= jobListingService.getJobListingById(jobListingId);
//        hiringCompany.setJobListingId(joblisting);
        // Call the service method to save the hiring company to the database
        model.addAttribute("hiringCompanyDTO", hiringCompanyDTO);
        hiringCompanyService.registerhiringCompany(hiringCompany);
        // Redirect to a success page
        return "redirect:/joblisting-register";
    }
}
