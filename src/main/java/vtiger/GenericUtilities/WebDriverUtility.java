package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of re usable methods related to webdriver
 * @author Pranav
 *
 */
public class WebDriverUtility
    {
	
     /**
      * This method will maximise the browser window
      * @param driver
      */
	 public void maximiseWindow(WebDriver driver)
	 {
		 driver.manage().window().maximize();
	 }
	 
	 /**
	  * This method will minimise the browser window
	  * @param driver
	  */
	 public void minimiseWIndow(WebDriver driver)
	 {
		 driver.manage().window().minimize();
	 }
	 
	 /**
	  * This method will launch the browser in fullscreen mode
	  * @param driver
	  */
	 public void fullScreenWindow(WebDriver driver)
	 {
		 driver.manage().window().fullscreen();
	 }
	 
	 /**
	  * This method will wait 10 seconds for loading all the web elements
	  * @param driver
	  * @param sec
	  */
	 public void waitforPageLoad(WebDriver driver)
	 {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 }
	 
	 /**
	  * This method waits 10 seconds for particular web element to be visible
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
	
	 /**
	  * This method waits 10 seconds for particular web element to be clickable
	  * @param driver
	  * @param element
	  */
	 public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	 {
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(element));
		 
	 }
	 
	 /**
	  * This method will handle drop down using index
	  * @param element
	  * @param index
	  */
	 public void handleDropDown(WebElement element,int index)
	 {
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
		 
	 }
	 
	 /**
	  * This method will handle drop down using value
	  * @param element
	  * @param value
	  */
	 public void handleDropDown(WebElement element,String value)
	 {
		 Select sel=new Select(element);
		 sel.selectByValue(value);
		 
	 }
	 
	 /**
	  * This method will handle drop down using visible text
	  * @param value
	  * @param element
	  */
	 public void handleDropDown(String value,WebElement element)
	 {
		 Select sel=new Select(element);
		 sel.selectByVisibleText(value);
		 
	 }
	 
	 /**
	  * This method will perform mouse hover action on a webelement
	  * @param driver
	  * @param element
	  */
	 public void mouseHoverAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(element).perform();
	 }
	 
	 /**
	  * This method will perform right click anywhere on the web page
	  * @param driver
	  * @param element
	  */
	 public void rightClickAction(WebDriver driver)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick().perform();
	 }
	 
	 /**
	  * This method will perform right click on a particular web element
	  * @param driver
	  * @param element
	  */
	 public void rightClickAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.contextClick(element).perform();
	 }
	 /**
	  * This method performs double click anywhere on the webpage
	  * @param driver
	  */
	 public void doubleClickAction(WebDriver driver)
	 {
		 Actions act=new Actions(driver);
		 act.doubleClick().perform();
	 }
	 
	 /**
	  * This method performs double click on a particular web element
	  * @param driver
	  * @param element
	  */
	 public void doubleClickAction(WebDriver driver,WebElement element)
	 {
		 Actions act=new Actions(driver);
		 act.doubleClick(element).perform();
	 }
	 
	 /**
	  * This method will perform drag and drop operation
	  * @param driver
	  * @param src
	  * @param target
	  */
	 public void dragAndDropAction(WebDriver driver, WebElement src, WebElement target)
	 {
		 Actions act=new Actions(driver);
		 act.dragAndDrop(src, target).perform();
	 }
	 
	 /**
	  * This method will move the cursor by offset and click
	  * @param driver
	  * @param x
	  * @param y
	  */
	 public void moveTheCursorAndClick(WebDriver driver, int x, int y)
	 {
		 Actions act=new Actions(driver);
		 act.moveByOffset(x, y).click().perform();
	 }
	 
	 /**
	  * This method will scroll down for 500 units
	  * @param driver
	  */
	 public void scrollAction(WebDriver driver)
	 {
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
	 }
	 
	 public void scrollAction(WebDriver driver,WebElement element)
	 {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].scrollIntoView();", element);
		 
	 }
	 
	 /**
	  * This method will switch to immediate parent frame
	  * @param driver
	  * @param frame
	  */
	 public void switchToParentFrame(WebDriver driver)
	 {
		 driver.switchTo().parentFrame();
	 }
	 
	 /**
	  * This method will switch to frame using index value
	  * @param driver
	  * @param index
	  */
	 public void switchToFrame(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 
	 /**
	  * This method will handle the frame using Frame element
	  * @param driver
	  * @param index
	  */
	 public void handleFrame(WebDriver driver,WebElement element)
	 {
		 driver.switchTo().frame(element);
	 }
	 
	 /**
	  * This method will switch to frame using frame ID or name
	  * @param driver
	  * @param id
	  */
	 public void switchToFrame(WebDriver driver,String nameorid)
	 {
		 driver.switchTo().frame(nameorid);
	 }
	 
	 /**
	  * This method will switch to default page
	  * @param driver
	  */
	 public void switchToDefaultContent(WebDriver driver)
	 {
		 driver.switchTo().defaultContent();
	 }
	 
	 /**
	  * This method will help to switch the control from one window to another
	  * @param driver
	  * @param partialWindowTitle
	  */
	 public void switchToWindow(WebDriver driver,String partialWindowTitle)
	 {
		 //Step 1: Capture all Window IDs
		 Set<String> allids = driver.getWindowHandles();
		 
		 //Step 2: Navigate through each window
		 for (String id : allids) 
		 {
			
		  //Step 3: Switch to each window and capture title
			 String actTitle = driver.switchTo().window(id).getTitle();
			 
			//Step 4: Compare title with required
			 
			 if(actTitle.contains(partialWindowTitle))
			 {
				 break;
			 }
		}
	 }
	 
	 /**
	  * This method will accept the alert popup
	  * @param driver
	  */
	 public void acceptAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 }
	 
	 /**
	  * This method will cancel the alert popup
	  * @param driver
	  */
	 public void dismissAlert(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 /**
	  * This method will get the alert text and return it to caller
	  * @param driver
	  */
	 public String getAlertText(WebDriver driver)
	 {
		 String data = driver.switchTo().alert().getText();
		 return data;
	 }
	 
	 /**
	  * This method will take screenshot and store it in a required folder
	  * @param driver
	  * @param screenshotname
	  * @return
	  * @throws Throwable
	  */
	 public String captureScreenShot(WebDriver driver,String screenshotname) throws Throwable
	 {
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest = new File(".\\Screenshots\\"+screenshotname+".png");
		 Files.copy(src, dest);
		 return dest.getAbsolutePath(); //used for extent reporting
	 }
	 
	}
