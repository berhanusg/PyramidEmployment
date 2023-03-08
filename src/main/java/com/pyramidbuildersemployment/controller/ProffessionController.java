package  com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.ProffesionDTO;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.service.ProffesionService;
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
public class ProffessionController {
    @Autowired
    private ProffesionService professionService;

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

/*
registerProfession(): This method is used to register a new profession.
It sends a POST request to /profession-save endpoint and takes a ProfessionDTO object as input.
 First, it checks if there are any validation errors. If there are any errors, it returns the "profession-register" template.
 Otherwise, it creates a new Profession object, sets its properties
 using the values from ProfessionDTO object, and saves it to the database
  using the ProfessionService. Finally, it redirects the user to "/profession-list" endpoint.

 */
// With this change, the endpoint will be able to handle both GET and POST requests {RequestMethod.GET, RequestMethod.POST}
   // @RequestMapping(value = "/profession-register", method = {RequestMethod.GET, RequestMethod.POST})
    @PostMapping("/profession-register")
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

    @RequestMapping(value = "/profession-list", method = {RequestMethod.GET, RequestMethod.POST})
  //  @GetMapping("/profession-list")
    public String listProfessions(Model model)
    {
        List<Profession> professionList = professionService.getAllProffessions();

        model.addAttribute("profList", professionList);

        return  "profession-list";
    }

    @RequestMapping(value = "/edit-profession/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView showEditProfessionForm(@PathVariable(name="id") Long id) {
        Profession profession = professionService.getProfessionById(id);

        ModelAndView modelAndView = new ModelAndView("profession-edit");
        modelAndView.addObject("id", id);
        modelAndView.addObject("profession", profession);
        System.out.println(id);
        return modelAndView;
    }



    @RequestMapping(value = "/update-profession", method = {RequestMethod.GET, RequestMethod.POST})
   // @PostMapping("/update-profession")
    public String updateProfession(@ModelAttribute("profession") Profession profession) {
        professionService.registerProfession(profession);
        return "redirect:/profession-list";
    }

    @RequestMapping(value = "/delete-profession/{id}", method = RequestMethod.GET)
    public String deleteProfession(@PathVariable(name="id") Long id) {
        professionService.deleteProffession(id);
        return "redirect:/profession-list";
    }


//    @RequestMapping(value = "/delete-profession", method = RequestMethod.POST)
//    public String deleteProfession(@ModelAttribute("profession") Profession profession) {
//        professionService.deleteProffession(profession.getId());
//        return "redirect:/profession-list";
//    }

    //@RequestMapping(value = "/profession-delete/{id}", method = RequestMethod.POST)
//    @RequestMapping(value = "/delete-profession/{id}", method =  RequestMethod.POST)
//    public String deleteProfession(@PathVariable(name="id") Long id) {
//        professionService.deleteProffession(id);
//        return "redirect:/profession-list";
//    }



}

