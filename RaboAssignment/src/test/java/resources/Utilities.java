package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/*
 * Description :
 * This class contains the Utility methods to be used in the stepDefinitions of the Scenario implementation
 * 1. Re-usable method  requestSpecification(), is used to create the request for all the scenarios
 * 2. Logs are written in a .txt file named "logging.txt". The file is created automatically after the 1st run of the test cases. Can be found
 *    in the project folder directly
 * 3. Global properties - the global property file is read in this class to get the baseURL to which the requests should be sent. Also refer the
 *    "global.properties" file in the "resources" package to see more details.
 *    
 *    Note: Update the path of the "global.properties" file in the method getGlobalValue()
 */

public class Utilities {

	public RequestSpecification req;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
			req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
			return req;
		}
		return req;
	}

	public static String getGlobalValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\mradul.shrivastava\\sts-workspace\\RaboAssignment\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}

}
