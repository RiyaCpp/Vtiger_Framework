package Vtiger_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.CreateNewOrganisation;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInfoPage;
import vtiger.ObjectRepository.OrganisationPage;

public class CreateOrgWithIndustryPOM
{
	public static void main(String[] args) throws Throwable
	{
		
		//Step 1: Read Data from Property file
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
				
				//Using Business Library
	LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

				//Login opertation using getter method
/*	LoginPage lp=new LoginPage(driver);
	lp.getUserNameTextField().sendKeys(USERNAME);
	lp.getPasswordTextField().sendKeys(PASSWORD);
	lp.getLoginButton().click();*/
	
		//Step 3: Navigate to Organisations Link
		HomePage hp=new HomePage(driver);
		hp.organizationLink();
		
		//Step 4: Click on create Organisation Look up Image
		OrganisationPage op=new OrganisationPage(driver);
		op.clickCreateOrgLink();
		
		//Step 5: Create Organisation with mandatory information
		CreateNewOrganisation cnop=new CreateNewOrganisation(driver);
		cnop.createOrgwithIndustry(ORGNAME, INDUSTRYTYPE);
		
		//Step 8: Validate
		OrganisationInfoPage oip=new OrganisationInfoPage(driver);
		String orgheader=oip.verifyOrganisation();
		//String orgheader=oip.getOrgHeader().toString();
		if(orgheader.contains(ORGNAME))
		{
			System.out.println("PASS" + orgheader);
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step 9: Logout of App
		hp.logoutofApp(driver);
		
		//Step 10: Close the browser
		driver.quit();

	}
	
}
