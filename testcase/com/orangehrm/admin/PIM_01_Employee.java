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

public class PIM_01_Employee extends BaseTest {
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
        nameContact = fakerConfig.getNameContact();
        relationship = fakerConfig.getRelationship();
        otherId = fakerConfig.getOtherId();
//        driversLicenseNumber = fakerConfig.getDriversLicenseNumber();
        driversLicenseNumber = "A123-456-8899";
        licenseExpiryDate = "2028-10-25";
//        nationality = fakerConfig.getNationality();
        nationality = "Vietnamese";
        maritalStatus = "Married";
//        maritalStatus = fakerConfig.getMaritalStatus();
//        gender = fakerConfig.getGender();
        gender = "Male";
        dateOfBirth = "1991-04-10";
        firstName = fakerConfig.getFirstName();
        middleName = fakerConfig.getMiddleName();
        lastName = fakerConfig.getLastName();
        employeeID = fakerConfig.getEmployeeID();
        file1 = "996.png";
        file2 = "997.png";
        file3 = "998.png";
//        multiFile[] = {file1, file2, file3};
        street1 = fakerConfig.getStreet1();
        street2 = fakerConfig.getStreet2();
        city = fakerConfig.getCity();
        stateProvince = fakerConfig.getStateProvince();
        zipCode = fakerConfig.getZipCode();
        country = "Aruba";
        homeTelephone = fakerConfig.getHomeTelephone();
        workTelephone = fakerConfig.getWorkTelephone();
        mobile = fakerConfig.getMobile();
        other_Email = fakerConfig.getEmail();
        work_Email = fakerConfig.getEmail();
        comment = fakerConfig.getComment();

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
        //Contact Details
        contactDetailsPage.enterToStreet1Textbox(street1);
        contactDetailsPage.enterToStreet2Textbox(street2);
        contactDetailsPage.enterToCityTextbox(city);
        contactDetailsPage.enterToStateTextbox(stateProvince);
        contactDetailsPage.enterToZipCodeTextbox(zipCode);
        contactDetailsPage.selectToCountryDropdown(country);
        contactDetailsPage.enterToHomeTextbox(homeTelephone);
        contactDetailsPage.enterToMobileTextbox(mobile);
        contactDetailsPage.enterToWorkTelephoneTextbox(workTelephone);
        contactDetailsPage.enterToWorkEmailTextbox(work_Email);
        contactDetailsPage.enterToOtherEmailTextbox(other_Email);
        contactDetailsPage.clickToSaveButtonOnContactDetails();
        Assert.assertTrue(contactDetailsPage.isSuccessMessageDisplayed("Successfully Updated"));
        contactDetailsPage.waitForSpinnerIconInvisible();
        Assert.assertEquals(contactDetailsPage.getToStreet1Textbox(), street1);
        //Attachment

        contactDetailsPage.clickToAddAttachmentsButton();
        contactDetailsPage.uploadOneFile(file1);
        contactDetailsPage.enterToCommentTextarea(comment);
        contactDetailsPage.clickToSaveAttachmentButton();
        Assert.assertTrue(contactDetailsPage.isSuccessMessageDisplayed("Successfully Saved"));
        contactDetailsPage.waitForSpinnerIconInvisible();
    }

    @Test
    public void TC_04_Add_Emergency_Contacts() {
        contactDetailsPage.openDynamicLeftMenuPIMByText("Emergency Contacts");
        emergencyContactPage = PageGenerator.getEmergencyContactPage(driver);
        emergencyContactPage.waitForSpinnerIconInvisible();
        emergencyContactPage.clickToAddContactButton();
        emergencyContactPage.enterToNameTextbox(nameContact);
        emergencyContactPage.enterToRelationshipTextbox(relationship);
        emergencyContactPage.enterToHomeTelephoneTextbox(homeTelephone);
        emergencyContactPage.enterToMobileTextbox(mobile);
        emergencyContactPage.enterToWorkTelephone(workTelephone);
        emergencyContactPage.clickToSaveContactButton();
        Assert.assertTrue(emergencyContactPage.isSuccessMessageDisplayed("Successfully Saved"));
        emergencyContactPage.waitForSpinnerIconInvisible();
        emergencyContactPage.isValueDisplayedAtColumnNameInContact("1", "Name", nameContact);
        emergencyContactPage.isValueDisplayedAtColumnNameInContact("1", "Relationship", relationship);
        emergencyContactPage.isValueDisplayedAtColumnNameInContact("1", "Home Telephone", homeTelephone);
        emergencyContactPage.isValueDisplayedAtColumnNameInContact("1", "Mobile", mobile);
        emergencyContactPage.isValueDisplayedAtColumnNameInContact("1", "Work Telephone", workTelephone);

    }


    @AfterClass
    public void afterClass() {
        closeBrowserDriver();
    }



}
