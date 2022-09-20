package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.myecom.base.BaseClass;
import com.myecom.pom.ProductListingPOM;
import com.myecom.pom.SignInPagePOM;

public class IndexPagePom extends BaseClass
{
	public IndexPagePom() 
	{
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath = "//img[@alt='My Store']")
	public WebElement logo;

	@FindBy(xpath = "//a[@class='login']")
	public WebElement signinButton;
	
	@FindBy(id = "search_query_top")
	public WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	public WebElement searchButton;
	
	@FindBy(xpath = "//div[@class ='left-block']//img[@alt = 'Printed Summer Dress'][1]")
	public WebElement dressclick;
	
	
//to check if LOGO is displayed or not
	
	public boolean validateLogo() 
	{
		if(logo.isDisplayed()) 
		{
			System.out.println("logo is available");
			return true;
		}
		else 
		{
			return false;
		}
	}
	
//to check the TITLE of page
	public String getTitleOfPage() 
	{
		String getTitle = driver.getTitle();
		return getTitle;
	}
	
//to click on Search tab
	public void searchBox() 
	{
		searchProductBox.sendKeys("T-shirts");
	}
	
	public boolean searchTextValue() 
	{
		searchProductBox.sendKeys("t-shirt");
		String text1 = searchProductBox.getAttribute("value");
		
		if(text1.equalsIgnoreCase(searchProductBox.getAttribute("value"))) 
		{
			System.out.println("Matches Text");
		}
		else 
		{
			System.out.println("Does not Match");
		}
		return true;
	}
	
	public ProductListingPOM searchButton() 
	{
		searchProductBox.sendKeys("T-shirts");
		searchButton.click();
		return new ProductListingPOM();
	}
	
//click on signin button
	public SignInPagePOM signInButton() 
	{
		signinButton.click();
		return new SignInPagePOM();
	}
	
	


}
