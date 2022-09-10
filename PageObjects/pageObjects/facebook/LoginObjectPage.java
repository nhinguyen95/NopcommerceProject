package pageObjects.facebook;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUIs.faceBook.LoginPageUI;

public class LoginObjectPage extends BasePage {
	private WebDriver driver;


	public LoginObjectPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
	waitForElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	clickToElement(driver,  LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		
	}

	public boolean isEmailAddressTextboxDisplayed() {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		return isElementDisplayed(driver, LoginPageUI.EMAIL_TEXTBOX);
	}

	public void enterToEmailAddressTextbox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
	    sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
		
	}
	public boolean isConfirmEmailAddressTextboxDisplayed() {
		return isElementDisplayed(driver, LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}

	public void clickToCloseIconAtRegisterForm() {
		waitForElementClickable(driver, LoginPageUI.CLOSE_ICON);
		clickToElement(driver, LoginPageUI.CLOSE_ICON);
	}

	public boolean isConfirmEmailAddressTextboxUnDisplayed() {
		return isElementUnDisplayed(driver,LoginPageUI.CONFIRM_EMAIL_TEXTBOX);
	}
}