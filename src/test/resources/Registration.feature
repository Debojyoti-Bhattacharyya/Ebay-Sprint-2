Feature: Registration Functionality
  We want to check whether the registration page is working properly or not
	
	Scenario: Registration successful for valid credential
   	Given User is on Registration Page
    When User enters first_name, last_name, email, password and clicks on register button
    Then User redirects to Login page