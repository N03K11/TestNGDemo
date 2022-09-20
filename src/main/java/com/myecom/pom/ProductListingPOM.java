package com.myecom.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.myecom.base.BaseClass;

public class ProductListingPOM extends BaseClass
{
	Select select;
	
	public ProductListingPOM()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='selectProductSort']")
	WebElement dropdown;
	
	@FindBy(xpath = "//ul[@class='block_content products-block']//li[@class='clearfix'][4]") //option 4 xpath
	WebElement dress1;
	
	@FindBy(id = "search_query_top")
	WebElement searchtextbox;
	

	public void dropDown() 
	{
		select = new Select(dropdown);
		select.selectByVisibleText("Price: Highest first");
		
	}
	
	public boolean dressClick() 
	{
		dress1.click();
		return true;
	}

}
