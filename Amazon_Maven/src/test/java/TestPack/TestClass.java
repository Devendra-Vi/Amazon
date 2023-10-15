package TestPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.HomePage;

public class TestClass {

	public static void main(String[] args) {
		WebDriver driver123 = new ChromeDriver();
		driver123.get("https://www.amazon.in/");
		
		HomePage homepage = new HomePage(driver123);
		
		homepage.signIN();


	}

}
