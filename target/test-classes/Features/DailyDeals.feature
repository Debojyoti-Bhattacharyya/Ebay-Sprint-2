Feature: Daily Deals Functionality
  We want to check whether the Daily Deals functionality is working as expected or not
 
Scenario: Checking Daily Deals
 	Given User is on Home page
 	When User clicks on Daily Deals button
 	And User clicks on category
 	And User clicks required product
  And User clicks on View in Cart button
 	Then User redirects to Shopping Cart page