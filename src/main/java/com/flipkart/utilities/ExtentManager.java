package com.flipkart.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

private static ExtentReports extent;
	
	public static  ExtentReports getInstance(String FailCases) {
		if (extent == null) {
			extent = new ExtentReports (FailCases, true, DisplayOrder.NEWEST_FIRST);
			
			//Loading the configuration file for the report
			extent.loadConfig(new File(System.getProperty("user.dir") + "//reportConfig.xml"));
			
			//Adding the system information in the reports
			extent.addSystemInfo("Selenium Version", "3.141.59").addSystemInfo("Environment", "QA");
    	}
   
    	
        return extent;
    }
}
