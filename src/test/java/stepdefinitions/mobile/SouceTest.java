package stepdefinitions.mobile;

import com.mobile.CapSetUp;
import io.appium.java_client.android.AndroidDriver;
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

    @Given("setup the MobileDriver")
    public void setupTheMobileDriver() throws MalformedURLException, InterruptedException {
        capset.setMobDriver();

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
    @Then("Open LinkedIn App On Device")
    public void openLinkedInApp_Device() throws InterruptedException {

        //android.widget.ImageView[@content-desc="Cancel"]

        //android.widget.Button[@resource-id="com.linkedin.android:id/growth_prereg_fragment_login_button"]


        /*CapSetUp.getMobDriver().get("https://in.linkedin.com");
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
        //CapSetUp.getMobDriver().findElement(By.name(""));*/

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
