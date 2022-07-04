package nopcommerce_TCs;

	import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

    public class Topic03_Page_Object {
		private WebDriver driver;
		String emailAddress,firstName, lastname,password ;
		private HomePageObject homePage = new HomePageObject(driver);
	    private	RegisterPageObject registerPage = new RegisterPageObject(driver);
		BasePage basePage;
		
	@BeforeClass
	public void BeforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		basePage = BasePage.getBasePageOject();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		emailAddress = "Nobita" + generateEmail();
		firstName = "Auto";
		lastname = "FC";
		password = "123456";
		
		homePage = new HomePageObject(driver);
		registerPage = new RegisterPageObject(driver);
		
	}
	
	public void TC_01_Register_Emty_Data() {
		homePage.clickToRegisterLink();
		registerPage.clickToRegisterButton();
		
		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(),"First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(),"Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(),"Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"Password is required.");
	}
	
	public void TC_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox("nhi@gm");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextboxExist(),"Wrong email");
		
	}
	@Test
	public void TC_03_Register_Valid_Information() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(),"Your registration completed");
		registerPage.clickToLogoutLink();
		
	}
	@Test
	public void TC_04_Register_Email_Already_Exists() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox("nhi@gmai.com");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextboxExist(),"The specified email already exists");
		
	}
	@Test
	public void TC_05_Register_Invalid_Password_Least_Characters() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),"Password must meet the following rules:\nmust have at least 6 characters");
	
	}
	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox("emailAddress");
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox("1233");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),"The password and confirmation password do not match.");
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.com";
	}
	}


