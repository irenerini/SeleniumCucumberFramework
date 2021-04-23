package stepDefinitions;

import com.wallethub.manager.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

//*** This file is the has the open browser (before TC) and close browser (after TC) methods ***//

public class Hooks {

	TestContext testContext;
		
	public Hooks(TestContext context) {
		testContext = context;
	}
	
	@Before
	public void openDriver() {
		
		testContext.getWebDriverManager().getDriver();
	}
	
	@After
	public void closeDriver() {
		testContext.getWebDriverManager().closeDriver();
	}
	
}
