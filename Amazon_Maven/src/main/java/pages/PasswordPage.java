package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	
	// Variables - private
	
		@FindBy (xpath="//input[@type='password']")
		private WebElement password;
	
		@FindBy (xpath="//input[@id='signInSubmit']")
		private WebElement signInButton;
		
		@FindBy (xpath="//a[contains(text(),'Forgot Password')]")
		private WebElement forgotPasswordLink;
		
		@FindBy (xpath="//span[@class='a-list-item']")
		private WebElement text;
		
		@FindBy (xpath="//span[@class='a-list-item']")
		private WebElement incorrectPasswordWarningMessage;
		
	
		// Constructor - public
		
		public PasswordPage(WebDriver driver) 
		{
			            //To find Element
			PageFactory.initElements(driver, this);
		}
		//Methods - public
		
		public void sendPassword(String pass)
		{
			password.sendKeys(pass);
		}
		
		public void clickSignInButton()
		{
			signInButton.click();
		}
		
		public String getWarningMessage()
		{
			return incorrectPasswordWarningMessage.getText();
			
		}
		public void forgotPassword() 
		{
			forgotPasswordLink.click();
		}
		
		public String getText() 
		{
			String msg = text.getText();
			return msg;
		}
	
	
		
		
	
	
	
	
	
}
