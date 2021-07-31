package com.Utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	
	
	public static String captureScreenshot(WebDriver driver) {
		
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/Flipkart"+getSystemDateTime()+".png";
		
		try {
			
			FileUtils.copyFile(scr, new File(screenshotPath));
			
		} 
		catch (Exception e) {
			System.out.println("Unable to capture Screenshots .. "+e.getMessage());
		}
		
		
		System.out.println("Screenshot Captured!!!");
		
		return screenshotPath;
	}
	
	public static String getSystemDateTime() {
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date Curr_date = new Date();
		return format.format(Curr_date);
	}
	
	public void handleAlerts() {
		
	}
}
