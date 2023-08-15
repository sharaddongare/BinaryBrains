package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    //public static Logger Logger= (org.slf4j.Logger) LogManager.getLogger(DriverFactory.class);
    public Logger logger= LogManager.getLogger("DriverFactory");

    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            tlDriver.set(new SafariDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        logger.info("Webdriver Created");
        logger.error("Webdriver Created");
        logger.warn("Webdriver Created");
        return getDriver();

    }
    public static WebDriver getDriver() {

        return tlDriver.get();
    }
}
