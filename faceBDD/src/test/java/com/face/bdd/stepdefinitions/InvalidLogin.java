package com.face.bdd.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.face.bdd.baseclass.Driver;
import com.face.bdd.pageobjects.HomePage;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalidLogin extends baseClass{
	//HomePage ob1 = PageFactory.initElements(driver, HomePage.class);
public WebDriver driver1;
@Given("^I go to URL on the Browser$")
public void I_go_to_URL_on_the_Browser() throws Throwable {
   HomePage.OpenURL();
}

@When("^I enter user as \"([^\"]*)\"$")
public void I_enter_user_as(String InvalidUser) throws Throwable {
    HomePage.InvalidUserID(InvalidUser);
}

@When("^I enter pass as \"([^\"]*)\"$")
public void I_enter_pass_as(String InvalidPass) throws Throwable {
   HomePage.InvalidPassword(InvalidPass);
}

@When("^I click on the Login Button$")
public void I_click_on_the_Login_Button() throws Throwable {
	HomePage.LogInButton();
	//getScreenshot(scenario);
}

@Then("^I should not login on the Webpage$")
public void I_should_not_login_on_the_Webpage() throws Throwable {
   
}

@After
public void setup(Scenario sc) {
	System.out.println(sc.getName() + sc.isFailed());
	Driver.tearDownScreenshot(sc);
	driver1.close();
}


	
	
}