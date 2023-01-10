package com.flipkart.pages;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.flipkart.utilities.ExtentManager;
import com.flipkart.utilities.ReadingPropertiesFile;
import com.flipkart.utilities.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartBasePage {
	
	
	public static ExtentTest test;
	public static ExtentReports extent;
	public static WebDriver driver;
	
	
	
	@BeforeSuite
	public void setup() {
		
		
		extent = ExtentManager.getInstance("reports/Reports.html");
	
		
		String browserName = ReadingPropertiesFile.getProperty("browser");
		System.out.println("Browser Name is : " + browserName);
		
		// Set a mode in which the code is supposed to run 
		String runOption = ReadingPropertiesFile.getProperty ("runoption");
		System.out.println("Option for running the program is : " + runOption);
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ReadingPropertiesFile.getProperty("Chromepath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
//			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadingPropertiesFile.getProperty("globalwait"))));
			
			if (runOption.equalsIgnoreCase("headless")) {
				//Create object of ChromeOption  Class
				ChromeOptions options = new ChromeOptions();
				 //Set the SetHeadless is equal to true which will run test in Headless mode
				options.setHeadless (true);
				driver = new ChromeDriver (options);
			}
			
			else {
				System.out.println ("Program will run in normal mode");
			}
		}
			
			else if (browserName.equalsIgnoreCase("firefox")) {
				System.out.println (ReadingPropertiesFile.getProperty("Firefoxpath"));
				System.setProperty("webdriver.gecko.driver", ReadingPropertiesFile.getProperty("firefoxpath"));
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			else if (browserName.equalsIgnoreCase("edge")) {
				System.out.println (ReadingPropertiesFile.getProperty("Edgepath"));
				
				System.setProperty("webdriver.edge.driver", ReadingPropertiesFile.getProperty("Edgepath"));
				
				EdgeOptions capabilities = new EdgeOptions();
			//	capabilities.ignoreZoomSettings();
				driver = new EdgeDriver (capabilities);
				driver.manage().window().maximize();
				
			}
			
			else
			
				System.out.println ("Invalid browser name");
	
	}
				
		
		@BeforeMethod
		public void beforeMethod(Method method) {
		
			test = extent.startTest(method.getName());
		}
		
		@AfterMethod
		public void afterMethod(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS)
				test.log(LogStatus.PASS, "Test case got passed");
			else if (result.getStatus() == ITestResult.FAILURE) {
				test.log(LogStatus.FAIL, result.getThrowable());
				Screenshot.takeScreenShot(driver,result.getName());
			}
			else if (result.getStatus() == ITestResult.SKIP)
				test.log(LogStatus.SKIP, result.getThrowable());

			extent.flush();

		}

		@AfterSuite
		public static void teardown() {
			driver.quit();

			
		}
	}

