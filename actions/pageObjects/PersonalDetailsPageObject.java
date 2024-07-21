package pageObjects;

import commons.BaseActions;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.EmployeeListPageUI;
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
}
