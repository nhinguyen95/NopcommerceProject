package com.facebook.register;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import faceBook.PageGeneratorManager;
import pageObjects.facebook.LoginObjectPage;

public class Verify_Element_Undisplayed extends BaseTest{
	private LoginObjectPage loginPage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browerName, String appURL) {
	driver = getBrowerDriver(browerName, appURL);
	loginPage= PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Verify_Element_displayed () {
		loginPage.clickToCreateNewAccountButton();
		verifyTrue(loginPage.isEmailAddressTextboxDisplayed());
	}
	@Test
	public void TC_02_Verify_Element_Undisplayed_In_Dom () {
		loginPage.enterToEmailAddressTextbox("");
		loginPage.sleepSecond(3);
		//verifyTrue(loginPage.isConfirmEmailAddressTextboxDisplayed());
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
	}
	@Test
	public void TC_03_Verify_Element_Undisplayed_Not_In_Dom () {
		loginPage.clickToCloseIconAtRegisterForm();
		loginPage.sleepSecond(3);
		verifyTrue(loginPage.isConfirmEmailAddressTextboxUnDisplayed());
	}
	@AfterClass
	public void afterClass() {
     driver.quit();
	}
}
