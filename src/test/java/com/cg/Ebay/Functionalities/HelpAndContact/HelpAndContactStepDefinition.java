package com.cg.Ebay.Functionalities.HelpAndContact;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cg.PageBin.HelpAndContact.ObjectRepo.HelpAndContactRepo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpAndContactStepDefinition {
	
	WebDriver driver;
	HelpAndContactRepo hcrepo;
	
	@Test
	@Given("User is on Home page")
	public void user_is_on_home_page() throws IOException, DocumentException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		hcrepo = new HelpAndContactRepo();
		
		Assert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
		
	}
	@When("User clicks on Help & Contact button")
	public void user_clicks_on_help_contact_button() {
		hcrepo.clickHelpAndContactBtn(driver);
	}
	@When("User clicks on query")
	public void user_clicks_on_query() throws InterruptedException {
		hcrepo.selectQuery(driver);
		Thread.sleep(5000);
	}
	@Then("User redirects to query page")
	public void user_redirects_to_query_page() {
	    driver.close();
	}
}
