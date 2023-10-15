package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	
	// Variables - private
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement emailIdOrPassword;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continueButton;

	// Constructor - public
	
	public ForgotPasswordPage(WebDriver driver) 
	{
		            //To find Element
		PageFactory.initElements(driver, this);
	}


	//Methods - public

	public void sendEmail(String user)
	{	emailIdOrPassword.clear();
		emailIdOrPassword.sendKeys(user);
		
	}
	
	
	
	public void continueButton()
	{
		continueButton.click();
	}

}
