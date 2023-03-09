//package com.pyramidbuildersemployment.controller;
//
//import com.pyramidbuildersemployment.dto.UserDTO;
//import com.pyramidbuildersemployment.models.User;
//import com.pyramidbuildersemployment.service.RoleService;
//import com.pyramidbuildersemployment.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
//import org.springframework.security.web.savedrequest.SavedRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;
//@Controller
//public class AuthController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    // handler method to handle login page request
//    @GetMapping("/login")
//    public String loginPage(){
//        return "login";
//    }
//
//    @RequestMapping(value = "/register", method = {RequestMethod.GET, RequestMethod.POST})
//    // handler method to handle user registration request
//    public String showRegistrationForm(Model model){
//        // this object holds form data
//        UserDTO user = new UserDTO();
//        model.addAttribute("user", user);
//        return "register";
//    }
//
//    // handler method to handle user registration form submit request
//    @RequestMapping(value = "/register/save", method = {RequestMethod.GET, RequestMethod.POST})
//    public String register(@Valid @ModelAttribute("user") User user,
//                           BindingResult result,
//                           Model model,
//                           HttpServletRequest request){
//
//        User existingUser = userService.findByEmail(user.getEmail());
//        if(existingUser != null && existingUser.getEmail() !=null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null, "There is already a user with same email id");
//        }
//
//        if(result.hasErrors()){
//            model.addAttribute("user", user);
//            return "register";
//        }
//
//        userService.createUser(user);
//
//        // authenticate the user and log in
//        UsernamePasswordAuthenticationToken authReq
//                = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
//        Authentication auth = authenticationManager.authenticate(authReq);
//        SecurityContextHolder.getContext().setAuthentication(auth);
//
//        // redirect the user to the originally requested page or the home page
//        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, null);
//        if (savedRequest != null && !savedRequest.getRedirectUrl().isEmpty()) {
//            return "redirect:" + savedRequest.getRedirectUrl();
//        } else {
//            return "redirect:/";
//        }
//    }
//}
