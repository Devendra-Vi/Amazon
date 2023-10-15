package modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewAddressForm {

	
			// Variables - private
			@FindBy (xpath="(//span[@class='a-button-text a-declarative'])[1]")
			private WebElement countryDropdown;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement fullNameBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement StreetNumberBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement apartmmentBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement cityBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement stateBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement pinCodeBox;
			
			@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
			private WebElement phoneNumberBox;
		
			// Constructor - public
			
			public AddNewAddressForm(WebDriver driver) 
			{
				            //To find Element
				PageFactory.initElements(driver, this);
			}
		
		
			//Methods - public

			public void country()
			{
				countryDropdown.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void fullName()
			{
				fullNameBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void StreetNumbe()
			{
				StreetNumberBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void apartmment()
			{
				apartmmentBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void city()
			{
				cityBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			
			public void state()
			{
				stateBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void pinCode()
			{
				pinCodeBox.sendKeys("devendravishvakarma786@gmail.com");
			}
			
			public void phoneNumber()
			{
				phoneNumberBox.sendKeys("devendravishvakarma786@gmail.com");
			}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//input[contains(@id,'address-ui-widgets-e')]
	//span[@class='a-button-text a-declarative']
	
	
	
	
	
}
