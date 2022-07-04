package pageObjects;

import org.openqa.selenium.WebDriver;
import common.BasePage;
import pageUl.LoginPageUI;
public class LoginPageObject extends BasePage{
private WebDriver driver;

public LoginPageObject(WebDriver driver) {
	this.driver = driver;
}

public void clickToButtonLogin() {
	waitForElementClickable(driver, LoginPageUI.BUTTON_LOGIN);
	clickToElement(driver, LoginPageUI.BUTTON_LOGIN);
	
	
}

public String getErrorAtEmailTextbox() {
	waitAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
	return getElementText(driver, LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
}

public void inputToEmailTextbox(String invalidEmailAddress) {
	  waitAllElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
      sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmailAddress);
	
}

public void inputToPasswordTextbox(String password) {
	waitAllElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
    sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);	
}

public String getErrorMessageUnsuccesfull() {
	waitAllElementVisible(driver, LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
	return getElementText(driver, LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
}
}