package com.orangehrm.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGenerator;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        loginPage.clickToLoginButton();
        homepage = PageGenerator.getHomepage(driver);

    }

//    @Test
    public void TC_01(Method method){
        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01");

    }

    @Test
    public void TC_02(){

    }


    @AfterClass
    public void afterClass(){
        closeBrowserDriver();
    }


}
