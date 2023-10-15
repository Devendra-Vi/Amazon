package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.CreateNewAccountPage;
import pages.HomePage;

public class CreateAccountFunctionalityTestClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		HomePage homepage = new HomePage(driver);
		homepage.startHere();
		CreateNewAccountPage createNewAccountPage= new CreateNewAccountPage(driver);
		createNewAccountPage.sendFirstAndLastName();
		createNewAccountPage.sendMobileNumber();
		createNewAccountPage.sendEmail();
		createNewAccountPage.sendPassword();
		createNewAccountPage.continueButton();
	}

}
