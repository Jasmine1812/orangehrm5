package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.ContactDetailsPageUI;
import pageUIs.admin.PersonalDetailsPageUI;

public class ContactDetailsPageObject extends BaseActions {
    WebDriver driver;
    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddAttachmentsButton() {
        waitForElementClickable(ContactDetailsPageUI.ADD_ATTACHMENT_BUTTON);
        clickToElement(ContactDetailsPageUI.ADD_ATTACHMENT_BUTTON);
    }

    public void clickToSaveAttachmentButton() {
        waitForElementClickable(ContactDetailsPageUI.SAVE_ATTACHMENT_BUTTON);
        clickToElement(ContactDetailsPageUI.SAVE_ATTACHMENT_BUTTON);
    }
    public void enterToStreet1Textbox(String street1){
        waitForElementVisible(ContactDetailsPageUI.STREET1_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.STREET1_TEXTBOX,street1);
    }
    public void enterToStreet2Textbox(String street2){
        waitForElementVisible(ContactDetailsPageUI.STREET2_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.STREET2_TEXTBOX,street2);
    }

    public void enterToCityTextbox(String city){
        waitForElementVisible(ContactDetailsPageUI.CITY_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.CITY_TEXTBOX,city);
    }

    public void enterToStateTextbox(String stateProvince){
        waitForElementVisible(ContactDetailsPageUI.STATE_PROVINCE_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.STATE_PROVINCE_TEXTBOX,stateProvince);
    }

    public void enterToZipCodeTextbox(String zipCode){
        waitForElementVisible(ContactDetailsPageUI.ZIP_CODE_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.ZIP_CODE_TEXTBOX,zipCode);
    }
    public void selectToCountryDropdown(String country){
        selectItemInCustomDropdown(ContactDetailsPageUI.COUNTRY_PARENT, ContactDetailsPageUI.COUNTRY_CHILD, country);
    }

    public void enterToHomeTextbox(String homeTelephone){
        waitForElementVisible(ContactDetailsPageUI.HOME_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.HOME_TEXTBOX,homeTelephone);
    }

    public void enterToMobileTextbox(String mobile){
        waitForElementVisible(ContactDetailsPageUI.MOBILE_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.MOBILE_TEXTBOX,mobile);
    }

    public void enterToWorkTelephoneTextbox(String workTelephone){
        waitForElementVisible(ContactDetailsPageUI.WORK_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.WORK_TEXTBOX,workTelephone);
    }
    public void enterToWorkEmailTextbox(String workEmail){
        waitForElementVisible(ContactDetailsPageUI.WORK_EMAIL_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.WORK_EMAIL_TEXTBOX,workEmail);
    }
    public void enterToOtherEmailTextbox(String otherEmail){
        waitForElementVisible(ContactDetailsPageUI.OTHER_EMAIL_TEXTBOX);
        sendKeyToElement(ContactDetailsPageUI.OTHER_EMAIL_TEXTBOX,otherEmail);
    }
    public void enterToCommentTextarea(String comment){
        waitForElementVisible(ContactDetailsPageUI.COMMENT_TEXTAREA);
        sendKeyToElement(ContactDetailsPageUI.COMMENT_TEXTAREA,comment);
    }
    public void clickToSaveButtonOnContactDetails() {
        clickToElement(ContactDetailsPageUI.SAVE_BUTTON);
    }

    public String getToStreet1Textbox() {
        return getElementText(ContactDetailsPageUI.STREET1_TEXTBOX);
    }
}
