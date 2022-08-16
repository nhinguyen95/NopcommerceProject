package jQuery.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Java_Basic_Example.For_ForEach;
import common.BasePage;
import jQuery.PageUIs.HomePageUIs;

public class HomePageObject extends BasePage {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		sleepSecond(3);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUIs.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUIs.PAGINATION_PAGE_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLable(String headerLabel, String values) {
		waitAllElementVisible(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE_NAME, headerLabel);
		sendkeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE_NAME, values, headerLabel);
		pressKeyToElement(driver, HomePageUIs.HEADER_TEXTBOX_BY_LABLE_NAME, Keys.ENTER, headerLabel);
	}

	public List<String> getValueEachRowAllPage() {
	// yêu cầu : lấy ra dữ liệu trong 1 cái row/tất cả row/ 1 cột 
		int totalPage = getElementSize(driver, HomePageUIs.TOTAL_PAGINATION);
		System.out.println("Total size = " + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();

		// duyệt qua tất cả các page
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUIs.PAGINATION_PAGE_BY_INDEX, String.valueOf(index));
		
			// get text của all row mỗi page đưa vào ArrayList
			//List<WebElement> allRowEachPage = getListWebElements(driver, HomePageUIs.ALL_ROW_EACH_PAGE);
			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUIs.ALL_ROW_COUNTRY_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		// in tất cả các giá trụ row ra - tất cả các page
		for (String value : allRowValueAllPage) {
			System.out.println(value);
		}
		return allRowValueAllPage;
	}

	public void enterToTextBoxByColumNameAtRowNumber(String columnName, String rowNumber, String valueToSendkey ) {
		//lấy ra column index dựa vào tên cột
		int columIndex = getElementSize(driver, HomePageUIs.COLUM_INDEX_BY_NAME,columnName)+1;
		System.out.println("colum Index = " + columIndex);
		
		//senkey vào dòng nào 
		waitForElementVisible(driver, HomePageUIs.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		sendkeyToElement(driver, HomePageUIs.ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSendkey, rowNumber,String.valueOf(columIndex));
		
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columIndex = getElementSize(driver, HomePageUIs.COLUM_INDEX_BY_NAME,columnName)+1;
		System.out.println("colum Index = " + columIndex);
		waitForElementClickable(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
	    selectItemInDefaultDropDown(driver, HomePageUIs.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber,String.valueOf(columIndex));
	}

	public void checkToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUIs.COLUM_INDEX_BY_NAME,columnName)+1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
	}

	public void unCheckToCheckBoxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columIndex = getElementSize(driver, HomePageUIs.COLUM_INDEX_BY_NAME,columnName)+1;
		waitForElementClickable(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
		unCheckToDefaultCheckboxRadio(driver, HomePageUIs.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,String.valueOf(columIndex));
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, HomePageUIs.LOAD_BUTTON);
		clickToElement(driver,  HomePageUIs.LOAD_BUTTON);
		
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUIs.ICON_NAME_BY_ROW_NUMBER, rowNumber,iconName);
		clickToElement(driver, HomePageUIs.ICON_NAME_BY_ROW_NUMBER, rowNumber,iconName);
		
	}
}