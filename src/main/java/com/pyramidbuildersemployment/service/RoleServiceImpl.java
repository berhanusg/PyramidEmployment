package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.repository.RoleRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepoInterface roleRepoInterface;


    @Override
    public Role getRoleById(Long id) {
        return null;
    }

    @Override

    //   we first convert the String value of the roleName parameter
    //   to the corresponding RoleName enum value using the valueOf method.
    //   Then we retrieve the name of the enum value using the name()
    // method and pass it to the findByName method of the RoleRepository to retrieve the corresponding Role object
    public Role getRoleByName(String roleName) {
        Role.RoleName roleNameEnum = Role.RoleName.valueOf(roleName);
        return roleRepoInterface.findByName(Role.RoleName.valueOf(roleNameEnum.name()));
    }


    @Override
    public List<Role> getAllRoles() {
        return (List<Role>) roleRepoInterface.findAll();

    }

    @Override
    public Role createRole(Role role) {
        return roleRepoInterface.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return roleRepoInterface.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepoInterface.deleteById(id);
    }

   // @Override
   // public void saveRole(String roleName) {



//    @Override
//    public void saveRole(String roleName){
//        Role role = new Role();
//       // role.setName(Role.RoleName.valueOf(roleName));
//        role.setName(roleName);
//        roleRepoInterface.save(role);
//    }


//    public void saveRole(Role.RoleName roleName) {
//        Role role = new Role();
//        role.setName(roleName);
//        roleRepoInterface.save(role);
//    }

    public void saveRole(String roleName) {
        Role role = new Role();
        role.setName(roleName);
        roleRepoInterface.save(role);
    }


    // other methods
//
//        @Override
//        public void saveRole(String roleName) {
//            Role role = new Role();
//            role.setName(Role.RoleName.valueOf(roleName));
//            roleRepoInterface.save(role);
//        }

    }

