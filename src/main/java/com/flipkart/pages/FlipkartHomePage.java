package com.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	WebDriver ldriver;

	// Creating Constructor
	public FlipkartHomePage(WebDriver rdriver) {
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

	// Add To Cart Button
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")
	WebElement addToCartbtn;

	// Place Order
	@FindBy(xpath = "//button[@class='_2KpZ6l _2ObVJD _3AWRsL']/child::span[text()='Place Order']")
	WebElement placeOrderBtn;

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

	// For Add to cart
	public void addToCartbtn() {
		// searchBar.click();
		addToCartbtn.click();
	}

	// For Add to cart
	public void placeOrderBtn() {
		// searchBar.click();
		placeOrderBtn.click();
	}
}
