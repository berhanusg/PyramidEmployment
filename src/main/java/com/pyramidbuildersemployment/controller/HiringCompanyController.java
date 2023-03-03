package  com.pyramidbuildersemployment.controller;
import com.pyramidbuildersemployment.dto.HiringCompanyDTO;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.HiringCompanyService;
import com.pyramidbuildersemployment.service.JobListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String showHiringCompanyRegistrationForm(Model model) {
        List<JobListing> jobListing = jobListingService.getAlljoblistings();
      //  model.addAttribute("joblisting", jobListing);
        model.addAttribute("hiringCompanyDTO", new HiringCompanyDTO());

        return "hiringcompany-register";
    }

    //@PostMapping(value = "/hiringcompany-register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)

    @PostMapping("/hiringcompany-register")
    public String registerCandidate(@ModelAttribute("hiringCompanyDTO") @Valid HiringCompanyDTO hiringCompanyDTO, BindingResult bindingResult, Model model) {
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
//        Long jobListingId = hiringCompanyDTO.getJobListingId();
//        JobListing joblisting= jobListingService.getJobListingById(jobListingId);
//        hiringCompany.setJobListingId(joblisting);
        // Call the service method to save the hiring company to the database
        model.addAttribute("hiringCompanyDTO", hiringCompanyDTO);
        hiringCompanyService.registerhiringCompany(hiringCompany);
        // Redirect to a success page
        return "redirect:/hiringcompany-list";
    }



    @GetMapping("/hiringcompany-list")
    public String hiringCompanyList(Model model) {
        List<HiringCompany> hiringCompanyList = hiringCompanyService.getAllAllHiringCompanies();
        model.addAttribute("hiringcompany",hiringCompanyList);
        return "hiringcompany-list";
    }







}
