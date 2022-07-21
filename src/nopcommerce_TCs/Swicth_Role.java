package nopcommerce_TCs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Admin.PageObjects.AdminDashboardPageObject;
import Admin.PageObjects.Admin_LoginPageObject;
import User.PageObjects.User_HomePageObject;
import User.PageObjects.User_LoginPageObject;
import User.PageObjects.User_RegisterPageObject;
import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;


public class Swicth_Role extends BaseTest {
	
		private WebDriver driver;
		String userEmailAddress, userFirstName, userLastname, userPassword,adminEmailAddress,adminPassword;
		private User_HomePageObject userHomePage;
		private User_RegisterPageObject userRegisterPage;
		private User_LoginPageObject userLoginPage;
		private Admin_LoginPageObject adminLoginPage;
		private AdminDashboardPageObject adminDashboardPage;
		
		@Parameters("browser")
		@BeforeClass
		public void BeforeClass(String browerName) {
			driver = getBrowerDriver(browerName);
			userHomePage = PageGeneratorManager.getHomePage(driver);
			userEmailAddress = "Tester" + generateEmail();
			userFirstName = "Auto";
			userLastname = "FC";
			userPassword = "123456";
			adminEmailAddress ="admin@yourstore.com";
			adminPassword ="admin";
		}
		@Test
		public void Login_01_Register_User() {
			userRegisterPage = userHomePage.clickToRegisterLink();
			userRegisterPage.inputToFirstNameTextbox(userFirstName);
			userRegisterPage.inputToLastNameTextbox(userLastname);
			userRegisterPage.inputToEmailTextbox(userEmailAddress);
			userRegisterPage.inputToPasswordTextbox(userPassword);
			userRegisterPage.inputToConfirmPasswordTextbox(userPassword);
			userRegisterPage.clickToRegisterButton();
			Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
			userHomePage = userRegisterPage.clickToLogoutLink();
		}
		
		@Test
		public void Role_01_User() {
			userLoginPage = userHomePage.openLoginPage();
			userLoginPage.loginAsUser(userEmailAddress, userPassword);
			Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		}
		
		@Test
		public void Role_02_Admin() {
          userHomePage.openPageUrL(driver,GlobalConstants.ADMIN_PAGE_URL);
          adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
          adminLoginPage.loginAsAdmin(adminEmailAddress,adminPassword);
          Assert.assertTrue(adminLoginPage.isAdminDashboardDisplayed());
		}

	}