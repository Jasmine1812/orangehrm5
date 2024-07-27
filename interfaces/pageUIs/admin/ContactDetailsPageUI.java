package pageUIs.admin;

public class ContactDetailsPageUI {

    public static final String ADD_ATTACHMENT_BUTTON = "xpath=//button[contains(string(),'Add')]";
    public static final String SAVE_ATTACHMENT_BUTTON = "xpath=//div[@class='orangehrm-attachment']//button[@type='submit']";
    public static final String STREET1_TEXTBOX = "xpath=//label[text()='Street 1']/parent::div//following-sibling::div/input";
    public static final String STREET2_TEXTBOX = "xpath=//label[text()='Street 2']/parent::div//following-sibling::div/input";
    public static final String CITY_TEXTBOX = "xpath=//label[text()='City']/parent::div//following-sibling::div/input";
    public static final String STATE_PROVINCE_TEXTBOX = "xpath=//label[text()='State/Province']/parent::div//following-sibling::div/input";
    public static final String ZIP_CODE_TEXTBOX = "xpath=//label[text()='Zip/Postal Code']/parent::div//following-sibling::div/input";
    public static final String HOME_TEXTBOX = "xpath=//label[text()='Home']/parent::div//following-sibling::div/input";
    public static final String MOBILE_TEXTBOX = "xpath=//label[text()='Mobile']/parent::div//following-sibling::div/input";
    public static final String WORK_TEXTBOX = "xpath=//label[text()='Work']/parent::div//following-sibling::div/input";
    public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text()='Work Email']/parent::div//following-sibling::div/input";
    public static final String OTHER_EMAIL_TEXTBOX = "xpath=//label[text()='Other Email']/parent::div//following-sibling::div/input";
    public static final String COUNTRY_PARENT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//i" ;
    public static final String COUNTRY_CHILD = "xpath=//label[text()='Country']/parent::div/following-sibling::div//span" ;
    public static final String COUNTRY_SELECT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']" ;
    public static final String SAVE_BUTTON = "xpath=//button[@type='submit']";
    public static final String COMMENT_TEXTAREA = "xpath=//textarea[@placeholder='Type comment here']";

}
