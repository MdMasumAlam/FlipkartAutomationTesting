package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	//Creating Constructor
	public LoginPage (WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identifying The Elements 
	//Email & Mobile Number Field
	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU']")
	WebElement emailUserName;
	
	
	
	//Request OtpNumber Button
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	WebElement otpRequesting;
	
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	
	//input[contains(@name,'q')]
	WebElement searchBar;
	
	//Search Icon
	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	WebElement searchIcon;
	
	
	//Actions
	//for email and mobile number
	public void userName(String uname)
	{
		emailUserName.click();
		emailUserName.sendKeys(uname);
	}
	
	
	//for requesting otp
	public void otpBtn()
	{
		otpRequesting.click();
	}
	
	public void searchBar(String uname)
	{
		searchBar.click();
		searchBar.sendKeys(uname);
	}
	
	
	//for requesting otp
	public void searchIcon()
	{
		searchIcon.click();
	}
}
	

