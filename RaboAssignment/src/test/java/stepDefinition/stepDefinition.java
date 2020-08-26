package stepDefinition;

import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import resources.AddEmployeeData;
/*
 * Description :
 * This class contains the methods to perform the actions mentioned in the feature file.
 * The actions under the Given, When, & Then keywords, in the all the Scenarios have their implementation defined in this class
 * 
 * Note: All the API calls from this class are directed to a Wiremock server instance at the moment
 * The mock server runs on port 8080 as defined in the @BeforeClass method in the TestRunner class
 * 
 * The requests are served by the mocked stubs (request/response). The mappings/files can be found in the src/test/resources folder 
 */

@RunWith(Cucumber.class)
public class stepDefinition extends resources.Utilities {
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	AddEmployeeData data = new AddEmployeeData();

	// Verify User login
	@Given("user tries to login with {string} {string}")
	public void user_tries_to_login(String userName, String password) throws IOException {
		res = given().spec(requestSpecification()).param("name", userName).and().param("pwd", password);
	}

	@When("user hits the {string} url with method GET")
	public void user_hits_the_url_with_method_GET(String action) {
		response = res.when().get("/" + action);
	}

	// Verify User logout
	@Given("user tries to logout")
	public void user_tries_to_logout() throws IOException {
		res = given().spec(requestSpecification());
	}

	// Verify adding new employee
	@Given("user tries to add an employee {int} {string} {string} {string} {string} {string} {string} {int}")
	public void user_tries_to_add_an_employee(int id, String employeeName, String firstName, String lastName,
			String email, String password, String phone, int employeeStatus) throws Throwable {
		res = given().spec(requestSpecification()).body(
				data.getPostPutData(id, employeeName, firstName, lastName, email, password, phone, employeeStatus));
	}

	// Verify updating an employee
	@Given("user tries to update an employee {int} {string} {string} {string} {string} {string} {string} {int}")
	public void user_tries_to_update_an_employee(int id, String employeeName, String firstName, String lastName,
			String email, String password, String phone, int employeeStatus) throws Throwable {
		res = given().spec(requestSpecification()).body(
				data.getPostPutData(id, employeeName, firstName, lastName, email, password, phone, employeeStatus));
	}

	// Verify deleting an employee
	@Given("user tries to delete an employee")
	public void user_tries_to_delete_an_employee() throws Throwable {
		res = given().spec(requestSpecification());
	}

	// Verify retrieve specific employee
	@Given("user tries to retrieve an employee")
	public void user_tries_to_retrieve_an_employee() throws Throwable {
		res = given().spec(requestSpecification());
	}

	// @Then common for all - check status code as 200
	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(Integer int1) {
		res.then().log().all().statusCode(int1);
		// assertEquals(response.getStatusCode(), 200);
	}

	// @When common for all based on method type
	@When("user hits the base url with method {string} and {string}")
	public void user_hits_the_base_url_with_method(String method, String employeeName) throws Throwable {
		if (method.equalsIgnoreCase("PUT"))
			response = res.when().put("/" + employeeName);
		else if (method.equalsIgnoreCase("GET"))
			response = res.when().get("/" + employeeName);
		else if (method.equalsIgnoreCase("DELETE"))
			response = res.when().delete("/" + employeeName);
		else if (method.equalsIgnoreCase("POST"))
			response = res.when().post();

	}

}
