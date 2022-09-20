package com.myecom.testcases;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;

public class DemoTest extends BaseClass 
{
	@BeforeMethod
	public void setUp() 
	{
		loadApplication();
		driver.get(prop.getProperty("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	//@Test(invocationCount = 2) //it will run the respective test cases for 2 times.
	/*@Test(priority = 3)  it will help to set the priority. lowest priority gets the highest preference. if priority 3,2,1 then 1 will be the lowest and it will be executed first. 
	 default priority is zero. if methods have same priority then they will be executed alphabetically*/
	//@Test(groups = {"smoke"}) it will help to run the test cases regarding the group provided
	//@Parameters("browser")
	
	@Test(priority = 3, groups = {"sanity", "regression"}) 
	public void test1() 
	{
		System.out.println("in test 1");
	}
	
	@Test(groups = {"smoke"})
	public void test2() 
	{
		System.out.println("in test 2");
	}
	
	@Test(priority = 1, groups = {"sanity"})
	public void test3() 
	{
		System.out.println("in test 3");
	}

}
