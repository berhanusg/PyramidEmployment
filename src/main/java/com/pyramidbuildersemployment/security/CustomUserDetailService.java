//package com.pyramidbuildersemployment.security;
//
//import com.pyramidbuildersemployment.models.Role;
//import com.pyramidbuildersemployment.models.User;
//import com.pyramidbuildersemployment.repository.UserRepoInterface;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import com.pyramidbuildersemployment.models.Role.RoleName;
//import java.util.stream.Collectors;
//@Service
//public class CustomUserDetailService implements UserDetailsService{
//
//    private UserRepoInterface userRepoInterface;
//
//        public CustomUserDetailService(UserRepoInterface userRepository) {
//            this.userRepoInterface = userRepository;
//        }
//
//
//    @Override
//        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//            User user = userRepoInterface.findByEmail(email);
//            if(user != null){
//                org.springframework.security.core.userdetails.User authenticatedUser =
//                        new org.springframework.security.core.userdetails.User(
//                                user.getEmail(),
//                                user.getPassword(),
//                                user.getRoles().stream()
//                                       // .map((role) -> new SimpleGrantedAuthority(role.getName().name()))
//                                        .map((role) -> new SimpleGrantedAuthority("ROLE_" + role.getName().name()))
//                                        .collect(Collectors.toList())
//                        );
//                return authenticatedUser;
//            } else {
//                throw new UsernameNotFoundException("Invalid username and password");
//            }
//        }
//
//}
//
//
