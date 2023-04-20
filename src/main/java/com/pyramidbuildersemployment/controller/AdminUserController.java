package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.RoleName;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.UserRepoInterface;
import com.pyramidbuildersemployment.service.RoleService;
import com.pyramidbuildersemployment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

// In this method, we use the @Controller annotation to indicate that this class is a controller.

@Controller
@RequestMapping("/admin")
public class AdminUserController {



        // Define the passwordEncoder method
        private BCryptPasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Autowired
        private UserRepoInterface userRepoInterface;
        @Autowired
        private UserService userService;
        @Autowired
        private RoleService roleService;



        // We also use the @GetMapping annotation to map the "/user-list" URL to this method.
        //The showUsers() method takes a Model object as a parameter. This Model object is used to pass data to the Thymeleaf template.
        // In this case, we create a list of users and add it to the model with the key "users".
        // we create a list of users and add it to the model with the key "users".
        // Finally we return the name of the Thymeleaf template ("user-list") that should be used to render the view.
        @GetMapping("/user-list")
        public String showUserList(Model model) {
      //  List<User> users = userService.getAllUsers();

            List<UserDTO> userList = userService.getAllUsers();//  list of User objects

            userList.forEach(user -> {
                System.out.println("User ID: " + user.getId());
                System.out.println("User Email: " + user.getEmail());
                System.out.println("User First Name: " + user.getFirstName());
                System.out.println("User Last Name: " + user.getLastName());
                System.out.println("User Password: " + user.getPassword());
                System.out.println("User Role ID: " + user.getRolename());
                System.out.println("User Username: " + user.getUsername());
                System.out.println("---------------------------------");
            });

            model.addAttribute("users", userList);
            return "users-list";
        }

        @GetMapping("/user-register")
        public String showRegistrationForm(Model model) {
            model.addAttribute("user", new UserDTO());
            return "register";
        }

        @PostMapping("/register")
        public String registerUser(@ModelAttribute("user") User user,
                                   Model model,
                                   HttpSession session) {
            //for terms and conditions in registration page
            user.setPassword(passwordEncoder().encode(user.getPassword()));
            user.setRoleId(RoleName.USER.toString());
            userService.save(user);

            //if the terms and conditions are checked
            return "redirect:/admin/user-list";
        }
    }



