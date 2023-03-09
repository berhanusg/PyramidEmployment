package com.pyramidbuildersemployment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

    @GetMapping("/login-admin")
    public String showAdminLogin1(Model model) {

        return "loginadmin";
    }

    @GetMapping("/login-client")
    public String showclientLogin(Model model) {

        return "loginclient";
    }
}

