package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;


public class DriverFactory {

    public WebDriver driver;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public Logger logger= LogManager.getLogger("DriverFactory");

    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            tlDriver.set(new ChromeDriver());
            logger.info("Chrome Driver Initiated");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            tlDriver.set(new FirefoxDriver());
            logger.info("Firefox Driver Initiated");
        } else if (browser.equalsIgnoreCase("safari")) {
            tlDriver.set(new SafariDriver());
            logger.info("Chrome Driver Initiated");
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        logger.info("All cockies Deleted");
        getDriver().manage().window().maximize();
        logger.info("Driver Maximized");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        logger.info("Implicit wait appllied");
        return getDriver();
    }
    public static WebDriver getDriver() {

        return tlDriver.get();
    }

    public void closeBrowser(){
        try {
            getDriver().close();
        }
        catch (Exception e){
            logger.info("Issue while closing browser");
        }


    }
}
