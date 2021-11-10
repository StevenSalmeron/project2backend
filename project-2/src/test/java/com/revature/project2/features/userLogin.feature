#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login Action
	Description: In order to use the app, as a registered user, I need to provide the correct login information

Scenario: 'Standard login with valid credentials'
Given the user is on the login page
And the user is registered
When the user enters "email" and "password"
And "email" and "password" are valid
Then the user should be logged in
And viewing the homepage

