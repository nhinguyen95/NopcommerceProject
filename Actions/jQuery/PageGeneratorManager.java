package jQuery;

import org.openqa.selenium.WebDriver;

import pageObjects.jQuery.LoginPageObject;

public class PageGeneratorManager {
	public static LoginPageObject getHomePage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
