package com.revature.cucumber_test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	private String customerId = "";
	private HttpResponse response = null;
	private ObjectMapper objectMapper = new ObjectMapper();
	

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    System.out.println("Customer is viewing login page");
	    //HttpGet getRequest = new HttpGet("http:localhost:9080/signin");
	   
	}

	@When("the user enters a valid {string} and {string}")
	public void the_user_enters_a_valid_and(String username, String password) throws Exception {
	    HttpPost request = new HttpPost("http://localhost:4200/login");
	    Map<String,String> data = new HashMap<>();
	    String validUsername = "test";
	    String validPassword = "test123";
	    data.put("username", validUsername);
	    data.put("password", validPassword);
	    
	    String json = objectMapper.writeValueAsString(data);	// convert map to json format
	    StringEntity entity = new StringEntity(json); 			// http body
	    request.addHeader("content-type", "application/json");  // adding headers
		request.setEntity(entity);								// set the http body
		response = httpClient.execute(request);					// Send the request to the server
	}

	@Then("login is successful")
	public void login_is_successful() {
	   int status = response.getStatusLine().getStatusCode();	// get status from server
	   assertEquals(200, status); 								// assert that the received status is equal to a successful response
	}

	@When("the user enters a invalid {string} and {string}")
	public void the_user_enters_a_invalid_and(String string, String string2) throws Exception {
		HttpPost request = new HttpPost("http://localhost:4200/login");
	    Map<String,String> data = new HashMap<>();
	    String invalidUsername = "wrong";
	    String invalidPassword = "morewrong";
	    data.put("username", invalidUsername);
	    data.put("password", invalidPassword);
	    
	    String json = objectMapper.writeValueAsString(data);	// convert map to json format
	    StringEntity entity = new StringEntity(json); 			// http body
	    request.addHeader("content-type", "application/json");  // adding headers
		request.setEntity(entity);								// set the http body
		response = httpClient.execute(request);					// Send the request to the server
	}

	@Then("login is unsuccessful")
	public void login_is_unsuccessful() {
		int status = response.getStatusLine().getStatusCode();	// get status from server
		assertEquals(401, status);								//login fails, should receive code 401
	}
}
