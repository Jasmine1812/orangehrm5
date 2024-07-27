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
    private ContactDetailsPageObject contactDetailsPage;
    String firstName = "David";
    String middleName = "Trong";
    String lastName = "Duc";
    String employeeID;
    String file1 = "996.png";
    String file2 = "997.png";
    String file3 = "998.png";
    String multiFile[] = {file1, file2, file3};

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

    @Test
    public void TC_02_Update_Personal_Details() {
        personalDetailsPage = employeeListPage.openPersonalDetailsByEditIcon("1", "Id", employeeID);
        personalDetailsPage.enterToOtherIdTextbox(otherId);
        personalDetailsPage.enterToDriversLicenseNumberTextbox(driversLicenseNumber);
        personalDetailsPage.enterTolicenseExpiryDateDatePicker(licenseExpiryDate);
        personalDetailsPage.enterToDateOfBirthteDatePicker(dateOfBirth);
        personalDetailsPage.selectToNationalityDropdown(nationality);
        personalDetailsPage.selectToMaritalStatusDropdown(maritalStatus);
        personalDetailsPage.clickToRadioButtonByLabelName(gender);
        personalDetailsPage.clickToSaveButtonOnPersonalDetails();
        Assert.assertTrue(personalDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
        personalDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), nationality);
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), maritalStatus);
        Assert.assertTrue(personalDetailsPage.isRadioButtonSelectedByLabelName(gender));

    }

    @Test
    public void TC_03_Add_Contact_Details() {
        personalDetailsPage.openDynamicLeftMenuPIMByText("Contact Details");
        contactDetailsPage = PageGenerator.getContactDetailsPage(driver);
        contactDetailsPage.waitForSpinnerIconInvisible();
        contactDetailsPage.clickToAddAttachmentsButton();
        contactDetailsPage.uploadOneFile(file1);
//        contactDetailsPage.uploadMultipleFiles(multiFile);
    }

    String otherId = "112233";
    String driversLicenseNumber = "A123-456-8899";
    String licenseExpiryDate = "2028-10-25";
    String nationality = "Canadian";
    String maritalStatus = "Married";
    String gender = "Male";
    String dateOfBirth = "1991-04-10";


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }


}
