package Admin.PageObjects;

import org.openqa.selenium.WebDriver;

import Admin.nopcomerce.PageUIs.AdminDashboardPageUI;
import Admin.nopcomerce.PageUIs.AdminLoginPageUI;
import common.BasePage;
import common.PageGeneratorManager;

public class Admin_LoginPageObject extends BasePage{
	private WebDriver driver;

	public Admin_LoginPageObject (WebDriver driver) {
		this.driver = driver;
}

	public void inputToEmailTextBox(String adminEmailAddress) {
		  waitAllElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
	      sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmailAddress);
		
	}

	public void inputToPasswordTextBox(String adminPassword) {
		 waitAllElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
	      sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPageObject clickToButtonLogin() {
		waitForElementClickable(driver, AdminLoginPageUI.BUTTON_LOGIN);
		clickToElement(driver, AdminLoginPageUI.BUTTON_LOGIN);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

	public void loginAsAdmin(String adminEmailAddress,String adminPassword) {
		inputToEmailTextBox(adminEmailAddress);
		inputToPasswordTextBox(adminPassword);
		clickToButtonLogin();
	}

	public boolean isAdminDashboardDisplayed() {
		waitForElementVisible(driver,AdminDashboardPageUI.DASBOARD_PAGE);
		return isElementDisplayed(driver, AdminDashboardPageUI.DASBOARD_PAGE);
	}
}
