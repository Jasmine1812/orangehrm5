package pageObjects;

import commons.BaseActions;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AddEmployeePageUI;


public class AddEmployeePageObject extends BaseActions {
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


    public String getEmployeeID() {
        waitForElementVisible(AddEmployeePageUI.EMPLOYEE_ID);
        return getElementAttributeValue(AddEmployeePageUI.EMPLOYEE_ID, "value");
    }


}
