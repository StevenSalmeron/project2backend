
Feature: Registration Action
	Description: In order to login, as a user, I need to register

Scenario: 'Standard registration with valid data'
Given User is unregistered
And User is on the registration page
When User enters a valid "username" and a valid "email" and a valid "password"
Then User is registered
And a successful registration message is displayed


