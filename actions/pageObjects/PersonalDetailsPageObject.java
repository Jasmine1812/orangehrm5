package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.EmployeeListPageUI;
import pageUIs.admin.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends BasePage {
    public String getFirstName(){
        waitForElementVisible(PersonalDetailsPageUI.FIRST_NAME);
        return getElementText(PersonalDetailsPageUI.FIRST_NAME);
    }
    public String getMiddleName(){
        waitForElementVisible(PersonalDetailsPageUI.MIDDLE_NAME);
        return getElementText(PersonalDetailsPageUI.MIDDLE_NAME);
    }
    public String getLastName(){
        waitForElementVisible(PersonalDetailsPageUI.LAST_NAME);
        return getElementText(PersonalDetailsPageUI.LAST_NAME);
    }
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getEmployeeID() {
        waitForElementVisible(PersonalDetailsPageUI.EMPLOYEE_ID);
        return getElementText(PersonalDetailsPageUI.EMPLOYEE_ID);
    }

    public void clickToEmployeeListLink() {
        waitForElementClickable(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
        clickToElement(PersonalDetailsPageUI.EMPLOYEE_LIST_LINK);
    }
}
