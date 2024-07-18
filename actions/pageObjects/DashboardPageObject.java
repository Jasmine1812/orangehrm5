package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;
    public DashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
