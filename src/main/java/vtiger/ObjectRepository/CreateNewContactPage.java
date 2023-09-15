package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
 
	//Declaration
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@name='button']")
	private WebElement contactSaveButton;
	
	@FindBy(xpath="//input[@name='account_name']/../img[@alt='Select']")
	private WebElement selectOrgImg;
	
	@FindBy(name="search_text")
	private WebElement OrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement OrgSearchBtn;
	
	//Initialisation
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilisation
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getContactSaveButton() {
		return contactSaveButton;
	}
	
	public WebElement getSelectOrgImg()
	{
		return selectOrgImg;
	}
	public WebElement getOrgSearchEdt()
	{
		return OrgSearchEdt;
	}
	public WebElement getOrgSearchBtn()
	{
		return OrgSearchBtn;
	}
	
	/**
	 * This method will create contact with mandatory fields
	 * @param lastname
	 */
	public void createContact(String lastname)
	{
		lastNameTextField.sendKeys(lastname);
		contactSaveButton.click();
	}
	
	/**
	 * This method will create contact using Organisation
	 * @param lastname
	 * @param orgname
	 * @param driver
	 */
	public void createContact(String lastname, String orgname,WebDriver driver)
	{
		lastNameTextField.sendKeys(lastname);
		selectOrgImg.click();
		switchToWindow(driver, "Accounts");
		OrgSearchEdt.sendKeys(orgname);
		OrgSearchBtn.click();
		
		////a[text()='ch399'] --> Regular xpath
		//a[text()='"+orgname+"'] --> Dynamic xpath
		//driver.findElement(By.linkText(orgname));
		driver.findElement(By.xpath("//a[.='"+orgname+"']")).click(); //dynamic xpath
		switchToWindow(driver, "Contacts");
		contactSaveButton.click();
	}
	
	
}
