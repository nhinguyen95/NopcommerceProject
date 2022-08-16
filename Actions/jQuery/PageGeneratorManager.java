package jQuery;

import org.openqa.selenium.WebDriver;

import jQuery.PageObjects.HomePageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
}
