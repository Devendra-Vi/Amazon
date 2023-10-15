package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {

	//Variables - Private
	
	@FindBy (xpath="//input[@id='ap_customer_name']")
	private WebElement yourFirstAndLastName ;
	
	@FindBy (xpath="//input[@id='ap_phone_number']")
	private WebElement MobileNumber ;
	
	@FindBy (xpath="//input[@id='ap_email']")
	private WebElement Email ;
	
	@FindBy (xpath="//input[@id='ap_password']")
	private WebElement Password ;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement ContinueButton ;
	
	
	
	

	//Constructor - Public
	public CreateNewAccountPage (WebDriver driver) 
	{
		            //To find Element
		PageFactory.initElements(driver, this);
		
	}
	//Methods - Public

	public void sendFirstAndLastName()
	{
		yourFirstAndLastName.sendKeys("Devendra Vishvakarma");
	}
	
	public void sendMobileNumber()
	{
		MobileNumber.sendKeys("Devendra Vishvakarma");
	}
	
	public void sendEmail()
	{
		Email.sendKeys("Devendra Vishvakarma");
	}
	
	public void sendPassword()
	{
		Password.sendKeys("Devendra Vishvakarma");
	}
	
	public void continueButton()
	{
		ContinueButton.click();
	}
	
	














}
