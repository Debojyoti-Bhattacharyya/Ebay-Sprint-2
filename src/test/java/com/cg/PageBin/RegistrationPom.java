package com.cg.PageBin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPom {
	WebDriver driver;
	By firstname = By.id("firstname");
	By lastname = By.id("lastname");
	By email = By.id("Email");
	By password = By.id("password");
	By register_button = By.id("EMAIL_REG_FORM_SUBMIT");
	
	File src;
	FileInputStream fis;
	XSSFWorkbook wb1;
	XSSFSheet sheet1;
	
	public RegistrationPom(WebDriver driver) throws IOException {
		this.driver = driver;
		
		src = new File("C:\\Users\\DEBOJYBH\\eclipse-workspace\\Sprint2\\src\\test\\resources\\TestData.xlsx");
		fis = new FileInputStream(src);
		wb1 = new XSSFWorkbook(fis);
		sheet1 = wb1.getSheetAt(0);
	}
	
	public void typeFirstname(int i) {
		driver.findElement(firstname).sendKeys(sheet1.getRow(i).getCell(0).getStringCellValue());
	}
	
	public void typeLastname(int i) {
		driver.findElement(lastname).sendKeys(sheet1.getRow(i).getCell(1).getStringCellValue());
	}
	
	public void typeEmail(int i) {
		driver.findElement(email).sendKeys(sheet1.getRow(i).getCell(2).getStringCellValue());
	}
	
	public void typePassword(int i) {
		driver.findElement(password).sendKeys(sheet1.getRow(i).getCell(3).getStringCellValue());
	}
	
	public void clickRegister() {
		driver.findElement(register_button).click();
	}
}
