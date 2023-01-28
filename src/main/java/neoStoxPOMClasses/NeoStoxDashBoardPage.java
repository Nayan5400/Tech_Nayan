package neoStoxPOMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class NeoStoxDashBoardPage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") 
	private WebElement popUpOkButton;
	
	@FindBy(xpath = "(//a[text()='Close'])[5]") 
	private WebElement popUpCloseButton;
	
	@FindBy(id = "lbl_username") 
	private WebElement userName;
	
	@FindBy(xpath = "//span[text()='Logout']") 
	private WebElement logOutButton;
	
	@FindBy(id = "lbl_curbalancetop")
	private WebElement acBalance;
	
	public NeoStoxDashBoardPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
	
	if(popUpOkButton.isDisplayed())
	{
		Thread.sleep(5000);
		Utility.scrollIntoView(driver, popUpOkButton);
		popUpOkButton.click();
		Reporter.log("Clicking on PopUp Ok button",true);
	
	}
	
	else if(popUpCloseButton.isDisplayed())
	{
		Thread.sleep(500);
		Utility.scrollIntoView(driver,logOutButton);
		popUpCloseButton.click();
		Reporter.log("Clicking on PopUp Close button",true);
	}
	
	}
	
	public String getActualUserName()
	{
		String actualUserName=userName.getText();
		Reporter.log("Actual username is= "+actualUserName,true);
		return actualUserName;
	}
	
	public void logOutFromNeoStox() throws InterruptedException
	{
	
		userName.click();
	    Thread.sleep(1000);
	    logOutButton.click();
	    Reporter.log("Logging out from Neostox",true);
	}
	
	public String getAcBalance()
	{
		String balance = acBalance.getText();
		Reporter.log("getting AC Balance", true);
		Reporter.log("Account balance is "+balance, true);
		return balance;	
				
	}
	
}
