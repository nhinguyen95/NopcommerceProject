package jQuery;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.jQuery.LoginPageObject;


public class Upload_File extends BaseTest{
	LoginPageObject homePage;
	String cpngFileName = "C.png";
	String javapngFileName ="java.png";
	String pythonFileName ="python.png";
	String[] multipleFileName = {cpngFileName,javapngFileName,pythonFileName};
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void BeforeClass(String browerName, String appURL) {
	driver = getBrowerDriver(browerName, appURL);
	homePage = PageGeneratorManager.getHomePage(driver);
	}
	
	
	public void Upload_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, cpngFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(cpngFileName));
		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cpngFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(cpngFileName));
		
	}
	@Test
	public void Upload_Multiple_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, multipleFileName);
		
		Assert.assertTrue(homePage.isFileLoadedByName(cpngFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(javapngFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(pythonFileName));
		
		homePage.clickToStartButton();
		
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(cpngFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(javapngFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(pythonFileName));
		
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(cpngFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(javapngFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(pythonFileName));
		
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
