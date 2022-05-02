package com.cg.PageBin.HelpAndContact.ObjectRepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpAndContactRepo {
	
	WebDriver driver;
	File src;
	FileInputStream fis;
	SAXReader saxreader;
	Document document;
	
	public HelpAndContactRepo(WebDriver driver) throws IOException, DocumentException {
		this.driver = driver;
		src = new File("C:\\Users\\DEBOJYBH\\eclipse-workspace\\Sprint2\\src\\test\\java\\com\\cg\\PageBin\\HelpAndContact\\ObjectRepo\\Config.xml");
		fis = new FileInputStream(src);
		saxreader = new SAXReader();
		document = saxreader.read(fis);
	}
	
	public void clickHelpAndContactBtn(WebDriver driver) {
		driver.findElement(By.xpath(document.selectSingleNode("//HelpAndContact/HelpAndContactBtn").getText())).click();
	}
	
	public void selectQuery(WebDriver driver) {
		driver.findElement(By.xpath(document.selectSingleNode("//HelpAndContact/query").getText())).click();
	}

}
