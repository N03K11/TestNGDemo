package com.myecom.testcases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.myecom.base.BaseClass;
import com.myecom.base.ProductListingPOM;
import com.myecom.base.SignInPagePOM;
import com.myecom.pom.IndexPagePom;

public class IndexPageTest extends BaseClass
{
	IndexPagePom index;
	SignInPagePOM signin;
	ProductListingPOM product;
	SoftAssert softassert = new SoftAssert();
	ExtentReports extent;
	ExtentTest logger;

	@BeforeMethod
	public void generateExtentReport() 
	{
		ExtentSparkReporter generateReport = new ExtentSparkReporter(projectPath+"//extentreport/Extent Report.html");
		extent = new ExtentReports();
		extent.attachReporter(generateReport);
		
	}
	
	@AfterTest
	public void flushReport() 
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setUp() 
	{
		loadApplication();
		driver.get(prop.getProperty("baseurl"));
		index = new IndexPagePom();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test
	public void validateLogo() 
	{
		//index = new IndexPagePom();
		boolean ref = index.validateLogo();
		Assert.assertTrue(ref);
	}
	
	@Test
	public void getTitleOfPage() 
	{
		logger = extent.createTest("getTitleOfPage");
		//index = new IndexPagePom();
		String title = index.getTitleOfPage();
		//Assert.assertTrue(true, title);
		logger.log(Status.INFO, title);
		Assert.assertEquals(title, "My Store");
		//System.out.println("Title of Page: "+title);
	}
	
	/*@Test
	public void searchBox() throws InterruptedException 
	{
		
		index.searchBox();
		Thread.sleep(3000);
	}*/
	
	@Test
	public SignInPagePOM signInClick() 
	{
		signin.signIn();
		return new SignInPagePOM();
	}
	
	@Test
	public void createClick() throws InterruptedException 
	{
		logger = extent.createTest("createClick");
		index.signinButton.click();
		signin = new SignInPagePOM();
		signin.createEmail();
		Thread.sleep(3000);
		signin.clickOnCreate();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void search() throws InterruptedException 
	{
		index = new IndexPagePom();
		index.searchButton();
		Thread.sleep(5000);
	}
	
	@Test
	public void searchTextValue() 
	{
		index = new IndexPagePom();
		index.searchTextValue();
		boolean case1 = true;
		Assert.assertTrue(case1);
	}
	
	@Test
	public void selectDropDown() throws InterruptedException 
	{
		
		index = new IndexPagePom();
		index.searchButton();
		Thread.sleep(3000);
		product = new ProductListingPOM();
		product.dropDown();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void clickOnDress() throws InterruptedException 
	{
		index = new IndexPagePom();
		index.searchButton();
		product = new ProductListingPOM();
		product.dressClick();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void hardassert() 
	{
		System.out.println("open webpage");
		Assert.assertEquals(false, true); //hard assert
		System.out.println("logo check");
		System.out.println("title check");
		System.out.println("click on sign in");
	}

	@Test
	public void softassert() 
	{
		System.out.println("open webpage");
		softassert.assertEquals(false, true); //soft assert
		System.out.println("logo check");
		System.out.println("title check");
		softassert.assertEquals(false, true);
		System.out.println("click on sign in");
		softassert.assertAll(); //it gives failure and also executes all the methods. if not written then it will not give any failure.
	}
	
	

}
