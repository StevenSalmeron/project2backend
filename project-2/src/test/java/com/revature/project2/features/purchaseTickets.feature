
Feature: Purchase Action
	Description: As a user, I would like to be able to purchase tickets for available Showings and open Theaters

Scenario: 'Standard purchase of tickets'
Given the Showing has not started
And the Theater has available capacity
When the User selects a Ticket amount less than or equal to available capacity
Then the purchase is successful
And the tickets are available to the user
