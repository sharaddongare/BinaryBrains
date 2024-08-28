package stepdefinitions.mobile;

import com.mobile.CapSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class SouceTest {

    CapSetUp capset= new CapSetUp();
    public Logger logger = LogManager.getLogger("Capabilities setup");
    @Given("TestingoFSouceLab")
    public void testingofsoucelab() throws MalformedURLException, InterruptedException {

    }

    @Given("setup the MobileDriver Virtual")
    public void setupTheMobileDriver_Virtual() throws MalformedURLException, InterruptedException {
        capset.setMobDriver_VirtualDevice();
    }
    @Given("setup the MobileDriver_LocalDevice")
    public void setupTheMobileDriver_Local() throws MalformedURLException, InterruptedException {
        capset.setMobDriver_LocalDevice();
    }

    @Then("Open LinkedIn App On Web")
    public void openLinkedInApp() throws InterruptedException {
        CapSetUp.getMobDriver().get("https://in.linkedin.com");
        CapSetUp.getMobDriver().findElement(By.xpath("//a[@data-tracking-control-name='guest_homepage-basic_nav-header-signin']")).click();
        CapSetUp.getMobDriver().findElement(By.id("username")).click();
        CapSetUp.getMobDriver().findElement(By.id("username")).sendKeys("rajpatil592@gmail.com");
        System.out.println("User Name Entered Successfully");
        logger.info("User Name Entered Successfully");
        CapSetUp.getMobDriver().findElement(By.id("password")).click();
        CapSetUp.getMobDriver().findElement(By.id("password")).sendKeys("Smart@1212");
        System.out.println("Password Entered Successfully");
        logger.info("Password Entered Successfully");
        CapSetUp.getMobDriver().findElement(By.xpath("//button[@aria-label='Sign in']")).click();
        logger.info("Clicked On Login Button");
        Thread.sleep(5000);
        //CapSetUp.getMobDriver().findElement(By.name(""));

    }
    @Then("Launch Step In forum App")
    public void LaunchStepInApp() throws InterruptedException {

        CapSetUp.getMobDriver().findElement(By.xpath("//android.widget.Button")).click();

    }
    @Then("Get The Product details")
    public void getTheProductDetails() throws InterruptedException {
        String productName=CapSetUp.getMobDriver().findElement(By.xpath("//android.widget.TextView[@text='JBL Wireless Earbuds']")).getText();
        System.out.println("Product Name" +productName);
        logger.info("Product Name" +productName);

        String productDetails=CapSetUp.getMobDriver().findElement(By.xpath("//android.widget.TextView[@text='High-quality wireless earbuds with noise cancellation and 20 hours of battery life.']")).getText();
        System.out.println("Product Details" +productDetails);
        logger.info("Product Details" +productDetails);

        String productPrice=CapSetUp.getMobDriver().findElement(By.xpath("//android.widget.TextView[@text='₹5999.0']")).getText();
        System.out.println("Product Price" +productPrice);
        logger.info("Product Price" +productPrice);

    }

    @Then("Verify somethoing")
    public void verifySomethoing() {
        System.out.println("Inside do something");

    }

    @Then("Close the App")
    public void closeTheApp() {

        capset.quitMobDriver();
    }
}
