package com.cumframework.steps;


import java.util.ArrayList;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.cumframework.baseUtils.BaseClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.cumframework.utils.ConfigFileReader;
import com.cumframework.utils.WriteExcel;
import com.cumframework.utils.ReadExcel;

public class CarwaleSteps extends BaseClass{
	
private BaseClass base;
	
	public CarwaleSteps(BaseClass base) {
		this.base = base;
	}
	
	public JavascriptExecutor js;
	ConfigFileReader configFileReader;
	
	public List<HashMap<String, String>> dataSet;
	
	public int dataRow;
	
	public String filePath = "./TestData/carwale.xlsx"; //dataSet read excel
	public String sheetName = "Sheet1"; //dataSet read excel
	
	public String wsheetName = "Sheet2"; //write excel
	
	//WriteExcel writeExcel = new WriteExcel();
	
	
	@Given("Go to https:\\/\\/www.carwale.com\\/")
	public void go_to_https_www_carwale_com() {
	    // Write code here that turns the phrase above into concrete actions
		configFileReader= new ConfigFileReader();
		
		base.driver.get(configFileReader.getApplicationUrl());
		
		
		base.driver.manage().window().maximize();
		base.driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		
		dataSet = ReadExcel.readExcelDatafromFile(filePath, sheetName);
						
	}

	@Given("Click on Used")
	public void click_on_Used() throws InterruptedException {
		
		Actions builder = new Actions(base.driver);
		Thread.sleep(5000);
		WebElement usedcars = base.driver.findElementByXPath("//div[text()='USED CARS']");
		WebElement fusedcars = base.driver.findElementByXPath("//div[text() = \"Find Used Cars\"]");
		
		//base.driver.findElementByXPath("//span[text()=\"Used\"]").click();
		builder.moveToElement(usedcars).perform();
		builder.moveToElement(fusedcars).click().perform();
		Thread.sleep(2000);
		
	}

	@Given("Select the City as {string} as Chennai")
	public void select_the_City_as_Chennai(String excelDataRow) throws InterruptedException {
		
		dataRow = Integer.parseInt(excelDataRow)-1;
		System.out.println("DataRow"+dataRow);
		base.driver.findElementById("usedCarsList").sendKeys(dataSet.get(dataRow).get("City"));
		Thread.sleep(2000);
		base.driver.findElementByXPath("//li//strong[text()=\""+(dataSet.get(dataRow).get("City"))+"\"]").click();
		
	}
	

	@Given("Select budget min \\({int}L) and max\\({int}L) and Click Search")
	public void select_budget_min_L_and_max_L_and_Click_Search(Integer int1, Integer int2) throws InterruptedException {
		
		base.driver.findElementByXPath("//li[text()='8 Lakh']").click();
		base.driver.findElementByXPath("(//li[text()='12 Lakh'])[2]").click();
		base.driver.findElementById("btnFindCarLanding").click();
		Thread.sleep(2000);

	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {

		js = (JavascriptExecutor) base.driver;
		js.executeScript("window.scrollBy(0,500)");
		base.driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		Thread.sleep(2000);
		
	}

	@Given("Select Manufacturer as Hyundai Creta")
	public void select_Manufacturer_as_Hyundai_Creta() throws InterruptedException {
		
		js = (JavascriptExecutor) base.driver;
//		Actions builder = new Actions(driver);
		js.executeScript("window.scrollBy(0,500)");
		base.driver.findElementByXPath("//span[text()=' Hyundai ']").click();
		Thread.sleep(2000);
		base.driver.findElementByXPath("//span[text()='Creta']").click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		
	}

	
	@Given("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {

		base.driver.findElementByXPath("//h3[text()[normalize-space()='Fuel Type']]").click();
		Thread.sleep(2000);
		base.driver.findElementByXPath("(//ul//li[@name='Petrol']//span)[1]").click();
		Thread.sleep(2000);
		
	}

	@When("Select Best Match as KM: Low to High")
	public void select_Best_Match_as_KM_Low_to_High() {

		base.driver.findElementById("sort").click();
		WebElement sort = base.driver.findElementById("sort");
		Select srt = new Select(sort);
		srt.selectByVisibleText("KM: Low to High");
		
	}

	@Then("Validate the Cars are listed with KMs Low to High, Add least KM")
	public void validate_the_Cars_are_listed_with_KMs_Low_to_High() {

		List<WebElement> carpr = base.driver.findElementsByXPath("(//span[@class='slkms vehicle-data__item'])");

		int carpricee[] = new int[carpr.size()];
		int carprices[] = new int[carpr.size()];

		for (int i = 0; i < carpr.size(); i++) {
			int carprice = Integer.parseInt(carpr.get(i).getText().replaceAll("[^0-9]", ""));
			System.out.println("Price of car is " + carprice);
			carpricee[i] = carprice;
			carprices[i] = carprice;
		}

		Arrays.sort(carpricee);
		for (int i = 0; i < carpr.size(); i++) {
			System.out.println(carpricee[i]);

		}

		if (Arrays.equals(carpricee, carprices)) {
			System.out.println("Cars are sorted accordingly with KMs Low to High");

		} else
			System.out.println("Cars are not sorted accordingly with KMs Low to High");

		
	for (int i = 0; i < carpr.size(); i++) {
			if (carprices[i] == (carpricee[0])) {
				i = i + 1;
				WebElement ele = base.driver
						.findElementByXPath("(//span[@class='shortlist-icon--inactive shortlist'])[" + i + "]");
				js.executeScript("arguments[0].click()", ele);
				break;
			}
		}

	base.driver.findElementByXPath("//li[text()='& Compare']").click();
		
	}

	@When("Go to Wishlist and Click on More Details")
	public void go_to_Wishlist_and_Click_on_More_Details() throws Exception {

		base.driver.findElementByPartialLinkText("More details »").click();
		Set<String> windows = base.driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windows);
		base.driver.switchTo().window(lst.get(1));
		
		String carname = base.driver.findElementById("car-breadcrumb-link").getText();
		System.out.println(carname);
		
		WriteExcel.writexls(filePath, wsheetName, carname, dataRow+1, 1);
				
		
	}

	@Then("Print all the details under Overview")
	public void print_all_the_details_under_Overview() {

		List<WebElement> model = base.driver.findElements(By.xpath("//div[@class='overview-list padding-bottom10']//li"));

		System.out.println();
		System.out.println("********* OverView Details **********");
		for (int k = 0; k <= model.size(); k++) {

			List<WebElement> cols = base.driver
					.findElements(By.xpath("//div[@class='overview-list padding-bottom10']//li[" + k + "]//div"));

			for (int i = 0; i < cols.size(); i++) {

				System.out.format("%-30s", cols.get(i).getText());

			}

			System.out.println();

		}
		
	}

	@Then("Close the browser")
	public void close_the_browser() {
		base.driver.quit();

		
	}


}
