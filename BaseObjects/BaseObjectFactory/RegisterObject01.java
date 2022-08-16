package BaseObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePageFactory.BasePageFactory;


public class RegisterObject01 extends BasePageFactory {
	private WebDriver driver;

	public RegisterObject01(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(id = "register-button")
	private WebElement register;

	@CacheLookup
	@FindBy(id = "FirstName-error")
	private WebElement firstNameError;

	@CacheLookup
	@FindBy(id = "LastName-error")
	private WebElement lastNameError;

	@CacheLookup
	@FindBy(id = "Email-error")
	private WebElement emailError;

	@FindBy(id = "Password-error")
	private WebElement passwordError;

	@FindBy(id = "ConfirmPassword-error")
	private WebElement confirmPasswordError;

	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement registerSuccessMessage;

	@FindBy(xpath = "//div[contains(@class ,'message-error')] //li")
	private WebElement emailSpecifiedErrorMessage;

	public void clickToRegisterButton() {
		waitForElementClickable(driver, register);
		clickToElement(driver, register);

	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameError);
		return getElementText(driver, firstNameError);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameError);
		return getElementText(driver, lastNameError);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordError);
		return getElementText(driver, passwordError);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailError);
		return getElementText(driver, emailError);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		return getElementText(driver, confirmPasswordError);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getElementText(driver, registerSuccessMessage);
	}

	public String getErrorMessageAtEmailTextboxExist() {
		waitForElementVisible(driver, emailSpecifiedErrorMessage);
		return getElementText(driver, emailSpecifiedErrorMessage);
	}
}
