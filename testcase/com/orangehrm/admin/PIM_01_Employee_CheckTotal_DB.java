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

import java.lang.reflect.Method;

public class PIM_01_Employee_CheckTotal_DB extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject homepage;
    private String browserName;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private ContactDetailsPageObject contactDetailsPage;
    private EmergencyContactPageObject emergencyContactPage;
    private DataFakerConfig fakerConfig;

    String nameContact, relationship, otherId, driversLicenseNumber, licenseExpiryDate, nationality, maritalStatus, gender, dateOfBirth, firstName, middleName,
            lastName, employeeID, file1, file2, file3, multiFile,street1, street2, city, stateProvince, zipCode, country, homeTelephone, workTelephone, mobile,other_Email,comment,work_Email;



    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        fakerConfig = DataFakerConfig.getFaker();
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        homepage = loginPage.clickToLoginButton();
        employeeListPage = homepage.openEmployeeListPage();

    }

    @Test
    public void TC_Verify_Total_Employee_FromDB(Method method) {
        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_Verify_Total_Employee_FromDB");
        int employeeNumberInUI = employeeListPage.getEmployeeListNumberInUI();
        int employeeumberInDB = employeeListPage.getEmployeeListNumberInDB();
        System.out.println("employeeNumberInUI " + employeeNumberInUI);
        System.out.println("employeeumberInDB " + employeeumberInDB);
        Assert.assertEquals(employeeNumberInUI, employeeumberInDB);
    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



}
