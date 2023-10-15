package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPuzzlePage {


			// Variables - private
					@FindBy (xpath="//span[contains(text(),'Solve this')]")
					private WebElement text;
				
			 // Constructor - public
					
					public AmazonPuzzlePage(WebDriver driver) 
					{
						            //To find Element
						PageFactory.initElements(driver, this);
					}
				
				
		    //Methods - public

					public String getResponse()
					{
						String message=text.getText();
						
						return message;
					}
	

}
