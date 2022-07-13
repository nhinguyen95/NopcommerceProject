package pageObjects;

import org.openqa.selenium.WebDriver;

import User.nopcomerce.PageUIs.User_LoginPageUI;
import common.BasePage;
public class User_LoginPageObject extends BasePage{
private WebDriver driver;

public User_LoginPageObject(WebDriver driver) {
	this.driver = driver;
}

public void clickToButtonLogin() {
	waitForElementClickable(driver, User_LoginPageUI.BUTTON_LOGIN);
	clickToElement(driver, User_LoginPageUI.BUTTON_LOGIN);
	
	
}

public String getErrorAtEmailTextbox() {
	waitAllElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
	return getElementText(driver, User_LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
}

public void inputToEmailTextbox(String invalidEmailAddress) {
	  waitAllElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX);
      sendkeyToElement(driver, User_LoginPageUI.EMAIL_TEXTBOX, invalidEmailAddress);
	
}

public void inputToPasswordTextbox(String password) {
	waitAllElementVisible(driver, User_LoginPageUI.PASSWORD_TEXTBOX);
    sendkeyToElement(driver, User_LoginPageUI.PASSWORD_TEXTBOX, password);	
}

public String getErrorMessageUnsuccesfull() {
	waitAllElementVisible(driver, User_LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
	return getElementText(driver, User_LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
}

public void loginAsUser() {
	// TODO Auto-generated method stub
	
}
}