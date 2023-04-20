package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.dto.RoleDTO;
import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.Role;
import com.pyramidbuildersemployment.models.RoleName;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.RoleRepoInterface;
import com.pyramidbuildersemployment.repository.UserRepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepoInterface userRepoInterface;

    @Autowired
    private RoleRepoInterface roleRepointerface;

    @Autowired
    public UserServiceImpl(UserRepoInterface userRepoInterface, RoleRepoInterface roleRepointerface) {
        this.userRepoInterface = userRepoInterface;
        //injected this repository in your service and use the findByName method to get a role by its name.
        this.roleRepointerface = roleRepointerface;
    }


    // The Enum provides a way to define a set of named constant values that can be used in the code.
    // Used the Enum to set the role name in the Role object and then set the Role object in the User object.
    public void createUser(UserDTO userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

       /* Role.RoleName roleName = Role.RoleName.valueOf(String.valueOf(userDto.getRolename()));
        Role role = roleRepointerface.findByName(roleName);
        user.setRoleId(String.valueOf(role));*/
        user.setRoleId(RoleName.valueOf("USER").toString());

        userRepoInterface.save(user);

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepoInterface.findByEmail(username);
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void saveUser(UserDTO registrationDto) {

    }

    @Override
    public User findByEmail(String email) {
        return userRepoInterface.findByEmail(email);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return StreamSupport.stream(userRepoInterface.findAll().spliterator(), false)
                .map(user -> {
                    Role role = roleRepointerface.findById(Long.valueOf(user.getRoleId())).orElseThrow(() -> new RuntimeException("Role not found"));
                    RoleDTO roleDTO = new RoleDTO(role.getId(), role.getName());
                    return new UserDTO(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), roleDTO.toString());
                })
                .collect(Collectors.toList());
    }
    @Override
    public void save(User user) {

    }

}



