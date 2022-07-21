package nopcommerce_TCs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import User.PageObjects.User_AddressPageObject;
import User.PageObjects.User_CustomerInforPageObject;
import User.PageObjects.User_HomePageObject;
import User.PageObjects.User_LoginPageObject;
import User.PageObjects.User_MyAccountPageObject;
import User.PageObjects.User_MyProductReviewPageOject;
import User.PageObjects.User_RegisterPageObject;
import User.PageObjects.User_RewardPointPageObject;
import common.BaseTest;
import common.PageGeneratorManager;

public class Swicth_Page extends BaseTest {
	private WebDriver driver;
	String EmailAddress, firstName, lastname, password;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private User_MyAccountPageObject myAccountPage;
	private User_AddressPageObject addressPage ;
	private User_MyProductReviewPageOject myProductReviewPage ;
	private User_RewardPointPageObject reviewPointPage ;
	private User_CustomerInforPageObject customerInforPage ;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		homePage = PageGeneratorManager.getHomePage(driver);
         driver.getWindowHandles().size();
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
	public void Login_User() {
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(EmailAddress);
		loginPage.inputToPasswordTextbox(password);
	    loginPage.clickToButtonLogin();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void My_Account() {
		myAccountPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(myAccountPage.isCustomerInforPageDisplayed());
	}
	
	@Test
	public void Switch_Page() {
	    addressPage = myAccountPage.opendAddressPage(driver);
		myProductReviewPage = addressPage.opendMyProductReviewPage(driver);
		reviewPointPage = myProductReviewPage.opendRewardPointPage(driver);
		customerInforPage = reviewPointPage.opendCustomerInforPage(driver);
	}


}