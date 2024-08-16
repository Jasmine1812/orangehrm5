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
import utilities.DataFakerConfig;
import utilities.ExcelConfig;

import java.lang.reflect.Method;

public class PIM_01_Employee_Data_Excel extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private ExcelConfig excelConfig;

    String firstName, middleName, lastName, employeeID;


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
        excelConfig = ExcelConfig.getExcelData();
        excelConfig.switchToSheet("employeeInfo");

        firstName = excelConfig.getCellData("FirstName", 1);
        middleName = excelConfig.getCellData("MiddleName", 1);
        lastName = excelConfig.getCellData("LastName", 1);


    }

    @Test
    public void TC_01_Add_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01_Add_Employee");

        addEmployeePage = employeeListPage.clickToAddEmployeeLink();
        addEmployeePage.EnterToFirstNameTextbox(firstName);
        addEmployeePage.EnterToMiddleNameTextbox(middleName);
        addEmployeePage.EnterToLastNameTextbox(lastName);
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        Assert.assertTrue(personalDetailsPage.isHeaderTitleDisplayed());
        personalDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), middleName);
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeID);
        employeeListPage = personalDetailsPage.clickToEmployeeListLink();
        employeeListPage.waitForSpinnerIconInvisible();
        employeeListPage.enterToEmployeeIDTextbox(employeeID);
        employeeListPage.clickToSearchButton();
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Id", employeeID));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "First (& Middle) Name", firstName + " " + middleName));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Last Name", lastName));
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }


}
