package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.JobListingDTO;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.ProffesionService;
import com.pyramidbuildersemployment.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
      @PostMapping("/login-client")
      public String processClientLogin(@RequestParam("email") String email, @RequestParam("password") String password) {
        // Perform login logic and redirect to dashboard on success
        // ...
        return "redirect:/user/hiring/loginhiring";
    }

    @GetMapping("/loginhiring")
            public String showDashboard() {
                return "loginhiring";
            }

    }


