package mavenDriverPractice;

import org.openqa.selenium.WebDriver;

public class PageObject2 {

	
		WebDriver driver;
		WebDriverManager webdrivermanager;
		PageObjects pageobjects;
	
		public PageObject2(WebDriver driver) {
			this.driver = driver;
		}


		public void getThirdUrl() {
			
			driver.get("https://www.toolsqa.com/selenium-cucumber-framework/design-webdriver-manager/");
			pageobjects = new PageObjects(driver);
			pageobjects.getFourthUrl();
			
		}
		
}
