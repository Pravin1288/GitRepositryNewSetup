package com.face.bdd.stepdefinitions;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.face.bdd.baseclass.Driver;
import com.face.bdd.pageobjects.HomePage;
import com.face.bdd.pageobjects.LoggedInPage;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class baseClass {

	public static  WebDriver driver;
    public static Scenario scenario;
    
    public baseClass() {
    	driver = Driver.driver;
    	PageFactory.initElements(driver, HomePage.class);
    	PageFactory.initElements(driver, LoggedInPage.class);
    	
    }
	
    
    @AfterClass
    public void setDown() {
    	driver.close();
    	driver.quit();
    }


}
