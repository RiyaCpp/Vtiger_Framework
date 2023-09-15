package Vtiger_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateOrganisationWithIndustryusingDDT {

	public static void main(String[] args) throws Throwable 
	{
		
		Random r=new Random();
		int random=r.nextInt(1000);
		WebDriver driver=null;
		
		//Step 1: Read all the data required
	/*---Read data from property file*/
		FileInputStream fisp=new FileInputStream(".\\src\\\\test\\\\resources\\\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		/*- Read data from Excel file--*/
		FileInputStream fise=new FileInputStream(".\\src\\\\test\\\\resources\\\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Organizations");
		String ORGNAME=sh.getRow(4).getCell(2).getStringCellValue();
		String INDUSTRY=sh.getRow(4).getCell(3).getStringCellValue();
		
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

		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Step 2: Login to Application with valid credentials
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(1000);
		
		//Step 3: Navigate to Organisations Link
		
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		
		//Step 4: Click on create organisation look up image
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		Thread.sleep(1000);
		
		//Step 5: Create Organisation with mandatory fields
		
		String orgname=ORGNAME+random;
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		Thread.sleep(1000);
		
		//Step 6: Select "Chemicals" in the industry drop down
		
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel=new Select(dropdown);
		sel.selectByValue(INDUSTRY);
		
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
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//Step 9: Close the Browser
		
		driver.quit();
		

		

	}

}
