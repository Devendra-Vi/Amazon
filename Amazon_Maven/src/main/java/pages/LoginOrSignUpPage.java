package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignUpPage {
	// Variables - private
	@FindBy (xpath="//input[@id='ap_email']") 
	private WebElement userName;
	
	
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continueButton;
	
	@FindBy (xpath="//a[@id='createAccountSubmit']")
	private WebElement createNewAccountButton;
	
	@FindBy (xpath="//span[@class='a-list-item']")
	private WebElement text;
	
	@FindBy (xpath="//h1")
	private WebElement alertToSignIn;
	
	// Constructor - public
	
	public LoginOrSignUpPage(WebDriver driver) 
	{
		            //To find Element
		PageFactory.initElements(driver, this);
	}
	//Methods - public

	public void sendUserName(String user)
	{
		userName.sendKeys(user);
	}
	
	public void continueButton()
	{
		continueButton.click();
	} 
	
	public void createAccountButton()
	{
		createNewAccountButton.click();
	}
	public String getText()
	{
		String message=text.getText();
		
		return message;
	}
	public String alertMessageToSignIn()
	{
		return alertToSignIn.getText();
	}

}
