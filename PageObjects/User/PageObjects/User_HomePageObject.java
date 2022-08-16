package User.PageObjects;

import org.openqa.selenium.WebDriver;

import User.nopcomerce.PageUIs.User_HomePageUl;
import common.BasePage;
import common.PageGeneratorManager;

public class User_HomePageObject extends BasePage {
	private WebDriver driver;

	public User_HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public User_RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, User_HomePageUl.REGISTER_LINK);
		clickToElement(driver, User_HomePageUl.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
		
	}

	public User_LoginPageObject openLoginPage() {
		waitForElementClickable(driver,User_HomePageUl.LOGIN_LINK);
		clickToElement(driver, User_HomePageUl.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, User_HomePageUl.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, User_HomePageUl.MY_ACCOUNT_LINK);
	}

	public User_MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, User_HomePageUl.MY_ACCOUNT_LINK);
		clickToElement(driver, User_HomePageUl.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserMyAccountPage(driver);
	}

	public User_CustomerInforPageObject opendMyAccountPage() {
		waitForElementClickable(driver, User_HomePageUl.MY_ACCOUNT_LINK);
		clickToElement(driver, User_HomePageUl.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}
}
