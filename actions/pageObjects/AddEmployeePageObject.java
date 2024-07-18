package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AddEmployeePageUI;
import pageUIs.admin.BaseElementUI;


public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;
    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void EnterToFirstNameTextbox(String firstName) {
        waitForElementVisible(AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void EnterToMiddleNameTextbox(String middleName) {
        waitForElementVisible(AddEmployeePageUI.MIDDLE_NAME_TEXTBOX);
        sendKeyToElement(AddEmployeePageUI.MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void EnterToLastNameTextbox(String lastName) {
        waitForElementVisible(AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(AddEmployeePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void clickToSaveButton() {
        waitForElementClickable(AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(AddEmployeePageUI.SAVE_BUTTON);
    }

    public String getMessageSuccess() {
        waitForElementVisible(BaseElementUI.TOAST_MESSAGE);
        return getElementText(BaseElementUI.TOAST_MESSAGE);
    }

    public String getEmployeeID() {
        waitForElementVisible(AddEmployeePageUI.EMPLOYEE_ID);
        return getElementText(AddEmployeePageUI.EMPLOYEE_ID);
    }
}
