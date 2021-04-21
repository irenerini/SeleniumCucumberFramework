package mavenDriverPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObjects {

	WebDriver driver;
	
	public PageObjects(WebDriver driver) {
		this.driver = driver;
	}

		
	public void getFirstUrl() {
		
		driver.get("https://en.wikipedia.org/wiki/Google");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	public void getanotherUrl() {

		driver.get("https://www.justdial.com/");
		

	}
	
	public void getFourthUrl() {

		driver.get("https://www.lambdatest.com/blog/behaviour-driven-development-by-selenium-testing-with-gherkin/");
		
	}

}
