package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganisation extends WebDriverUtility
{
	//Step 1: Declaration
	
	@FindBy(name="accountname")
	private WebElement orgNameTextField;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	//Initialisation
	
	public CreateNewOrganisation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilisation
	
		public WebElement getOrgNameTextField() {
		return orgNameTextField;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method will create organisation using mandatory field 
	 * @param orgname
	 */
	public void createOrgwithIndustry(String orgname)
	{
		orgNameTextField.sendKeys(orgname);
		saveButton.click();
	}
	
	//Business Libraries
	/**
	 * This method will create organisation by handling industry dropdown
	 * @param orgname
	 * @param industry
	 */
	public void createOrgwithIndustry(String orgname, String industry)
	{
		orgNameTextField.sendKeys(orgname);
		handleDropDown(IndustryDropDown, industry);
		saveButton.click();
	}
	

}
