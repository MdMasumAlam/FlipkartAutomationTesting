package com.flipkartTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartBasePage;
import com.flipkart.pages.FlipkartBecomeASeller;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.pages.FlipkartTravel;
import com.flipkart.utilities.ReadingPropertiesFile;

public class BecomeASeller extends FlipkartBasePage {

	static Logger log = Logger.getLogger(LoginTestCase.class);

	// This Test Case Is for Entering in Become A Seller PAge In Flipkart
	@Test(priority=1)
	public void testCase05() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Navigate the Browser
		driver.get(ReadingPropertiesFile.getProperty("url"));

		// Creating Objects for Login Page
		FlipkartBecomeASeller bs = new FlipkartBecomeASeller(driver);

		log.info("Flipkart open");

		// For Clearing The Login POPUP
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
		log.info("Login Pop Up is Cleared ");

		// Clicking on Become A Seller

		bs.becomeASeller();
		
		
		log.info("Clicked Become A Seller ");
		// Expected Title For Assertion
		String ExpectedTitle = "Sell Online - Become a Online Seller in India | Flipkart Seller Hub";

		// Assertion For Matching Title
		{
			String ActualTitle = driver.getTitle();
			System.out.println("The Title of the Application is " + ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);

		}


		log.info("TestCase05 Passed ");
	}

	// This Test Case IS for Checking The Fees Structure Section
	@Test(priority=2)
	public void testCase06() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Creating Objects for Login Page
		FlipkartBecomeASeller bs = new FlipkartBecomeASeller(driver);

		log.info("Flipkart open");


		// Clicking on Become A Seller

	//	bs.becomeASeller();
		log.info("Clicked on Become A Seller ");

		// Click on Fee Structure

		driver.get("https://seller.flipkart.com/sell-online/pricing");
		//driver.findElement(By.xpath("//a[text()='Fee Structure']/parent::li")).click();

		log.info("Fees Structure Clicked ");

		// Expected Title For Assertion
		String ExpectedTitle = "Flipkart fee structure";

		// Assertion For Matching Title
		{
			String ActualTitle = driver.getTitle();
			System.out.println("The Title of the Application is " + ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);

		}

		log.info("TestCase06 Passed ");
	}
}
