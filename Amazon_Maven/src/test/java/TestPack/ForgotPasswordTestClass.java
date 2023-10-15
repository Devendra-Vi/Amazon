package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.PasswordPage;

public class ForgotPasswordTestClass {

	public static void main(String[] args) {
		WebDriver driver123 = new ChromeDriver();
		driver123.get("https://www.amazon.in/");
		HomePage homepage = new HomePage(driver123);
		
		homepage.signIn();
		LoginOrSignUpPage loginSignUpPage = new LoginOrSignUpPage(driver123);
		loginSignUpPage.sendUserName("devendravishvakarma786@gmail.com");
		loginSignUpPage.continueButton();
		PasswordPage passwordPage= new PasswordPage(driver123);
		passwordPage.sendPassword("tuayuay");
		passwordPage.clickSignInButton();
		String msg=passwordPage.getText();
		if(msg.equals("Your password is incorrect")) 
		{
			
			passwordPage.forgotPassword();
			ForgotPasswordPage forgotPasswordPage=new ForgotPasswordPage(driver123);
			
			forgotPasswordPage.sendEmail("devendravishvakarma786@gmail.com");
			forgotPasswordPage.continueButton();
			
		
		}
		else
		{
			System.out.println("passwordok");
		}
	}

}
