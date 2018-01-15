package com.face.bdd.pageobjects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.face.bdd.baseclass.Driver;

import cucumber.api.Scenario;

public class HomePage extends Driver{
	
	
	@FindBy (css="#email")
	private static WebElement EmailID;
	
	
	@FindBy (css="#pass1")
	private static WebElement Pwd;
	
	@FindBy (css="input[type=submit]")
	private static WebElement LogIn;
	
	
	public static void EmailButton(String Username) {
		assertingWebElement(EmailID);
		EmailID.clear();
		EmailID.sendKeys(Username);
	}
	
	
	public static void PasswordButton(String Password) {
		assertingWebElement(Pwd);
		Pwd.clear();
		Pwd.sendKeys(Password);
	}

	
	public static void LogInButton() {
		assertingWebElement(LogIn);
		LogIn.click();
	}
	
	
	public static void InvalidUserID(String InvalidUser) {
		assertingWebElement(EmailID);
		EmailID.clear();
		EmailID.sendKeys(InvalidUser);
	}
	
	public static void InvalidPassword(String InvalidPass) {
		assertingWebElement(Pwd);
		Pwd.clear();
		Pwd.sendKeys(InvalidPass);
	}
	
	
}



