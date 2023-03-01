package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.ProffesionDTO;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.CandidateService;
import com.pyramidbuildersemployment.service.ProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@CrossOrigin
public class ProffessionController {
    @Autowired
 //   private ProfessionServiceImpl professionServiceImpl;
    private ProffesionService professionService;
    private CandidateService candidateService;
    public ProffessionController(ProffesionService professionService) {
        this.professionService = professionService;
    }


   @GetMapping("/profession")
  // @RequestMapping(value = "/profession", method = {RequestMethod.GET})
    public List<ProffesionService> getAllProfessions() {
        return professionService.getAllProffessions();
    }




    @PostMapping("/profession-save")

    public String registerProfession(@ModelAttribute("professionDTO") @Valid ProffesionDTO professionDTO, BindingResult bindingResult,Model model) {
        if (bindingResult.hasErrors()) {
            return "profession-register";
        }

        // create new profession entity
        Profession profession = new Profession();
        profession.setId(professionDTO.getId());
        profession.setProfessionName(professionDTO.getProfessionName());
        profession.setIndustry(professionDTO.getIndustry());
        model.addAttribute("professionDTO", new ProffesionDTO());
        // save profession entity to database
        model.addAttribute("professionDTO", professionDTO);

        professionService.registerProfession(profession);

        return "redirect:/profession-list";
    }

    @GetMapping("/profession-register")
    public String registerProfession(Model model) {
        model.addAttribute("professionDTO", new ProffesionDTO());
        return "profession-register";
    }

        // @PostMapping("/profession")
        @RequestMapping(value = "/profession", method = {RequestMethod.POST})
        public ResponseEntity<Profession> registerProfession (@RequestBody Profession profession){
            professionService.registerProfession(profession);
            return ResponseEntity.status(HttpStatus.CREATED).body(profession);
        }


        //  @RequestMapping(value = "/profession/{id}", method = {RequestMethod.GET, RequestMethod.POST})
        @PutMapping("/profession/{id}")
        public ResponseEntity<ProffesionService> updateProfession (@RequestBody Profession profession,
        @PathVariable long id){
            if (professionService.getProfessionById(id).equals(id)) {
                profession = professionService.updateProfession(profession);
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
        public ResponseEntity<String> deleteProfession ( @PathVariable long id){
            professionService.deleteProffession(id);
            return new ResponseEntity<String>("Profession deleted successfully!.", HttpStatus.OK);
        }


    }
