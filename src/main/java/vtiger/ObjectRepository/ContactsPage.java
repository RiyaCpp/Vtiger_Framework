package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
  //Step 1: Declaration
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactImg;
	
	//Initialisation
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilisation
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	/**
	 * This method will click on create contact lookup image
	 */
	public void createContactImgClick()
	{
		createContactImg.click();
	}
	
}
