package com.pyramidbuildersemployment.controller;


import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.service.RoleService;
import com.pyramidbuildersemployment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@Controller
    public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/register-user")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register-user";
    }

  //  @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") @Valid UserDTO userDto, BindingResult bindingResult, Model model) {
//
//        if (bindingResult.hasErrors()) {
//            return "register";
//        }
//        User user = new User();
//        user.setId(userDto.getId());
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//        Role role = roleService.getRoleById(userDto.getId());
//
//        model.addAttribute("userDto", userDto);
//        userService.createUser(user);
//        return "redirect:/login?success";
//    }
/*
 The User class   does not have a setRole() method.
  Instead, it has a setRoles() method that sets a Set of Role objects.

 modify the code to add the role to the set of roles for the user.
 */

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userDto") @Valid UserDTO userDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        Role.RoleName roleName = Role.RoleName.valueOf(String.valueOf(userDto.getRolename()));
        Role role = roleService.getRoleByName(String.valueOf(roleName));
      //  user.setRole(role);
        /*
      Set is useful for representing roles in the User
      entity because each role can only be assigned to a user once.
     Using a List could allow duplicate roles to be added to the user,
     which could cause issues with role-based access control or other business logic.
         */
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        user.setRoles(roles);
        userService.createUser(user);

        return "redirect:/login?success";
    }
}