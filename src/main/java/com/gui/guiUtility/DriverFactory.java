package com.gui.guiUtility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;




public class DriverFactory {


    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public Logger logger= LogManager.getLogger("DriverFactory");


    /**
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser) {

        System.out.println("browser value is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
            logger.info("Chrome Driver Initiated");
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
            logger.info("Firefox Driver Initiated");
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());
            logger.info("Edge Driver Initiated");
        } else if (browser.equals("safari")) {
            driver.set(new SafariDriver());
            logger.info("Safari Driver Initiated");
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        logger.info("All cookies Deleted");
        getDriver().manage().window().maximize();
        logger.info("Driver Maximized");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        logger.info("Implicit wait applied");
        return getDriver();
    }

    /**
     * @return
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     *
     */
    public void closeBrowser(){
        try {
            getDriver().close();
        }
        catch (Exception e){
            logger.info("Issue while closing browser");
        }
    }
}
