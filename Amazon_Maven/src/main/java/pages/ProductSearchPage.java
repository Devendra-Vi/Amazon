package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchPage {

	// Variables - private
	@FindBy (xpath="//span[contains(text(),'realme narzo 50i Prime ')]")
	private WebElement product;

	// Constructor - public
	
	public ProductSearchPage(WebDriver driver) 
	{
		            //To find Element
		PageFactory.initElements(driver, this);
	}


	//Methods - public

	public void product()
	{
		product.click();
	}

	
	
	
	
	
}
