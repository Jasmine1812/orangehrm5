package com.orangehrm.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pojoData.EmployeeInfor;
import pojoData.PersonalDetailsInfor;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class PIM_01_Employee_Data_Search_Test_Not_Dependency extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private EmployeeInfor employeeInfor;
    private PersonalDetailsInfor personalDetailsInfor;



    @Parameters({"browser", "url"})
    @BeforeMethod
    public void beforeMethod(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        homepage = loginPage.clickToLoginButton();
        employeeListPage = homepage.openEmployeeListPage();
    }

    @Test
    public void TC_01_shouldBeSearchByEmptyData() {
        employeeListPage.clickToSearchButton();
    }

    @Test
    public void TC_02_shouldBeSearchByContainsEmployeeName() {
        employeeListPage.enterToEmployeeNameTextbox("Bia");
        employeeListPage.clickToSearchButton();
    }

    @Test
    public void shouldBeSearchByEmployeeIDNotExist() {
        employeeListPage.enterToEmployeeIDTextbox("10002");
        employeeListPage.clickToSearchButton();
        Assert.assertEquals(employeeListPage.getNoRecordsMessage(),"No Records Found");
        Assert.assertTrue(employeeListPage.isWarningMessageDisplayed("No Records Found"));
    }


    @AfterMethod
    public void afterMethod() {
        closeBrowserDriver();
    }


}
