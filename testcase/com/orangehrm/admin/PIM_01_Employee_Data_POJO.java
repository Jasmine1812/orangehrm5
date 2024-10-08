package com.orangehrm.admin;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pojoData.EmployeeInfor;
import pojoData.PersonalDetailsInfor;
import reportConfig.ExtentTestManager;
import utilities.DataFakerConfig;

import java.lang.reflect.Method;

public class PIM_01_Employee_Data_POJO extends BaseTest {
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
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        this.browserName = browserName;
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.enterToUserNameTextBox("Admin");
        loginPage.enterToPasswordTextBox("Admin@admin123");
        homepage = loginPage.clickToLoginButton();
        employeeListPage = homepage.openEmployeeListPage();
        employeeInfor = EmployeeInfor.getEmployeeInfor();
        employeeInfor.setFirstName("Tran");
        employeeInfor.setMiddleName("Thai");
        employeeInfor.setLastName("Tong");
        personalDetailsInfor = PersonalDetailsInfor.getPersonalDetailsInfor();
        personalDetailsInfor.setOtherId("123456");
        personalDetailsInfor.setDriversLicenseNumber("A123-456-8899");
        personalDetailsInfor.setDateOfBirth("1991-04-10");
        personalDetailsInfor.setGender("Male");
        personalDetailsInfor.setLicenseExpiryDate("2028-10-25");
        personalDetailsInfor.setMaritalStatus("Married");
        personalDetailsInfor.setNationality("Vietnamese");
    }

    @Test
    public void TC_01_Add_Employee(Method method) {
        ExtentTestManager.startTest(method.getName() + " - " + this.browserName.toUpperCase(), "TC_01_Add_Employee");

        addEmployeePage = employeeListPage.clickToAddEmployeeLink();
        addEmployeePage.EnterToFirstNameTextbox(employeeInfor.getFirstName());
        addEmployeePage.EnterToMiddleNameTextbox(employeeInfor.getMiddleName());
        addEmployeePage.EnterToLastNameTextbox(employeeInfor.getLastName());
        employeeInfor.setEmployeeID(addEmployeePage.getEmployeeID());
        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isSuccessMessageDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);
        Assert.assertTrue(personalDetailsPage.isHeaderTitleDisplayed());
        personalDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(personalDetailsPage.getFirstName(), employeeInfor.getFirstName());
        Assert.assertEquals(personalDetailsPage.getLastName(), employeeInfor.getLastName());
        Assert.assertEquals(personalDetailsPage.getMiddleName(), employeeInfor.getMiddleName());
        Assert.assertEquals(personalDetailsPage.getEmployeeID(), employeeInfor.getEmployeeID());
        employeeListPage = personalDetailsPage.clickToEmployeeListLink();
        employeeListPage.waitForSpinnerIconInvisible();
        employeeListPage.enterToEmployeeIDTextbox(employeeInfor.getEmployeeID());
        employeeListPage.clickToSearchButton();
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Id", employeeInfor.getEmployeeID()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "First (& Middle) Name", employeeInfor.getFirstName() + " " + employeeInfor.getMiddleName()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColumnName("1", "Last Name", employeeInfor.getLastName()));
    }

    @Test
    public void TC_02_Update_Personal_Details() {
        personalDetailsPage = employeeListPage.openPersonalDetailsByEditIcon("1", "Id", employeeInfor.getEmployeeID());
        personalDetailsPage.setPersonalDetail(personalDetailsInfor);
        personalDetailsPage.clickToSaveButtonOnPersonalDetails();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
        personalDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), personalDetailsInfor.getNationality());
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), personalDetailsInfor.getMaritalStatus());
        Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(personalDetailsInfor.getGender()));

    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }


}
