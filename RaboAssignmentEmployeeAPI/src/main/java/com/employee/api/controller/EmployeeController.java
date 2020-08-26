package com.employee.api.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.employee.api.dao.EmployeeEntity;
import com.employee.api.service.EmployeeService;
import com.employee.model.EmployeeModel;

/*
 * Description:
 * This class contains the URL mappings of the Spring application 
 */

@RestController
@Validated
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/login")
	public String login(@RequestParam String name, String pwd) {
		return employeeService.login(name);
	}

	@RequestMapping("/logout")
	public String login() {
		return employeeService.logout();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public List<EmployeeEntity> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<EmployeeModel> addEmployee(@Valid @RequestBody EmployeeEntity employee) {
		EmployeeModel employeeModel = new EmployeeModel(employeeService.addEmployee(employee));
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{employeeName}")
	public ResponseEntity<List<EmployeeEntity>> getEmployee(
			@PathVariable(value = "employeeName", required = false) @NotBlank @NotEmpty String employeeName) {
		return new ResponseEntity<List<EmployeeEntity>>(employeeService.getEmployee(employeeName), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{employeeName}")
	public ResponseEntity<EmployeeModel> updateEmployee(@Valid @RequestBody EmployeeEntity employee,
			@PathVariable String employeeName) {
		EmployeeModel employeeModel = new EmployeeModel(employeeService.updateEmployee(employee, employeeName));
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{employeeName}")
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable String employeeName) {
		EmployeeModel employeeModel = new EmployeeModel(employeeService.deleteEmployee(employeeName));
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createWithList")
	public ResponseEntity<EmployeeModel> addEmployeeArray(@Valid @RequestBody List<EmployeeEntity> employee) {
		EmployeeModel employeeModel = new EmployeeModel(employeeService.addEmployeeList(employee));
		return new ResponseEntity<EmployeeModel>(employeeModel, HttpStatus.OK);
	}

}
