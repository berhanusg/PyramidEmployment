package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.ProfessionServiceImpl;
import com.pyramidbuildersemployment.service.ProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class ProffessionController {
    @Autowired
    private ProfessionServiceImpl professionServiceImpl;

    public ProffessionController(ProfessionServiceImpl professionServiceImpl) {
        this.professionServiceImpl = professionServiceImpl;
    }


    @GetMapping("/profession/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("profession", new Profession());
        return "profession-registration-form";
    }

    @PostMapping("/profession/register")
    public String registerCandidate(@ModelAttribute("profession") Profession profession) {
        // Call the service method to save the candidate and address to the database
        professionServiceImpl.registerProfession(profession);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping() // change this whatever you want the path to be
    public List<ProffesionService> getAllProffesions() {
        return professionServiceImpl.getAllProffessions();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Profession> getCandidateById(@PathVariable long id) {
        Profession profession = professionServiceImpl.getProfessionById(id);

        if (profession != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(profession);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{profession}")
    public ResponseEntity<Profession> registerCandidat(@RequestBody Profession profession) {

        profession = professionServiceImpl.saveAll(profession);
        return ResponseEntity.status(HttpStatus.CREATED).body(profession);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Profession> updateProfession(@RequestBody Profession profession, @PathVariable long id) {


        if (profession.getExperienceid().equals(id)) {
            profession = professionServiceImpl.updateProfession(profession);
            if (profession != null) {
                return ResponseEntity.ok(profession);
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
        professionServiceImpl.deleteProffession(id);

        return new ResponseEntity<String>("Profession deleted successfully!.", HttpStatus.OK);
    }


}
