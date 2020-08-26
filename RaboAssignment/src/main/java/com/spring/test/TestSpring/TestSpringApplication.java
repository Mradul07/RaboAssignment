package com.spring.test.TestSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Description:
 * This is the base class to run the Spring Application
 * Check the url http://localhost:8000 
 * (by default this application runs on port 8000, mentioned in the application.properties)
 * 
 * The request mappings can be found in the TestSpringController class
 */

@SpringBootApplication
public class TestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}
}
