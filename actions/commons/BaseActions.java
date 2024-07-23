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

    public boolean isSuccessMessageDisplayed(String message){
        waitForElementVisible(BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE, message);
        return isElementDisplayed(BaseActionsPageUI.DYNAMIC_SUCCESS_MESSAGE,message);
    }

    public void waitForSpinnerIconInvisible(){
        waitForListElementInvisible(BaseActionsPageUI.SPINNER_ICON);
    }
    public PersonalDetailsPageObject openPersonalDetailsByEditIcon(String rowIndex, String columnName, String valueCell){
        int columnIndex = getListElementSize(BaseActionsPageUI.COLUMN_INDEX_BY_COMLUMN_NAME, columnName) + 1;
        waitForElementClickable(BaseActionsPageUI.DYNAMIC_EDIT_ICON_BY_COLUMN_INDDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
        clickToElement(BaseActionsPageUI.DYNAMIC_EDIT_ICON_BY_COLUMN_INDDEX_AND_ROW_INDEX, rowIndex, String.valueOf(columnIndex), valueCell);
        waitForSpinnerIconInvisible();
        return new PersonalDetailsPageObject(driver);
    }

    public void clickToRadioButtonByLabelName(String gender) {
        clickToElementByJS(BaseActionsPageUI.GENDER_STATUS, gender);
        sleepInSeconds(3);
    }

    public boolean isRadioButtonSelectedByLabelName(String gender) {
        return isElementSelected(BaseActionsPageUI.GENDER_STATUS, gender);
    }




}
