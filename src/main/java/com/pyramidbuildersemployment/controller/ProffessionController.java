package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.ProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class ProffessionController {
    @Autowired
 //   private ProfessionServiceImpl professionServiceImpl;
    private ProffesionService professionService;

    public ProffessionController(ProffesionService professionService) {
        this.professionService = professionService;
    }


    @GetMapping("/profession")
    public List<ProffesionService> getAllProfessions() {
        return professionService.getAllProffessions();
    }

    @GetMapping("/profession/{id}")
    public ResponseEntity<Profession> getProfessionById(@PathVariable long id) {
        Profession profession = professionService.getProfessionById(id);

        if (profession != null) {
            return ResponseEntity.ok(profession);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/profession")
    public ResponseEntity<Profession> registerProfession(@RequestBody Profession profession) {
        professionService.registerProfession(profession);
        return ResponseEntity.status(HttpStatus.CREATED).body(profession);
    }

    @PutMapping("/profession/{id}")
    public ResponseEntity<ProffesionService> updateProfession(@RequestBody Profession profession, @PathVariable long id) {
        if (professionService.getProfessionById(id).equals(id)) {
            profession = professionService.updateProfession(profession );
            if (profession != null) {
                return ResponseEntity.ok(professionService);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @DeleteMapping("/profession/{id}")
    public ResponseEntity<String> deleteProfession(@PathVariable long id) {
        professionService.deleteProffession(id);
        return new ResponseEntity<String>("Profession deleted successfully!.", HttpStatus.OK);
    }


}
