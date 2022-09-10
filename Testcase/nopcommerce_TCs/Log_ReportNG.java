package nopcommerce_TCs;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import common.PageGeneratorManager;
import pageObjects.nopcommerce.User.User_HomePageObject;
import pageObjects.nopcommerce.User.User_LoginPageObject;
import pageObjects.nopcommerce.User.User_MyAccountPageObject;
import pageObjects.nopcommerce.User.User_RegisterPageObject;

public class Log_ReportNG extends BaseTest {
	private WebDriver driver;
	String EmailAddress, firstName, lastname, password;
	private User_HomePageObject homePage;
	private User_RegisterPageObject registerPage;
	private User_LoginPageObject loginPage;
	private User_MyAccountPageObject myAccountPage;

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
	public void Login_01_Register_User() {
		log.info("Register-Step 01: Navigate to 'Register' Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register-Step 02: Enter to FirtName textbox with value is '" + firstName + "'" );
		registerPage.inputToFirstNameTextbox(firstName);
		log.info("Register-Step 03: Enter to LastName textbox with value is '" + lastname + "'" );
		registerPage.inputToLastNameTextbox(lastname);
		log.info("Register-Step 04: Enter to EmailAddress textbox with value is '" + EmailAddress + "'" );
		registerPage.inputToEmailTextbox(EmailAddress);
		log.info("Register-Step 05: Enter to Password textbox with value is '" + password + "'" );
		registerPage.inputToPasswordTextbox(password);
		log.info("Register-Step 06: Enter to ConfirmPassword textbox with value is '" + password + "'" );
		registerPage.inputToConfirmPasswordTextbox(password);
		log.info("Register-Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register-Step 08: Verify Register success mesage is display");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		log.info("Register-Step 09: Click to LogOut Link");
		homePage = registerPage.clickToLogoutLink();
	}
	
	@Test
	public void Login_02_Login_User() {
	log.info("Login-Step 01: Navigate to 'login' Page");
	loginPage = homePage.openLoginPage();
	log.info("Login-Step 02: Enter to EmailAddress textbox with value is '" + EmailAddress + "'" );
	loginPage.inputToEmailTextbox(EmailAddress);
	log.info("Login-Step 03: Enter to Password textbox with value is '" + password + "'" );
	loginPage.inputToPasswordTextbox(password);
	log.info("Login-Step 04: Click to LogOut Link");
	loginPage.clickToButtonLogin();
	
	log.info("Login-Step 05: Verify 'MyAccount Link' is display");
	verifyTrue(homePage.isMyAccountLinkDisplayed());
	
	log.info("Login-Step 06: Click to my Account Link");
	myAccountPage = homePage.clickToMyAccountLink();
	
	log.info("Login-Step 07: Verify 'CustomerInfor' page is display");
	verifyTrue(myAccountPage.isCustomerInforPageDisplayed());
}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}