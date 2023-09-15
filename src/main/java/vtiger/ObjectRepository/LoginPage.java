package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
    //Rule 1: Create a separate POM Class for every web page
	
	//Rule 2: Identify the web element using Annotations (@FindBy, @FindBys, @FindAll
	
	//Declaration
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement UserNameTextField;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement PasswordTextField;
	
	@FindBy(id="submitButton")
	private WebElement LoginButton;
	
	//Rule 3: Create a constructor to initialise the WebElements
	
	public LoginPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getters for accessing the web elements
	
	

	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Rule 5: Provide Business Libraries - Framework developers idea
	//- generic method created using web elements present only in current page
	/**
	 * This method will login to application
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		UserNameTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}
	
	
	
	
	
}
