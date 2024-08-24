package com.mobile;

import com.gui.guiUtility.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class CapSetUp {

    private String soucelabusername = ConfigReader.init_prop().getProperty("soucelabUsername");
    private String soucelabkey = ConfigReader.init_prop().getProperty("soucelabkey");
    private String souceLaburl = ConfigReader.init_prop().getProperty("soucelabUrl");
    private String platform = ConfigReader.init_prop().getProperty("souceplatformname");

    private static AndroidDriver mobDriver;
    //String jobStatus = "";

    public static AndroidDriver getMobDriver() {
        return mobDriver;
    }

/*    public void setMobDriver(AndroidDriver mobDriver) {
        this.mobDriver = mobDriver;
    }*/


    public AndroidDriver setMobDriver() throws MalformedURLException, InterruptedException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        //caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("browserName", "Chrome");
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
        return mobDriver;
    }

// replace with commands and assertions

         // or "failed"


// end the session
    public void quitMobDriver(){
        getMobDriver().executeScript("sauce:job-result=" + "passed");
        getMobDriver().quit();
    }

}
