package com.revature.project2.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewShowtimeSteps {
	@Given("^the user is on the homepage$")
	public void the_user_is_on_the_homepage(){
	    System.out.println("User is on homepage of application");
	}

	@When("^the user selects 'view showtimes'$")
	public void the_user_selects_view_showtimes(){
	    System.out.println("User navigates to the view showtimes option");
	}

	@Then("^open <Theater> and availabe <Showing> are displayed$")
	public void open_Theater_and_availabe_Showing_are_displayed() throws Throwable {
	    System.out.println("Theaters with enough seating and available Showings are displayed");
	}
}
