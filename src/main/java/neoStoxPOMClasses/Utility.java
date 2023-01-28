package neoStoxPOMClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import net.bytebuddy.utility.RandomString;

public class Utility 
{
	    // read data from property file
	    // excel
		// wait                     //utility
		// screenShot
		// scrolIntoView         
	
	  public static String readDataFromPropertyFile(String key) throws IOException
	  {
		 Properties prop=new Properties();
		 FileInputStream myfile=new FileInputStream("C:\\Users\\nayan\\eclipse-workspace\\MVN_Repo\\myProperty.properties");
		 prop.load(myfile);
		 String value = prop.getProperty(key);
		 Reporter.log("Reading data from peroperty file", true);
		 Reporter.log("data is "+value, true);
		 return value;
	  }
	
	public static String readDataFromExcel(int row, int cell) throws EncryptedDocumentException, IOException 
		{
			
			File myfile = new File("D:\\neostox.xlsx");
			Sheet mysheet = WorkbookFactory.create(myfile).getSheet("Sheet1");
			String value = mysheet.getRow(row).getCell(cell).getStringCellValue();
			Reporter.log("Reading data from excel row is "+row+" cell is "+cell, true);
			Reporter.log("data is "+value, true);
			return value;

		}

		public static void takeScreenshot(WebDriver driver, String random) throws IOException, InterruptedException 
		{
		    String s=RandomString.make(2);
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest = new File("D:\\Automated_Screenshot\\screenshot"+random+s+".png");
			FileHandler.copy(src, dest);
			Reporter.log("screenShot taken and saved at "+dest, true);
		}

		public static void scrollIntoView(WebDriver driver, WebElement element) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Reporter.log("scrolling into view to "+element.getText(), true);
		}
	
}
