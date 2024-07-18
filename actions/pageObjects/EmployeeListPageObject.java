package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AddEmployeePageUI;
import pageUIs.admin.EmployeeListPageUI;

public class EmployeeListPageObject extends BasePage {
    private WebDriver driver;
    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddEmployeeLink() {
        waitForElementClickable(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
        clickToElement(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
    }

    public void enterToEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(EmployeeListPageUI.EMPLOYEE_ID);
        sendKeyToElement(EmployeeListPageUI.EMPLOYEE_ID, employeeID);
    }
}
