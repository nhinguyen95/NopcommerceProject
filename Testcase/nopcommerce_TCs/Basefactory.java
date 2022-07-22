package nopcommerce_TCs;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BaseObjectFactory.HomePageObject01;
import BaseObjectFactory.RegisterObject01;
import BasePageFactory.BasePageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basefactory extends BasePageFactory{
	private WebDriver driver;
	private HomePageObject01 HomePageObject01 = new HomePageObject01(driver);
    private	RegisterObject01 RegisterObject01 = new RegisterObject01(driver);
    BasePageFactory BasePageFactory;
	
@BeforeClass
public void BeforeClass() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	BasePageFactory = BasePageFactory.getBasePageFactory();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	HomePageObject01 = new HomePageObject01(driver);
	RegisterObject01 = new RegisterObject01(driver);

}

@Test
public void TC_01_Register_Emty_Data() {
	HomePageObject01.clickToRegisterLink();
	RegisterObject01.clickToRegisterButton();
	Assert.assertEquals(RegisterObject01.getErrorMessageAtFirstnameTextbox(),"First name is required.");
	Assert.assertEquals(RegisterObject01.getErrorMessageAtLastnameTextbox(),"Last name is required.");
	Assert.assertEquals(RegisterObject01.getErrorMessageAtEmailTextbox(),"Email is required.");
	Assert.assertEquals(RegisterObject01.getErrorMessageAtPasswordTextbox(),"Password is required.");
	Assert.assertEquals(RegisterObject01.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
}
}
