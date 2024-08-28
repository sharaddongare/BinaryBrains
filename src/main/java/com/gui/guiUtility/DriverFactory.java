package com.gui.guiUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverFactory {


    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Logger logger = LogManager.getLogger("DriverFactory");
    private String url = ConfigReader.init_prop().getProperty("remoteUrl");

    /**
     * @return
     */
    public WebDriver init_driver() {
        String browser = ConfigReader.init_prop().getProperty("browser");
        logger.info("browser is set to {} ", browser);
        String platform = ConfigReader.init_prop().getProperty("execution");
        logger.info("platform is to {} ", platform);
        if (platform.equalsIgnoreCase("local")) {
            this.setDriver(browser);
        } else if (platform.equalsIgnoreCase("grid")) {
            this.setRemoteDriver(browser);
        }
        getDriver().manage().deleteAllCookies();
        logger.info("All cookies Deleted");
        getDriver().manage().window().maximize();
        logger.info("Driver Maximized");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        logger.info("Implicit wait applied");
        Allure.description("To check Indian Express functionality");
        return getDriver();
    }

    public void setDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                logger.info("{} Driver Initiated", browser);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                logger.info("{} Driver Initiated", browser);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                logger.info("{} Driver Initiated", browser);
                break;
            case "safari":
                driver.set(new SafariDriver());
                logger.info("{} Driver Initiated", browser);
                break;
            default:
                logger.info("Please provide proper browser value {}", browser);
        }
    }

    public void setRemoteDriver(String browser) {
        Capabilities options;
        switch (browser) {
            case "remote-chrome":
                options = new ChromeOptions();
                try {
                    driver.set(new RemoteWebDriver((new URL(url)), options));
                } catch (MalformedURLException e) {
                    logger.info("Exception while opening a remote browser {} {}", browser, e.getStackTrace());
                }
                logger.info("Remote chrome has been opened");
                break;
            case "remote-firefox":
                options = new FirefoxOptions();
                try {
                    driver.set(new RemoteWebDriver((new URL(url)), options));
                } catch (MalformedURLException e) {
                    logger.info("Exception while opening a remote browser {} {}", browser, e.getStackTrace());
                }
                logger.info("Remote firefox is opened");
                break;
            case "remote-edge":
                options = new EdgeOptions();
                try {
                    driver.set(new RemoteWebDriver((new URL(url)), options));
                } catch (MalformedURLException e) {
                    logger.info("Exception while opening a remote browser {} {}", browser, e.getStackTrace());
                }
                logger.info("Remote Edge is opened");
                break;
            default:
                logger.info("Please provide proper browser value {}", browser);
        }
    }


    /**
     * @return - method return an instance of WebDriver
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * This method used to close browser
     *
     */
    public void closeBrowser() {
        try {
            getDriver().close();
        } catch (Exception e) {
            logger.info("Issue while closing browser");
        }
    }
}
