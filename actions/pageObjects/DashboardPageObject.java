package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.DashboardPageUI;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToPIMLink() {
        waitForElementClickable(DashboardPageUI.PIM_LINK);
        clickToElement(DashboardPageUI.PIM_LINK);
    }
}
