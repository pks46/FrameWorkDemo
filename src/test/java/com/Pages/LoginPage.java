package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[contains(@class,'_2QfC02')]")
	WebElement Flyout;
	
	@FindBy(xpath="//button[contains(text(),'✕')]")
	WebElement XClosing;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement LoginButton;
	
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement UserName;
	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	WebElement UserPassword;
	
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;		
	}
	
	public void LoginToApplication(String Useremail, String Userpassword) {
		XClosing.click();
		LoginButton.click();
		UserName.sendKeys(Useremail);
		UserPassword.sendKeys(Userpassword);
		
	}
}
