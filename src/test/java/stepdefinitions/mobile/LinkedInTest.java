package stepdefinitions.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class LinkedInTest {
    @Given("TestingoFSouceLab_LD")
    public void testingofsoucelab_LD() throws MalformedURLException, InterruptedException {

        System.out.println("********* I am here");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        //caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "15.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("browserName", "Chrome");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-pirangutekiran-dba7d");
        sauceOptions.setCapability("accessKey", "7dbccb8b-1416-472a-8b8e-ba2c71eb8e50");
        sauceOptions.setCapability("build", "appium-build-FHWJH");
        sauceOptions.setCapability("name", "Android_Demo_KP_"+new Date().getTime());
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

//        appium-build-PRIFC
// Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

// replace with commands and assertions
        Thread.sleep(5000);
        String jobStatus = "passed"; // or "failed"

// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();


    }

    @Given("TestingoFSouceLab_LD_LocalDevice")
    public void testingofsoucelab_LD_LocalDevice() throws MalformedURLException, InterruptedException {

        System.out.println("********* I am here");

        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus");//Medium Phone API 35
        caps.setCapability(MobileCapabilityType.UDID, "12c7bb2c");//
//      caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");//for chrome
        //To open native Mobile App from local Device we require appPkg and app Activity
        caps.setCapability("appPackage", "com.linkedin.android");
		caps.setCapability("appActivity", "com.linkedin.android.authenticator.LaunchActivity");

// Start the session
        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, caps);
        Thread.sleep(5000);


    }
}