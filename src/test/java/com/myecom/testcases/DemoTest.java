package com.myecom.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.listener.MyListener;
import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;

@Listeners(MyListener.class)
public class DemoTest extends BaseClass 
{
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) 
	{
		loadApplication(browser);
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
	//@Parameters("browser") it helps to run cross browser testing
	//Parallel when we need to run the test cases simultaneously. but for that test cases should not be dependant on each other and thread should be appropriate
	
	@Test(priority = 3, groups = {"sanity", "regression"}) 
	public void test1() 
	{
		System.out.println("in test 1");
		Assert.fail();
	}
	
	
	@Test
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
