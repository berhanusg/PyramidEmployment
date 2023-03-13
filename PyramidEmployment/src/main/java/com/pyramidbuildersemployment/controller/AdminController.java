package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.HiringCompanyDTO;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.service.HiringCompanyService;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//
//    @GetMapping("/loginadmin")
//    public String showAdminLogin() {
//        return "loginadmin";
//    }
//    @GetMapping("/adminhome")
//    public String showDashboard() {
//        return "adminhome";
//    }
//
//    @GetMapping("/hiring-company")
//    public String showHiringCompanyManagement() {
//        // code to show hiring company management page
//        return "hiringcompany-list";
//    }
//
//    @GetMapping("/candidate")
//    public String showCandidateManagement() {
//        // code to show candidate management page'
//        return "candidate-list";
//    }
//
//    @GetMapping("/profession")
//    public String showProfessionManagement() {
//        // code to show profession management page
//        return "proffession-register";
//    }
//
//    @GetMapping("/user-register")
//    public String showUserManagement() {
//        // code to show user management page
//        return "";
//    }
//
//    @GetMapping("/role-create")
//    public String showRoleManagement() {
//        // code to show role management page
//        return "";
//    }
//
//    @Autowired
//    // private HiringCompanyServiceImpl hiringCompanyServiceImpl;
//    private HiringCompanyService hiringCompanyService;
//    @Autowired
//    private JobListingService jobListingService;
//
//      /*
//
//      This code defines a controller method showHiringCompanyRegistrationForm()
//       that returns a String which is the name of the Thymeleaf template file (hiringcompany-register.html).
//       The method also adds a new HiringCompanyDTO object to the model so that it can be used in the template to bind form data.
//       Additionally, the method retrieves a list of all JobListing objects from the database using jobListingService.getAllAlljoblistings()
//        and adds it to the model so that it can be used to populate a select box in the template.
//  */
//
//
//
//    @GetMapping("/hiringcompany-register")
//    public String registerHiringCompanies(Model model) {
//        List<HiringCompany> hiringcompanyList = hiringCompanyService.getAllAllHiringCompanies();
//
//        model.addAttribute("hiringCompanyDTO", new HiringCompanyDTO());
//
//        return "hiringcompany-register";
//    }
//
//    //@PostMapping(value = "/hiringcompany-register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//
//    @PostMapping("/hiringcompany-register")
//    public String registerHiringCompany(@ModelAttribute("hiringCompanyDTO") @Valid HiringCompanyDTO hiringCompanyDTO, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "hiringcompany-register";
//        }
//
//        // add null check for address
//        if (hiringCompanyDTO.getHiringCompanyName() == null) {
//            // handle null name error
//            return "hiringcompany-register";
//        }
//        // create new HiringCompany entity
//        HiringCompany hiringCompany = new HiringCompany();
//
//        hiringCompany.setHiringCompanyName(hiringCompanyDTO.getHiringCompanyName());
//        hiringCompany.setContactpersonfname(hiringCompanyDTO.getContactpersonfname());
//        hiringCompany.setContactpersonlname(hiringCompanyDTO.getContactpersonlname());
//        hiringCompany.setHiringcompanyemail(hiringCompanyDTO.getEmail());
//        hiringCompany.setCity(hiringCompanyDTO.getCity());
//        hiringCompany.setState(hiringCompanyDTO.getState());
//        hiringCompany.setCountry(hiringCompanyDTO.getCountry());
//        hiringCompany.setZip(hiringCompanyDTO.getZip());
//        hiringCompany.setWebSite(hiringCompanyDTO.getWebSite());
//        hiringCompany.setStreet(hiringCompanyDTO.getStreet());
////        Long jobListingId = hiringCompanyDTO.getJobListingId();
////        JobListing joblisting= jobListingService.getJobListingById(jobListingId);
////        hiringCompany.setJobListingId(joblisting);
//        // Call the service method to save the hiring company to the database
//        model.addAttribute("hiringCompanyDTO", hiringCompanyDTO);
//        hiringCompanyService.registerhiringCompany(hiringCompany);
//        // Redirect to a success page
//        return "hiringcompany-list";
//    }
//
//
//    @RequestMapping(value = "/hiringcompany-list", method = {RequestMethod.GET, RequestMethod.POST})
//    //@GetMapping("/hiringcompany-list")
//    public String hiringCompanyList(Model model) {
//        List<HiringCompany> hiringcompany = hiringCompanyService.getAllAllHiringCompanies();
//        model.addAttribute("hiringcompany",hiringcompany);
//        return "hiringcompany-list";
//    }
//
//
//    //retrieve the hiring company by its ID and add it to the model for the view:
//    @RequestMapping(value = "/edit-hiring-company/{id}", method = {RequestMethod.GET, RequestMethod.POST})
//    public ModelAndView showEditHiringCompanyForm(@PathVariable(name="id") Long id) {
//        HiringCompany hiringcompany = hiringCompanyService.getHiringCompanyById(id);
//
//        ModelAndView modelAndView = new ModelAndView("hiringcompany-edit");
//        modelAndView.addObject("id", id);
//
//        //modelAndView.addObject("hiringcompany", hiringcompany);
//        System.out.println(id);
//        return modelAndView;
//    }
//
//
//
//    @RequestMapping(value = "/update-hiringcompany", method = {RequestMethod.GET, RequestMethod.POST})
//    // @PostMapping("/update-profession")
//    public String updateHiringCompany(@ModelAttribute("hiringcompany") HiringCompany hiringCompany) {
//
//        hiringCompanyService.updateHiringCompany(hiringCompany);
//        return "redirect:/hiringcompany-list";
//    }
//
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CandidateController candidateController;

    @Autowired
    private HiringCompanyController hiringCompanyController;

    @Autowired
    private HiringJobListingController hiringJobListingController;

    @Autowired
    private JobListingController jobListingController;

    @Autowired
    private ProffessionController professionController;

    @Autowired
    private RoleController roleController;

    @Autowired
    private UserController userController;

    @GetMapping("/loginadmin")
    public String showAdminLogin() {
        return "loginadmin";
    }

    @GetMapping("/adminhome")
    public String showDashboard() {
        return "adminhome";
    }


    @GetMapping("/{controller}")
    public String redirectToController(@PathVariable String controller) {


        switch (controller) {

            case "candidate":

                return "redirect:/admin/candidate-list";
            case "hiring-company":
                return "redirect:/admin/hiring-company-list";
            case "hiring-job-listing":
                return "redirect:/admin/hiring-job-listing-list";
            case "job-listing":
                return "redirect:/admin/job-listing-list";
            case "profession":

                return "redirect:/admin/profession-list";
            case "role":
                return "redirect:/admin/role-list";
            case "user":
                return "redirect:/admin/user-list";
            default:
                return "adminhome";
        }
    }

}





