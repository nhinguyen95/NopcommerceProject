package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcomerce.User.User_CustormerInforPageUIs;

public class User_MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public User_MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
	waitForElementVisible(driver, User_CustormerInforPageUIs.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, User_CustormerInforPageUIs.CUSTOMER_INFOR_HEADER);
	}

}
