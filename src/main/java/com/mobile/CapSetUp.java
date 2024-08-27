package com.mobile;

import com.gui.guiUtility.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class CapSetUp {

    private String soucelabusername = ConfigReader.init_prop().getProperty("soucelabUsername");
    private String soucelabkey = ConfigReader.init_prop().getProperty("soucelabkey");
    private String souceLaburl = ConfigReader.init_prop().getProperty("soucelabUrl");
    private String platform = ConfigReader.init_prop().getProperty("souceplatformname");
    private String browserName = ConfigReader.init_prop().getProperty("MobilebrowserName");
    public Logger logger = LogManager.getLogger("Capabilities setup");

    private static AndroidDriver mobDriver;
    //String jobStatus = "";

    public static AndroidDriver getMobDriver() {
        return mobDriver;
    }

/*    public void setMobDriver(AndroidDriver mobDriver) {
        this.mobDriver = mobDriver;
    }*/


    public AndroidDriver setMobDriver_VirtualDevice() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("browserName", browserName);
        //caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", soucelabusername);
        sauceOptions.setCapability("accessKey", soucelabkey);
        sauceOptions.setCapability("build", "appium-build-FHWJH");
        sauceOptions.setCapability("name", "Android_Demo_" + new Date().getTime());
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        // Start the session
        URL url = new URL(souceLaburl);
        mobDriver = new AndroidDriver(url, caps);
        Thread.sleep(5000);
        System.out.println("Capabilities set successfully");
        logger.info("Virtual Device Capabilities set successfully");
        return mobDriver;
    }
    public AndroidDriver setMobDriver_LocalDevice() throws MalformedURLException, InterruptedException {
        System.out.println("********* Inside Set Mobile Driver Local Device *******");

        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");//Medium Phone API 35
        caps.setCapability(MobileCapabilityType.UDID, "12c7bb2c");//
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);//for chrome

        //To open native Mobile App from local Device we require appPkg and app Activity
//        caps.setCapability("appPackage", "com.linkedin.android");
//        caps.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");

// Start the session
        URL url = new URL("http://127.0.0.1:4723/");
        mobDriver = new AndroidDriver(url, caps);
        Thread.sleep(5000);
        System.out.println("Capabilities set successfully");
        logger.info("Local Device Capabilities set successfully");
        return mobDriver;

    }

    public void quitMobDriver() {
        getMobDriver().executeScript("sauce:job-result=" + "passed");
        getMobDriver().quit();
        System.out.println("Mobile driver closed successfully");
        logger.info("Mobile driver closed successfully");
    }

}
