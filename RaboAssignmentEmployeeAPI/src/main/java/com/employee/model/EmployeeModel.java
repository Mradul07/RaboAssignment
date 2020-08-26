package com.employee.model;

/*
 * Description:
 * This class model class to return the customized JSON response 
 */

public class EmployeeModel {

	private String description;

	public EmployeeModel() {
	}

	public EmployeeModel(String description) {
		super();
		this.description = description;
	}

	public void setDescription(String addEmployee) {
		this.description = addEmployee;
	}

	public String getDescription() {
		return description;
	}

}
