package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLibrary {
	
	
	@SuppressWarnings("deprecation")
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL) 
	{
		
		if(browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver(options);
		}
		
		else if(browserName.equals("firefox")) {
			
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void Quit(WebDriver driver) {
		driver.quit();
	}



}
