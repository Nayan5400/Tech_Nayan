package neoStoxTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import neoStoxPOMClasses.NeoStoxDashBoardPage;
import neoStoxPOMClasses.NeoStoxHomePage;
import neoStoxPOMClasses.NeoStoxPasswordPage;
import neoStoxPOMClasses.NeoStoxSignInPage;
import neoStoxPOMClasses.Utility;

@Listeners(neoStoxTestClass.Listener.class)

public class ValidateNeoStoxUserNameUsingPropertyFile extends Base
{
  
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage pwd;
	NeoStoxDashBoardPage dash;
	String random;
	
	
	@BeforeClass

	public void launchNeoStoxApp() throws IOException
	{
		launchBrowser();
		
		home=new NeoStoxHomePage(driver);
		signIn=new NeoStoxSignInPage(driver);
		pwd=new NeoStoxPasswordPage(driver);
		dash=new NeoStoxDashBoardPage(driver);
	
	}
	
	@BeforeMethod
	
	public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{
		home.clickOnSignInButton();
		
		
		signIn.enterMobileNumber(Utility.readDataFromPropertyFile("mobile"));
		
		signIn.clickOnSignInButton();
		
		Thread.sleep(1000);
		pwd.enterPassword(Utility.readDataFromPropertyFile("password"));
	    pwd.clickOnSubmitButton();
	    
	    Thread.sleep(5000);
	    dash.handlePopUp(driver);
	    
	}
	
	@Test
	
	public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException
	
	{
	    //Assert.fail();
		Assert.assertEquals(dash.getActualUserName(),Utility.readDataFromPropertyFile("username"),"Actual and Expected user Names are not matching TC is failed" );
		
	}
	
	@Test
	
	public void validateACBalance() throws IOException, InterruptedException
	{
		Assert.assertNotNull(dash.getAcBalance(),"AC Balance is null TC failed");
		
	}
	
	@AfterMethod
	
	public void logOutFromNeoStox() throws InterruptedException
	{
		
		dash.logOutFromNeoStox();	
			
	}
		
	@AfterClass
		
	public void closeNeoStoxApp() throws InterruptedException
	{
		
		driver.close();
		Reporter.log("Closing application", true);
		Thread.sleep(1000);
		
	}
	
}

