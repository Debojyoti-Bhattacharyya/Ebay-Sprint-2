package com.cg.PageBin;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyingPageFactory {
	
	WebDriver driver;
	
	@FindBy(linkText = "Sign in")
	WebElement signinAtHome;
	
	@FindBy(id = "userid")
	WebElement email;
	
	@FindBy(id = "signin-continue-btn")
	WebElement continue_button;
	
	@FindBy(xpath = "//input[@id='pass']")
	WebElement password;
	
	@FindBy(id = "sgnBt")
	WebElement signin_button;
	
	@FindBy(linkText = "Electronics")
	WebElement category;
	
	@FindBy(linkText = "Smart Watches")
	WebElement subCategory;
	
	@FindBy(linkText = "Motorola")
	WebElement brand;
	
//	@FindBy(linkText = "Motorola Moto 360 (2020 3rd Gen) Rose Gold Wear OS by Google M360FS19-RG SEALED")
//	WebElement product;
	
	@FindBy(xpath = "//*[@id=\"s0-29_2-9-0-1[0]-0-0\"]/ul/li[3]/div/div[2]/a")
	WebElement product;
	
	@FindBy(xpath = "//*[@id=\"s0-0-18-5-12-26-77\"]/div/div[1]/a")
	WebElement buybtn;
	
	public BuyingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void signin() throws InterruptedException {
		signinAtHome.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		email.sendKeys("amitvermaebay@gmail.com");
		Thread.sleep(1000);
		continue_button.click();
		
		password.sendKeys("amit@@ebay");
		Thread.sleep(1000);
		
		signin_button.click();
	}
	
	public void select_category() throws InterruptedException {
		Thread.sleep(2000);
		category.click();
	}
	
	public void select_subcategory() {
		subCategory.click();
	}
	
	public void select_brand() {
		brand.click();
	}
	
	public void select_product(WebDriver driver) {
		String currentHanlde = driver.getWindowHandle();
		String urlToBeSwitched = product.getAttribute("href");
		
		product.click();
		
		Set<String> handles = driver.getWindowHandles();
		for(String actual : handles) {
			if(!actual.equalsIgnoreCase(currentHanlde)) {
				driver.switchTo().window(actual);
				driver.get(urlToBeSwitched);
			}
		}
		
	}
	
	public void buy_product() {
		
		// Wait for the button to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(buybtn));
		buybtn.click();
	}
}
