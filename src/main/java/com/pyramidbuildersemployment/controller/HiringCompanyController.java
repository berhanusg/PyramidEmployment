package  com.pyramidbuildersemployment.controller;
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


@Controller
@CrossOrigin
public class HiringCompanyController {
    @Autowired
   // private HiringCompanyServiceImpl hiringCompanyServiceImpl;
    private HiringCompanyService hiringCompanyService;
    @Autowired
    private JobListingService jobListingService;
    public HiringCompanyController(HiringCompanyService hiringCompanyService) {
        this.hiringCompanyService = hiringCompanyService;
    }
      /*

      This code defines a controller method showHiringCompanyRegistrationForm()
       that returns a String which is the name of the Thymeleaf template file (hiringcompany-register.html).
       The method also adds a new HiringCompanyDTO object to the model so that it can be used in the template to bind form data.
       Additionally, the method retrieves a list of all JobListing objects from the database using jobListingService.getAllAlljoblistings()
        and adds it to the model so that it can be used to populate a select box in the template.
  */



        @GetMapping("/hiringcompany-register")
    public String registerHiringCompanies(Model model) {
        List<HiringCompany> hiringcompanyList = hiringCompanyService.getAllAllHiringCompanies();

        model.addAttribute("hiringCompanyDTO", new HiringCompanyDTO());

        return "hiringcompany-register";
    }

    //@PostMapping(value = "/hiringcompany-register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @PostMapping("/hiringcompany-register")
    public String registerHiringCompany(@ModelAttribute("hiringCompanyDTO") @Valid HiringCompanyDTO hiringCompanyDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "hiringcompany-register";
        }

        // add null check for address
        if (hiringCompanyDTO.getHiringCompanyName() == null) {
            // handle null name error
            return "hiringcompany-register";
        }
        // create new HiringCompany entity
        HiringCompany hiringCompany = new HiringCompany();

        hiringCompany.setHiringCompanyName(hiringCompanyDTO.getHiringCompanyName());
        hiringCompany.setContactpersonfname(hiringCompanyDTO.getContactpersonfname());
        hiringCompany.setContactpersonlname(hiringCompanyDTO.getContactpersonlname());
        hiringCompany.setHiringcompanyemail(hiringCompanyDTO.getEmail());
        hiringCompany.setCity(hiringCompanyDTO.getCity());
        hiringCompany.setState(hiringCompanyDTO.getState());
        hiringCompany.setCountry(hiringCompanyDTO.getCountry());
        hiringCompany.setZip(hiringCompanyDTO.getZip());
        hiringCompany.setWebSite(hiringCompanyDTO.getWebSite());
        hiringCompany.setStreet(hiringCompanyDTO.getStreet());

        // Call the service method to save the hiring company to the database
        model.addAttribute("hiringCompanyDTO", hiringCompanyDTO);
        hiringCompanyService.registerhiringCompany(hiringCompany);
        // Redirect to a success page
        return "joblisting";
    }


    @RequestMapping(value = "/hiringcompany-list", method = {RequestMethod.GET, RequestMethod.POST})
    //@GetMapping("/hiringcompany-list")
    public String hiringCompanyList(Model model) {
        List<HiringCompany> hiringcompany = hiringCompanyService.getAllAllHiringCompanies();
        model.addAttribute("hiringcompany",hiringcompany);
        return "hiringcompany-list";
    }


//retrieve the hiring company by its ID and add it to the model for the view:
    @RequestMapping(value = "/edit-hiring-company/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showEditHiringCompanyForm(@PathVariable(name="id") Long id) {
        HiringCompany hiringcompany = hiringCompanyService.getHiringCompanyById();

        ModelAndView modelAndView = new ModelAndView("hiringcompany-edit");
        modelAndView.addObject("id", id);

        //modelAndView.addObject("hiringcompany", hiringcompany);
        System.out.println(id);
        return modelAndView;
    }



    @RequestMapping(value = "/update-hiringcompany", method = {RequestMethod.GET, RequestMethod.POST})
    // @PostMapping("/update-profession")
    public String updateHiringCompany(@ModelAttribute("hiringcompany") HiringCompany hiringCompany) {

        hiringCompanyService.updateHiringCompany(hiringCompany);
        return "redirect:/hiringcompany-list";
    }






}
