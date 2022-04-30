package com.cg.PageBin.Selling.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SellButtonPageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id=\"gh-p-2\"]/a")
	WebElement sellbtn;
	
	public SellButtonPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSell(WebDriver driver) {
		sellbtn.click();
	}
}
