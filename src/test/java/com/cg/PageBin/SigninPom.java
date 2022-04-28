package com.cg.PageBin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPom {
	WebDriver driver;
	By signinAtHome = By.linkText("Sign in");
	By email = By.id("userid");
	By continue_button = By.id("signin-continue-btn");
	By password = By.xpath("//input[@id='pass']");
	By signin_button = By.id("sgnBt");
	By userBtn = By.xpath("//button[@id='gh-ug']");
	By signoutbtn = By.linkText("Sign out");
	By staySigninbtn = By.id("kmsi-checkbox");
	By switchAccount = By.id("switch-account-anchor");
	
	File src;
	FileInputStream fis;
	XSSFWorkbook wb1;
	XSSFSheet sheet1;
	
	public SigninPom(WebDriver driver) throws IOException {
		this.driver = driver;
		
		src = new File("C:\\Users\\DEBOJYBH\\eclipse-workspace\\Sprint2\\src\\test\\resources\\TestData.xlsx");
		fis = new FileInputStream(src);
		wb1 = new XSSFWorkbook(fis);
		sheet1 = wb1.getSheetAt(1);
	}
	
	public void clickSigninAtHome() {
		driver.findElement(signinAtHome).click();
	}
	
	public void typeUserid(int i) {
		driver.findElement(email).sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(staySigninbtn).click();
	}
	
	public void clickContinue() {
		driver.findElement(continue_button).click();
	}
	
	public void typePassword(int i) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(password));
		driver.findElement(password).sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue());
	}
	
	public void clickSignin() {
		driver.findElement(signin_button).click();
	}
	
	public void signout() {
		driver.findElement(userBtn).click();
		driver.findElement(signoutbtn).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(signinAtHome).click();
		driver.findElement(switchAccount).click();
	}
}