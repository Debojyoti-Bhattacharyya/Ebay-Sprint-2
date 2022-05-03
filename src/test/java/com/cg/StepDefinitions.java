package com.cg;

import java.io.IOException;
import java.time.Duration;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.BuyingPageFactory;
import com.cg.PageBin.RegistrationPom;
import com.cg.PageBin.SigninPom;
import com.cg.PageBin.DailyDeals.ObjectRepo.DailyDealsRepo;
import com.cg.PageBin.HelpAndContact.ObjectRepo.HelpAndContactRepo;
import com.cg.PageBin.Selling.PageFactory.SellButtonPageFactory;
import com.cg.PageBin.Selling.PageFactory.SellingPageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	RegistrationPom registerpom;
	SigninPom signinpom;
	SoftAssert softassert;
	BuyingPageFactory pf;
	SellingPageFactory sellingpf;
	SellButtonPageFactory sellbtnpf;
	SigninPom signin;
	DailyDealsRepo ddrepo;
	HelpAndContactRepo hcrepo;
	
	/*Registration Functionality*/
	
	@Given("User is on Registration Page")
	public void user_is_on_registration_page() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.findElement(By.linkText("register")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		registerpom = new RegistrationPom(driver);
		Assert.assertEquals(driver.getTitle(), "Register: Create a personal account");
	}
	@When("User enters first_name, last_name, email, password and clicks on register button")
	public void user_enters_first_name_last_name_email_password_and_clicks_on_register_button() {
		for(int row = 1; row <= 3; row++) {
			registerpom.typeFirstname(row);
			registerpom.typeLastname(row);
			registerpom.typeEmail(row);
			registerpom.typePassword(row);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			registerpom.clickRegister();
			
			driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2F");
		}
	}
	@Then("User redirects to Login page")
	public void user_redirects_to_login_page() {
		driver.close();
	}
	
	/*Sign in Functionality*/
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
		driver.get("https://www.ebay.com/");
		signinpom = new SigninPom(driver);
		signinpom.clickSigninAtHome();	
		softassert = new SoftAssert();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in button")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in_button() throws InterruptedException {
		for (int i = 1; i <= 1; i++) {
			signinpom.typeUserid(i);
			signinpom.clickContinue();
			
			if (driver.findElement(By.tagName("body")).getText().contains("Oops, that's not a match.")) {
				System.out.println("Invalid credential at row no:" + i);
			}
			else {
				signinpom.typePassword(i);
				Thread.sleep(2000);
				signinpom.clickSignin();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				
				signinpom.signout();
			}
		}
	}
	@Then("User redirects to home page")
	public void user_redirects_to_home_page() {
		driver.close();
	}
	
	/*Buying Functionality*/
	
	@Given("User is on signin page")
	public void user_is_on_signin_page() {
		
		driver.get("https://www.ebay.com/");
	    pf = new BuyingPageFactory(driver);
	}
	@When("User enters required details, clicks on sign in button")
	public void user_enters_required_details_clicks_on_sign_in_button() throws InterruptedException {
		pf.signin();
	}
	@Then("User is redirected to home page")
	public void user_is_redirected_to_home_page() {
		softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
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
	@Then("User redirects to payments page")
	public void user_redirects_to_payments_page() {
		driver.quit();
	}
	
	/*Selling Functionality*/
	
	@Given("User is on login")
	public void user_is_on_login() throws IOException {
		driver.get("https://www.ebay.com/");
		
		signin = new SigninPom(driver);
		sellbtnpf = new SellButtonPageFactory(driver);
		sellingpf = new SellingPageFactory(driver);
	}
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in() {
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
	@Given("User is signed in")
	public void user_is_signed_in() {
	    
	}
	@When("User clicks on Sell button")
	public void user_clicks_on_sell_button() {
		sellbtnpf.clickSell(driver);
	}
	@Then("User redirects to sell page")
	public void user_redirects_to_sell_page() {
	    driver.close();
	}
	
	/*Daily Deals Functionality*/
	
	@Given("User is on Home page")
	public void user_is_on_home_page() throws IOException {
		
		driver.get("https://www.ebay.com/");
		
		ddrepo = new DailyDealsRepo();
		String driverPath = ddrepo.getDriverPath();
	    String url = ddrepo.getUrl();
	    
	    System.setProperty("webdriver.chrome.driver", driverPath);
	    driver = new ChromeDriver();
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
	@Then("User redirects to Shopping Cart page")
	public void user_redirects_to_shopping_cart_page() {
		driver.close();
	}
	
	/*Help and Contact Functionality*/
	
	@Given("User is on Home")
	public void user_is_on_home() throws IOException, DocumentException {
		driver.get("https://www.ebay.com/");
		
		hcrepo = new HelpAndContactRepo(driver);
		softassert.assertEquals(driver.getTitle(), "Electronics, Cars, Fashion, Collectibles & More | eBay");
	}
	@When("User clicks on Help & Contact button")
	public void user_clicks_on_help_contact_button() {
		hcrepo.clickHelpAndContactBtn(driver);
		softassert.assertEquals(driver.getTitle(), "eBay Customer Service");
	}
	@When("User clicks on query")
	public void user_clicks_on_query() {
		hcrepo.selectQuery(driver);
		
		boolean isPresent = false;
		if(driver.findElement(By.tagName("body")).getText().contains("Buying as a guest")) {
			isPresent = true;
		}
		
		softassert.assertEquals(isPresent, "true");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Then("User redirects to query page")
	public void user_redirects_to_query_page() {
		driver.close();
	}
}
