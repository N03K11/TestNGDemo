package com.myecom.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static String projectPath = System.getProperty("user.dir");
	
	@BeforeMethod
	public void readProperty() throws IOException 
	{
		FileInputStream fis = new FileInputStream(projectPath+"//config//config.properties");
		prop.load(fis);
	}
	public void loadApplication() 
	{
		String browser = (String) prop.get("browser");
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",projectPath+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",projectPath+"//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.edge.driver",projectPath+"//drivers//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		//driver.get(prop.getProperty("baseurl"));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(10000)); //OR (page load timeout is used for performance testing)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}


	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	

}
