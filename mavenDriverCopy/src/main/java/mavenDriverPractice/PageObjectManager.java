package mavenDriverPractice;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {
	
	private WebDriver driver;
	private PageObjects pageobjects;
	private PageObject2 pageobject2;
	private Hooks hooks;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public PageObjects getPageObjects() {
		return (pageobjects == null) ? pageobjects = new PageObjects(driver) : pageobjects;
	}
	
	public PageObject2 getPageObject2() {
		return (pageobject2 == null) ? pageobject2 = new PageObject2(driver) : pageobject2;
	}
	
	
	

}
