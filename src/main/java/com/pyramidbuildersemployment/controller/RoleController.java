package com.pyramidbuildersemployment.controller;

import com.pyramidbuildersemployment.dto.RoleDTO;
import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/role-list")
    public String showRoleList(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "role/role-list";
    }

    @GetMapping("/role-create")
    public String showRoleCreate(Model model) {
        RoleDTO roleDto = new RoleDTO();
        model.addAttribute("roleDto", roleDto);
        return "/role-create";
    }

    @PostMapping("/role-create")
    public String createRole(@ModelAttribute("roles") Role role) {
        roleService.createRole(role);
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
