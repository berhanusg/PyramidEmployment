package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.RoleDTO;
import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.service.RoleService;
import com.pyramidbuildersemployment.service.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/admin")
public class AdminRoleController {




    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @GetMapping("/role-list")
    public String showRoleList(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roleDTO", roles);
        return "role-list";
    }


    @GetMapping("/role-create")
    public String showRoleCreate(Model model) {
        RoleDTO roleDto = new RoleDTO();
        model.addAttribute("roleDto", roleDto);
        return "role-create";
    }




    //    public String registerRole(@ModelAttribute("roleDTO") @Valid RoleDTO roleDTO, BindingResult bindingResult,Model model) {
    @PostMapping("/role-create")
    public String createRole(@ModelAttribute("roleDTO") @Valid RoleDTO roleDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "role-create";
        }
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(Role.RoleName.valueOf(roleDTO.getRoleName()));
        System.out.println(roleDTO.getRoleName());
        model.addAttribute("roleDTO", roleDTO);
        roleService.createRole(role); // save role in the database

        return "redirect:/role-list";
    }


    @GetMapping("/role-edit/{id}")
    public String showRoleEdit(@PathVariable("id") Long id, Model model) {


        Role role = roleService.getRoleById(id);
        model.addAttribute("role", role);
        return "role/role-edit";
    }




    @PostMapping("/role-edit")
    public String editRole(@ModelAttribute("roleDto") Role role) {
        roleService.updateRole(role);
        return "redirect:/role-list";
    }

    @GetMapping("/role-delete/{id}")
    public String deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return "redirect:/role-list";
    }
}
