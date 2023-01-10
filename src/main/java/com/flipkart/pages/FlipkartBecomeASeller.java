package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartBecomeASeller {

	WebDriver ldriver;

	// Creating Constructor
	public FlipkartBecomeASeller(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	// Identifying The Elements for ProuctsPurchase
		// Become a seller
		@FindBy(xpath ="//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/a[1]/span[1]")
		WebElement becomeASeller;

		// Actions ProuctsPurchase
		// For Clicking on Become  A Seller 
		public void becomeASeller() {
			becomeASeller.click();
		}


}
