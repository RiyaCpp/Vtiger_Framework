package Vtiger_Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.ObjectRepository.LoginPage;

public class CreateContactWithOrgUsingGU {

	public static void main(String[] args) throws Throwable
	{
		
		//Create objects of all utility classes
		ExcelFileUtility eutil=new ExcelFileUtility();
		javaUtility jutil=new javaUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver=null;
		
		//Read all data from Property File
		String BROWSER = putil.readdatafrompropertyfile("browser");
		String URL=putil.readdatafrompropertyfile("url");
		String USERNAME = putil.readdatafrompropertyfile("username");
		String PASSWORD = putil.readdatafrompropertyfile("password");
		
		
		//Read Data from Excel File
		String CONTACTNAME = eutil.readdatafromexcelfile("Contacts", 1, 2);
		String ORGNAME = eutil.readdatafromexcelfile("Contacts", 4, 2);
		
		
		
				
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

				wutil.waitforPageLoad(driver);
				wutil.maximiseWindow(driver);
				driver.get(URL);
				
				//Step 2: Login to Application with valid credentials
				
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//Step 3: Click on Contacts Link
				
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				Thread.sleep(1000);
				
				//Step 4: Click on create contact lookup image
				
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
						
						
				//Step 5: Fill the mandatory fields
						
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(CONTACTNAME);
				Thread.sleep(1000);
				
				//Step 6: Select the organisation
				driver.findElement(By.xpath("//input[@name='account_name']/../img[@alt='Select']")).click();
				
				
				String mainid = driver.getWindowHandle();
				Set<String> allid = driver.getWindowHandles();
				
				for (String id : allid) 
				{
					if(!mainid.equals(id))
					{
						driver.switchTo().window(id);
						break;
					}
				}
				driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
				driver.findElement(By.xpath("//a[@id='1']")).click();
				//wutil.switchToWindow(driver, mainid)
				//driver.switchTo().window(mainid);
				
				//Step 7: Click on Save Button
				
				driver.findElement(By.xpath("//input[@name='button']")).click();
				Thread.sleep(1000);
						
				//Step 8: Verify for contacts creation
						
				String org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(org_name.contains(CONTACTNAME))
					{
						System.out.println("PASS" + org_name);
					}
					else
					{
						System.out.println("FAIL");
					}
						
				//Step 8: Logout from the application
					
				WebElement mouse_hover = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(mouse_hover).perform();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
						
				//Step 9: Close the Browser
				
				driver.quit();

	}

}
