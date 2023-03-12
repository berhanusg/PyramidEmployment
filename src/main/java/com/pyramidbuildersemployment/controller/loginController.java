package com.pyramidbuildersemployment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {




    @GetMapping("/user/home")
    public String userHome(Model model) {

       // return "home";

        return "/user/login-client";
    }

    @PostMapping("/user/loginclient")
    public String processClientLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {

        // Redirect user to home page
        return "redirect:/user/home";
    }



    /*

    When the user submits the login form, Spring Security will intercept the request and handle the
     authentication automatically. If the authentication is successful, the user will be redirected
     to the default success URL (in this case, /user/home).
    If the authentication fails, Spring Security will automatically redirect the user to the login page with an error message.

     */
}

