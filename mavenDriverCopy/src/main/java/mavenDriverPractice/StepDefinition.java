package mavenDriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class StepDefinition{
	
	PageObjects pageobjects;
	PageObject2 pageobject2;
	TestContext testContext;
	
	public StepDefinition(TestContext context) {
		testContext = context;
		pageobjects = testContext.getPageObjectManager().getPageObjects();
		pageobject2 = testContext.getPageObjectManager().getPageObject2();
		
	}
		
	@Given("Goto google wikipedia")
	public void goto_google_wikipedia() {
	
		pageobjects.getFirstUrl();

	}

	@And("Goto Just Dail")
	public void goto_cloud_computing_Wiki() {
		
		pageobjects.getanotherUrl();
		pageobject2.getThirdUrl();
		
	}


}
