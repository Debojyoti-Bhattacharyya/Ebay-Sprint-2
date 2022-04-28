Feature: Login Functionality
  We want to check whether the login functionality is working properly or not

  Scenario: Login successful for valid credential
    Given User is on login page
    When User enters email, clicks on Continue button and enters password, clicks on sign in button
    Then User redirects to home page
