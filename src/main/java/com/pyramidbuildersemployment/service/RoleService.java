package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);
    Role getRoleByName(String rolename);
    List<Role> getAllRoles();
    Role createRole(Role role);
    Role updateRole(Role role);
    void deleteRole(Long id);
}
