package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
    public class AuthController {
    @Autowired
        private UserService userService;

        @Autowired
        public AuthController(UserService userService) {
            this.userService = userService;
        }

        // handler method to handle login page request
        @GetMapping("/login")
        public String loginPage(){
            return "login";
        }

    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
        // handler method to handle user registration request
       // @GetMapping("/register ")
        public String showRegistrationForm(Model model){
            // this object holds form data
            UserDTO user = new UserDTO();
            model.addAttribute("user", user);
            return "register";
        }

        // handler method to handle user registration form submit request
        @RequestMapping(value = "/register/save", method = {RequestMethod.GET, RequestMethod.POST})
      //  @PostMapping("/register/save")
        public String register(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){
            User existingUser = userService.findByEmail(user.getEmail());
            if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
                result.rejectValue("email", null, "There is already a user with same email id");
            }

            if(result.hasErrors()){
                model.addAttribute("user", user);
                return "register";
            }
            userService.createUser(user);
            return "redirect:/register?success";
        }
    }


