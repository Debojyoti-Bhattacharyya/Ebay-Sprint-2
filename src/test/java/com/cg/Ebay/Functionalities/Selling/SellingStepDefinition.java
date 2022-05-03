package com.cg.Ebay.Functionalities.Selling;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.SigninPom;
import com.cg.PageBin.Selling.PageFactory.SellButtonPageFactory;
import com.cg.PageBin.Selling.PageFactory.SellingPageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SellingStepDefinition {
	
	WebDriver driver;
	SellingPageFactory sellingpf;
	SellButtonPageFactory sellbtnpf;
	SigninPom signin;
	SoftAssert softassert;
	
	@BeforeTest
	@Test
	@Given("User is on login")
	public void user_is_on_login() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		
		signin = new SigninPom(driver);
		sellbtnpf = new SellButtonPageFactory(driver);
		sellingpf = new SellingPageFactory(driver);
		softassert = new SoftAssert();
		
		softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in() throws InterruptedException {
		
		signin.clickSigninAtHome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		signin.typeUserid(1);
		signin.clickContinue();
		signin.typePassword(1);
		signin.clickSignin();
	}
	@Then("User redirects to home")
	public void user_redirects_to_home() {
	    
	}
	@Test
	@Given("User is signed in")
	public void user_is_signed_in() {
		softassert.assertTrue(driver.findElement(By.tagName("button")).getText().contains("Hi "));
	}
	@When("User clicks on Sell button")
	public void user_clicks_on_sell_button() {
		sellbtnpf.clickSell(driver);
	}
	@AfterTest
	@Then("User redirects to sell page")
	public void user_redirects_to_sell_page() {
	    driver.close();
	}
}
