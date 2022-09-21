package com.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.myecom.base.BaseClass;
import com.myecom.utility.Utility;

public class MyListener extends BaseClass implements ITestListener 
{
	Utility utility = new Utility();
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		try 
		{
			utility.screenShot(driver, result.getName());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void onTestFailure(ITestResult result) 
	{
		try 
		{
			utility.screenShot(driver, result.getName());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
