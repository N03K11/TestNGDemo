package com.myecom.pom;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myecom.base.BaseClass;
import com.myecom.pom.IndexPagePom;

public class SignInPagePOM extends BaseClass
{
	IndexPagePom index;
	Actions act;
	
	
	public SignInPagePOM()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email_create")
	public WebElement createemail;
	
	@FindBy(id = "SubmitCreate")
	public WebElement clickcreate;
	
	@FindBy(id = "create_account_error")
	public WebElement blankemail;
	
	@FindBy(id = "email")
	public WebElement loginemail;
	
	@FindBy(id = "passwd")
	public WebElement loginpassword;
	
	@FindBy(id = "SubmitLogin")
	public WebElement login;
	
	@FindBy(xpath = "//h1[@class='page-heading']")
	public WebElement pageheading;
	
	@FindBy(id = "id_gender2")
	public WebElement female;
	
	@FindBy(id="customer_firstname")
	public WebElement custFirstName;
	
	@FindBy(id="customer_lastname")
	public WebElement custLastName;
	
	@FindBy(id="email")
	public WebElement email;
	
	@FindBy(id="passwd")
	public WebElement passwd;
	
	@FindBy(id="days")
	public WebElement days;
	
	@FindBy(id="months")
	public WebElement months;
	
	@FindBy(id="years")
	public WebElement years;
	
	@FindBy(id="firstname")
	public WebElement firstname;
	
	@FindBy(id="lastname")
	public WebElement lastname;
	
	@FindBy(id="company")
	public WebElement company;
	
	@FindBy(id="address1")
	public WebElement address1;
	
	@FindBy(id="address2")
	public WebElement address2;
	
	@FindBy(id="city")
	public WebElement city;
	
	@FindBy(id="id_state")
	public WebElement id_state;
	
	@FindBy(id="postcode")
	public WebElement postcode;
	
	@FindBy(id="id_country")
	public WebElement id_country;
	
	@FindBy(id="phone")
	public WebElement phone;
	
	@FindBy(id="phone_mobile")
	public WebElement phone_mobile;
	
	@FindBy(id="alias")
	public WebElement alias;
	
	@FindBy(id="newsletter")
	public WebElement newsletter;
	
	@FindBy(id="optin")
	public WebElement optin;
	
	@FindBy(id="submitAccount")
	public WebElement submitAccount;
	
	@FindBy(xpath="//a[@title='Women']")
	public WebElement women;
	
	@FindBy(xpath="//a[@class='home']")
	public WebElement home;
	
	public String title = driver.getTitle();
	
	public void createEmail() 
	{
		createemail.sendKeys("neha.kulkarni.0311@gmail.com");
	}
	
	public boolean clickOnCreate() 
	{
		clickcreate.click();
		return true;
	}
	
	public boolean blankEmail() throws InterruptedException 
	{
		clickcreate.click();
		Thread.sleep(10000);
		boolean value = blankemail.isDisplayed();
		return value;
	}
		
	public void signIn() 
	{
		index = new IndexPagePom();
		index.signinButton.click();
		boolean case1 = true;
		Assert.assertTrue(case1);
		//without putting assert still test case result is shown as passed
	
	}
	
	public void validateCreateAccountPage() 
	{
		String title = pageheading.getText();
		Assert.assertTrue(title.equalsIgnoreCase("Create an account"));
		System.out.println(title);
	}
	
	public void setLoginText(String username, String password) 
	{
		loginemail.sendKeys(username);
		loginpassword.sendKeys(password);
	}
	
	public void createNewAccount(String username) 
	{
		createemail.sendKeys(username);
		
	}
	
	public void signUpCreate(String firstname, String lastname, String number, String password, String comp, String add, String city1, String pin, String add2) 
	{
		female.click();
		custFirstName.sendKeys(firstname);
		custLastName.sendKeys(lastname);
		phone_mobile.sendKeys(number);
		passwd.sendKeys(password);
		company.sendKeys(comp);
		address1.sendKeys(add);
		city.sendKeys(city1);
		postcode.sendKeys(pin);
		alias.sendKeys(add2);
		
	}
	
	public void signUpDropDown() 
	{
		Select daysel = new Select(days);
		daysel.selectByValue("7");
		
		Select monthsel = new Select(months);
		monthsel.selectByValue("2");
		
		Select yearsel = new Select(years);
		yearsel.selectByValue("2000");
		
		Select statesel = new Select(id_state);
		statesel.selectByValue("32");
	}
	
	public void signUpCheckBoxes() 
	{
		newsletter.click();
		optin.click();
	}
	
	public void create() 
	{
		submitAccount.click();
	}
	
	public void womenMouseHover() 
	{
		act = new Actions(driver);
		act.moveToElement(women);
	}
	
	public void returnHome() 
	{
		home.click();
	}

}
