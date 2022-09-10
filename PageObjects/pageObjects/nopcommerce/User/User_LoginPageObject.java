package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.PageGeneratorManager;
import pageUIs.nopcomerce.User.User_LoginPageUI;
public class User_LoginPageObject extends BasePage{
private WebDriver driver;

public User_LoginPageObject(WebDriver driver) {
	this.driver = driver;
}

public User_HomePageObject clickToButtonLogin() {
	waitForElementClickable(driver, User_LoginPageUI.BUTTON_LOGIN);
	clickToElement(driver, User_LoginPageUI.BUTTON_LOGIN);
	return PageGeneratorManager.getUserHomePage(driver);
}

public String getErrorAtEmailTextbox() {
	waitAllElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
	return getElementText(driver, User_LoginPageUI.EMAIL_TEXTBOX_ERROR_MESSAGE);
}

public void inputToEmailTextbox(String userEmailAddress) {
	  waitAllElementVisible(driver, User_LoginPageUI.EMAIL_TEXTBOX);
      sendkeyToElement(driver, User_LoginPageUI.EMAIL_TEXTBOX, userEmailAddress);
	
}

public void inputToPasswordTextbox(String userPassword) {
	waitAllElementVisible(driver, User_LoginPageUI.PASSWORD_TEXTBOX);
    sendkeyToElement(driver, User_LoginPageUI.PASSWORD_TEXTBOX, userPassword);	
}

public String getErrorMessageUnsuccesfull() {
	waitAllElementVisible(driver, User_LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
	return getElementText(driver, User_LoginPageUI.UNSUCSSES_FULL_ERROR_MESSAGE);
}

public User_HomePageObject loginAsUser( String userEmailAddress,String userPassword) {
inputToEmailTextbox(userEmailAddress);
inputToPasswordTextbox(userPassword);
return clickToButtonLogin();
}
}