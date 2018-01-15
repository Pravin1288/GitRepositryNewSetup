package com.face.bdd.stepdefinitions;

import java.util.logging.LoggingMXBean;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.face.bdd.baseclass.Driver;
import com.face.bdd.pageobjects.HomePage;
import com.face.bdd.pageobjects.LoggedInPage;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ValidLogin extends baseClass {
	
	
public static  WebDriver driver2;	
	

@Given("^I go to URL on the browser$")
public void I_go_to_URL_on_the_browser() throws Throwable {
   Driver.OpenURL();
}

@When("^I enter my username as \"([^\"]*)\"$")
public void I_enter_my_username_as(String Username) throws Throwable {
	HomePage.EmailButton(Username);
   
}

@When("^I enter my password as \"([^\"]*)\"$")
public void I_enter_my_password_as(String Password) throws Throwable {
	HomePage.PasswordButton(Password);
   
}

@When("^I click on the Login button$")
public void I_click_on_the_Login_button() throws Throwable {
    HomePage.LogInButton();
}

@When("^I should login successfully$")
public void I_should_login_successfully() throws Throwable {
    
}

@When("^I click on the Settings$")
public void I_click_on_the_Settings() throws Throwable {
    LoggedInPage.UserNavigationButton();
}

@When("^I click on the Logout$")
public void I_click_on_the_Logout() throws Throwable {
 LoggedInPage.LogOutButton(); 
}

@Then("^I should be logged off successfully$")
public void I_should_be_logged_off_successfully() throws Throwable {
    
}

@After
public void setup(Scenario sc) {
	System.out.println(sc.getName() + sc.isFailed());
	Driver.tearDownScreenshot(sc);
	driver2.close();
}


}
