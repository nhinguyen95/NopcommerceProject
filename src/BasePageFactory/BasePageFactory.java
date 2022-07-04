package BasePageFactory;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePageFactory getBasePageFactory() {
		return new BasePageFactory();
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	public void waitForElementVisible(WebDriver driver, WebElement element ) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitAllElementVisible(WebDriver driver, List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitAllElementInvisible(WebDriver driver,List<WebElement> elements) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	private long longTimeOut = 30 ;
}
