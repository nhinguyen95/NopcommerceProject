package nopcommerce_Users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.User_LoginPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;


public class Swicth_Role extends BaseTest {
	
		private WebDriver driver;
		String EmailAddress, firstName, lastname, password;
		private HomePageObject homePage;
		private RegisterPageObject registerPage;
		private User_LoginPageObject loginPage;

		@Parameters("browser")
		@BeforeClass
		public void BeforeClass(String browerName) {
			driver = getBrowerDriver(browerName);
			homePage = PageGeneratorManager.getHomePageObject(driver);
			EmailAddress = "Tester" + generateEmail();
			firstName = "Auto";
			lastname = "FC";
			password = "123456";

		}
		@Test
		public void Login_01_Register_User() {
			registerPage = homePage.clickToRegisterLink();
			registerPage.inputToFirstNameTextbox(firstName);
			registerPage.inputToLastNameTextbox(lastname);
			registerPage.inputToEmailTextbox(EmailAddress);
			registerPage.inputToPasswordTextbox(password);
			registerPage.inputToConfirmPasswordTextbox(password);
			registerPage.clickToRegisterButton();
			Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
			homePage = registerPage.clickToLogoutLink();
		}
		
		@Test
		public void Role_01_User() {
			loginPage = homePage.openLoginPage();
			loginPage.loginAsUser();
			loginPage.inputToEmailTextbox(EmailAddress);
			loginPage.inputToPasswordTextbox(password);
		    loginPage.clickToButtonLogin();
			Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		}


	}