package nopcommerce_TCs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalConstants;
import common.PageGeneratorManager;
import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.Admin_LoginPageObject;
import pageObjects.nopcommerce.User.User_CustomerInforPageObject;
import pageObjects.nopcommerce.User.User_HomePageObject;
import pageObjects.nopcommerce.User.User_LoginPageObject;
import pageObjects.nopcommerce.User.User_RegisterPageObject;

public class Swicth_Role extends BaseTest {

	private WebDriver driver;
	String userEmailAddress, userFirstName, userLastname, userPassword, adminEmailAddress, adminPassword;
	private User_HomePageObject userHomePage;
	private User_RegisterPageObject userRegisterPage;
	private User_LoginPageObject userLoginPage;
	private Admin_LoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private User_CustomerInforPageObject userCustomerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		userEmailAddress = "Tester" + generateEmail();
		userFirstName = "Auto";
		userLastname = "FC";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";
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
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userCustomerInforPage = userHomePage.opendMyAccountPage();
		userHomePage = userCustomerInforPage.clickToLogOutLinkAtUserPage(driver);
		
		userHomePage.openPageUrL(driver, GlobalConstants.ADMIN_DEV_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminLoginPage.isAdminDashboardDisplayed());
		
		//dòng này đang lỗi null pointer
		adminLoginPage = adminDashboardPage.clickToLogOutLinkAtAdminPage(driver);
		
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUrL(driver, GlobalConstants.USER_DEV_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}