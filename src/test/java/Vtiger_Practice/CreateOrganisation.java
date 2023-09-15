package Vtiger_Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganisation {

	public static void main(String[] args) throws Throwable
	{
		
	    Random ran=new Random();
	    int r=ran.nextInt(1000);
	    //Step 1: Launch Browser
		
		WebDriver driver=new ChromeDriver();
		driver.get("http:/localhost:8888");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
	    //Step 2: Login to application with valid credentials
		
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
		String org="Anand Sweets"+r;
		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		
		//Step 6: Save and Verify
		
		String org_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(org_name.contains(org))
		{
			System.out.println("PASS" + org_name);
			
		}
		else
			System.out.println("FAIL");
		
		//Step 7: Logout of Application
		
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Step 8: Close the browser
		
		driver.quit();
		
		
		

	}

}
