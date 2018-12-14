package elibrary.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserWrapper {

    protected WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BrowserWrapper.class.getName());

    public static final int STANDARD_WAIT_TIME = 10;

    BrowserWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public String getStringDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(new Date());
    }

    public Date getDate() {
        return new Date();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void goTo(String url) {
        driver.get(url);
        if (driver.getClass().getName().equalsIgnoreCase("org.openqa.selenium.ie.InternetExplorerDriver") && isElementPresentById("overridelink")) {
            driver.findElement(By.id("overridelink")).click();
        }
//        logger.info(url + " " + "opened");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean containsText(String text) {
        if (driver.getPageSource().contains(text)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementPresentById(String id) {
        try {
            return driver.findElement(By.id(id)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String checkIfElementNotPresent(WebElement element) {
        try {
            element.isDisplayed();
            return "";
        } catch (Exception e) {
            return element.toString();
        }
    }

    public void doubleClick(WebElement element) {
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }

    public void doubleClickOnCoordinates(WebElement element, int x, int y) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element, x, y).doubleClick().build().perform();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void browserBack() {
        driver.navigate().back();
    }

    public void implicitWait(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public void waitUntilAlertIsPresent() {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.alertIsPresent());
    }

    public void waitUntilElementSelectionState(WebElement element, boolean bool) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementSelectionStateToBe(element, bool));
    }

    public void waitUntilElementClickable(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilElementSelected(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitUntilElementVisible(WebElement element) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementInvisible(By locator) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitUntilTitleContains(String title) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.titleContains(title));
    }

    public void waitUntilAllVisible(List<WebElement> elements) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitUntilElementIsPresent(By locator) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitUntilUrlAvaliable(String url) {
        new WebDriverWait(driver, STANDARD_WAIT_TIME).until(ExpectedConditions.urlToBe(url));
    }

    public void selectDropdown(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public static String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public void sleep(int Seconds) {
        try {
            Thread.sleep(Seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDataFromTable(int k, int l) {
        int rowCount = getDriver().findElements(By.xpath("//table/tbody/tr")).size();
        int colCount = getDriver().findElements(By.xpath("//table/tbody/tr[1]/td")).size();

        String firstPart = "//table/tbody/tr[";
        String secondPart = "]/td[";
        String thirdPart = "]";

        String finalXpath = firstPart + k + secondPart + l + thirdPart;
        String tableData = getDriver().findElement(By.xpath(finalXpath)).getText();
        return tableData;
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void browserMaximize() {
        driver.manage().window().maximize();
    }

    public void assertTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (Throwable ex) {
            logger.error(ex);
            throw new Error();
        }
    }
}

