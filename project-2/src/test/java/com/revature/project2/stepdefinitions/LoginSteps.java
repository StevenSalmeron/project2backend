package com.revature.project2.stepdefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	
	WebDriver driver;
	
	@Given("^the user is on the login page$")
	public void user_is_on_login_page(){
//	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
//	    driver = new ChromeDriver();
//	    driver.get("http:localhost:9080/signin");
//	    driver.navigate().to("http:localhost:9080/signin");
//		
//	    driver = new ChromeDriver();
//	    driver.get("http://www.google.com");
	    
	    System.out.println("User is on login page");

	}
	@When("^the user enters a valid 'username' and 'password'$")
	public void the_user_enters_a_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^login is successful$")
	public void login_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the user enters a invalid 'username' and 'password'$")
	public void the_user_enters_a_invalid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^login is unsuccessful$")
	public void login_is_unsuccessful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
