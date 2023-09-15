package Vtiger_Practice;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EndtoEndIntegration {

	public static void main(String[] args) throws Throwable
	{
		
		Random ran=new Random();
		int rand = ran.nextInt(1000);
		//Step 1: Launch Browser
		
		WebDriver driver=new ChromeDriver();
		driver.get("http:/localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Step 2: Login to application with valid credentials
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//Thread.sleep(1000);
		
		//Step 3: Navigate to Contacts link
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Thread.sleep(1000);
		
		//Step 4: Click on create contact look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//Step 5: Create contact with mandatory fields
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Riya");
		//Thread.sleep(1000);
		
		//Step 6: Select organisation from organisation look up image
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		//Thread.sleep(1000);
		
		String mainwindid = driver.getWindowHandle(); //returns the current window id
		Set<String> windId = driver.getWindowHandles(); //returns all the child window id of main window
		for (String id : windId) 
		{
			if(id!=mainwindid)
			{
				driver.switchTo().window(id);
				System.out.println("COntrol switched to child window");
			}
		}
		
		//Search for organisation
		driver.findElement(By.name("search_text")).sendKeys("Qspider");
		driver.findElement(By.name("search")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//a[.='Qspider']")).click();
		
		//Switch control back to main window
		driver.switchTo().window(mainwindid);
		
		//Step 7: Save and Verify
		
		driver.findElement(By.xpath("//input[@name='button']")).click();
		//Thread.sleep(1000);
		String contact_name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contact_name.contains("Riya"))
		{
			System.out.println("PASS" + contact_name);
			
		}
		else
			System.out.println("FAIL");
		
		//Step 8: Logout of application
		
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Step 9: Close the Browser
		
		driver.quit();

	}

}
