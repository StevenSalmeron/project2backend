
Feature: View Showtimes for available movies
	Description: While logged in, as a user, I can view available showtimes
	
Scenario: 'User is browsing available showtimes'
Given the user is on the homepage
When the user selects 'view showtimes'
Then open <Theater> and availabe <Showing> are displayed