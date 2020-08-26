Feature: Validate Employee API

Scenario Outline: Verify User Login
	Given user tries to login with "<user_id>" "<password>"
	When user hits the "login" url with method GET
	Then the API call got success with status code 200

Examples:
	|user_id |password|
	|Tester123|test123|
	
Scenario Outline: Verify invalid User Login
	Given user tries to login with "<user_id>" "<password>"
	When user hits the "login" url with method GET
	Then the API call got success with status code 400

Examples:
	|user_id |password|
	|abcdefgh|abcer123|	
	
Scenario: Verify User logout
	Given user tries to logout
	When user hits the "logout" url with method GET
	Then the API call got success with status code 200

Scenario Outline: Verify adding new employee 
	Given user tries to add an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "POST" and "no_employee"
	Then the API call got success with status code 200
	
Examples:
	|id|employeeName		|firstName	 	|lastName	|email					|password  |phone	 |employeeStatus|
	|1 |Mahendra Singh Dhoni|Mahendra Singh	|Dhoni		|ms.dhoni@gmail.com		|msdhoni123|012345678|1|
	|2 |Suresh Raina		|Suresh 		|Raina		|suresh.raina@gmail.com |raina123  |012345678|1|

Scenario Outline: Verify updating an employee - Invalid employee (spaces)
	Given user tries to update an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "PUT" and "<employeeName>"
	Then the API call got success with status code 400

Examples:
	|id 	 |employeeName	|firstName	|lastName	|email	|password	|phone	|employeeStatus|
	|0 	 	 | 				|empty		|empty		|empty	|empty		|empty	|0 			   |
	
Scenario Outline: Verify updating an employee - Employee not found
	Given user tries to update an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "PUT" and "<employeeName>"
	Then the API call got success with status code 404

Examples:
	|id 	 |employeeName	|firstName	|lastName	|email	|password	|phone	|employeeStatus|
	|0 	 	 |Test Employee |empty		|empty		|empty	|empty		|empty	|0 			   |

Scenario Outline: Verify updating an employee 

	Given user tries to update an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "PUT" and "<employeeName>"
	Then the API call got success with status code 200

Examples:
	|id 	 |employeeName	|firstName	|lastName	|email					|password	|phone	|employeeStatus|
	|3	 	 |Rahul Dravid	|Rahul		|Dravid		|rahul.dravid@gmail.com	|rahul123	|999111	|1			   |
	
Scenario Outline: Verify deleting an employee - Invalid employee (spaces)
	Given user tries to delete an employee 
	When user hits the base url with method "DELETE" and "<employeeName>"
	Then the API call got success with status code 400

Examples:
	|employeeName|
	| 			 |	
	
Scenario Outline: Verify deleting an employee - Not found
	Given user tries to delete an employee 
	When user hits the base url with method "DELETE" and "<employeeName>"
	Then the API call got success with status code 404

Examples:
	|employeeName|
	|Test Employee|	

Scenario Outline: Verify deleting an employee 
	Given user tries to delete an employee 
	When user hits the base url with method "DELETE" and "<employeeName>"
	Then the API call got success with status code 200
#	Then employee is deleted successfully

Examples:
	|employeeName|
	|Rohit Sharma|	
	
Scenario Outline: Verify retrieve specific employee - Invalid (spaces)
	Given user tries to retrieve an employee
	When user hits the base url with method "GET" and "<employeeName>"
	Then the API call got success with status code 400

Examples:
	|employeeName|
	||	

Scenario Outline: Verify retrieve specific employee - Not found
	Given user tries to retrieve an employee
	When user hits the base url with method "GET" and "<employeeName>"
	Then the API call got success with status code 400

Examples:
	|employeeName|
	|Test Employee|	

Scenario Outline: Verify retrieve specific employee
	Given user tries to retrieve an employee
	When user hits the base url with method "GET" and "<employeeName>"
	Then the API call got success with status code 200

Examples:
	|employeeName		 |
	|Mahendra Singh Dhoni|	