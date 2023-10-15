package TestPack;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import modules.AddToCartPopUp;
import pages.AddToCartPage;
import pages.AmazonHeader;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.ProductInformationPage;

public class AddToCartAndBuyProductTestClass extends Browser {

			private WebDriver driver;
			private AmazonHeader amazonHeader;
			private HomePage homePage ;
			private ProductInformationPage productInformationPage;
			private  AddToCartPopUp addToCartPopUp;
			private AmazonHeader amazonHeader1;
			private AddToCartPage addToCartToPage;
			private LoginOrSignUpPage loginOrSignUpPage;
			
			
			@Parameters("browser")
			@BeforeTest
			public void launchTheBrowser(String browserName) 
			{
				if(browserName.equals("Chrome")) 
				{
					driver = launchChrome();
				}
				if(browserName.equals("FireFox"))
				{
					driver = launchFirefox();
				}
				
				if(browserName.equals("Edge"))
				{
					driver = launchEdge();
				}
				
				driver.manage().window().maximize();
			}
			
			@BeforeClass
			public  void POMcreation()
			{
				 amazonHeader = new AmazonHeader(driver);
				  homePage = new HomePage(driver);
				  productInformationPage =new ProductInformationPage(driver);
				   addToCartPopUp =new AddToCartPopUp(driver);
				   amazonHeader1 = new AmazonHeader(driver);
				    addToCartToPage = new AddToCartPage(driver);
				    loginOrSignUpPage = new LoginOrSignUpPage(driver);
			}
			
			@BeforeMethod
		
			public void beforeMethod() throws InterruptedException
			{
				driver.get("https://www.amazon.in/");
				
				amazonHeader.searchProduct("realme narzo 50i Prime");
				amazonHeader.search();
				
				
				homePage.clickOnProduct();
				ArrayList<String> address =new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(address.get(1));
				
				productInformationPage.addToCartButton();
				
				addToCartPopUp.closeAddToCartPopUp();
				Thread.sleep(5000);
				JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
				javascriptExecutor.executeScript("window.scrollBy(0,-100)");
				
				amazonHeader1.addToCartIcon();
				
				
				
			}
			
		
			 
			
			@Test (priority=1)
		
			public void test1() throws InterruptedException
			{
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				String actual1=addToCartToPage.addedProductToTheCart();
				String expected1="realme narzo 50i Prime (Mint Green 4GB RAM+64GB Storage) Octa-core Processor |5000 mAh Battery";
				Assert.assertEquals(actual1, expected1);
				
				addToCartToPage.selectProductQuantity();
				String actual2 = addToCartToPage.quantity();
				String expected2="2";
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertEquals(actual2, expected2);
				
				addToCartToPage.deleteProduct();
				
				driver.close();
				ArrayList<String> address =new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(address.get(0));
			}
				
			
			
			
			@Test (priority=2)
			
			public void test2() 
			{
				
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				addToCartToPage.proceedToBuy();
				
				String actual=loginOrSignUpPage.alertMessageToSignIn();
				System.out.println(actual);
				String expected="Sign in";
				Assert.assertEquals(actual, expected);
				
			
			}
			
		
		
			
			@AfterClass
		
			public void clearObject() throws InterruptedException
		
			{
				 amazonHeader = null;
				  homePage = null;
				  productInformationPage =null;
				   addToCartPopUp =null;
				   amazonHeader1 = null;
				    addToCartToPage = null;
				    loginOrSignUpPage =null;
		
			}
			
			@AfterTest
			public void closeTheBrowser()
			{
				driver.quit();
				driver=null;
				System.gc();
			}
		














}
