package pageUIs.admin;

public class BaseActionsPageUI {
    public static final String COLUMN_INDEX_BY_COMLUMN_NAME = "xpath=//div[contains(@class,'oxd-table-header-cell') and text()='%s']/preceding-sibling::div";
    public static final String DYNAMIC_CELL_VALUE_BY_COMLUMN_INDEX_AND_ROW_INDEX = "xpath=//div[@class='oxd-table-card'][%s]//div[%s]/div[text()='%s']";
    public static final String SPINNER_ICON = "xpath=//div[@class='oxd-loading-spinner-container']";
    public static final String DYNAMIC_SUCCESS_MESSAGE = "xpath=//div[contains(@class,'oxd-toast-content--success')]/p[text()='%s']";
    public static final String GENDER_STATUS = "xpath=//label[contains(string(),'%s')]/input" ;
    public static final String DYNAMIC_EDIT_ICON_BY_COLUMN_INDDEX_AND_ROW_INDEX = "xpath=//div[@class='oxd-table-card'][%s]//div[%s]/div[text()='%s']/parent::div/following-sibling::div//i[contains(@class,'bi-pencil-fill')]";
}
