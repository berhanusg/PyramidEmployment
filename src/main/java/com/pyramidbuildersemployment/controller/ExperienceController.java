package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Experience;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.ExperienceService;
import com.pyramidbuildersemployment.service.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExperienceController {
    @Autowired
    private ExperienceServiceImpl experienceServiceImpl;

    public ExperienceController(ExperienceServiceImpl experienceServiceImpl) {
        this.experienceServiceImpl = experienceServiceImpl;
    }


    @GetMapping("/experience/register")
    public String showJobSeekerRegistrationForm(Model model) {
        model.addAttribute("experience", new Experience());
        return "experience-registration-form";
    }

    @PostMapping("/profession/register")
    public String registerCandidate(@ModelAttribute("experience") Experience experience) {
        // Call the service method to save the candidate and address to the database
        experienceServiceImpl.registerexperience(experience);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping() // change this whatever you want the path to be
    public List<ExperienceService> getAllExperiences() {
        return experienceServiceImpl.getAllAllexperiencs();
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<Experience> getCandidateById(@PathVariable long id) {
        Experience experience = experienceServiceImpl.getExperienceById(id);

        if (experience != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(experience);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{experience}")
    public ResponseEntity<Experience> registerCandidat(@RequestBody Experience experience) {

        experience = experienceServiceImpl.saveAll(experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(experience);

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Experience> updateProfession(@RequestBody Experience experience, @PathVariable long id) {


        if (experience.getExperienceid()==id) {
            experience = experienceServiceImpl.updateExperience(experience);
            if (experience != null) {
                return ResponseEntity.ok(experience);
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
        experienceServiceImpl.deleteExperience(id);

        return new ResponseEntity<String>("Experience deleted successfully!.", HttpStatus.OK);
    }



}
