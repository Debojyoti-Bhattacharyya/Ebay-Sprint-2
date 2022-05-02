package com.cg.Ebay.Functionalities.Buying;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.BuyingPageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BuyingStepDefinition {
	
	WebDriver driver;
	BuyingPageFactory pf;
	SoftAssert softassert;
	
	@BeforeTest
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
	    pf = new BuyingPageFactory(driver);
	    softassert = new SoftAssert();
	}
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in button")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in_button() throws InterruptedException {
		pf.signin();
	}
	
	@Test
	@Then("User redirects to home page")
	public void user_redirects_to_home_page() {
	    softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	@Test
	@Given("User is logged in")
	public void user_is_logged_in() {
		softassert.assertTrue(driver.findElement(By.tagName("button")).getText().contains("Hi "));
	}
	@When("User clicks on a category")
	public void user_clicks_on_a_category() throws InterruptedException {
		pf.select_category();
	}
	@When("User clicks on subcategory")
	public void user_clicks_on_subcategory() {
	    pf.select_subcategory();
	}
	@When("User clicks on brand")
	public void user_clicks_on_brand() {
	    pf.select_brand();
	}
	@When("User clicks on a product")
	public void user_clicks_on_a_product() {
	    pf.select_product(driver);
	}
	@When("User clicks on Buy it Now button")
	public void user_clicks_on_buy_it_now_button() {
	    pf.buy_product();
	}
	@AfterTest
	@Then("User redirects to payments page")
	public void user_redirects_to_payments_page() {
	    driver.quit();
	}
}
