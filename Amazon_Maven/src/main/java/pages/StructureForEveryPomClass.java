package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StructureForEveryPomClass {

			// Variables - private
			@FindBy (xpath="")
			private WebElement webElementName;
		
			// Constructor - public
			
			public StructureForEveryPomClass(WebDriver driver) 
			{
				            //To find Element
				PageFactory.initElements(driver, this);
			}
		
		
			//Methods - public

			public void webElementNameMethod()
			{
				webElementName.click();
			}










}
