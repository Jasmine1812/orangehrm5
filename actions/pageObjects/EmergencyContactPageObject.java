package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.EmergencyContactsPageUI;

public class EmergencyContactPageObject extends BaseActions {
    WebDriver driver;
    public EmergencyContactPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isValueDisplayedAtColumnNameInContact(String rowIndex, String columnName, String valueCell){
        int indexColumn = getListElementSize(EmergencyContactsPageUI.COMLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        return isElementDisplayed(EmergencyContactsPageUI.DYNAMIC_CELL_VALUE_BY_INDEX_COMLUMN_AND_INDEX_ROW, rowIndex, String.valueOf(indexColumn),valueCell);
    }

    public void clickToAddContactButton() {
        waitForElementClickable(EmergencyContactsPageUI.ADD_CONTACT_BUTTON);
        clickToElement(EmergencyContactsPageUI.ADD_CONTACT_BUTTON);
    }

    public void enterToNameTextbox(String nameContact) {
        waitForElementVisible(EmergencyContactsPageUI.NAME_TEXTBOX);
        sendKeyToElement(EmergencyContactsPageUI.NAME_TEXTBOX, nameContact);
    }

    public void enterToRelationshipTextbox(String relationship) {
        waitForElementVisible(EmergencyContactsPageUI.RELATIONSHIP_TEXTBOX);
        sendKeyToElement(EmergencyContactsPageUI.RELATIONSHIP_TEXTBOX, relationship);
    }

    public void enterToHomeTelephoneTextbox(String homeTelephone) {
        waitForElementVisible(EmergencyContactsPageUI.HOME_TELEPHONE_TEXTBOX);
        sendKeyToElement(EmergencyContactsPageUI.HOME_TELEPHONE_TEXTBOX, homeTelephone);
    }

    public void enterToMobileTextbox(String mobile) {
        waitForElementVisible(EmergencyContactsPageUI.MOBILE_TEXTBOX);
        sendKeyToElement(EmergencyContactsPageUI.MOBILE_TEXTBOX, mobile);
    }

    public void enterToWorkTelephone(String workTelephone) {
        waitForElementVisible(EmergencyContactsPageUI.WORK_TELEPHONE_TEXTBOX);
        sendKeyToElement(EmergencyContactsPageUI.WORK_TELEPHONE_TEXTBOX, workTelephone);
    }

    public void clickToSaveContactButton() {
        waitForElementClickable(EmergencyContactsPageUI.SAVE_CONTACT_BUTTON);
        clickToElement(EmergencyContactsPageUI.SAVE_CONTACT_BUTTON);
    }
}
