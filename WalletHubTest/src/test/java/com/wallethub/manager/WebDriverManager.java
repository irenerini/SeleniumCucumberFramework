package com.wallethub.manager;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*This file initiates the Web Driver*/

public class WebDriverManager {

	private WebDriver driver;

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;

	}

	
	private WebDriver createDriver() {
		//System.out.println("Irene");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-Notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_90.exe");
		driver = new ChromeDriver(options);
		driver.get("https://wallethub.com/join/light");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
	
	public void closeDriver() {
		
		driver.quit();

	}

}
