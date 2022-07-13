package nopcommerce_Users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObjects.AddressPageObject;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.User_LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewPageOject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Swicth_Page extends BaseTest {
	private WebDriver driver;
	String EmailAddress, firstName, lastname, password;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private MyAccountPageObject myAccountPage;
	private AddressPageObject addressPage ;
	private MyProductReviewPageOject myProductReviewPage ;
	private RewardPointPageObject reviewPointPage ;
	private CustomerInforPageObject customerInforPage ;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		homePage = PageGeneratorManager.getHomePageObject(driver);
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