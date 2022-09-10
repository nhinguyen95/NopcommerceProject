package faceBook;

import org.openqa.selenium.WebDriver;
import pageObjects.facebook.LoginObjectPage;

public class PageGeneratorManager  {
	public static LoginObjectPage getLoginPage(WebDriver driver) {
		return new LoginObjectPage(driver);
	}
}
