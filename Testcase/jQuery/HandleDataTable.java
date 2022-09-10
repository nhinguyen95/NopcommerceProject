package jQuery;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import common.BaseTest;
import pageObjects.jQuery.LoginPageObject;

public class HandleDataTable extends BaseTest {
LoginPageObject homePage;
List<String> actualAllCountryValues, expectedAllCountryValues ;

	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browerName, String appURL) {
	driver = getBrowerDriver(browerName, appURL);
	homePage = PageGeneratorManager.getHomePage(driver);
	}
	

	public void TC_01_Paging() {
		homePage.openPagingByPageNumber("10");
		homePage.sleepSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		
		homePage.openPagingByPageNumber("8");
		homePage.sleepSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("8"));
		
		homePage.openPagingByPageNumber("3");
		homePage.sleepSecond(1);
		Assert.assertTrue(homePage.isPageNumberActived("3"));
	}
	
	public void TC_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		
		homePage.enterToHeaderTextboxByLable("Females","180000");
		homePage.enterToHeaderTextboxByLable("Country","Zambia");
		homePage.enterToHeaderTextboxByLable("Males","181000");
		homePage.enterToHeaderTextboxByLable("Total","361000");
		homePage.getValueEachRowAllPage();
		actualAllCountryValues = homePage.getValueEachRowAllPage();
		Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
	}
	
	@Test
	public void TC_03_Enter_To_Textbox_At_Any_Row() {
	//nhập dữ liệu vào textbox tại cột album 
	//nhập dữ liệu vào textbox tại cột bất kỳ cột nào có textbox
		// value để nhập liệu - tham số 1
		// row number : tại row nào và tại column Name : cột nào 
		//Ex: nhập vào textbox tại dòng số 3/5/2
		homePage.enterToTextBoxByColumNameAtRowNumber("Album","1","Micheal 97");
		homePage.sleepSecond(1);
		homePage.enterToTextBoxByColumNameAtRowNumber("Artist","1","Micheal");
		homePage.enterToTextBoxByColumNameAtRowNumber("Year","1","1997");
		homePage.enterToTextBoxByColumNameAtRowNumber("Price","1","150");
		
		homePage.selectDropdownByColumnNameAtRowNumber("Origin","1","Taiwan");
		
		homePage.clickToLoadButton();
		
		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","3");
		homePage.checkToCheckBoxByColumnNameAtRowNumber("With Poster?","5");
		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","1");
		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","2");
		homePage.unCheckToCheckBoxByColumnNameAtRowNumber("With Poster?","4");
		
		homePage.clickToIconByRowNumber("1","Insert Row Above");
		homePage.sleepSecond(1);
		homePage.clickToIconByRowNumber("3","Move Up");
		homePage.sleepSecond(1);
		homePage.clickToIconByRowNumber("5","Remove Current Row");
		homePage.sleepSecond(1);
		homePage.clickToIconByRowNumber("4","Remove Current Row");
		homePage.sleepSecond(1);
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
