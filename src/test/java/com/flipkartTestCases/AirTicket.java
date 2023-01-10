package com.flipkartTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartBasePage;
import com.flipkart.pages.FlipkartTravel;
import com.flipkart.utilities.ReadingPropertiesFile;

public class AirTicket extends FlipkartBasePage {

	static Logger log = Logger.getLogger(LoginTestCase.class);

	@Test(priority = 1)
	public void testCase04() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Navigate the Browser
		driver.get(ReadingPropertiesFile.getProperty("url"));

		// Creating Objects for Login Page
		FlipkartTravel at = new FlipkartTravel(driver);

		log.info("Flipkart open");

		// For Clearing The Login POPUP
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
		log.info("Login Pop Up is Cleared ");

		// Click on Flights

		// at.flightBtn();

		driver.findElement(By.xpath("//div[text()='Travel']")).click();
		log.info("Clicked On Flights");

		// Expected Title For Assertion
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";

		// Assertion For Matching Title
		{
			String ActualTitle = driver.getTitle();
			System.out.println("The Title of the Application is " + ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);

		}

		log.info("TestCase04 Passed ");
	}
}
