package com.cg.Ebay.Functionalities.Login;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cg.PageBin.SigninPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SigninStepDefinition {
	
	WebDriver driver;
	SigninPom signinpom;
	
	@Given("User is on login page")
	public void user_is_on_login_page() throws IOException {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEBOJYBH\\SeleniumProject\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ebay.com/");
		
		signinpom = new SigninPom(driver);
		signinpom.clickSigninAtHome();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}
	
	@When("User enters email, clicks on Continue button and enters password, clicks on sign in button")
	public void user_enters_email_clicks_on_continue_button_and_enters_password_clicks_on_sign_in_button() throws InterruptedException {
	    
		for (int i = 1; i <= 3; i++) {
			signinpom.typeUserid(i);
			signinpom.clickContinue();
			signinpom.typePassword(i);
			Thread.sleep(2000);
			signinpom.clickSignin();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			
			signinpom.signout();
		}
	}
	@Then("User redirects to home page")
	public void user_redirects_to_home_page() {
	    driver.close();
	}
}
