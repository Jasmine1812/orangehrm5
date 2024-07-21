package commons;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.BaseActionsPageUI;

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


}
