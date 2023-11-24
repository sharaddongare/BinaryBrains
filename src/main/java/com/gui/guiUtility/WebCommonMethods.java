package com.gui.guiUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;

public class WebCommonMethods {

    public Logger logger = LogManager.getLogger(WebCommonMethods.class);
    private static final int WAIT_TIMEOUT = 20;
    private static final int WAIT_FREQUENCY = 3;
    private WebDriver driver = DriverFactory.getDriver();

    /**
     * @param element - passed as an argument to perform click operation
     */
    public void clickOnElement(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
            logger.info("Click on " + element);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Unable to find element: {}", e);
        }
    }

    /**
     * @param webElementPath - passed as an argument to perform click operation using JavascriptExecutor
     */
    public void clickWebElementJSE(By webElementPath) {
        WebElement element = driver.findElement(webElementPath);
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT));
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * @param webElementPath - passed as an argument to write value in web element
     * @param value
     */
    public void fillValueInWebElement(By webElementPath, String value) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(WAIT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(webElementPath)).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(webElementPath)).sendKeys(value);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Unable to find Webelement :{}", e);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * @param webElementPath - passed as an argument to write value in web element using JavascriptExecutor
     * @param val
     */
    public void fillValueInWebElementJSE(By webElementPath, String val) {
        int count = WAIT_FREQUENCY;
        WebElement element = driver.findElement(webElementPath);
        while (count <= WAIT_TIMEOUT) {
            try {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_FREQUENCY));
                JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
                myExecutor.executeScript("arguments[0].value-" + val + ";", element);
                break;
            } catch (Exception e) {
                count += WAIT_FREQUENCY;
                if (count == WAIT_TIMEOUT)
                    throw e;
            }
        }
    }

    /**
     * @param element - passed as an argument to check presence of element on web page
     * @return
     */
    public boolean isWebElementPresent(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
            return false;
        }
    }

    /**
     * @param element - passed as an argument to perform  switch To Window operation
     */
    public void switchToWindow(By element) {
        String currentwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String childwindow : allWindows) {
            if (!childwindow.equalsIgnoreCase(currentwindow)) {
                driver.switchTo().window(childwindow);
                clickWebElementJSE(element);
            }
        }
        driver.switchTo().window(currentwindow);
    }

    /**
     * @param message - passed as an argument to handle Alerts popup up
     */
    public void handleAlerts(String message) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();
            if (message.equals("")) {
                alert.dismiss();
            } else if (alertMessage.contains(message)) {
                alert.accept();
            } else {
                logger.info("Alert message is:" + message);
                logger.info("Alert message is:" + message);
            }
            logger.info(alertMessage);
        } catch (Exception ex) {
            logger.info("Alert is not displayed on the page");
        }
    }

    /**
     * @param element - passed as an argument to wait until element is Visible
     */
    public void waitForVisible(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to get text of an element once visible
     * @return
     */
    public String getTextOfElementOnceVisible(By element) {
        this.waitForVisible(element);
        return driver.findElement(element).getText();
    }

    /**
     * @param element - passed as an argument to wait for Clickable operation
     */
    public void waitForClickable(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to wait for element to disappear
     */
    public void waitForElementToDisappear(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to select option by Text from dropdown
     * @param text
     */
    public void selectOptionByText(By element, String text) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            Select dropdown = new Select(ele);
            dropdown.selectByVisibleText(text);
            wait.until(ExpectedConditions.textToBe(element, text));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to select Option By Value from dropdown
     * @param value
     */
    public void selectOptionByValue(By element, String value) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            Select dropdown = new Select(ele);
            dropdown.selectByValue(value);
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to select option by Index from dropdown
     * @param index
     */
    public void selectOptionByIndex(By element, int index) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            Select dropdown = new Select(ele);
            dropdown.selectByIndex(index);
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to check web element
     */
    public void check(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            if (ele.isSelected()) {
                ele.click();
            }
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to uncheck web element
     */
    public void uncheck(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            if (!ele.isSelected()) {
                ele.click();
            }
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    /**
     * @param element - passed as an argument to wait Until element has a text
     * @param text
     */
    public void waitUntilHasText(By element, String text) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            logger.info("Waiting for element {} text to be {}", element, text);
            wait.until(ExpectedConditions.textToBe(element, text));
            WebElement ele = driver.findElement(element);
            if (!ele.isSelected()) {
                ele.click();
            }
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }
}