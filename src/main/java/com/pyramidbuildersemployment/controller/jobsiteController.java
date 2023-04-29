package com.pyramidbuildersemployment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class jobsiteController {


    @GetMapping("/")
    public String showCandidateRegistrationForm(Model model) {

            return "jobsite";
        }
    }

