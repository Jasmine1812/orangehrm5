package pageObjects;

import commons.BaseActions;
import commons.BasePage;
import connectDB.MySQLConnUtils;
import connectDB.MySQLTestConnection;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AddEmployeePageUI;
import pageUIs.admin.EmployeeListPageUI;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListPageObject extends BaseActions {
    private WebDriver driver;
    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePageObject clickToAddEmployeeLink() {
        waitForElementClickable(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
        clickToElement(EmployeeListPageUI.ADD_EMPLOYEE_LINK);
        waitForSpinnerIconInvisible();
        return PageGenerator.getAddEmployeeListPage(driver);
    }

    public void enterToEmployeeIDTextbox(String employeeID) {
        waitForElementVisible(EmployeeListPageUI.EMPLOYEE_ID);
        sendKeyToElement(EmployeeListPageUI.EMPLOYEE_ID, employeeID);
    }

    public void clickToSearchButton() {
        waitForElementClickable(EmployeeListPageUI.SEARCH_BUTTON);
        clickToElement(EmployeeListPageUI.SEARCH_BUTTON);
    }

    public String getNoRecordsMessage() {
        waitForElementVisible(EmployeeListPageUI.NO_RECORDS_MESSAGE);
        return getElementText(EmployeeListPageUI.NO_RECORDS_MESSAGE);
    }

    public void enterToEmployeeNameTextbox(String name) {
        waitForElementVisible(EmployeeListPageUI.EMPLOYEE_NAME);
        sendKeyToElement(EmployeeListPageUI.EMPLOYEE_NAME, name);
    }

    public int getEmployeeListNumberInUI() {
        waitForElementVisible(EmployeeListPageUI.TOTAL_RECORD);
        return Integer.parseInt(getElementText(EmployeeListPageUI.TOTAL_RECORD).replaceAll("[^0-9]", ""));
    }

    public int getEmployeeListNumberInDB() {
        List<Integer> totalUsers = new ArrayList<Integer>();
        String sql = "SELECT * FROM hs_hr_employee;";
        Connection conn = MySQLConnUtils.getMySQLConnection();
        Statement statement;
        try{
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                totalUsers.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return totalUsers.size();
    }
}
