package com.pyramidbuildersemployment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PbbackendApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PbbackendApplication.class, args);

		//System.setProperty("server.port", "8082");
        // or, use
        // System.getProperties().put("server.port", 8081);

//		@Configuration
//		class MvcConfig implements WebMvcConfigurer {
//
//
//			public void addViewControllers(ViewControllerRegistry registry) {
//				registry.addViewController("/").setViewName("resources/templates/jobsite");
//			}
//		}
	}

}
