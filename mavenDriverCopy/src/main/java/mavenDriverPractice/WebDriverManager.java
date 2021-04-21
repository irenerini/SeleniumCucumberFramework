package mavenDriverPractice;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class WebDriverManager {
	 public WebDriver driver;
	 
	
	 public WebDriver getDriver() {
		 if(driver == null) driver = createDriver();
		 return driver;
		 }
	 
	 private WebDriver createDriver() {
		 
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-Notifications");
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
			return driver;
	 }

	 public void closeDriver() {
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();

		} 
	

}
