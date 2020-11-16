package com.cumframework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


// Add comments in everything


@CucumberOptions(features = "src/test/java/feature", 
					glue = "com.cumframework.steps", 
					tags = "@Carwale", 
				//	plugin = { "pretty:STDOUT","html:C:\\Users\\Irene\\Desktop\\Test Leaf\\Eclipse folder\\Cucumber\\target\\cucumber-pretty",},
					plugin = { "pretty",
		"json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports" },
					dryRun = false, 
					monochrome = true)

public class Runner extends AbstractTestNGCucumberTests {

	}
