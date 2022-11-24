package com.pyramidbuildersemployment.pbbackend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pyramidbuildersemployment.models.Candidate;
import com.pyramidbuildersemployment.models.HiringCompany;
import com.pyramidbuildersemployment.models.Address;
import com.pyramidbuildersemployment.repository.service.AddressServiceRepoImplement;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
 public class PbbackendApplication {///implements CommandLineRunner{


	public static void main(String[] args) {
		
		SpringApplication.run(PbbackendApplication.class, args);

         
	}
//	@EnableWebSecurity
//	public class SecurityConfig {
//
//		@Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//			auth
//					.inMemoryAuthentication()
//					.withUser("user").password("password").roles("USER");
//		}
//	}

}
