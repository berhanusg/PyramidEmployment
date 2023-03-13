package com.pyramidbuildersemployment.controller;


import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.models.RoleName;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.UserRepoInterface;
import com.pyramidbuildersemployment.service.RoleService;
import com.pyramidbuildersemployment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
    public class UserController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepoInterface userRepoInterface;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
  // Here the USER is Registered
    @GetMapping("/user-register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model, HttpSession session)
    {
        //for terms and conditions in registration page
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(RoleName.valueOf("USER").toString());
        userRepoInterface.save(user);

        //if the terms and conditions are checked

       return "redirect:/user-register";

    }


}

