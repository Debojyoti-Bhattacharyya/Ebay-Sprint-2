package com.cg.Ebay.Functionalities.Selling;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		signin = new SigninPom(driver);
	}
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in button")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in_button() throws InterruptedException {
		
		signin.clickSigninAtHome();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		signin.typeUserid(1);
		signin.clickContinue();
		signin.typePassword(1);
		signin.clickSignin();
	}
	@Then("User redirects to home page")
	public void user_redirects_to_home_page() {
	    
	}
	@Given("User clicks on Sell button")
	public void user_clicks_on_sell_button() {
		sellbtnpf = new SellButtonPageFactory(driver);
		sellbtnpf.clickSell(driver);
	}
	@When("User clicks on a Browse Categories dropdown")
	public void user_clicks_on_a_browse_categories_dropdown() {
//	    pf.browse_category();
	}
	@When("User clicks on category")
	public void user_clicks_on_category() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.get("https://bulksell.ebay.com/ws/eBayISAPI.dll?SingleList&sellingMode=AddItem");
		System.out.println(driver.getCurrentUrl());
		try {
			sellingpf = new SellingPageFactory(driver);
			sellingpf.select_category();
		}
		catch(NoSuchElementException e) {
			System.out.println("NoSuchElement Exception");
		}
	}
	@When("User clicks on subcategory")
	public void user_clicks_on_subcategory() {
//		sellingpf.select_subcategory();
	}
	@When("User fills the required product details")
	public void user_fills_the_required_product_details() {
		sellingpf.fill_details();
	}
	@When("User clicks on Save as Draft button")
	public void user_clicks_on_save_as_draft_button() {
		sellingpf.save_draft();
	}
	@Then("User redirects to browse category page")
	public void user_redirects_to_browse_category_page() {
	    driver.close();
	}
}
