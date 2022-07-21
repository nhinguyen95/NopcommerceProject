package BaseObjectFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePageFactory.BasePageFactory;
import User.PageObjects.User_RegisterPageObject;

public class HomePageObject01 extends BasePageFactory{
	private WebDriver driver;

	public HomePageObject01 (WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLinkElement;
	
	public void clickToRegisterLink() {
       waitForElementClickable(driver,registerLinkElement);
		clickToElement(driver, registerLinkElement);	
		new User_RegisterPageObject(driver);
	}

}
