package com.pyramidbuildersemployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PbbackendApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PbbackendApplication.class, args);

		//System.setProperty("server.port", "8082");
        // or, use
        // System.getProperties().put("server.port", 8081);
 
         
	}

}
