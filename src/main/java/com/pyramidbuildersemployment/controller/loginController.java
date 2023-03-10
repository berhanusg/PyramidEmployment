package com.pyramidbuildersemployment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {

//    @GetMapping("/admin/loginadmin")
//    public String showAdminLogin1(Model model) {
//
//        return "loginadmin";
//    }

    @GetMapping("/user/login-client")
    public String showclientLogin(Model model) {

        return "loginclient";
    }

    @GetMapping("/user/home")
    public String userHome(Model model) {

        return "home";
    }
}

