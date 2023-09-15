package vtiger.OrganisationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.CreateNewOrganisation;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInfoPage;
import vtiger.ObjectRepository.OrganisationPage;

public class CreateOrganisationwithIndustryTest extends BaseClass
{
	
	@Test(groups="RegressionSuite")
  public void createOrgwithIndustryTest() throws Throwable
  {
		
				
				/*- Read data from Excel file--*/
				String ORGNAME=eutil.readdatafromexcelfile("Organizations", 4, 2)+jutil.getRandomNumber();
				String INDUSTRYTYPE=eutil.readdatafromexcelfile("Organizations",4,3);

		

	
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
		
		Assert.assertTrue(orgheader.contains(ORGNAME));
		System.out.println(orgheader);
		
	
	}
	
	@Test
	public void demo()
	{
		System.out.println("Demo");
	}

}
