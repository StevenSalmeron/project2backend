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

Feature: Purchase Action
	Description: As a user, I would like to be able to purchase tickets for available Showings and open Theaters

Scenario: 'Standard purchase of tickets'
Given the Showing has not started
And the Theater has available capacity
When the User selects a Ticket amount less than or equal to available capacity
Then the purchase is successful
And the tickets are available to the user
