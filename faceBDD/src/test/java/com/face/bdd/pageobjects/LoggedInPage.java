package com.face.bdd.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.face.bdd.baseclass.Driver;

public class LoggedInPage extends Driver{

	@FindBy (css="#userNavigationLabel")
	private static WebElement UserNavigation;
	
	/*@FindBy (css="._54nh")
	private WebElement LogOut;	*/
	
	
	public static void UserNavigationButton() {
		waitForElementToBePresent(UserNavigation);
		assertingWebElement(UserNavigation);
		UserNavigation.click();
	}
	
	public static void LogOutButton() {
		
		List<WebElement> LogOut = driver.findElements(By.cssSelector("._54nh1"));
		for(WebElement All : LogOut){
			System.out.println(All.getText());
			WebElement ClickLogout = LogOut.get(10);
			waitForElementToBePresent(ClickLogout);
			ClickLogout.click();
			}
	}	
}
