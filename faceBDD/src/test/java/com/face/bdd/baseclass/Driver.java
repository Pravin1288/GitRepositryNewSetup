package com.face.bdd.baseclass;

import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.Chromaticity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.steadystate.css.util.Output;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Driver {

	public static WebDriver driver;
	public static Scenario scenario;
	/**
	 * Fires up a firefox browser which is then used by the pageObjects to
	 * trigger browser events.
	 */
	
	
	
	public static void initialiseDriver(String browser) throws MalformedURLException {
		//if (driver == null) {
		File file = new File("");
		String path = file.getAbsolutePath().toString();
		System.err.println(path+"\\Browsers\\geckodriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if(browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", path+"\\Browsers\\geckodriver.exe");
			//capabilities.setCapability("marionette", false);
			//capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("firefox");
			capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			driver = new FirefoxDriver(capabilities);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			/*capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName("Firefox");
			driver = new FirefoxDriver(capabilities);*/
			
		} else if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", path+"\\Browsers\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-extension"); 
			option.addArguments("--disable-infobars");
			option.addArguments("--start-maximized");
			capabilities= DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, option);
			capabilities.setPlatform(org.openqa.selenium.Platform.ANY);
			capabilities.setBrowserName("Chrome");
			driver = new ChromeDriver(option);
			
		}
	}

	public void waitForPageTitle(String pageTitle) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}

	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void assertingWebElement(WebElement element) {
		Assert.assertTrue("Is " + element + " displayed ========>",
				element.isDisplayed());
	}
	
public static void waitForElementToBePresent(WebElement element){
    	
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }

public boolean isElementPresent(String objectName){
	int count = driver.findElements(By.cssSelector(objectName)).size();
	if(count==0)
		return false;
	else
		return true;
}

public boolean isSearchTextpresent(){
	
	if(isElementPresent("searchText"))
		return true;
	else
		return false;
}

public static void OpenURL() throws MalformedURLException{
	initialiseDriver("Chrome");
	driver.get("http://facebook.com");
	//driver.manage().window().maximize();
}


public static void tearDownScreenshot(Scenario scenario) {
  
	if (scenario.isFailed()) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String testName = scenario.getName();
            scenario.embed(screenshot, "image/png");
            scenario.write(testName);
            driver.close();
        } catch (WebDriverException wde) {
           // System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            //cce.printStackTrace();}
        }
    
    
}
}

}

