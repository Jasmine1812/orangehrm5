package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.PersonalDetailsPageObject;
import pageUIs.admin.BaseActionsPageUI;
import pageUIs.admin.PersonalDetailsPageUI;

public class BaseActions extends BasePage {
    WebDriver driver;

    public BaseActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isValueDisplayedAtColumnName(String rowIndex, String columnName, String valueCell) {
        int columnIndex = getListElementSize(BaseActionsPageUI.COLUMN_INDEX_BY_COMLUMN_NAME, columnName) + 1;
        return isElementDisplayed(BaseActionsPageUI.DYNAMIC_CELL_VALUE_BY_COMLUMN_INDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
    }

    public boolean isSuccessMessageDisplayed(String message) {
        waitForElementVisible(BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
        return isElementDisplayed(BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
    }

    public void waitForSpinnerIconInvisible() {
        waitForListElementInvisible(BaseActionsPageUI.SPINNER_ICON);
    }

    public PersonalDetailsPageObject openPersonalDetailsByEditIcon(String rowIndex, String columnName, String valueCell) {
        int columnIndex = getListElementSize(BaseActionsPageUI.COLUMN_INDEX_BY_COMLUMN_NAME, columnName) + 1;
        waitForElementClickable(BaseActionsPageUI.DYNAMIC_EDIT_ICON_BY_COLUMN_INDDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
        clickToElement(BaseActionsPageUI.DYNAMIC_EDIT_ICON_BY_COLUMN_INDDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
        waitForSpinnerIconInvisible();
        return new PersonalDetailsPageObject(driver);
    }

    public void clickToRadioButtonByLabelName(String gender) {
        clickToElementByJS(BaseActionsPageUI.GENDER_STATUS, gender);
    }

    public boolean isRadioButtonSelectedByLabelName(String gender) {
        return isElementSelected(BaseActionsPageUI.GENDER_STATUS, gender);
    }


    public void openDynamicLeftMenuPIMByText(String pageName) {
        clickToElementByJS(BaseActionsPageUI.DYAMIC_LEFT_MENU_PIM_BY_TEXT, pageName);
    }

    public void uploadOneFile(String fileName) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = filePath + fileName;
        getElement(BaseActionsPageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }

    public void uploadMultipleFiles(String... fileName) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileName) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        getElement(BaseActionsPageUI.UPLOAD_FILE).sendKeys(fullFileName);
        sleepInSeconds(4);
    }


    public boolean isWarningMessageDisplayed(String message) {
        waitForElementVisible(BaseActionsPageUI.DYNAMIC_WARNING_MESSAGE, message);
        return isElementDisplayed(BaseActionsPageUI.DYNAMIC_WARNING_MESSAGE, message);
    }
}
