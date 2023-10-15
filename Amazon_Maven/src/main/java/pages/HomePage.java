package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

				// Variables - private
				
				
				
				@FindBy (xpath="(//span[contains(text(),'realme narzo 50i Prime')])[3]")
				private WebElement product;
				
				
				
				
				
				
				
				private WebDriver driver;
				
				// Constructor - public
								
				public HomePage(WebDriver driver) 
				{
					            //To find Element
					PageFactory.initElements(driver, this);
					this.driver=driver;
				
				}
			
			
				//Methods - public
				
				public void clickOnProduct() 
				{	
					JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
					javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)",product);
					javascriptExecutor.executeScript("window.scrollBy(0,-150)");
					product.click();
				
				}
				
			
				
				
				
				
				
			
		

	
	

}
