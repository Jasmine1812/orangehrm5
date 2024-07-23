package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.BaseActionsPageUI;
import pageUIs.admin.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BaseActions {
    public String getFirstName(){
        waitForElementVisible(PersonalDetailsPageUI.FIRST_NAME);
        return getElementAttributeValue(PersonalDetailsPageUI.FIRST_NAME, "value");
    }
    public String getMiddleName(){
        waitForElementVisible(PersonalDetailsPageUI.MIDDLE_NAME);
        return getElementAttributeValue(PersonalDetailsPageUI.MIDDLE_NAME, "value");
    }
    public String getLastName(){
        waitForElementVisible(PersonalDetailsPageUI.LAST_NAME);
        return getElementAttributeValue(PersonalDetailsPageUI.LAST_NAME, "value");
    }
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getEmployeeID() {
        waitForElementVisible(PersonalDetailsPageUI.EMPLOYEE_ID);
        return getElementAttributeValue(PersonalDetailsPageUI.EMPLOYEE_ID, "value");
    }

    public EmployeeListPageObject clickToEmployeeListLink() {
        waitForElementClickable(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
        return PageGenerator.getEmployeeListPage(driver);
    }

    public boolean isHeaderTitleDisplayed() {
        waitForElementVisible(PersonalDetailsPageUI.HEAD_TITLE_LABEL);
        return isElementDisplayed(PersonalDetailsPageUI.HEAD_TITLE_LABEL);
    }

    public void enterToOtherIdTextbox(String otherId) {
        waitForElementVisible(PersonalDetailsPageUI.OTHER_ID);
        sendKeyToElement(PersonalDetailsPageUI.OTHER_ID,otherId);
    }

    public void enterToDriversLicenseNumberTextbox(String driversLicenseNumber) {
        waitForElementVisible(PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER);
        sendKeyToElement(PersonalDetailsPageUI.DRIVER_LICENSE_NUMBER,driversLicenseNumber);
    }

    public void enterTolicenseExpiryDateDatePicker(String licenseExpiryDate) {
        waitForElementVisible(PersonalDetailsPageUI.LICENSE_EXPIRY_DATE);
        sendKeyToElement(PersonalDetailsPageUI.LICENSE_EXPIRY_DATE,licenseExpiryDate);
    }

    public void enterToDateOfBirthteDatePicker(String dateOfBirth) {
        waitForElementVisible(PersonalDetailsPageUI.DATE_OF_BIRTH);
        sendKeyToElement(PersonalDetailsPageUI.DATE_OF_BIRTH,dateOfBirth);
    }

    public void selectToNationalityDropdown(String nationality) {
        selectItemInCustomDropdown(PersonalDetailsPageUI.NATIONALITY_PARENT, PersonalDetailsPageUI.NATIONALITY_CHILD, nationality);
    }

    public void selectToMaritalStatusDropdown(String maritalStatus) {
        selectItemInCustomDropdown(PersonalDetailsPageUI.MARITAL_STATUS_PARENT, PersonalDetailsPageUI.MARITAL_STATUS_CHILD, maritalStatus);
    }


    public void clickToSaveButtonOnPersonalDetails() {
        clickToElement(PersonalDetailsPageUI.SAVE_BUTTON);
    }

    public String getNationalityDropdownSelectedText() {
      return getElementText(PersonalDetailsPageUI.NATIONALITY_SELECT);
    }

    public String getMaritalStatusDropdownSelectedText() {
        return getElementText(PersonalDetailsPageUI.MARITAL_STATUS_SELECT);
    }

}
