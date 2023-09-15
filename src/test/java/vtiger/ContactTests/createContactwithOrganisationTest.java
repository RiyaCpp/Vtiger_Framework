package vtiger.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganisation;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganisationInfoPage;
import vtiger.ObjectRepository.OrganisationPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class createContactwithOrganisationTest extends BaseClass {
	
	@Test(groups="SmokeSuite")

	public void createContactwithOrgTest() throws Throwable 
	{
	
				/*- Read data from Excel file--*/
				String ORGNAME=eutil.readdatafromexcelfile("Contacts", 4, 2)+jutil.getRandomNumber();
				String LASTNAME=eutil.readdatafromexcelfile("Contacts", 4, 3);

				//Step 3: Navigate to Organisations Link
				HomePage hp=new HomePage(driver);
				hp.organizationLink();
				Reporter.log("Navigated to Organsiation link"); //low level reports
				
				//Step 4: Click on create Organisation Look up Image
				OrganisationPage op=new OrganisationPage(driver);
				op.clickCreateOrgLink();
				Reporter.log("Clicked on Organisation Look up Image");
				
				//Step 5: Create Organisation with mandatory information
				CreateNewOrganisation cnop=new CreateNewOrganisation(driver);
				cnop.createOrgwithIndustry(ORGNAME);
				Reporter.log("Organisation created");
				
				//Assert.fail();
				//Step 8: Validate
				OrganisationInfoPage oip=new OrganisationInfoPage(driver);
				String orgheader=oip.verifyOrganisation();
				Assert.assertTrue(orgheader.contains(ORGNAME));
				System.out.println(orgheader);
				
			//	String orgheader=oip.getOrgHeader().toString();
				/*if(orgheader.contains(ORGNAME))
				{
					System.out.println("PASS" + orgheader);
				}
				else
				{
					System.out.println("Fail");
				}*/
				
			//	Assert.fail();
				//Step 9: Click on Contacts Link
				hp.contactsLink();
				
				//Step 10: Click on create contact look up image
				ContactsPage cp=new ContactsPage(driver);
				cp.createContactImgClick(); 
				Reporter.log("Clicked on create contact look up image");
				
				//Step 11: Create contact using the organisation
				
				CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.createContact(LASTNAME, ORGNAME, driver);
				Reporter.log("Contact created");
				
				//Step 12: Validate for contacts
				ContactInfoPage cinp=new ContactInfoPage(driver);
				String Contactheader=cinp.verifyContact();
				Assert.assertTrue(Contactheader.contains(LASTNAME));
				System.out.println(Contactheader);
				/*if(Contactheader.contains(LASTNAME))
				{
					System.out.println("Pass" + Contactheader);
				}
				else
				{
					System.out.println("FAIL");
				}*/
				
		
	}
	@Test
	public void demo()
	{
		System.out.println("Demo");
	}

}
