package pageUIs.jQuery;

public class HomePageUIs {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABLE_NAME ="xpath=//div[@class='qgrd-header-text' and text() ='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION ="xpath=//ul[@class='qgrd-pagination-ul']//li[@class='qgrd-pagination-page']";
	public static final String PAGINATION_PAGE_BY_INDEX ="xpath=//ul[@class ='qgrd-pagination-ul']//li[@class ='qgrd-pagination-page'][%s]/a";
	public static final String ALL_ROW_EACH_PAGE ="xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE ="xpath=//tbody/tr/td[@data-key='country']";
	
	//Index của cái cột mà mình cần enter/clic/select... vào
	public static final String COLUM_INDEX_BY_NAME ="xpath=//tr/td[text()='%s']/preceding-sibling::td";
	public static final String ROW_TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/select";
	public static final String LOAD_BUTTON="xpath=//button[@id='btnLoad']"	;
	public static final String CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX ="xpath=//tbody/tr[%s]/td[%s]/input[@type='checkbox']";
	public static final String ICON_NAME_BY_ROW_NUMBER ="xpath=//tbody/tr[%s]//button[@title='%s']";
	
	//upload File 
	public static final String UPLOAD_FILE="xpath=//input[@type='file']";
	public static final String FILE_NAME_LOADED="xpath=//p[@class='name' and text() ='%s']";
	public static final String START_BUTTON ="css=table button.start";
	public static final String FILE_NAME_UPLOADED_LINK ="xpath=//a[text()='%s']";
	public static final String FILE_NAME_UPLOADED_IMAGE ="xpath=//a[@title='%s']/img";
}
