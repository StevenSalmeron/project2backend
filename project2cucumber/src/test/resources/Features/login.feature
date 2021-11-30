
Feature: Login Action
	Description: In order to use the app, as a registered user, I need to provide the correct login information

Scenario: Standard login with valid credentials
Given the user is on the login page
When the user enters a valid 'username' and 'password'
Then login is successful

Scenario: Standard login with invalid credentials
Given the user is on the login page
When the user enters a invalid 'username' and 'password'
Then login is unsuccessful