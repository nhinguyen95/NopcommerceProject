package nopcommerce_Users;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import common.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework_02_Apply_BasePage {
	WebDriver driver;
	BasePage basePage;
	String emailAddress ;

@BeforeClass
public void BeforeClass() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	emailAddress = "Nobita" + generateEmail();
	basePage = BasePage.getBasePageOject();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://demo.nopcommerce.com/");
	driver.manage().window().maximize();
	
}

public void TC_01_Register_Emty_Data() {
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),"First name is required.");
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"),"Last name is required.");
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"),"Email is required.");
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),"Password is required.");
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),"Password is required.");
}

public void TC_02_Register_Invalid_Email() {
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.sendkeyToElement(driver, "//input[@id = 'FirstName']", "ABC");
	basePage.sendkeyToElement(driver, "//input[@id = 'LastName']", "DEF");
	basePage.sendkeyToElement(driver, "//input[@id = 'Email']", "nhi@gm");
	basePage.sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
	basePage.sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	
	Assert.assertEquals(basePage.getElementText(driver, "//div[@class ='message-error validation-summary-errors']//li[text()='Wrong email']"),"Wrong email");
	
}

public void TC_03_Register_Valid_Information() {
	basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.sendkeyToElement(driver, "//input[@id = 'FirstName']", "ABC");
	basePage.sendkeyToElement(driver, "//input[@id = 'LastName']", "DEF");
	basePage.sendkeyToElement(driver, "//input[@id = 'Email']",emailAddress );
	basePage.sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
	basePage.sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	
	Assert.assertEquals(basePage.getElementText(driver, "//div[@class = 'result']"),"Your registration completed");
}
public void TC_04_Register_Email_Already_Exists() {
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.sendkeyToElement(driver, "//input[@id = 'FirstName']", "ABC");
	basePage.sendkeyToElement(driver, "//input[@id = 'LastName']", "DEF");
	basePage.sendkeyToElement(driver, "//input[@id = 'Email']","nhi@gmai.com");
	basePage.sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
	basePage.sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123456");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	
	Assert.assertEquals(basePage.getElementText(driver, "//div[@class ='message-error validation-summary-errors']//li"),"The specified email already exists");
}
@Test
public void TC_05_Register_Invalid_Password_Least_Characters() {
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.sendkeyToElement(driver, "//input[@id = 'FirstName']", "ABC");
	basePage.sendkeyToElement(driver, "//input[@id = 'LastName']", "DEF");
	basePage.sendkeyToElement(driver, "//input[@id = 'Email']",emailAddress );
	basePage.sendkeyToElement(driver, "//input[@id = 'Password']", "1234");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
}
public void TC_06_Register_Invalid_Confirm_Password() {
	basePage.clickToElement(driver, "//a[@class='ico-register']");
	basePage.sendkeyToElement(driver, "//input[@id = 'Email']",emailAddress );
	basePage.sendkeyToElement(driver, "//input[@id = 'Password']", "123456");
	basePage.sendkeyToElement(driver, "//input[@id = 'ConfirmPassword']", "123455");
	basePage.clickToElement(driver, "//button[@id='register-button']");
	Assert.assertEquals(basePage.getElementText(driver, "//span[@id = 'ConfirmPassword-error']"),"The password and confirmation password do not match.");
}

@AfterClass
public void afterClass() {
	driver.close();
}
public String generateEmail() {
	Random rand = new Random();
	return rand.nextInt(9999) + "@mail.com";
}
}
