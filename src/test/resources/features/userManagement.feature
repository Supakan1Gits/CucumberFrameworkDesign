@Regression @userLoginTests
Feature: Crater User Management
   User management focuses on user creation, update and delete 
   and also authentication
   
   
   Background: 
     Given user is on the login page
   
   @validLoginTest @loginTests @smokeTests
   Scenario: User is able to login successfully
     When  user enter valid "mochana24@gmail.com" and "Password1234"
     And   clicks on the login button
     Then  user should be on dashboard page
     And   user quits the browser
    
   @invalidLogin @loginTests 
   Scenario: Invalid login attempts
     When user enters invalid "google@yahoo.com" and "password1234"
     And clicks on the login button
     Then an error message appears
     And user is not logged in
     And user quits the browser
    
   @invalidTestSets
   Scenario Outline: Invalid login attempts
     When user enters invalid useremail "<useremail>" and password "<password>"
     And clicks on the login button
     Then error messages appear
     And user is not logged in
     And user quits the browser
 
    Examples:
    | useremail                   | password        |
    | helil@primetechschool.com   | standardhhfvajk |
    | nothing@primetechschool.com | Testing123      |
    |                             | Testing123      |
    | nothing@primetechschool.com | Testing123      |
    | nothing@primetechschool.com |                 |
    
