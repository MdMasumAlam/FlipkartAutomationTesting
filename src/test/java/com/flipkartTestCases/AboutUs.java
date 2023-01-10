package com.flipkartTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartBasePage;
import com.flipkart.pages.FlipkartBecomeASeller;
import com.flipkart.utilities.ReadingPropertiesFile;

public class AboutUs extends FlipkartBasePage{

	static Logger log = Logger.getLogger(LoginTestCase.class);

	// This Test Case Is for Entering in Become A Seller PAge In Flipkart
	@Test(priority=1)
	public void testCase07() throws InterruptedException {
		log.info(
				"****************************** Starting test cases execution  *****************************************");

		// Navigate the Browser
		driver.get(ReadingPropertiesFile.getProperty("url"));

		log.info("Flipkart open");

		// For Clearing The Login POPUP
		driver.findElement(By.xpath("//button[contains(@class,'_2KpZ6l _2doB4z')]")).click();
		log.info("Login Pop Up is Cleared ");

		// Clicking on About Us

		driver.findElement(By.xpath("//a[@class='_1arVWX'][text()='About Us']")).click();
		
		log.info("Clicked About Us");
		// Expected Title For Assertion
		String ExpectedTitle = "About Us";

		// Assertion For Matching Title
		{
			String ActualTitle = driver.getTitle();
			System.out.println("The Title of the Application is " + ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);

		}


		log.info("TestCase07 Passed ");
	}

}
