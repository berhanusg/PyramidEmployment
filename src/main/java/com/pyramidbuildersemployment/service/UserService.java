package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.models.Profession;
import com.pyramidbuildersemployment.models.User;

public interface UserService {


    User getUserById(Long id);
    User  getUserByUsername(String username);
    User  createUser(User user);
    User  updateUser(User user);
    void  deleteUser(Long id);
    }


