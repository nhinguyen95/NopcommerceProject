package pageObjects;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUl.HomePageUls;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUls.REGISTER_LINK);
		clickToElement(driver, HomePageUls.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPageObject(driver);
		
	}

	public LoginPageObject clickToLoginLink() {
		waitForElementClickable(driver,HomePageUls.LOGIN_LINK);
		clickToElement(driver, HomePageUls.LOGIN_LINK);
		return PageGeneratorManager.getLoginPageObject(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUls.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUls.MY_ACCOUNT_LINK);
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, HomePageUls.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUls.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getMyAccountPageObject(driver);
	}
}
