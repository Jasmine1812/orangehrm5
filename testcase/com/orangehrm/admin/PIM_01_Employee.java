package com.orangehrm.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    String firstName = "Nguyen";String middleName = "Trong";String lastName = "Duc";String employeeID;

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
        homepage.clickToPIMLink();
        employeeListPage = PageGenerator.getEmployeeListPage(driver);


    }

    @Test
    public void TC_01_Add_Employee() {
//        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01");
        employeeListPage.clickToAddEmployeeLink();
        addEmployeePage = PageGenerator.getAddEmployeeListPage(driver);
        addEmployeePage.EnterToFirstNameTextbox(firstName);
        addEmployeePage.EnterToMiddleNameTextbox(middleName);
        addEmployeePage.EnterToLastNameTextbox(lastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        Assert.assertEquals(addEmployeePage.getMessageSuccess(), "Successfully Saved");
        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), middleName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        personalDetailsPage.clickToEmployeeListLink();
        employeeListPage = PageGenerator.getEmployeeListPage(driver);
        employeeListPage.enterToEmployeeIDTextbox(employeeID);
    }

    @Test
    public void TC_02() {

    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }


}
