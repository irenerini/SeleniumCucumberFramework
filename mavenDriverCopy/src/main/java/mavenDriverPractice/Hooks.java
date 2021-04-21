package mavenDriverPractice;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{

	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void openDriver() {
		testContext.getWebDriverManager().getDriver();
		System.out.println("Irene");
	}
	
	@After
	public void closeDriver() {
		testContext.getWebDriverManager().closeDriver();
		System.out.println("Done All");
	}
	
}
