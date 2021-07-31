package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.Pages.LoginPage;

public class TC001_LoginFlipkart extends BaseClass{

	
	@Test(priority=1)
	public void LoginApp() {	
		
		logger = report.createTest("Login to Flipkart");
		
		//Running Login Properties---- Pages > LoginPage
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting the Application");
		loginpage.LoginToApplication(config.getUserName(), config.getPassword());
		
		logger.pass("Login Done Successfully!!!");
		
		
	}
	
//	@Test(priority=2)
//	public void LoginApp1() {	
//		
//		logger = report.createTest("Log out ");
//		//Running Login Properties---- Pages > LoginPage
//		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
//				
//		logger.info("Starting the Application");
//		loginpage.LoginToApplication(config.getUserName(), config.getPassword());
//		
//		logger.fail("Login Done Successfully!!!");
//		
//		
//	}
}
