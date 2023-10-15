package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {
	
		// Variables - private
		@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
		private WebElement ProceedToBuyButton;
		
		@FindBy (xpath="//span[@id=\"a-autoid-0-announce\"]")
		private WebElement toSelectQuantity;
		
		@FindBy (xpath="//span[@class='a-truncate-cut']")
		private WebElement addedProductTotheCart;
		
		@FindBy (xpath="//input[@value='Delete']")
		private WebElement delete ;
		
		@FindBy (xpath="//span[text()='Qty:']")
		private WebElement second ;
		
		@FindBy (xpath="//span[@class='a-dropdown-prompt']")
		private WebElement quantityMessage ;
		
		private WebDriver driver;
		
		
		
		// Constructor - public
		
		public AddToCartPage(WebDriver driver) 
		{
			            //To find Element
			PageFactory.initElements(driver, this);
			this.driver=driver;
		}
	
	
		//Methods - public

		public void proceedToBuy()
		{
			ProceedToBuyButton.click();
		}
		
		public String addedProductToTheCart()
		{
			return addedProductTotheCart.getText();
		}
		
		public void selectProductQuantity()
		
		{
			WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
			Actions actions =new Actions (driver);
			actions.moveToElement(toSelectQuantity).click().perform();
			wait.until(ExpectedConditions.visibilityOf(second));
			actions.moveToElement(second).click().perform();
			
			
		}
		
		public void deleteProduct() 
		{
			
			delete.click();
		}
		
		public String quantity ()
		{
			 return quantityMessage.getText();
		}
		
		
		
		
	
		
	
	
}
