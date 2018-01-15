@SmokeTest
Feature: Invalid_Login
As a General User
I will try logging with invalid credentials on the webpage

Background: 
Given I go to URL on the Browser

@InvalidTest
Scenario Outline: 
When I enter user as "<InvalidUser>"
And I enter pass as "<InvalidPass>"
And I click on the Login Button
Then I should not login on the Webpage

Examples:
|InvalidUser 	|  	InvalidPass|
|Hello    		| 	World|
|IamTrying		|  	ToAccess|

