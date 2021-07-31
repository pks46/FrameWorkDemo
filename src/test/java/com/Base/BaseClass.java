package com.Base;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Utilities.BrowserLibrary;
import com.Utilities.ConfigDataProvider;
import com.Utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void DataSetup() {
		config = new ConfigDataProvider();
		System.out.println(config.getTestURL());
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ExecutionReport"+Helper.getSystemDateTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void Setup() {
		
		driver = BrowserLibrary.startApplication(driver, config.getBrowser(), config.getTestURL());
	}

	
	@AfterClass
	public void tearDown() {
		BrowserLibrary.Quit(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			//Helper.captureScreenshot(driver);
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception e) {
				System.out.println("Unable to attach screenshot to the logger --- Base Class" +e.getMessage());
			}
		}
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.captureScreenshot(driver);
		}
		
		report.flush();
	}
}
