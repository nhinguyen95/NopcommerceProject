package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;

public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountPageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
