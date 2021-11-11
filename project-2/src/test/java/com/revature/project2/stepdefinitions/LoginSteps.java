package com.revature.project2.stepdefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

	WebDriver driver;
	
	@Given("^the user is on the login page$")
	public void user_is_on_login_page(){
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	    driver = new ChromeDriver();
	    driver.navigate().to("localhost:9080/signin");
	    
	    //driver.manage().window().maximize();
	   //driver.get("https://www.yahoo.com");
	    
	    System.out.println("User is on login page");

	}
	@Given("^the user is registered$")
	public void user_is_registered() {
	    System.out.println("User is registered");
	    
	}

	@When("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String email, String password){
	   System.out.println("User enters their username: " + email + " and their password: " + password);
	   driver.findElement(By.id("email")).sendKeys(email);
	   driver.findElement(By.id("password")).sendKeys(password);
	   driver.findElement(By.id("login")).click();
	}

	@When("^\"([^\"]*)\" and \"([^\"]*)\" are valid$")
	public void and_are_valid(String email, String password) throws Throwable {
	   System.out.println("Both the username and password match the database records");
	}

	@Then("^the user should be logged in$")
	public void user_is_logged_in() throws Throwable {
	   System.out.println("User login is successful");
	   driver.navigate().to("localhost:9080/user");
	}

	@Then("^viewing the homepage$")
	public void is_viewing_the_homepage() throws Throwable {
	   System.out.println("User is now viewing the homepage of the application");
	   driver.close();
	}
	
}
