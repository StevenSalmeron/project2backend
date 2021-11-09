package com.revature.project2.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationSteps {
	@Given("^User is unregistered$")
	public void user_is_unregistered(){
	    System.out.println("User is unregistered");
	}

	@Given("^User is on the registration page$")
	public void user_is_on_the_registration_page(){
	    System.out.println("User is viewing the registration form");
	}

	@When("^User enters a valid \"([^\"]*)\" and a valid \"([^\"]*)\" and a valid \"([^\"]*)\"$")
	public void user_enters_a_valid_and_a_valid_and_a_valid(String username, String email, String password){
	    System.out.println("User enters a valid " + username + " and " + email + " and " + password );
	}

	@Then("^a successful registration message is displayed$")
	public void a_successful_registration_message_is_displayed() throws Throwable {
	    System.out.println("User registration was successful");
	}
}
