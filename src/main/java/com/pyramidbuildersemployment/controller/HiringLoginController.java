package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.JobListingDTO;
import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.ProffesionService;
import com.pyramidbuildersemployment.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/hiring")
public class HiringLoginController {


    @Autowired
    CandidateService candidateService;
    @Autowired
    ProffesionService proffesionService;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    JobListingService jobListingService;

    JobListingDTO jobListingDTO;

    @GetMapping("/login-client")
    public String showClientLogin(Model model) {
        return "loginhiring";
    }

//    @PostMapping("/login-client")
//    public String processClientLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
//        // Perform login logic and redirect to dashboard on success
//        // ...
//        return "redirect:/user/hiring/loginhiring";
//    }

    @GetMapping("/loginhiring")
    public String showDashboard() {
        return "loginhiring";
    }


    @GetMapping("/register-hiring")
    public String showHiringRegistration(Model model) {
        model.addAttribute("users", new UserDTO()); // Assuming Users is the class name of your user entity
        return "hiringSignUp"; // Assuming hiringSignUp.html is your Thymeleaf view name for the form
    }


    @PostMapping("/register-hiring-process")
    public String processHiringRegistration(@ModelAttribute("users")  @Valid UserDTO userDTO ){
        // Perform registration logic here, like saving the user to the database
        userServiceImpl.createUser(new UserDTO()); // Uncomment this line if your service has a save method

        // After successful registration, you can redirect to the login page or a dashboard
        return "redirect:/user/hiring/login-client";
    }

}

