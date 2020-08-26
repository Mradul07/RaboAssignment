package com.employee.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.api.dao.EmployeeDao;
import com.employee.api.dao.EmployeeEntity;

/*
 * Description:
 * This class is a Service class for the Spring application. It contains the implementation of methods called in Controller.
 * This class interacts directly with the database using DAO as a middle ware. 
 */

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public String login(String name) {
		return "Successful Operation. " + name + " logged in successfully";
	}

	public String logout() {
		return "Logout successful";
	}

	// GET (Retrieve) specific employee using employeeName
	public List<EmployeeEntity> getEmployee(String employeeName) {
		return employeeDao.findByemployeeName(employeeName);
	}

	// POST (Add) a new employee
	public String addEmployee(EmployeeEntity employee) {
		employeeDao.save(employee);
		return "Successful Operation. Employee with name: " + employee.getEmployeeName() + " added successfully";
	}

	// PUT (Update) all the existing employees with matching id(PK) in the request
	// body
	public String updateEmployee(EmployeeEntity employee, String employeeName) {
		employeeDao.save(employee);
		return "Successful Operation. Employee : " + employeeName + " with employeeID : " + employee.getId()
				+ " updated successfully";
	}

	// DELETE (Remove) all the existing employees with matching employeeName
	public String deleteEmployee(String employeeName) {
		employeeDao.deleteAll(employeeDao.findByemployeeName(employeeName));
		return "Successful Operation. Employee : " + employeeName + " deleted successfully";
	}

	// GET (Retrieve) all the existing employees in the database
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity> employees = new ArrayList<>();
		employeeDao.findAll().forEach(employees::add);
		return employees;
	}

	// POST (Add) a list of new employees
	public String addEmployeeList(List<EmployeeEntity> employee) {
		employeeDao.saveAll(employee);
		return "Added all the employees in the input list";
	}
}
