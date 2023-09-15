package Vtiger_Practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.LoginPage;

public class CreateOrgWithIndustryUsingGU {

	public static void main(String[] args) throws Throwable 
	{
		
		//Create Objects of all Utility Classes
		javaUtility jutil=new javaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility  wutil=new WebDriverUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriver driver=null;
		
		//Step 1: Read all the data required
	/*---Read data from property file*/
		
		String BROWSER=putil.readdatafrompropertyfile("browser");
		String URL=putil.readdatafrompropertyfile("url");
		String USERNAME=putil.readdatafrompropertyfile("username");
		String PASSWORD=putil.readdatafrompropertyfile("password");
		
		
		/*- Read data from Excel file--*/
		String ORGNAME=eutil.readdatafromexcelfile("Organizations", 4, 2)+jutil.getRandomNumber();
		String INDUSTRYTYPE=eutil.readdatafromexcelfile("Organizations", 4, 3);
		
		//Step 2: Launch the Browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}

		wutil.maximiseWindow(driver);
		wutil.waitforPageLoad(driver);
		driver.get(URL);
		
		
		//Step 2: Login to Application with valid credentials
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 3: Navigate to Organisations Link
		
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		
		//Step 4: Click on create organisation look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(1000);
		
		//Step 5: Create Organisation with mandatory fields
		
		String orgname=ORGNAME;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Thread.sleep(1000);
		
		//Step 6: Select "Chemicals" in the industry drop down
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		wutil.handleDropDown(dropdown,INDUSTRYTYPE);
		
		
		//Step 7: Save and Verify
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		String org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org_name.contains(orgname))
		{
			System.out.println("PASS" + org_name);
			
		}
		else
			System.out.println("FAIL");
		
		//Step 8: Logout of Application
		

		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wutil.mouseHoverAction(driver,logout);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Step 9: Close the Browser
		
		driver.quit();
		

		


	}

}
