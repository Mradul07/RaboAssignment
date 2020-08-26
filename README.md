# RaboAssignment

## Table of Contents
- Items in repository
- Description of each project
- Pre-requisites to run each project
- Execution
- Verification
- Contact

## Projects in repository 
  1. **RaboAssignment** - this project contains 2 items
     - Dummy application that displays "Hello, all API tests were successful" on localhost:8080/employeeApp
     - Test cases for EmployeesAPI those run on dynamic Wiremock server and static stubs
  2. **RaboAssignmentEmployeeAPI** - this project is the working version of Employee API based on the yaml file provided. This app supports the inbuilt Apache derby database. 
  3. **Employee API Manual test cases.postman_collection** This is a postman collection for manual test cases to be run for **EmployeeAPI** in project **RaboAssignmentEmployeeAPI**
  
## Description of each project
1. **RaboAssignment**
   - This is a Maven project, hence all the dependencies and pluggins supporting the Spring, Cucumber, Rest Assured, Wiremock are present in the POM.xml
   - The project structure contains 
      - the directory "src/main/java", where the classes to run the API are located
      - the directory "src/main/test", where the test cases based on Cucumber framework are located to test the external Employee API hosted on mocked Wiremock server and stubs
        . Mocked stubs can be found under folder RaboAssignment/src/test/resources/mappings & RaboAssignment/src/test/resources/__files
2. **RaboAssignmentEmployeeAPI**
   - This is a Maven project, hence all the dependencies and pluggins supporting the Spring web, JPA, Apache Derby are present in the POM.xml. The project hosts the API on an internal Apacher tomcat server and internal Apache derby database. It has a single entity called Employee, on which actions can be performed using a Rest API and its methods (CRUD). Details of methods and URLs can be found in the yaml file.

## Pre-requisites to run each project
  - Windows or Mac pc
  - Java8 or higher pre-installed
  - Maven pre-installed (so that all the dependencies can be autoinstalled at the time of execution)
  - (Optional) If you wish to run the project in an IDE then there are various options like SpringToolSuite, Eclipse, Intellij, etc. The projects are build using STS.
  - (Optional) Cucumber pluggin if using IDE, to see the feature files
## Execution
  - Download or Clone the project from Git repository
  - Steps to run from cmd line
    - Navigate to the project directory (make sure you obly navigate until parent project directory where pom.xml is present)
      - Command to run the cucumber test cases   -> **mvn test**
      - Command to run the SpringAPP -> **mvn spring-boot:run**
      - Note : The **mvn test** is only relevant to the **RaboAssignment** project as this contains the Cucumber test cases. The **RaboAssignmentEmployeeAPI** project have test cases written in a separate feature file in the project **RaboAssignment**. To run those automated test cases, first the EmployeeAPI has to be started by running the **RaboAssignmentEmployeeAPI** project using **mvn spring-boot:run** and then run test cases in **RaboAssignment** project using **mvn test**. Make sure the feature file is changed the test runner class of **RaboAssignment**
  - Steps to run from IDE line
    - Download or clone the project in IDE
    - For **RaboAssignment** run the class *TestSpringApplication.java* (path - \src\main\java\com\spring\test\TestSpring\) right click the class > Run as > SpringBoot application or Java application. This will start the server, go to http//:localhost:8080/employeeApp on browser. To run the automated test cases, run the class *TestRunner.java* (path src\test\java\cucumberOptions) right click the class > Run as > Junit test cases. (change the Run configuration to Junit4 if you get an error for Junit5). This will run all the Cucumber test cases via Junit and result can be seen in the IDE itself.
    - For **RaboAssignmentEmployeeAPI** run the class *EmployeeApiApplication.java* (path - src\main\java\com\employee\api) right click the class > Run as > SpringBoot application or Java application. Trigger the API from POSTMAN for manual check, refer verification steps.
          
    
## Verification
  - For **RaboAssignment project**, the test cases are present in the *MockEmployeeAPI.feature* file under */src/test/java/features/* path. The file contains the parent feature and scenarios to test the feature. The scenarios are based on the method calls to the API and the possible return codes. Please refer yaml file. The data in the scenarios is mocked data for which pre-defined stubs are prepared and places under the directory *"/src/test/resources/"*. 
  The verification can be done by looking into the log files, console/terminal output, & Cucumber test reports. The location of the log file and report are below:
  1. log file - RaboAssignment/logging.txt. the log file shows all the request/response created per scenario/test case
  2. Cucumber report - RaboAssignment/target/cucumber-reports (This is an HTML report, if by chance it doesn't open in the broswer change the extension to .html to see the report).The report shows the status of all the scenarios/test cases in the feature file in the BDDish language
  
  - For **RaboAssignmentEmployeeAPI**, run the test cases from Postman manually. A sample postman collection can be found in the repository. If you want to run the automated test cases for the API, please refer the comments in the TestRunner file for RaboAssignment project located at *\src\test\java\cucumberOptions\TestRunner.java*. Then verification remains the same as above.
  

## Contact
If you have any questions related to the project feel free to reach out to me on mradul.s15@gamil.com. I'll do my best to revert asap.
Good luck reviewing :)
