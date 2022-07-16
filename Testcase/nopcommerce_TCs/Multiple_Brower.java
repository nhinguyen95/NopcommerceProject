package nopcommerce_TCs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import User.PageObjects.User_HomePageObject;
import User.PageObjects.User_LoginPageObject;
import common.BasePage;
import common.BaseTest;

public class Multiple_Brower extends BaseTest {
	private WebDriver driver;
	private User_HomePageObject homePage;
	private User_LoginPageObject loginPage;
	BasePage basePage;

	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browerName) {
		driver = getBrowerDriver(browerName);
		basePage = BasePage.getBasePageOject();
		homePage = new User_HomePageObject(driver);
		loginPage = new User_LoginPageObject(driver);
	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login_Step 01: Click Logout Link");
		homePage.openLoginPage();
		loginPage = new User_LoginPageObject(driver);

		System.out.println("Login_Step 02: Click button Login");
		loginPage.clickToButtonLogin();

		System.out.println("Login_Step 03: Verify error message email displayed");
		Assert.assertEquals(loginPage.getErrorAtEmailTextbox(), "Please enter your email");
	}

	@AfterClass
	public void afterClass() {
	driver.close();
	}

}
