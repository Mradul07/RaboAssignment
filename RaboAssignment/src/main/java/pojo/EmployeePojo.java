package pojo;

public class EmployeePojo {


	private int id;
	private String employeeName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String phone;
	private int employeeStatus;

	public EmployeePojo() {
	}

	public EmployeePojo(int id, String employeeName, String firstName, String lastName, String email, String password,
			String phone, int employeeStatus) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.employeeStatus = employeeStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(int employeeStatus) {
		this.employeeStatus = employeeStatus;
	}
}
