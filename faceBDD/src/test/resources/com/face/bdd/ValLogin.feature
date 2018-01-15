@SmokeTest
Feature: Valid_Login
As a Registered User
I want to login and logout Successfully

Background: 
Given I go to URL on the browser

@ValidTest
Scenario: ValidLogin
When I enter my username as "pravinkumar_12@hotmail.com"
And I enter my password as "London@123"
And I click on the Login button
And I should login successfully
And I click on the Settings
And I click on the Logout
Then I should be logged off successfully 