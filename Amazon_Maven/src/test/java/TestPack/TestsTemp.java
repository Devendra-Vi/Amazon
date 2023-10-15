package TestPack;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import modules.AddToCartPopUp;
import pages.AddToCartPage;
import pages.AmazonHeader;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.PasswordPage;
import pages.ProductInformationPage;

public class TestsTemp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		AmazonHeader amazonHeader = new AmazonHeader(driver);
		amazonHeader.searchProduct("mobile");
		amazonHeader.search();
		HomePage homePage = new HomePage(driver);
		Thread.sleep(5000);
		homePage.clickOnProduct();
		ArrayList<String> address =new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(address.get(1));
		ProductInformationPage productInformationPage =new ProductInformationPage(driver);
		productInformationPage.addToCartButton();
		AddToCartPopUp addToCartPopUp =new AddToCartPopUp(driver);
		addToCartPopUp.closeAddToCartPopUp();
		Thread.sleep(5000);
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("window.scrollBy(0,-100)");
		AmazonHeader amazonHeader1 = new AmazonHeader(driver);
		amazonHeader1.addToCartIcon();
		AddToCartPage addToCartToPage = new AddToCartPage(driver);
		String msg1=addToCartToPage.addedProductToTheCart();
		System.out.println(msg1);
		if(msg1.equals("realme narzo 50i Prime (Mint Green 4GB RAM+64GB Storage) Octa-core Processor |5000 mAh Battery")) 
		{
			addToCartToPage.selectProductQuantity();
			Thread.sleep(5000);
			String msg2 = addToCartToPage.warning();
			
			if(msg2.equals("Important messages for items in your Cart:")) 
			{
				System.out.println("You have to buy product using business account");
			}
			else 
			{
				System.out.println("You can buy");
			}
			
			addToCartToPage.deleteProduct();
			
		}
		else
		{
			System.out.println("Fail");
		}
		
	}

}
