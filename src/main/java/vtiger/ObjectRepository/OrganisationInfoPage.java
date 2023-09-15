package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage 
{
	//Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeader;
	
	//Initialisation
	
	public OrganisationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Utilisation
	public WebElement getOrgHeader() {
		return OrgHeader;
	}
	
	//Business Libraries
	/**
	 * This method will return the header Text
	 * @return
	 */
	public String verifyOrganisation()
	{
		return OrgHeader.getText();
	}
		/*if(OrgHeader.getText().contains(orgname))
		{
			return "pass";
		}
		else
		{
			return "fail";
		}*/
	}
	


