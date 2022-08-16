package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	public WebDriver driver;
	
	protected WebDriver getBrowerDriver(String browerName) {
		BrowserList browserList = BrowserList.valueOf(browerName.toUpperCase());
		
		if (browserList == browserList.FIREFOX) {
			System.out.println(browerName);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserList == browserList.CHROME) {
			System.out.println(browerName);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserList == browserList.EDGE) {
			System.out.println(browerName);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid !");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(GlobalConstants.USER_DEV_URL);
		return driver;
	}
	
	protected WebDriver getBrowerDriver(String browerName,String appURL)	{
		if (browerName.equals("firefox")) {
			System.out.println(browerName);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browerName.equals("chrome")) {
			System.out.println(browerName);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browerName.equals("edge")) {
			System.out.println(browerName);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser name invalid !");
		}
		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
		driver.get(appURL);
		return driver;
	}
	
	protected String getEnviromentURL(String serverName) {
		String envURL = null ;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envURL= "";
		}else if (environment == EnvironmentList.TEST){
			envURL= "";
		}
		return envURL;
	}
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.com";
	}
}
