package com.cg;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src\\test\\resources\\Features",
		glue = "StepDefinitions.java")
public class MainTestRunner extends AbstractTestNGCucumberTests {
	
}
