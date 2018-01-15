package com.face.bdd.runner;

import java.io.File;
import java.net.MalformedURLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;
import com.face.bdd.baseclass.Driver;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



	@RunWith(Cucumber.class)
	@CucumberOptions(tags = {"@SmokeTest"}, 
						features = {"src/test/resources/"},
						glue = {"com.face.bdd.stepdefinitions"}, //Give step definition 
						//strict = true, 
						format = {"html:src/test/report"},
						plugin = {"com.cucumber.listener.ExtentCucumberFormatter"}
						
						//monochrome  = true
						)

	public class TestRunner {

		@BeforeClass
		public static void setup() throws MalformedURLException {
			
			ExtentCucumberFormatter.initiateExtentCucumberFormatter();
	        ExtentCucumberFormatter.loadConfig(new File("src/test/extent-config.xml"));
	        ExtentCucumberFormatter.addSystemInfo("Selenium Version", "2.53.1");
	        ExtentCucumberFormatter.addSystemInfo("os","Windows");
		}
//
		

	}
