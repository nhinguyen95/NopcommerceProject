package pageObjects;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUl.HomePageUls;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplayed() {
		waitForElementClickable(driver,HomePageUls.MY_ACCOUNT_LINK);
		clickToElement(driver,HomePageUls.MY_ACCOUNT_LINK);
		return false;
	}

}
