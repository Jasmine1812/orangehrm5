package pageUIs.admin;

public class EmergencyContactsPageUI {
    public static final String ADD_CONTACT_BUTTON = "xpath=//h6[text()='Assigned Emergency Contacts']/following-sibling::button";
    public static final String NAME_TEXTBOX = "xpath=//label[text()='Name']/parent::div//following-sibling::div/input";
    public static final String RELATIONSHIP_TEXTBOX = "xpath=//label[text()='Relationship']/parent::div//following-sibling::div/input";
    public static final String HOME_TELEPHONE_TEXTBOX = "xpath=//label[text()='Home Telephone']/parent::div//following-sibling::div/input";
    public static final String MOBILE_TEXTBOX = "xpath=//label[text()='Mobile']/parent::div//following-sibling::div/input";
    public static final String WORK_TELEPHONE_TEXTBOX = "xpath=//label[text()='Work Telephone']/parent::div//following-sibling::div/input";
    public static final String SAVE_CONTACT_BUTTON = "xpath=//button[@type='submit']";
    public static final String DYNAMIC_CELL_VALUE_BY_INDEX_COMLUMN_AND_INDEX_ROW = "xpath=//div[@class='oxd-table-card'][%s]//div[contains(@class,'oxd-table-cell')][%s]/div[text()='%s']";
    public static final String COMLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[contains(@class,'oxd-table-row')]//div[contains(string(),'%s')]/preceding-sibling::div";

}
