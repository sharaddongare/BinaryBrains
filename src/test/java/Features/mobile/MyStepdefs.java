package Features.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class MyStepdefs {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        set_capabilities_for_souce_lab();
    }
    @Given("set capabilities for Souce lab")
    public static void set_capabilities_for_souce_lab() throws MalformedURLException, InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("********* I am here");

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-dongaresharad-32fe5");
        sauceOptions.setCapability("accessKey", "cb3b6f30-9561-454d-9ae6-2758f863ca07");
        sauceOptions.setCapability("build", "appium-build-FHWJH");
        //sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

// replace with commands and assertions
        Thread.sleep(5000);
        String jobStatus = "passed"; // or "failed"

// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();

        throw new io.cucumber.java.PendingException();
    }

    @Given("test SouceLab")
    public void testSouceLab() {

        System.out.println("Here.............");
    }

    /*@Given("set capabilities for Souce lab")
    public void listOfBooksAreAvailable() throws InterruptedException, MalformedURLException {

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");  // The filename of the mobile app
        caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", "oauth-dongaresharad-32fe5");
        sauceOptions.setCapability("accessKey", "cb3b6f30-9561-454d-9ae6-2758f863ca07");
        sauceOptions.setCapability("build", "appium-build-FHWJH");
        //sauceOptions.setCapability("name", "<your test name>");
        sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
        caps.setCapability("sauce:options", sauceOptions);

        // Start the session
        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, caps);

// replace with commands and assertions
        Thread.sleep(5000);
        String jobStatus = "passed"; // or "failed"

// end the session
        driver.executeScript("sauce:job-result=" + jobStatus);
        driver.quit();


    }*/

}
