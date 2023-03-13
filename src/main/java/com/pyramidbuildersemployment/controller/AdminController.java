package com.pyramidbuildersemployment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CandidateController candidateController;

    @Autowired
    private HiringCompanyController hiringCompanyController;

    @Autowired
    private HiringJobListingController hiringJobListingController;

    @Autowired
    private JobListingController jobListingController;

    @Autowired
    private ProffessionController professionController;

    @Autowired
    private RoleController roleController;

    @Autowired
    private UserController userController;

    @GetMapping("/loginadmin")
    public String showAdminLogin() {
        return "loginadmin";
    }

    @GetMapping("/adminhome")
    public String showDashboard() {
        return "adminhome";
    }


    @GetMapping("/{controller}")
    public String redirectToController(@PathVariable String controller) {


        switch (controller) {

            case "candidate":

                return "redirect:/admin/candidate-list";
            case "hiring-company":
                return "redirect:/admin/hiring-company-list";
            case "hiring-job-listing":
                return "redirect:/admin/hiring-job-listing-list";
            case "job-listing":
                return "redirect:/admin/job-listing-list";
            case "profession":

                return "redirect:/admin/profession-list";
            case "role":
                return "redirect:/admin/role-list";
            case "user":
                return "redirect:/admin/user-list";
            default:
                return "adminhome";
        }
    }

}





