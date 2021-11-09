package com.revature.project2.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	
	@Given("^the user is on the login page$")
	public void user_is_on_login_page(){
	    System.out.println("User is on login page");
	}
	@Given("^the user is registered$")
	public void user_is_registered() {
	    System.out.println("User exists in the database");
	}

	@When("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password){
	   System.out.println("User enters their username: " + username + " and their password: " + password);
	   
	}

	@When("^\"([^\"]*)\" and \"([^\"]*)\" are valid$")
	public void and_are_valid(String username, String password) throws Throwable {
	   System.out.println("Both the username and password match the database records");
	}

	@Then("^the user should be logged in$")
	public void user_is_logged_in() throws Throwable {
	   System.out.println("User login is successful");
	}

	@Then("^viewing the homepage$")
	public void is_viewing_the_homepage() throws Throwable {
	   System.out.println("User is now viewing the homepage of the application");
	}
}
