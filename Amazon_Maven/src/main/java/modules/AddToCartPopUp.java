package modules;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPopUp {

	
	// Variables - private
				@FindBy (xpath="//a[@id='attach-close_sideSheet-link']")
				private WebElement closeButtton;
				
				private WebDriver driver;
			
				// Constructor - public
				
				public AddToCartPopUp(WebDriver driver) 
				{
					            //To find Element
					PageFactory.initElements(driver, this);
					this.driver=driver;
				}
			
			
				//Methods - public

				public void closeAddToCartPopUp()
				{
					WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
					wait.until(ExpectedConditions.visibilityOf(closeButtton));
					closeButtton.click();
				}
	
	
	
}
