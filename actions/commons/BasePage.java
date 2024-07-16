package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private WebDriver driver;
    private long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageUrl(String url) {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void refreshCurrentPage() {
        driver.navigate().refresh();
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    private By getByLocator(String locatorValue) {
        By by = null;
        if (locatorValue.startsWith("Xpath=") || locatorValue.startsWith("xpath=") || locatorValue.startsWith("XPATH=") || locatorValue.startsWith("XPath=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.startsWith("ID=") || locatorValue.startsWith("Id=") || locatorValue.startsWith("id=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.startsWith("class=") || locatorValue.startsWith("Class=") || locatorValue.startsWith("CLass=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.startsWith("css=") || locatorValue.startsWith("CSS=") || locatorValue.startsWith("Css=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.startsWith("Name=") || locatorValue.startsWith("NAME=") || locatorValue.startsWith("name=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.startsWith("tagName=") || locatorValue.startsWith("TagName=") || locatorValue.startsWith("Tagname=") || locatorValue.startsWith("tagname=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid");
        }
        return by;
    }

    public WebElement getElement(String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getElement(String locator, String... restParams) {
        return driver.findElement(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public List<WebElement> getListElement(String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public int getListElementSize(String locator) {
        return getListElement(locator).size();
    }

    public int getListElementSize(String locator, String... restParams) {
        return getListElement(locator, restParams).size();
    }

    public void clickToElement(String locator) {
        getElement(locator).click();
    }

    public void clickToElement(String locator, String... restParams) {
        getElement(locator, restParams).click();
    }

    public void sendKeyToElement(String locator, String keysToSend) {
        getElement(locator).clear();
        getElement(locator).sendKeys(keysToSend);
    }

    public void sendKeyToElement(String locator, String keysToSend, String... restParams) {
        getElement(getDynamicLocator(locator, restParams)).clear();
        getElement(getDynamicLocator(locator, restParams)).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(String locator, String textItem) {
        new Select(getElement(locator)).selectByVisibleText(textItem);
    }

    public void selectItemInDropdown(String locator, String textItem, String... restParams) {
        new Select(getElement(getDynamicLocator(locator, restParams))).selectByVisibleText(textItem);
    }

    public String getSelectedItemInDropdown(String locator) {
        return new Select(getElement(locator)).getFirstSelectedOption().getText();
    }


    public void selectItemInCustomDropdown(String parentLocator, String childItemLocator, String expectedItem) {
        getElement(parentLocator).click();
        sleepInSeconds(2);

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));
        sleepInSeconds(2);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }

    }

    public void waitForElementVisible(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementClickable(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(String locator, String... restParams) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
    }

    public void waitForElementInvisible(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void sleepInSeconds(long timeSecond) {
        try {
            Thread.sleep(timeSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean isPageLoadedSuccess() {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery!=null)&&(jQuery.active===0);");
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);

    }

    public void uploadMultipleFiles(String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";
        for (String file : fileNames) {
            fullFileName = fullFileName + filePath + file + "\n";
        }
        fullFileName = fullFileName.trim();
//        getElement(BasePageUI.UPLOAD_FILE).sendKeys(fullFileName);
    }
}
