package TestPack;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.Utility;
import base.Browser;
import pages.AmazonHeader;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.PasswordPage;

public class Login extends Browser{
	
	private  WebDriver driver ;
	private  LoginOrSignUpPage loginOrSignUpPage;
	private  PasswordPage passwordPage;
	private String testID;
	
	
	//BeforeClass annotation runs only one time 
	//and we have to Create objects only once
	@Parameters("browser")
	@BeforeTest
	public  void launchBrowser(String browserName)
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
	public  void creatingPOMObject()
	{
		loginOrSignUpPage = new LoginOrSignUpPage(driver);
		passwordPage = new PasswordPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@BeforeMethod
	public void openLoginPage()
	{
		driver.get("https://www.amazon.in/");
		AmazonHeader amazonHeader = new AmazonHeader(driver);
		
		amazonHeader.signIn();
	}

	@Test (priority=1)
	public void withValidCredential() throws InterruptedException
	{
		testID ="T101";
		loginOrSignUpPage.sendUserName("devendravishvakarma786@gmail.com");
		loginOrSignUpPage.continueButton();
		 
		passwordPage.sendPassword("starlord@10");
		passwordPage.clickSignInButton();
		Thread.sleep(3000);
		String actual =driver.getCurrentUrl();
		String expected="https://www.amazon.in/?ref_=nav_ya_signin";
		Assert.assertEquals(actual, expected);
	} 
	
	@Test (priority=2)
	public void withValidEmailAndWrongPassword() throws InterruptedException
	{
		testID ="T102";
		loginOrSignUpPage.sendUserName("devendravishvakarma786@gmail.com");
		loginOrSignUpPage.continueButton();
		
		passwordPage.sendPassword("starlord");
		passwordPage.clickSignInButton();
		Thread.sleep(3000);
		String actual =driver.getCurrentUrl();
		String expected="https://www.amazon.in/ap/signin";
		Assert.assertEquals(actual, expected);
	}
	
	@Test (priority=3)
	public void withInValidEmail() 
	{
		testID ="T103";
		loginOrSignUpPage.sendUserName("dhsjhdjshd@gmail.com");
		loginOrSignUpPage.continueButton();
		String actual =driver.getCurrentUrl();
		System.out.println(actual);
		String expected="https://www.amazon.in/ap/signin";
		Assert.assertEquals(actual, expected);
	
	}
	
	@AfterMethod
	public void takeFailedScreenshotOrLOgout(ITestResult result) throws IOException 
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 if(ITestResult.FAILURE == result.getStatus())
		 {
			 Utility.captureScreenshot(testID);
		 }
	
	}
	
	
	@AfterClass
	public void clearObject() 
	{
		loginOrSignUpPage =null;
		passwordPage =null;
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc(); //inside gc method finalized method automatic will be called 
	}








}
