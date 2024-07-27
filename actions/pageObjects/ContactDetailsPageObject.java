package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.ContactDetailsPageUI;

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
}
