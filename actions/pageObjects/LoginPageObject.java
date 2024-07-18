package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToUserNameTextBox(String username) {
        waitForElementVisible(LoginPageUI.USER_NAME_TEXTBOX);
        sendKeyToElement(LoginPageUI.USER_NAME_TEXTBOX, username);
    }
    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
    }
    public void clickToLoginButton() {
        waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
        clickToElement(LoginPageUI.LOGIN_BUTTON);
    }

}
