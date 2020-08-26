Feature: Validate Employee API

Scenario Outline: Verify User Login
	Given user tries to login with "<user_id>" "<password>"
	When user hits the "login" url with method GET
	Then the API call got success with status code 200

Examples:
	|user_id |password|
	|Tester123|test123|

Scenario: Verify User logout
	Given user tries to logout
	When user hits the "logout" url with method GET
	Then the API call got success with status code 200
	
Scenario Outline: Verify adding new employee 
	Given user tries to add an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "POST" and "no_employee"
	Then the API call got success with status code 200
	
Examples:
	|id 	 |employeeName	|firstName	|lastName	|email		|password	|phone	|employeeStatus|
	|1	 	 |Virat Kohli	|Virat		|Kohli		|v.k@b.com	|Virat123	|012345	|1			   |
	|2	 	 |Suresh Raina	|Suresh		|Raina		|s.r@b.com	|Suresh123	|012345	|1			   |

	
Scenario Outline: Verify updating an employee 
	Given user tries to update an employee <id> "<employeeName>" "<firstName>" "<lastName>" "<email>" "<password>" "<phone>" <employeeStatus>
	When user hits the base url with method "PUT" and "<employeeName>"
	Then the API call got success with status code 200

Examples:
	|id 	 |employeeName	|firstName	|lastName	|email		|password	|phone	|employeeStatus|
	|1	 	 |Virat Virat	|Virat		|Virat		|k.v@b.com	|Virat123	|012345	|1			   |
	
	
Scenario Outline: Verify deleting an employee 
	Given user tries to delete an employee 
	When user hits the base url with method "DELETE" and "<employeeName>"
	Then the API call got success with status code 200

Examples:
	|employeeName|
	|Suresh Raina|	
	
Scenario Outline: Verify retrieve specific employee
	Given user tries to retrieve an employee
	When user hits the base url with method "GET" and "<employeeName>"
	Then the API call got success with status code 200

Examples:
	|employeeName|
	|Virat Virat|	