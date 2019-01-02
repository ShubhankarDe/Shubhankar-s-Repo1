package com.automation.test;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.automation.pageObjects.LoginPage;
import com.automation.utilities.ActionMethods;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;

public class ValidateChanges {
	
	
	WebDriver driver = SetUp.driver;
	LoginPage loginPageobj = SetUp.loginPageobj;
	ActionMethods user = new ActionMethods();
	
	
	@Then("^validate the following details$")
	public void enter_the_following_details(DataTable table) throws Throwable {
		
		throw new PendingException();
		
		
		
		
	    
	}

}
