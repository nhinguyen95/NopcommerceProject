package nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

@Test
public class PageGeneratorManager_III extends BaseTest {
	private WebDriver driver;
	String existingEmailAddress, invalidEmailAddress, notFoundEmail, firstName, lastname, password;
	private HomePageObject homePage ;
	private RegisterPageObject registerPage ;
	private LoginPageObject loginPage ;
	private MyAccountPageObject myAccountPage ;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		homePage = PageGeneratorManager.getHomePageObject(driver);

		notFoundEmail = "AutoFC" + generateEmail();
		existingEmailAddress = "Nobita" + generateEmail();
		firstName = "Auto";
		lastname = "FC";
		password = "123456";
		invalidEmailAddress = "nhi@";

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(existingEmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();
	}

	public void Login_01_Empty_Data() {
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getErrorAtEmailTextbox(), "Please enter your email");
	}

	public void Login_02_Invalid_Email() {

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getErrorAtEmailTextbox(), "Wrong email");
	}

	public void Login_03_Email_Not_Found() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	public void Login_04_Existing_Email_Empty_Password() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmailAddress);
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	public void Login_05_Existing_Email_Incorrect_Password() {
		
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmailAddress);
		loginPage.clickToButtonLogin();
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}
	public void Login_06_Email_Correct_Password() {

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(existingEmailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonLogin();

	}
	
	@Test
	public void Login_06_My_AccountLink() {
		
		myAccountPage = homePage.clickToMyAccountLink();
		
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
