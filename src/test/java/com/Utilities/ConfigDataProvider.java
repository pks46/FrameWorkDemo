package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider() {
		
		File src = new File(System.getProperty("user.dir")+"/Config/config.properties");
		try {
			FileInputStream fi = new FileInputStream(src);			
			prop = new Properties();
			prop.load(fi);
		} 
		catch (Exception e) {
			System.out.println("Unable to read/load Properties file .. "+e.getMessage());
		}
	}
	
	public String getUserName() {
		return prop.getProperty("USERNAME");
	}
	
	public String getPassword() {
		return prop.getProperty("PASSWORD");
	}
	public String getBrowser() {
		return prop.getProperty("BROWSER");
	}
	public String getTestURL() {
		return prop.getProperty("URL");
	}
}
