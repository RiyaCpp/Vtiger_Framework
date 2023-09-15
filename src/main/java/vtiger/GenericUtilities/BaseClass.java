package vtiger.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This is a generic class consisiting of all basic configuration
 * annotations of TESTNG
 * @author Pranav
 *
 */
public class BaseClass 
{
 public javaUtility jutil=new javaUtility();
 public ExcelFileUtility eutil=new ExcelFileUtility();
 public PropertyFileUtility putil=new PropertyFileUtility();
 public WebDriverUtility wutil=new WebDriverUtility();
 public WebDriver driver=null;
 public static WebDriver sdriver;
 
 @BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
 public void bsconfig()
 {
	 System.out.println("=======Database Connection Successful====");
 }
 
// @Parameters("browser") - for crossbrowser execution
// @BeforeTest -- for parallel suite execution
 
 /*public void bcConfig(String BROWSER) throws Throwable - for cross browser execution while using @parameters we use
                                                           parameter in function to accept the browser value and comment
                                                          the reading statement from property files.*/
 @BeforeClass(alwaysRun = true)
 public void bcConfig() throws Throwable
 {
	  String BROWSER=putil.readdatafrompropertyfile("browser");
		String URL=putil.readdatafrompropertyfile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}

		wutil.maximiseWindow(driver);
		wutil.waitforPageLoad(driver);
		driver.get(URL);
		sdriver=driver;
		System.out.println("Browser Launched");
		
 }
 
 @BeforeMethod(alwaysRun = true)
 public void bmConfig() throws Throwable
 {
	    String USERNAME=putil.readdatafrompropertyfile("username");
		String PASSWORD=putil.readdatafrompropertyfile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=======Login Successful============");
 }
 
 @AfterMethod(alwaysRun=true)
 public void amConfig() throws Throwable
 {
	 HomePage hp=new HomePage(driver);
		hp.logoutofApp(driver);
		System.out.println("========Logout Successfull=======");
 }
 
 //@AfterTest---for parallel suite execution 
 @AfterClass(alwaysRun = true)
 public void acConfig()
 {
	 driver.quit();
	 System.out.println("=======Browser Closed========");
 }
 
 @AfterSuite(alwaysRun = true)
 public void asconfig()
 {
	 System.out.println("========Database Connection Closed====");
 }
}
