package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartTravel {

	WebDriver ldriver;

	// Creating Constructor
	public FlipkartTravel(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Identifying The Elements for ProuctsPurchase
	// Search Bar
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	WebElement searchBar;

	// Search Icon
	@FindBy(xpath = "//button[@type='submit']//*[name()='svg']")
	WebElement searchIcon;

	
	//Click On Flights
	@FindBy(xpath="//*[@class='eFQ30H' and @data-tkid='M_4d913c68-43f9-4846-b37d-20aeb5c649ee_1_372UD5BXDFYS_MC.V4ZPKTOAO321']//child::a")
	WebElement flightBtn;
	
	
	
	
	
	
	
	// Actions ProuctsPurchase
	// For Searching Products in Search Bar
	public void searchBar(String uname) {
		// searchBar.click();
		searchBar.sendKeys(uname);
	}

	// Click on the Search Icon
	public void searchIcon() {
		searchIcon.click();
	}
	
	// Click on the Search Icon
		public void flightBtn() {
			flightBtn.click();
		}
}
