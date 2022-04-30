package com.cg.PageBin.Selling.PageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SellingPageFactory {
	
	WebDriver driver;
	
	// Product Details Elements
	@FindBy(xpath = "//*[@id=\"s0-1-4-16-3-find-product-search-bar-search-field\"]")
	WebElement searchBox;
	
	@FindBy(xpath = "//input[@id=\"s0-1-4-16-3-find-product-search-bar-autocomplete-autocomplete[1]\"]/button")
	WebElement category;
	
	@FindBy(xpath = "//input[@id='editpane_title']")
	WebElement title;
	
	@FindBy(xpath = "//select[@id='format']")
	WebElement format;
	
	@FindBy(xpath = "//select[@id='duration']")
	WebElement duration;
	
	@FindBy(id = "startPrice")
	WebElement startPrice;
	
	@FindBy(xpath = "//input[@id='immediatePayment']")
	WebElement immediatePayment;
	
	@FindBy(xpath = "//select[@id='domesticShipping']")
	WebElement domesticeShipping;
	
	@FindBy(xpath = "//*[@id=\"actionbar\"]/input[3]")
	WebElement savebtn;
	
	public SellingPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void select_category() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		searchBox.sendKeys("eBay User Tools");
		category.click();
	}
	
	public void fill_details() {
		title.sendKeys("random name");
		
		Select drpFormat = new Select(format);
		drpFormat.selectByVisibleText("Auction-style");
		
		Select drpDuration = new Select(duration);
		drpDuration.selectByIndex(2);
		
		startPrice.sendKeys("200");
		
		immediatePayment.click();
		
		Select drpDomesticShopping = new Select(domesticeShipping);
		drpDomesticShopping.selectByVisibleText("Flat: same cost to all buyers");
	}
	
	public void save_draft() {
		savebtn.click();
	}
}
