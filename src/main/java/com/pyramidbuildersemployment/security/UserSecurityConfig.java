package com.pyramidbuildersemployment.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(2)
public class UserSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().antMatchers("/").permitAll();
        http.antMatcher("/user/user/**").authorizeHttpRequests().anyRequest().hasAuthority("USER")
                .and().formLogin()
                .loginPage("/user/user/login-client")
                .usernameParameter("email")
                .loginProcessingUrl("/user/login-client")
                .defaultSuccessUrl("/user/home").permitAll();

        return http.build();

    }


}
