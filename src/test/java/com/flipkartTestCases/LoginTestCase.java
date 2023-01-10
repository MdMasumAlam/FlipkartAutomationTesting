package com.flipkartTestCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartBasePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.utilities.ReadingPropertiesFile;



public class LoginTestCase extends FlipkartBasePage{

	static Logger log = Logger.getLogger(LoginTestCase.class);
	
	
	
	@Test
	public void testCase01() throws InterruptedException
	{
		log.info("****************************** Starting test cases execution  *****************************************");
		
		//Expected Title For Assertion
		String ExpectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		log.info("Url Is Opened");
		//Navigate the Browser
		driver.get(ReadingPropertiesFile.getProperty("url"));
		
		
		
		
		//Creating Objects for Login Page
		LoginPage lp = new LoginPage(driver);
		
		//Enter the User Name
		lp.userName("8101190413");
		
		log.info("Clicked on Email field");
		
		//Clicked on OTP button
		
		lp.otpBtn();
		log.info("Clicked on OTP button");
		
		
		//Assertion for Matching Title
		{	
			String ActualTitle = driver.getTitle();
			System.out.println("The Title of the Application is " + ActualTitle);
			Assert.assertEquals(ActualTitle, ExpectedTitle);
		
			
			}
	}
}
