Feature: Selling Functionality
  We want to check whether the selling functionality is working as expected or not

Background: User is logged in
  Given User is on login page
  When User enters email, clicks on Continue button and enters password, clicks on sign in button
  Then User redirects to home page
 
Scenario: Selling a product
 	Given User clicks on Sell button
 	When User clicks on a Browse Categories dropdown
 	And User clicks on category
 	And User clicks on subcategory
 	And User fills the required product details
  And User clicks on Save as Draft button
 	Then User redirects to browse category page