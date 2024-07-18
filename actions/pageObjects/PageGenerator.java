package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static DashboardPageObject getHomepage(WebDriver driver) {
        return new DashboardPageObject(driver);
    }
}
