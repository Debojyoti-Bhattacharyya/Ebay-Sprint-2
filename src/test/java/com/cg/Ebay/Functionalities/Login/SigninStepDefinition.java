package com.cg.Ebay.Functionalities.Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cg.PageBin.SigninPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SigninStepDefinition {
	
	WebDriver driver;
	SigninPom signinpom;
	SoftAssert softassert;
	
	@Test
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
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
	@AfterTest
	@Then("User redirects to home page")
	public void user_redirects_to_home_page() {
	    driver.close();
	}
}
