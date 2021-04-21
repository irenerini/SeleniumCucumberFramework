package mavenDriverPractice;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src/main/resources/GoogleUrl.feature", glue = "mavenDriverCopy/StepDefinition", tags = "@tag",

		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports" }, dryRun = false, monochrome = true)

public class Runner {

}