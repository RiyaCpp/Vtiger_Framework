package Vtiger_Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactwithOrg {

	public static void main(String[] args) throws Throwable 
	{

     //Step 1: Launch the Browser
		WebDriver driver=new ChromeDriver();
		driver.get("http:/localhost:8888");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Step 2: Login to Application with valid credentials
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		//Step 3: Click on Contacts Link
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(1000);
		
		//Step 4: Click on create contact lookup image
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				
		//Step 5: Fill the mandatory fields
				
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("CP");
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
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("Qsp");
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		driver.findElement(By.xpath("//a[@id='1']")).click();
		driver.switchTo().window(mainid);
		
		//Step 7: Click on Save Button
		
		driver.findElement(By.xpath("//input[@name='button']")).click();
		Thread.sleep(1000);
				
		//Step 8: Verify for contacts creation
				
		String org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org_name.contains("CP"))
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
