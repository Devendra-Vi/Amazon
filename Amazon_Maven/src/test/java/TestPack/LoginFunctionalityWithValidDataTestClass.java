package TestPack;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AmazonHeader;
import pages.AmazonPuzzlePage;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.PasswordPage;

public class LoginFunctionalityWithValidDataTestClass {

	
	public static void main(String[] args) throws InterruptedException   {
		
		WebDriver driver123 = new ChromeDriver();
		driver123.get("https://www.amazon.in/");
		AmazonHeader amazonHeader = new AmazonHeader(driver123);
		
		amazonHeader.signIn();
		LoginOrSignUpPage loginSignUpPage = new LoginOrSignUpPage(driver123);
		loginSignUpPage.sendUserName("devendravishvakarma786@gmail.com");
		loginSignUpPage.continueButton();
		PasswordPage passwordPage= new PasswordPage(driver123);
		passwordPage.sendPassword("starlord@10");
		passwordPage.clickSignInButton();
		Thread.sleep(10000);
		AmazonPuzzlePage amazonPuzzlePage =  new AmazonPuzzlePage(driver123);
		String msg=amazonPuzzlePage.getResponse();
		if(msg.equals("Solve this puzzle to protect your account")) 
		{
			System.out.println("Pass");
		}
		else 
		{
			System.out.println("fail");
		}
		

	}

}
