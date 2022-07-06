package pageObjects;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUl.CustormerInforPageUIs;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInforPageDisplayed() {
	waitForElementVisible(driver, CustormerInforPageUIs.CUSTOMER_INFOR_HEADER);
		return isElementDisplayed(driver, CustormerInforPageUIs.CUSTOMER_INFOR_HEADER);
	}

}
