package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	private WebDriver BaseTestDriver;
	protected WebDriver getBrowerDriver(String browerName) {
		if (browerName.equals("firefox")) {
			System.out.println(browerName);
			WebDriverManager.firefoxdriver().setup();
			BaseTestDriver = new FirefoxDriver();
		} else if (browerName.equals("chrome")) {
			System.out.println(browerName);
			WebDriverManager.chromedriver().setup();
			BaseTestDriver = new ChromeDriver();
		} else if (browerName.equals("edge")) {
			System.out.println(browerName);
			WebDriverManager.edgedriver().setup();
			BaseTestDriver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid !");
		}
		
		BaseTestDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BaseTestDriver.get("https://demo.nopcommerce.com/");
		return BaseTestDriver;
	}
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.com";
	}
}
