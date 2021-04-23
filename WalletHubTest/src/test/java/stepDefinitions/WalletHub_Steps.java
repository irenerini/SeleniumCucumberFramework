package stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.wallethub.manager.PageObjectManager;
import com.wallethub.manager.TestContext;
import com.wallethub.manager.WebDriverManager;
import com.wallethub.pageobjects.WalletHub_PageObjects;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletHub_Steps {

	WalletHub_PageObjects walletHubPageObjects;
	WebDriver driver;
	PageObjectManager pageObjectManager;
	WebDriverManager webDriverManager;
	TestContext testContext;

	public WalletHub_Steps(TestContext context) {
		testContext = context;
		walletHubPageObjects = testContext.getPageObjectManager().getWalletHub_PageObjects();

	}

	@Given("Login to the WalletHub website")
	public void login_to_the_WalletHub_website() {
		try {

			walletHubPageObjects.clickLoginTab();
			walletHubPageObjects.enterUsername();
			walletHubPageObjects.enterPassword();
			walletHubPageObjects.clickBtnLogin();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@When("Rate stars as part of review")
	public void rate_stars_as_part_of_review() throws InterruptedException {
		try {

			walletHubPageObjects.moveToReviewStar();
			walletHubPageObjects.clickReviewStar();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Then("Write a review by selecting company")
	public void write_a_review_by_selecting_company() {
		try {
			walletHubPageObjects.clickSelect();
			walletHubPageObjects.selectInsurance();
			walletHubPageObjects.enterReviewText();
			walletHubPageObjects.clickSubmit();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Then("Check for the updation of review feed")
	public void check_for_the_updation_of_review_feed() {
		try {
		walletHubPageObjects.moveToProfileName();
		walletHubPageObjects.clickProfileMenu();
		walletHubPageObjects.getReviewFeed();
		}
		catch (Exception e) {
			e.getMessage();
		}

	}

}
