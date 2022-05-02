package com.cg.Ebay.Functionalities.Registration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.cg.PageBin.RegistrationPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationStepDefinition {
	
	WebDriver driver;
	RegistrationPom registerpom;
	
	@Test
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
	
	@AfterTest
	@Then("User redirects to Login page")
	public void user_redirects_to_login_page() {
	    
		driver.close();
	}
}
