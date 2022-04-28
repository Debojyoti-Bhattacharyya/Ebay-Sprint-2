package com.cg.PageBin.DailyDeals.ObjectRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DailyDealsRepo {
	
	File src;
	FileInputStream fis;
	Properties properties;
	WebDriver driver;
	
	public DailyDealsRepo() throws IOException {
		src = new File("C:\\Users\\DEBOJYBH\\eclipse-workspace\\Sprint2\\src\\test\\java\\com\\cg\\PageBin\\DailyDeals\\ObjectRepo\\Config.property");
		fis = new FileInputStream(src);
		properties = new Properties();
		properties.load(fis);
	}
	
	public String getDriverPath() {
		return properties.getProperty("chromeDriver");
	}
	
	public String getUrl() {
		return properties.getProperty("url");
	}
	
	public void clickDailyDealsBtn(WebDriver driver) {
		driver.findElement(By.linkText(properties.getProperty("dailyDealsBtn"))).click();
	}
	
	public void selectCategory(WebDriver driver) {
		driver.findElement(By.linkText(properties.getProperty("category"))).click();
	}
	
	public void selectProduct(WebDriver driver) {
		WebElement product = driver.findElement(By.xpath(properties.getProperty("product")));
		String urlToBeSwitched = product.getAttribute("href");
		driver.get(urlToBeSwitched);
	}

}
