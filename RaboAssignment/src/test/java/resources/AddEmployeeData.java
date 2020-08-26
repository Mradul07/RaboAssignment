package resources;

import pojo.EmployeePojo;

/*
 * Description :
 * This class is the plain old java object class which defines the employee data in the form of a java object
 */

public class AddEmployeeData {

	public EmployeePojo getPostPutData(int id, String employeeName, String firstName, String lastName, String email,
			String password, String phone, int employeeStatus) {
		EmployeePojo emp = new EmployeePojo();
		emp.setId(id);
		emp.setEmployeeName(employeeName);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setPhone(phone);
		emp.setEmployeeStatus(employeeStatus);
		return emp;
	}
}
