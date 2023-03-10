package com.pyramidbuildersemployment.security;


import com.pyramidbuildersemployment.models.User;
import com.pyramidbuildersemployment.repository.UserRepoInterface;
import com.pyramidbuildersemployment.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepoInterface userRepoInterface;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepoInterface.findByEmail(username);

        if(user==null){
            throw new UsernameNotFoundException("could not found user!!!!");
        }
        CustomUserDetails customUserDetails=new CustomUserDetails(user);
        return customUserDetails;
    }
}
