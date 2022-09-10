package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.facebook.LoginObjectPage;

public class BaseTest {
	public WebDriver driver;
    protected final Log log;
    
    protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}

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

	protected WebDriver getBrowerDriver(String browerName, String appURL) {
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
		String envURL = null;
		EnvironmentList environment = EnvironmentList.valueOf(serverName.toUpperCase());
		if (environment == EnvironmentList.DEV) {
			envURL = "";
		} else if (environment == EnvironmentList.TEST) {
			envURL = "";
		}
		return envURL;
	}

	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.com";
	}

	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			System.out.println(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}
}
