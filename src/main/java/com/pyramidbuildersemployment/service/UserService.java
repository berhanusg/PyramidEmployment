package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.dto.UserDTO;
import com.pyramidbuildersemployment.models.User;

import java.util.List;

public interface UserService {


    User getUserById(Long id);
    User  getUserByUsername(String username);
    User  createUser(User user);
    User  updateUser(User user);
    void  deleteUser(Long id);
    void saveUser(UserDTO registrationDto);

    User findByEmail(String email);
    List<UserDTO> getAllUsers();

    void save(User user);
}


