package com.cg.Ebay.Functionalities.HelpAndContact;

import java.io.IOException;
import java.time.Duration;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.HelpAndContact.ObjectRepo.HelpAndContactRepo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HelpAndContactStepDefinition {
	
	WebDriver driver;
	HelpAndContactRepo hcrepo;
	SoftAssert softassert;
	
	@BeforeTest
	@Test
	@Given("User is on Home page")
	public void user_is_on_home_page() throws IOException, DocumentException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		hcrepo = new HelpAndContactRepo(driver);
		softassert = new SoftAssert();
		
		softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
		
	}
	
	@Test
	@When("User clicks on Help & Contact button")
	public void user_clicks_on_help_contact_button() {
		hcrepo.clickHelpAndContactBtn(driver);
		softassert.assertEquals(driver.getTitle(), "eBay Customer Service");
	}
	
	@Test
	@When("User clicks on query")
	public void user_clicks_on_query() throws InterruptedException {
		hcrepo.selectQuery(driver);
		
		boolean isPresent = false;
		if(driver.findElement(By.tagName("body")).getText().contains("Buying as a guest")) {
			isPresent = true;
		}
		
		softassert.assertEquals(isPresent, "true");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterTest
	@Then("User redirects to query page")
	public void user_redirects_to_query_page() {
	    driver.close();
	}
}
