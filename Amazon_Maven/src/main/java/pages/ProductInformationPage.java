package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	
				// Variables - private
				@FindBy (xpath="//input[@id='add-to-cart-button']")
				private WebElement addToCartButton;
				
				private WebDriver driver;
				// Constructor - public
				
				public ProductInformationPage(WebDriver driver) 
				{
					            //To find Element
					PageFactory.initElements(driver, this);
					this.driver=driver;
				}
			
			
				//Methods - public

				public void addToCartButton()
				{
					JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",addToCartButton);
					javascriptExecutor.executeScript("window.scrollBy(0,-150)");
					addToCartButton.click();
				}
	
	
	
	
	
	
	
}
