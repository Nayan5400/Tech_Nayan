package neoStoxTestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxPOMClasses.Utility;


public class Base 
{
	protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nayan\\eclipse-workspace\\MVN_Repo\\Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.get(Utility.readDataFromPropertyFile("url"));
		
		Reporter.log("launching browser", true);
	}
	
	
	
	
	
	

}
