package com.cumframework.steps;


import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import com.cumframework.baseUtils.BaseClass;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;

import com.cumframework.utils.ConfigFileReader;

public class Hooks extends BaseClass{

	private BaseClass base;
	ConfigFileReader configFileReader;

	public Hooks(BaseClass base) {
		this.base = base;
		
	}
	
	@Before
	public void openDriver() {
		System.out.println("Irene");
		configFileReader = new ConfigFileReader();
		System.out.println(configFileReader.getBrowser());
		if (configFileReader.getBrowser().equalsIgnoreCase("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPathChrome());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-Notifications");
		base.driver = new ChromeDriver(options);
		
		}
		else if (configFileReader.getBrowser().equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver",
					configFileReader.getDriverPathEdge());
			base.driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser could not be launched");
		}
	}
	
	@BeforeStep
	public void addBeforeStep() {
		System.out.println("This step is passed before step");
	}
	
	
	@AfterStep
	public void addAfterStep() {
		System.out.println("This step has passed after step");
	}

	@After
	public void closeDriver() {
		System.out.println("Rini");

	}


}
