package com.revature.project2.featurerunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/java/com.revature.project2.features"},
				glue= {"src/test/java/com.revature.project2.stepdefinitions"})
public class LoginRunner {

}
