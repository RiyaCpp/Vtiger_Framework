package Vtiger_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganisationwithIndustryandType {

	public static void main(String[] args) throws Throwable
	{
		//Step 1: Launch Browser
		
				WebDriver driver=new ChromeDriver();
				driver.get("http:/localhost:8888");
				driver.manage().window().maximize();
				Thread.sleep(1000);
				
				//Step 2: Login to Application with valid credentials
				
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				Thread.sleep(1000);
				
				//Step 3: Navigate to Organisations Link
				
				driver.findElement(By.linkText("Organizations")).click();
				Thread.sleep(1000);
				
				//Step 4: Click on create organisation look up image
				
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				Thread.sleep(1000);
				
				//Step 5: Create Organisation with mandatory fields
				
				driver.findElement(By.name("accountname")).sendKeys("NIIT");
				Thread.sleep(1000);
				
				//Step 6: Select "Energy" in the industry drop down
				
				WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
				Select sel=new Select(dropdown);
				sel.selectByValue("Energy");
				
				//Step 7: Select "Customer" in the Type Drop Down
				
				WebElement type_dropdown = driver.findElement(By.name("accounttype"));
				Select seltype=new Select(type_dropdown);
				seltype.selectByValue("Customer");
				
				//Step 8: Save and Verify
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				Thread.sleep(1000);
				String org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(org_name.contains("NIIT"))
				{
					System.out.println("PASS" + org_name);
					
				}
				else
					System.out.println("FAIL");
				
				//Step 9: Logout of Application
				
				WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act=new Actions(driver);
				act.moveToElement(logout).perform();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
				//Step 10: Close the Browser
				
				driver.quit();
				

	}

}
