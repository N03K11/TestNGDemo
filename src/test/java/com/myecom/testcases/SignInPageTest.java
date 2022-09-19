package com.myecom.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.base.SignInPagePOM;
import com.myecom.pom.IndexPagePom;
import com.myecom.utility.ExcelSheethandle;

public class SignInPageTest extends BaseClass
{
	IndexPagePom index;
	SignInPagePOM signin;
	ExcelSheethandle data;
	
	
	@BeforeMethod
	public void setUp() 
	{
		loadApplication();
		driver.get(prop.getProperty("SignInPage"));
		signin = new SignInPagePOM();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	@Test
	public void validateAccount() throws InterruptedException 
	{
		Assert.assertTrue(signin.blankEmail());
	}
	
	@Test
	public void signInEmail() throws InterruptedException 
	{
		index = new IndexPagePom();
		index.signinButton.click();
		signin.createEmail();
		Thread.sleep(5000);
	}
	
	@Test
	public void validateSignIn() 
	{
		index = new IndexPagePom();
		index.signinButton.click();
		boolean case2 = signin.title.equals("Login - My Store");
		Assert.assertTrue(case2);
		
		/*if(signin.title.equals("Login - My Store")) 
		{
			System.out.println("Title is correct");
		}
		else 
		{
			System.out.println("Title is incorrect");
		}*/	
	}
	
	//validating methods
	@Test
	public void validateNewAccount() throws InterruptedException 
	{
		signin.createEmail();
		signin.clickOnCreate();
		Thread.sleep(15000);
		signin.validateCreateAccountPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@Test
	public void login() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException 
	{
		data = new ExcelSheethandle();
		Sheet s = data.getSheet(data.getExcelFile(), "Login");
		HashMap<String, Object> logindata = data.getExcelSheetData(s);
		signin.setLoginText((String)logindata.get("Username"), (String)logindata.get("Password"));
		Thread.sleep(3000);
	}
	
	@Test
	public void createAccount() throws Exception 
	{
		data = new ExcelSheethandle();
		Sheet s = data.getSheet(data.getExcelFile(), "SignUp");
		String emaildata = data.getSingleCellValue(s, 1, 0);
		signin.createNewAccount(emaildata);
	}
	
	@Test
	public void signUpPage() throws Exception
	{
		signin.createEmail();
		signin.clickOnCreate();
		data = new ExcelSheethandle();
		Sheet s = data.getSheet(data.getExcelFile(), "SignUp");
		HashMap<String, Object> logindata = data.getExcelSheetData(s);
		signin.signUpCreate((String)logindata.get("First Name"), (String)logindata.get("Last Name"), (String) logindata.get("Mobile Number"));
		Thread.sleep(3000);
		signin.signUpDropDown();
		Thread.sleep(3000);
	
	}
	

		
		

}
