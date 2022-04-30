Feature: Buying Functionality
  We want to check whether the buying functionality is working as expected or not

Background: User is logged in
  Given User is on login page
  When User enters email, clicks on Continue button and enters password, clicks on sign in button
  Then User redirects to home page
   
Scenario: Buying a product
 	Given User is logged in
 	When User clicks on a category
 	And User clicks on subcategory
 	And User clicks on brand
 	And User clicks on a product
  And User clicks on Buy it Now button
 	Then User redirects to payments page
 	
