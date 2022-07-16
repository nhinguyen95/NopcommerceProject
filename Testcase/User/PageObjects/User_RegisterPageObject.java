package User.PageObjects;

import org.openqa.selenium.WebDriver;

import User.nopcomerce.PageUIs.User_RegisterPageUI;
import common.BasePage;
import common.PageGeneratorManager;

public class User_RegisterPageObject extends BasePage{
private WebDriver driver;

public User_RegisterPageObject(WebDriver driver) {
	this.driver = driver;
}
	public User_RegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, User_RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, User_RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitAllElementVisible(driver, User_RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}
	public String getErrorMessageAtLastnameTextbox() {
		waitAllElementVisible(driver, User_RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitAllElementVisible(driver, User_RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}


	public String getErrorMessageAtEmailTextbox() {
		waitAllElementVisible(driver, User_RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}



	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitAllElementVisible(driver, User_RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextbox(String firstName) {
		waitAllElementVisible(driver, User_RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToLastNameTextbox(String lastName) {
		waitAllElementVisible(driver, User_RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String invalidEmailAddress) {
		waitAllElementVisible(driver, User_RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.EMAIL_TEXTBOX, invalidEmailAddress);		
	}
	
	public void inputToPasswordTextbox(String password) {
		waitAllElementVisible(driver, User_RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.PASSWORD_TEXTBOX, password);		
		
	}


	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitAllElementVisible(driver, User_RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, User_RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);		
		
	}

	public String getRegisterSuccessMessage() {
		waitAllElementVisible(driver, User_RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public String getErrorMessageAtEmailTextboxExist() {
		waitAllElementVisible(driver, User_RegisterPageUI.EMAIL_SPECIFIED_ERROR_MESSAGE);
		return getElementText(driver, User_RegisterPageUI.EMAIL_SPECIFIED_ERROR_MESSAGE);
	}
	public User_HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, User_RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, User_RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
}
