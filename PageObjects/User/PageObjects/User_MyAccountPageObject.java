package User.PageObjects;

import org.openqa.selenium.WebDriver;

import User.nopcomerce.PageUIs.User_CustormerInforPageUIs;
import common.BasePage;

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
