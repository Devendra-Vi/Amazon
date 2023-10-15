package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;
import pages.LoginOrSignUpPage;
import pages.PasswordPage;

public class LoginFunctionalityWithInvalidDataTestClass {

	public static void main(String[] args) {
		WebDriver driver123 = new ChromeDriver();
		driver123.get("https://www.amazon.in/");
		HomePage homepage = new HomePage(driver123);
		
		homepage.signIn();
		LoginOrSignUpPage loginSignUpPage = new LoginOrSignUpPage(driver123);
		loginSignUpPage.sendUserName("devendravishvakarma786@gmail.com");
		loginSignUpPage.continueButton();
		PasswordPage passwordPage = new PasswordPage(driver123);
		passwordPage.sendPassword("tytdysds");
		passwordPage.clickSignInButton();
		String message =passwordPage.getText()
		System.out.println(message);
		
	}

}
