Feature: Selling Functionality
  We want to check whether the selling functionality is working as expected or not

Background: User is logged in
  Given User is on login
  When User enters email, clicks on Continue button and enters password, clicks on sign in
  Then User redirects to home
 
Scenario: Selling a product
 	Given User is signed in
 	When User clicks on Sell button
 	Then User redirects to sell page