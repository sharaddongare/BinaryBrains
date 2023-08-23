package com.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebCommonMethods {

    public Logger logger = LogManager.getLogger(WebCommonMethods.class);
    private static final int WAIT_TIMEOUT = 20;
    private static final int WAIT_FREQUENCY = 3;
    private WebDriver driver;

    public WebCommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Unable to find element: {}", e);
        }
    }

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

    public void waitForVisible(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    public String getTextOfElementOnceVisible(By element) {
        this.waitForVisible(element);
        return driver.findElement(element).getText();
    }

    public void waitForClickable(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

    public void waitForElementToDisappear(By element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
        } catch (Exception e) {
            logger.error("Element not found {}", e.getMessage());
        }
    }

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