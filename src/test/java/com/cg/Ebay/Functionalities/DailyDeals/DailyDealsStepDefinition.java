package com.cg.Ebay.Functionalities.DailyDeals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.DailyDeals.ObjectRepo.DailyDealsRepo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DailyDealsStepDefinition {
	
	WebDriver driver;
	DailyDealsRepo ddrepo;
	SoftAssert softassert;
	
	@Test
	@Given("User is on Home page")
	public void user_is_on_home_page() throws IOException {
	    
		ddrepo = new DailyDealsRepo();
		softassert = new SoftAssert();
		
	    String driverPath = ddrepo.getDriverPath();
	    String url = ddrepo.getUrl();
	    
	    System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(url);
	    
	    softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	
	@When("User clicks on Daily Deals button")
	public void user_clicks_on_daily_deals_button() {
	    
		ddrepo.clickDailyDealsBtn(driver);
	}

	@When("User clicks on category")
	public void user_clicks_on_category() {
	    
		ddrepo.selectCategory(driver);
	}
	
	@When("User clicks required product")
	public void user_clicks_required_product() {
	    
		ddrepo.selectProduct(driver);
	}
	
	@When("User clicks on View in Cart button")
	public void user_clicks_on_view_in_cart_button() {

	}
	
	@AfterTest
	@Then("User redirects to Shopping Cart page")
	public void user_redirects_to_shopping_cart_page() {
	    
		driver.close();
	}
}
