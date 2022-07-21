package nopcommerce_TCs;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import User.PageObjects.User_HomePageObject;
import User.PageObjects.User_LoginPageObject;
import User.PageObjects.User_RegisterPageObject;
import common.BasePage;
import common.BaseTest;

public class LoginUser extends BaseTest {
	private WebDriver testCaseDriver;
	String existingEmailAddress, invalidEmailAddress, notFoundEmail, firstName, lastname, password;
	private User_HomePageObject homePage = new User_HomePageObject(testCaseDriver);
	private User_RegisterPageObject registerPage = new User_RegisterPageObject(testCaseDriver);
	private User_LoginPageObject loginPage = new User_LoginPageObject(testCaseDriver);
	BasePage basePage;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		testCaseDriver = getBrowerDriver(browerName);
		basePage = BasePage.getBasePageOject();
		
		notFoundEmail = "AutoFC" + generateEmail();
		existingEmailAddress = "Nobita" + generateEmail();
		firstName = "Auto";
		lastname = "FC";
		password = "123456";
		invalidEmailAddress = "nhi@";

		System.out.print("Pre-Condition-Step 01: Click Register Link");
		homePage.clickToRegisterLink();
		registerPage = new User_RegisterPageObject(testCaseDriver);

		System.out.print("Pre-Condition-Step 02: Input to required fields");
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(existingEmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.print("Pre-Condition-Step 03: Click to register button");
		registerPage.clickToRegisterButton();

		System.out.print("Pre-Condition-Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.print("Pre-Condition-Step 05: Click to logout button");
		registerPage.clickToLogoutLink();
		homePage = new User_HomePageObject(testCaseDriver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 03: Verify error message email displayed");
		Assert.assertEquals(loginPage.getErrorAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 04: Input to required fields");
		loginPage.inputToEmailTextbox(invalidEmailAddress);
		loginPage.inputToPasswordTextbox(password);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 03: Verify error message email displayed");
		Assert.assertEquals(loginPage.getErrorAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Not_Found() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 04: Input to required fields");
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.inputToPasswordTextbox(password);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 03: Verify error message email displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 04: Input to required fields");
		loginPage.inputToEmailTextbox(existingEmailAddress);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 03: Verify error message password displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 04: Input to required fields");
		loginPage.inputToEmailTextbox(existingEmailAddress);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 03: Verify error message password displayed");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccesfull(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.print("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(testCaseDriver);

		System.out.print("Login_Step 04: Input to required fields");
		loginPage.inputToEmailTextbox(existingEmailAddress);
		loginPage.inputToPasswordTextbox(password);

		System.out.print("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.print("Login_Step 06: Verify myAccount link dispalyed");
		loginPage = new User_LoginPageObject(testCaseDriver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterClass
	public void afterClass() {
		testCaseDriver.close();
	}

	public String generateEmail() {
		Random rand = new Random();
		return rand.nextInt(9999) + "@mail.com";
	}
}