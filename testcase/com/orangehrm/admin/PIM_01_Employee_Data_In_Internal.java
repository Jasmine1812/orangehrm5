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
import staticVariable.EmployeeObject;

import java.lang.reflect.Method;

public class PIM_01_Employee_Data_In_Internal extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private EmployeeObject employeeObject;
    String employeeID;


    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        homepage = loginPage.clickToLoginButton();
        employeeListPage = homepage.openEmployeeListPage();
        employeeObject = EmployeeObject.getEmployeeObject();

    }

    @Test
    public void TC_01_Add_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01_Add_Employee");

        addEmployeePage = employeeListPage.clickToAddEmployeeLink();
        addEmployeePage.EnterToFirstNameTextbox(employeeObject.FIRST_NAME);
        addEmployeePage.EnterToMiddleNameTextbox(employeeObject.MIDDLE_NAME);
        addEmployeePage.EnterToLastNameTextbox(employeeObject.LAST_NAME);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        Assert.assertTrue(personalDetailsPage.isHeaderTitleDisplayed());
        personalDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(personalDetailsPage.getFirstName(), employeeObject.FIRST_NAME);
        Assert.assertEquals(personalDetailsPage.getLastName(), employeeObject.LAST_NAME);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), employeeObject.MIDDLE_NAME);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        employeeListPage = personalDetailsPage.clickToEmployeeListLink();
        employeeListPage.waitForSpinnerIconInvisible();
        employeeListPage.enterToEmployeeIDTextbox(employeeID);
        employeeListPage.clickToSearchButton();
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Id", employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "First (& Middle) Name", employeeObject.FIRST_NAME + " " + employeeObject.MIDDLE_NAME));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Last Name", employeeObject.LAST_NAME));
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



}
