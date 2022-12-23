package com.pyramidbuildersemployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"com.pyramidbuildersemployment.*"})
@EnableAutoConfiguration
@SpringBootApplication
 public class PbbackendApplication {      //implements CommandLineRunner{
	public static void main(String[] args) {
		
		SpringApplication.run(PbbackendApplication.class, args);
	}


}
