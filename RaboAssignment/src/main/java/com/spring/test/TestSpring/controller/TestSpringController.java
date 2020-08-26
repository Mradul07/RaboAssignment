package com.spring.test.TestSpring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Description:
 * This class contains the URL mappings of the Spring application 
 */

@RestController
public class TestSpringController {

	@RequestMapping("/employeeApp")
	public String startApp() {
		return "Hello, all API tests were successful";
	}
}
