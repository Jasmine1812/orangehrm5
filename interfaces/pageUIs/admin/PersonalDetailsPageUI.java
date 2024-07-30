package pageUIs.admin;

public class PersonalDetailsPageUI {
    public static final String FIRST_NAME = "xpath=//input[@name='firstName']";
    public static final String MIDDLE_NAME = "name=middleName";
    public static final String LAST_NAME = "name=lastName";
    public static final String EMPLOYEE_ID = "xpath=//label[text()='Employee Id']/parent::div//following-sibling::div/input";
    public static final String EMPLOYEE_LIST_LINK = "xpath=//a[text()='Employee List']";
    public static final String HEAD_TITLE_LABEL = "xpath=//div[contains(@class,'orangehrm-horizontal-padding')]/h6";
    public static final String OTHER_ID = "xpath=//label[text()='Other Id']/parent::div/following-sibling::div//input";
    public static final String DRIVER_LICENSE_NUMBER = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div//input";
    public static final String LICENSE_EXPIRY_DATE = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";
    public static final String DATE_OF_BIRTH = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String NATIONALITY_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String NATIONALITY_CHILD = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//span";
    public static final String NATIONALITY_SELECT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String MARITAL_STATUS_CHILD = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//span";
    public static final String MARITAL_STATUS_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String MARITAL_STATUS_SELECT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String SAVE_BUTTON = "xpath=//button[@type='submit']";
}
