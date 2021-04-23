package com.wallethub.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*This file consists of reusable functions for WebElements*/

public class WebElementWrappers {

	public static void clickbyActionClass(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			
			action.moveToElement(element).click().build().perform();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void mouseOverbyActionClass(WebDriver driver, WebElement element) {
		try {
			Actions action = new Actions(driver);
			
			action.moveToElement(element).build().perform();
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void clickElement(WebElement element) {
		try {
			element.click();

		} catch (Exception e) {

			e.getMessage();

		}
	}

	public static void enterText(WebElement element, String text) {
		try {
			element.clear();
			
			element.sendKeys(text);
			
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
