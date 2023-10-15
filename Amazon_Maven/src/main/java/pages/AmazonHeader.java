package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHeader {

	
	
	// Variables - private
	@FindBy (xpath="//span[@id='nav-cart-count']")
	private WebElement addToCart;
	
	
	@FindBy (xpath="//span[contains(text(),'Account & Lists')]")
	private WebElement accountAndList;
	
	@FindBy (xpath="//a[text()='Start here.']")
	private WebElement startHereLink;
	
	@FindBy (xpath="//span[text()='Sign in']")
	private WebElement signInButton;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;
	
	@FindBy (xpath="//input[@id='nav-search-submit-button']")
	private WebElement searchButton;
	
	WebDriver driver ;

	// Constructor - public
	
	public AmazonHeader(WebDriver driver) 
	{
		            //To find Element
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	//Methods - public

	public void addToCartIcon()
	{
		
		
		addToCart.click();
	}
	
	public void searchProduct(String productName) 
	{
		 searchBox.sendKeys(productName);
		
	}
	
	public void search()
	{
		searchButton.click();
	}
	
	public void signIn() 
	{	
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		Actions action=new Actions(driver);
		action.moveToElement(accountAndList).perform();
		wait.until(ExpectedConditions.visibilityOf(signInButton));
		
		
		action.moveToElement(signInButton).click().perform();
		
		
	}
	
	public void startHere() 
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Actions actions=new Actions(driver);
		actions.moveToElement(accountAndList).perform();
		wait.until(ExpectedConditions.visibilityOf(startHereLink));
		
		actions.moveToElement(startHereLink).click().perform();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
