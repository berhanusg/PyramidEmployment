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
    private ProffesionService professionService;
    private CandidateService candidateService;
    public ProffessionController(ProffesionService professionService) {
        this.professionService = professionService;
    }


    /**
     * This method shows in browser
     * empty form
     *
     * @param model
     * @return
     */
    @GetMapping("/profession-register")
    public String registerProfession(Model model) {
        model.addAttribute("professionDTO", new ProffesionDTO());
        return "profession-register";
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
        model.addAttribute("professionDTO", professionDTO);

        professionService.registerProfession(profession);

        return "redirect:/profession-list";
    }



        // @PostMapping("/profession")

    @GetMapping("/profession-list")
    public String listProfessions(Model model)
    {
        List<Profession> professionList = professionService.getAllProffessions();

        model.addAttribute("profList", professionList);

        return  "profession-list";
    }


    }
