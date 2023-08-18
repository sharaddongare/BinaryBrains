package com.qa.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebCommonMethods {

    public Logger logger = LogManager.getLogger(WebCommonMethods.class);
    private static final int WAIT_TIMEOUT = 20;
    private static final int WAIT_FREQUENCY = 3;
    private WebDriver driver;

    public WebCommonMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(String element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT)).pollingEvery(Duration.ofSeconds(WAIT_FREQUENCY));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element))).click();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Unable to find element: {}", e);
        }
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

    public void clickWebElementJSE(String webElementPath) {
        WebElement element = driver.findElement(By.xpath(webElementPath));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(WAIT_TIMEOUT));
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}