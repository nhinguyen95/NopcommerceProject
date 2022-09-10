package common;

import org.openqa.selenium.WebDriver;

import pageObjects.nopcommerce.Admin.AdminDashboardPageObject;
import pageObjects.nopcommerce.Admin.Admin_LoginPageObject;
import pageObjects.nopcommerce.User.User_AddressPageObject;
import pageObjects.nopcommerce.User.User_CustomerInforPageObject;
import pageObjects.nopcommerce.User.User_HomePageObject;
import pageObjects.nopcommerce.User.User_LoginPageObject;
import pageObjects.nopcommerce.User.User_MyAccountPageObject;
import pageObjects.nopcommerce.User.User_MyProductReviewPageOject;
import pageObjects.nopcommerce.User.User_RegisterPageObject;
import pageObjects.nopcommerce.User.User_RewardPointPageObject;

public class PageGeneratorManager {
	public static User_HomePageObject getUserHomePage(WebDriver driver) {
		return new User_HomePageObject(driver);
	}

	public static User_LoginPageObject getUserLoginPageObject(WebDriver driver) {
		return new User_LoginPageObject(driver);
	}

	public static User_RegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new User_RegisterPageObject(driver);
	}
	public static User_MyAccountPageObject getUserMyAccountPage(WebDriver driver) {
		return new User_MyAccountPageObject(driver);
	}

	public static User_AddressPageObject getUserAddressPage(WebDriver driver) {
		return new User_AddressPageObject(driver);
	}
	
	public static User_MyProductReviewPageOject getUserMyProductReviewPage(WebDriver driver) {
		return new User_MyProductReviewPageOject(driver);
	}
	
	public static User_RewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new User_RewardPointPageObject(driver);
	}
	
	public static User_CustomerInforPageObject getUserCustomerInforPage(WebDriver driver) {
		return new User_CustomerInforPageObject(driver);
	}
	
	public static Admin_LoginPageObject getAdminLoginPage(WebDriver driver) {
		return new Admin_LoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
}
