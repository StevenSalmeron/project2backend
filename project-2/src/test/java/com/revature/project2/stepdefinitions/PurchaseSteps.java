package com.revature.project2.stepdefinitions;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PurchaseSteps {
	@Given("^the Showing has not started$")
	public void the_Showing_has_not_started(){
	    System.out.println("The start time of the Showing has not passed");
	}

	@Given("^the Theater has available capacity$")
	public void the_Theater_has_available_capacity(){
	    System.out.println("The Theater has available seats");
	}

	@When("^the User selects a Ticket amount less than or equal to available capacity$")
	public void the_User_selects_a_Ticket_amount_less_than_or_equal_to_available_capacity(){
	    System.out.println("The User selects an amount of tickets that is equal to or less than the available capacity of the theater");
	}

	@Then("^the purchase is successful$")
	public void the_purchase_is_successful(){
	    System.out.println("Purchase is successful");
	}

	@Then("^the tickets are available to the user$")
	public void the_tickets_are_available_to_the_user() {
	    System.out.println("User can view their purchased tickets");
	}
}
