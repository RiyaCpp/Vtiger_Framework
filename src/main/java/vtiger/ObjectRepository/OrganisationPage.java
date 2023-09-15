package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage 
{
	//Step 1:Declaration
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgImg;
	
	//Initialisation
	
	public OrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilisation
	
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	
	//Business Libraries
	/**
	 * This method will click on create organisation look up Image
	 */
	public void clickCreateOrgLink()
	{
		createOrgImg.click();
	}

}
