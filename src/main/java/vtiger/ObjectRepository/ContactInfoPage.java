package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{

	//Delcaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeader;
	
	//Initialisation
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilisation
	public WebElement getContactHeader() {
		return contactHeader;
	}
	
	public String verifyContact()
	{
		return contactHeader.getText();
		
	
}
}
