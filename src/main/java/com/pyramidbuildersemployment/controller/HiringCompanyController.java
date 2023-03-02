//package  com.pyramidbuildersemployment.controller;
//
//import com.pyramidbuildersemployment.models.HiringCompany;
//import com.pyramidbuildersemployment.models.JobListing;
//import com.pyramidbuildersemployment.service.HiringCompanyService;
//import com.pyramidbuildersemployment.service.HiringCompanyServiceImpl;
//import com.pyramidbuildersemployment.service.JobListingService;
//import com.pyramidbuildersemployment.service.JobListingServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Objects;
//
//@Controller
//@CrossOrigin
//public class HiringCompanyController {
//    @Autowired
//   // private HiringCompanyServiceImpl hiringCompanyServiceImpl;
//    private HiringCompanyService hiringCompanyService;
//    public HiringCompanyController(HiringCompanyService hiringCompanyService) {
//        this.hiringCompanyService = hiringCompanyService;
//    }
//
//
//    @GetMapping("/hiring-company/register")
//    public String showJobSeekerRegistrationForm(Model model) {
//        model.addAttribute("hiringcompany", new HiringCompany());
//        return "hiringcompany-registration-form";
//    }
//
//    @PostMapping("/hiring-company/register")
//    public String registerCandidate(@ModelAttribute("hiringcompany") HiringCompany hiringCompany) {
//        // Call the service method to save the candidate and address to the database
//        hiringCompanyService.registerhiringCompany(hiringCompany);
//
//        // Redirect to a success page
//        return "redirect:/success";
//    }
//
//
//    @GetMapping("/hiring-company") // change this whatever you want the path to be
//    public List<HiringCompanyService> getAllAllHiringCompanies() {
//        return hiringCompanyService.getAllAllHiringCompanies();
//    }
//
//
//    @GetMapping(path = "/hiring-company/{id}")
//    public ResponseEntity<HiringCompany> getCandidateById(@PathVariable long id) {
//        HiringCompany hiringCompany = hiringCompanyService.getHiringCompanyById(id);
//
//        if (hiringCompany != null) {
//            // send a 200 status code with the user object as the response body
//            return ResponseEntity.ok(hiringCompany);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//    @PostMapping("/{hiring-company}")
//    public ResponseEntity<HiringCompany> registerCandidat(@RequestBody HiringCompany hiringCompany) {
//
//        hiringCompany = hiringCompanyService.saveAll(hiringCompany);
//        return ResponseEntity.status(HttpStatus.CREATED).body(hiringCompany);
//
//    }
//
//    @PutMapping(path = "hiring-company/{id}")
//    public ResponseEntity<HiringCompany> updateProfession(@RequestBody HiringCompany hiringCompany, @PathVariable long id) {
//
//
//        if (hiringCompany.getHiringcompany_id()== id) {
//            hiringCompany = hiringCompanyService.updateHiringCompany(hiringCompany);
//            if (hiringCompany != null) {
//                return ResponseEntity.ok(hiringCompany);
//            } else {
//                return ResponseEntity.badRequest().build();
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//
//    }
//
//
//
//
//
//    @DeleteMapping(path = "hiringcompany/{id}")
//    public ResponseEntity<String> deleteAddress(@PathVariable long id) {
//
//        // delete address from DB
//        hiringCompanyService.deleteHiringCompany(id);
//
//        return new ResponseEntity<String>(" The Hiring Company  deleted successfully!.", HttpStatus.OK);
//    }
//
//}
