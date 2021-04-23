package com.wallethub.testrunner;



import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//*** This file is the main Runner file where the test case is executed with appropriate tags ***//

@CucumberOptions(features = {"src/test/resources/features"}, 
				glue = {"stepDefinitions"}, 
				tags = "@WalletHubReview", 
				plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports" }, 
				dryRun = false, 
				monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}