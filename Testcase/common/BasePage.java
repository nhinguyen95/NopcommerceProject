package common;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Admin.PageObjects.Admin_LoginPageObject;
import User.PageObjects.User_AddressPageObject;
import User.PageObjects.User_CustomerInforPageObject;
import User.PageObjects.User_HomePageObject;
import User.PageObjects.User_MyAccountPageObject;
import User.PageObjects.User_MyProductReviewPageOject;
import User.PageObjects.User_RewardPointPageObject;
import User.nopcomerce.PageUIs.PageBaseUI;
import User.nopcomerce.PageUIs.User_HomePageUl;
import User.nopcomerce.PageUIs.User_RegisterPageUI;

public class BasePage {

	public static BasePage getBasePageOject() {
		return new BasePage();
	}

	public void openPageUrL(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public Alert waitAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		waitAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {
		waitAlertPresence(driver).dismiss();
	}

	public String getTextlAlert(WebDriver driver) {
		return waitAlertPresence(driver).getText();
	}

	public void sendKeyToAlert(WebDriver driver, String textValue) {
		waitAlertPresence(driver).sendKeys(textValue);
	}

	public void swichToWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
			}
		}
	}

	public void swichtToWindowByTitle(WebDriver driver, String tabTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			driver.switchTo().window(id);
			String widowTitle = driver.getTitle();
			System.out.println(widowTitle);
			if (widowTitle.equals(tabTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String id : allWindows) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	private By getByLocator(String locatorType) {
		By by = null;
		System.out.println("Locator type = " + locatorType);
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not supported!");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... values) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
		|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {
			locatorType= String.format(locatorType, (Object[])values);
	}
		return locatorType;
	}

	private List<WebElement> getListWebElements(WebDriver driver, String locatorType) {
		return driver.findElements(By.xpath(locatorType));
	}

	public void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	public void clickToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locatorType, String textvalue) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(textvalue);
	}
	public void sendkeyToElement(WebDriver driver, String locatorType, String textvalue,String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		element.clear();
		element.sendKeys(textvalue);
	}

	public String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}
	public String getElementText(WebDriver driver, String locatorType,String... dynamicValues) {
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
	public void selectItemInDefaultDropDown(WebDriver driver, String locatorType, String textItem) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByValue(textItem);
	}

	public String getSelectedItemDefaultDropDown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropDownMultiple(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath,
			String ExpectedItem) {
		getWebElement(driver, parentXpath).click();
		sleepSecond(1);
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

		List<WebElement> allItems = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));
		System.out.println(allItems.size());

		for (WebElement item : allItems) {
			if (item.getText().trim().equals(ExpectedItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepSecond(1);
				item.click();
				break;
			}
		}
	}

	public void sleepSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locatorType, String name) {
		return getWebElement(driver, locatorType).getAttribute(name);
	}

	public String getElementCssvalue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	public String getHexaColorToRgba(String RgbaToHex) {
		return Color.fromString(RgbaToHex).asHex();
	}

	public int getListElementSize(WebDriver driver, String locatorType) {
		return getListWebElements(driver, locatorType).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		return getWebElement(driver, locatorType).isDisplayed();
	}
	public boolean isElementDisplayed(WebDriver driver, String locatorType,String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();
	}

	public boolean isElementEnable(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		return getWebElement(driver, locatorType).isEnabled();
	}

	public boolean isElementEnable(WebDriver driver, String locatorType,String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType,String...dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));
		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();
	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver, String locatorType) {
		driver.switchTo().defaultContent();
	}

	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");
		sleepSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitAllElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitAllElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElements(driver, locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementVisible(WebDriver driver, String locatorType,String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitAllElementVisible(WebDriver driver, String locatorType,String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType,String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitAllElementInvisible(WebDriver driver, String locatorType,String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(getListWebElements(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType,String...dynamicValues) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}
// Tối ưu ở bài học switch_page
	public User_AddressPageObject opendAddressPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.ADDRESS_LINK);
		clickToElement(driver, PageBaseUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}

	public User_MyProductReviewPageOject opendMyProductReviewPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, PageBaseUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public User_RewardPointPageObject opendRewardPointPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, PageBaseUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserRewardPointPage(driver);
	}

	public User_CustomerInforPageObject opendCustomerInforPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, PageBaseUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public User_HomePageObject clickToLogOutLinkAtUserPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.LOGOUT_USER_PAGE_LINK);
		clickToElement(driver, PageBaseUI.LOGOUT_USER_PAGE_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public Admin_LoginPageObject clickToLogOutLinkAtAdminPage(WebDriver driver) {
		waitForElementClickable(driver, PageBaseUI.LOGOUT_ADMIN_PAGE_LINK);
		clickToElement(driver, PageBaseUI.LOGOUT_ADMIN_PAGE_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
  
	public BasePage openPagesAtMyAccountByName (WebDriver driver,String pageName) {
		waitForElementClickable(driver, PageBaseUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, PageBaseUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA,pageName);
		switch (pageName) {
		case"Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		case"Reward points":
			return PageGeneratorManager.getUserRewardPointPage(driver);
		case"My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		case"Addresses":
			return PageGeneratorManager.getUserAddressPage(driver);
			
		default :
		    throw new RuntimeException("Invalid page name at My Account Area.");
		}
	}

	public void openPagesAtMyAccountByNameII (WebDriver driver,String pageName) {
		waitForElementClickable(driver, PageBaseUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA, pageName);
		clickToElement(driver, PageBaseUI.DYNAMIC_PAGES_AT_MY_ACCOUNT_AREA,pageName);
	}
	
	private long longTimeOut = 30;

}
