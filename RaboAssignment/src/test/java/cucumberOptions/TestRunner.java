package cucumberOptions;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.Options;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/*
 * Description :
 * This class is the base class which will be triggered to run all the Scenarios in the feature file
 * The class contains the mapping with the feature file under @CucumberOptions annotation and glue with the 
 * implementation of the keywords in Scenario in stepDefinition class. It used the pretty plugin to generate the Cucumber test report
 * The test report can be found in the "target" folder under the project folder directly
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/MockEmployeeAPI.feature", glue = "stepDefinition", plugin = { "pretty","html:target/cucumber-reports" })

/*
 * If you want to run the CUCUMBER framework against the real API, enable the
 * below step and comment the above
 * 
 * @CucumberOptions(features
 * ="src/test/java/features/ValidateEmployeeAPI.feature", glue =
 * "stepDefinition", plugin = {"pretty", "html:target/cucumber-reports" })
 *
 * The ValidateEmployeeAPI.feature contains the test data for real API and no
 * stubbings. Ensure that the API is running on some port number which should be
 * updated in the "global.properties" file in the "resources" package
 * 
 * Delete or Comment the @BeforeClass and @AfterClass methods while running with
 * real API
 */

public class TestRunner {

	private static WireMockServer wiremockServer = new WireMockServer(
			(Options) WireMockConfiguration.options().port(8080));

	@BeforeClass
	public static void testStart() {
		System.out.println("Start of the test cases");
		wiremockServer.start();
	}

	@AfterClass
	public static void testEnds() {
		System.out.println("End of the test cases");
		wiremockServer.shutdown();
	}
}
