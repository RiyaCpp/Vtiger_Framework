package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
 //Step 1: Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	//Step 2: Initialisation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilisation
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	//Business Libraries
	WebDriverUtility wuitl=new WebDriverUtility();
	public void logoutofApp(WebDriver driver)
	{
		mouseHoverAction(driver, adminImage);
		signoutlink.click();
	}
	
	public void organizationLink()
	{
		OrganizationLink.click();
	}
	
	public void contactsLink()
	{
		ContactsLink.click();
	}
	
	
}
