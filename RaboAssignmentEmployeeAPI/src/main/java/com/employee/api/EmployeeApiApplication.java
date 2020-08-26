package com.employee.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Description:
 * This is the base class to run the Spring Application
 * Check the url http://localhost:8080 
 * (by default this application runs on port 8080, mentioned in the application.properties)
 * 
 * The request mappings can be found in the TestSpringController class
 */

@SpringBootApplication
public class EmployeeApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeApiApplication.class, args);
	}
}
