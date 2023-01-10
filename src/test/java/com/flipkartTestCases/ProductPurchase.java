package com.flipkartTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartBasePage;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.utilities.ReadingPropertiesFile;

public class ProductPurchase extends FlipkartBasePage {

	static Logger log = Logger.getLogger(LoginTestCase.class);

	// Test For Search And Select Product
	@Test(priority = 1)
	public void testCase02() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Navigate the Browser
		driver.get(ReadingPropertiesFile.getProperty("url"));

		// Creating Objects for Login Page
		FlipkartHomePage hp = new FlipkartHomePage(driver);

		log.info("Flipkart open");

		// For Clearing The Login POPUP
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
		log.info("Login Pop Up is Cleared ");

		// Searching IPHONE 13
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']"))
				.sendKeys("Iphone13");
		// hp.searchBar("Iphone 13");

		log.info("yes search Complited");

		// Click on Search Bar And Type
		hp.searchIcon();

		log.info("Search Icon Clicked");

		// Clicking On IPhone 13
		driver.get(
				"https://www.flipkart.com/apple-iphone-13-starlight-128-gb/p/itmc9604f122ae7f?pid=MOBG6VF5ADKHKXFX&lid=LSTMOBG6VF5ADKHKXFXQGX7PK&marketplace=FLIPKART&q=iphone+13&store=tyy%2F4io&srno=s_1_1&otracker=AS_Query_OrganicAutoSuggest_1_1_na_na_na&otracker1=AS_Query_OrganicAutoSuggest_1_1_na_na_na&fm=search-autosuggest&iid=df0b6470-aa46-48c1-9957-beae32ff2400.MOBG6VF5ADKHKXFX.SEARCH&ppt=hp&ppn=homepage&ssid=4k9hdru2u80000001673263762000&qH=c68a3b83214bb235");

		log.info("Iphone Selected");

		log.info("TestCase01 Passed ");
	}

	// Test For Add to Cart and Place The Order

	@Test(priority = 2)
	public void testCase03() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Expected Title For Assertion
		String ExpectedTitle = "iPhone 13 ( 128 GB GB Storage, Starlight) Online at Best Price On Flipkart.com";
		
		// Assertion For Matching Title
				{
					String ActualTitle = driver.getTitle();
					System.out.println("The Title of the Application is " + ActualTitle);
					Assert.assertEquals(ActualTitle, ExpectedTitle);

				}

		// Creating Objects for Login Page
		FlipkartHomePage hp = new FlipkartHomePage(driver);

		// Click on aAdd To Cart Button
		hp.addToCartbtn();

		log.info("Add TO Cart Button Clicked ");

		// Click on Place Order Button
		hp.placeOrderBtn();

		log.info("Place Order Button  Clicked");

		
		log.info("TestCase02 Passed ");
	}

}
