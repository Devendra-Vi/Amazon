package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

			// Variables - private
			@FindBy (xpath="//a[contains(@id,'add-new-address')]")
			private WebElement addNewAddressLink;
		
			// Constructor - public
			
			public CheckOutPage(WebDriver driver) 
			{
				            //To find Element
				PageFactory.initElements(driver, this);
			}
		
		
			//Methods - public

			public void addNewAddress()
			{
				addNewAddressLink.click();
			}
	
	
	 
}
