package nopcommerce_TCs;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopcommerce.User.User_AddressPageObject;
import pageObjects.nopcommerce.User.User_CustomerInforPageObject;
import pageObjects.nopcommerce.User.User_HomePageObject;
import pageObjects.nopcommerce.User.User_LoginPageObject;
import pageObjects.nopcommerce.User.User_MyAccountPageObject;
import pageObjects.nopcommerce.User.User_MyProductReviewPageOject;
import pageObjects.nopcommerce.User.User_RegisterPageObject;
import pageObjects.nopcommerce.User.User_RewardPointPageObject;

public class Dynamic_Locator extends BaseTest {
	private WebDriver driver;
	String EmailAddress, firstName, lastname, password;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private User_MyAccountPageObject myAccountPage;
	private User_AddressPageObject addressPage;
	private User_MyProductReviewPageOject myProductReviewPage;
	private User_RewardPointPageObject rewardPointPage;
	private User_CustomerInforPageObject customerInforPage;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		driver.getWindowHandles().size();
		EmailAddress = "Tester" + generateEmail();
		firstName = "Auto";
		lastname = "FC";
		password = "123456";

	}

	@Test
	public void Login_01_Register_And_Login_User() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.inputToFirstNameTextbox(firstName);
		registerPage.inputToLastNameTextbox(lastname);
		registerPage.inputToEmailTextbox(EmailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickToLogoutLink();

		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(EmailAddress);
		loginPage.inputToPasswordTextbox(password);
		loginPage.clickToButtonLogin();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		myAccountPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(myAccountPage.isCustomerInforPageDisplayed());
	}

	public void Lv01_Switch_Page() {
		addressPage = myAccountPage.opendAddressPage(driver);
		myProductReviewPage = addressPage.opendMyProductReviewPage(driver);
		rewardPointPage = myProductReviewPage.opendRewardPointPage(driver);
		customerInforPage = rewardPointPage.opendCustomerInforPage(driver);
	}

	@Test
	public void Lv02_Dynamic_Page_01() {
		customerInforPage = (User_CustomerInforPageObject) myAccountPage.openPagesAtMyAccountByName(driver,"Customer info");
		myProductReviewPage = (User_MyProductReviewPageOject) customerInforPage.openPagesAtMyAccountByName(driver,"My product reviews");
		addressPage = (User_AddressPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Addresses");
		customerInforPage = (User_CustomerInforPageObject) addressPage.openPagesAtMyAccountByName(driver,"Customer info");
	}

	public void Lv03_Dynamic_Page_02() {
		myAccountPage.openPagesAtMyAccountByName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getUserCustomerInforPage(driver);

		customerInforPage.openPagesAtMyAccountByNameII(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);

		rewardPointPage.openPagesAtMyAccountByNameII(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}