package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Experience;

import com.pyramidbuildersemployment.service.ExperienceService;

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
   // private ExperienceServiceImpl experienceServiceImpl;
    private ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }


    @GetMapping("/experience/register")
    public String showExperienceRegistrationForm(Model model) {
        model.addAttribute("experience", new Experience());
        return "experience-registration-form";
    }

    @PostMapping("/profession/register")
    public String registerExperience(@ModelAttribute("experience") Experience experience) {
        // Call the service method to save the candidate and address to the database
        experienceService.registerexperience(experience);

        // Redirect to a success page
        return "redirect:/success";
    }


    @GetMapping("/experiences") // change this whatever you want the path to be
    public List<ExperienceService> getAllExperiences() {
        return experienceService.getAllAllexperiencs();
    }


    @GetMapping(path = " /experience/{id}" )
    public ResponseEntity<Experience> geExperienceeById(@PathVariable long id) {
        Experience experience = experienceService.getExperienceById(id);

        if (experience != null) {
            // send a 200 status code with the user object as the response body
            return ResponseEntity.ok(experience);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/{experience}")
    public ResponseEntity<Experience> registerCandidat(@RequestBody Experience experience) {

        experience = experienceService.saveAll(experience);
        return ResponseEntity.status(HttpStatus.CREATED).body(experience);

    }

    @PutMapping(path = "/experience/{id}")
    public ResponseEntity<Experience> updateProfession(@RequestBody Experience experience, @PathVariable long id) {


        if (experience.getExperienceid()==id) {
            experience = experienceService.updateExperience(experience);
            if (experience != null) {
                return ResponseEntity.ok(experience);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
    @DeleteMapping(path = "/experience/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {

        // delete address from DB
        experienceService.deleteExperience(id);

        return new ResponseEntity<String>("Experience deleted successfully!.", HttpStatus.OK);
    }



}
