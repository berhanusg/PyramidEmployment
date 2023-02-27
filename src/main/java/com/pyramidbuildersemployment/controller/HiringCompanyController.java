package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.JobListing;
import com.pyramidbuildersemployment.service.HiringCompanyService;
import com.pyramidbuildersemployment.service.HiringCompanyServiceImpl;
import com.pyramidbuildersemployment.service.JobListingService;
import com.pyramidbuildersemployment.service.JobListingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class HiringCompanyController {
    @Autowired
    private HiringCompanyServiceImpl hiringCompanyServiceImpl;

    public HiringCompanyController(HiringCompanyServiceImpl hiringCompanyServiceImpl) {
        this.hiringCompanyServiceImpl = hiringCompanyServiceImpl;
    }


    @GetMapping("/hiringcompany/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("hiringcompany", new HiringCompany());
        return "hiringcompany-registration-form";
    }

    @PostMapping("/hiringcompany/register")
    public String registerCandidate(@ModelAttribute("hiringcompany") HiringCompany hiringCompany) {
        // Call the service method to save the candidate and address to the database
        hiringCompanyServiceImpl.registerhiringCompany(hiringCompany);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping() // change this whatever you want the path to be
    public List<HiringCompanyService> getAllAllHiringCompanies() {
        return hiringCompanyServiceImpl.getAllAllHiringCompanies();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<HiringCompany> getCandidateById(@PathVariable long id) {
        HiringCompany hiringCompany = hiringCompanyServiceImpl.getHiringCompanyById(id);

        if (hiringCompany != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(hiringCompany);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{joblisting}")
    public ResponseEntity<HiringCompany> registerCandidat(@RequestBody HiringCompany hiringCompany) {

        hiringCompany = hiringCompanyServiceImpl.saveAll(hiringCompany);
        return ResponseEntity.status(HttpStatus.CREATED).body(hiringCompany);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<HiringCompany> updateProfession(@RequestBody HiringCompany hiringCompany, @PathVariable long id) {


        if (hiringCompany.getHiringcompany_id()== id) {
            hiringCompany = hiringCompanyServiceImpl.updateHiringCompany(hiringCompany);
            if (hiringCompany != null) {
                return ResponseEntity.ok(hiringCompany);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }





    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {

        // delete address from DB
        hiringCompanyServiceImpl.deleteHiringCompany(id);

        return new ResponseEntity<String>(" The Job Listed  deleted successfully!.", HttpStatus.OK);
    }

}
