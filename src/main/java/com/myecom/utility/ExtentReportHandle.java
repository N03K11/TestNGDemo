package com.myecom.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecom.base.BaseClass;

public class ExtentReportHandle extends BaseClass
{
	ExtentReports extent;
	
	public void generateExtentReport() 
	{
		ExtentSparkReporter generateReport = new ExtentSparkReporter(projectPath+"//extentreport/Extent Report.html");
		extent = new ExtentReports();
		extent.attachReporter(generateReport);
	}

}
