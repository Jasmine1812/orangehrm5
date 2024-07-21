package pageObjects;

import commons.BaseActions;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AddEmployeePageUI;
import pageUIs.admin.EmployeeListPageUI;

public class EmployeeListPageObject extends BaseActions {
    private WebDriver driver;
    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeLink() {
        waitForElementClickable(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
        clickToElement(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
        waitForSpinnerIconInvisible();
        return PageGenerator.getAddEmployeeListPage(driver);
    }

    public void enterToEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(EmployeeListPageUI.EMPLOYEE_ID);
        sendKeyToElement(EmployeeListPageUI.EMPLOYEE_ID, employeeID);
    }

    public void clickToSearchButton() {
        waitForElementClickable(EmployeeListPageUI.SEARCH_BUTTON);
        clickToElement(EmployeeListPageUI.SEARCH_BUTTON);
    }

}
