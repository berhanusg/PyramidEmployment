package com.pyramidbuildersemployment.service;

import com.pyramidbuildersemployment.PbbackendApplication;
import com.pyramidbuildersemployment.models.RoleName;
import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.UserRepoInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = PbbackendApplication.class)
class UserServiceImplTest {


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepoInterface userRepository;

    @Test
    public void save() {
        User user = new User();
        user.setEmail("suresh@gmail.com");
        user.setFirstName("suresh");
        user.setLastName("moole");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setRoleId(RoleName.valueOf("ADMIN").toString());

        userRepository.save(user);

    }

}
