package com.wallethub.manager;

import org.openqa.selenium.WebDriver;

import com.wallethub.pageobjects.WalletHub_PageObjects;

/*This file is the object manager for POM (WebElements) and assigns the driver after Hooks*/

public class PageObjectManager {

	private WalletHub_PageObjects pageObjects;
	private WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public WalletHub_PageObjects getWalletHub_PageObjects() {
		return (pageObjects == null) ? pageObjects = new WalletHub_PageObjects(driver) : pageObjects;
	}
	
}
