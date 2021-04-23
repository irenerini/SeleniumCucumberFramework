package com.wallethub.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wallethub.utils.ConfigFileReader;
import com.wallethub.utils.WebElementWrappers;


//*** This file is the Page Object Model having the WebElements and its methods ***//

public class WalletHub_PageObjects {

	WebElementWrappers webElementWrapper;
	ConfigFileReader configFileReader;
	WebDriver driver;

	public WalletHub_PageObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// finding web element

	@FindBy(css = "div#join-light>form>div>nav>ul>li:nth-of-type(2)>a")
	private WebElement logintab;

	@FindBy(id = "em-ipt")
	private WebElement username;

	@FindBy(id = "pw1-ipt")
	private WebElement password;

	@FindBy(xpath = "//span[text()='Login']")
	private WebElement btnlogin;

	@FindBy(xpath = "(//*[local-name() = 'svg'])[14]")
	private WebElement fourthstar;

	@FindBy(xpath = "//span[text()='Select...']")
	private WebElement drpselect;

	@FindBy(xpath = "//li[text()='Health Insurance']")
	private WebElement drpvalue;

	@FindBy(xpath = "//textarea[contains(@class,'textarea wrev-user-input')]")
	private WebElement reviewtext;

	@FindBy(xpath = "//div[text()='Submit']")
	private WebElement btnsubmit;

	@FindBy(xpath = "(//span[@class='brgm-list-title'])[3]")
	private WebElement profilename;

	@FindBy(xpath = "//div[@class='brgm-list brgm-user-list ng-enter-element']//a[1]")
	private WebElement profilemenu;

	@FindBy(xpath = "//div[@class='pr-rec-img-wrapper']/following-sibling::div[1]")
	private WebElement reviewfeed;

	public void clickLoginTab() {
		webElementWrapper = new WebElementWrappers();
		WebElementWrappers.clickElement(logintab);
	}

	
	public void enterUsername() {
		configFileReader = new ConfigFileReader();
		WebElementWrappers.clickElement(username);
		WebElementWrappers.enterText(username, configFileReader.getWHubUsername());
	}

	public void enterPassword() {
		WebElementWrappers.clickElement(password);
		WebElementWrappers.enterText(password, configFileReader.getWHubPassword());

	}

	public void clickBtnLogin() {
		WebElementWrappers.clickElement(btnlogin);
	}

	public void moveToReviewStar() throws InterruptedException {
		Thread.sleep(5000);
		driver.get("http://wallethub.com/profile/test_insurance_company/");
		WebElementWrappers.mouseOverbyActionClass(driver, fourthstar);
	}

	public void clickReviewStar() {
		WebElementWrappers.clickbyActionClass(driver, fourthstar);
	}

	public void clickSelect() {
		WebElementWrappers.clickElement(drpselect);
	}

	public void selectInsurance() {
		WebElementWrappers.clickElement(drpvalue);
	}

	
	public void enterReviewText() {
		WebElementWrappers.enterText(reviewtext, configFileReader.getWHubReviewText());

	}

	public void clickSubmit() {
		WebElementWrappers.clickElement(btnsubmit);
	}

	public void moveToProfileName() {
		WebElementWrappers.mouseOverbyActionClass(driver, profilename);
	}

	public void clickProfileMenu() {
		WebElementWrappers.clickbyActionClass(driver, profilemenu);
	}

	public void getReviewFeed() {

		if (reviewfeed.isDisplayed())

		{
			System.out.println("Review feed is updated");
		} else {
			System.out.println("Review feed is not updated");
		}

	}
}
