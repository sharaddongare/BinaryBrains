package stepdefinitions.mobile;

import com.mobile.CapSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class SouceTest {

    CapSetUp capset= new CapSetUp();
    @Given("TestingoFSouceLab")
    public void testingofsoucelab() throws MalformedURLException, InterruptedException {


    }

    @Given("setup the MobileDriver")
    public void setupTheMobileDriver() throws MalformedURLException, InterruptedException {
        capset.setMobDriver();

    }

    @Then("Open LinkedIn App")
    public void openLinkedInApp() throws InterruptedException {
        CapSetUp.getMobDriver().get("https://in.linkedin.com");
        CapSetUp.getMobDriver().findElement(By.xpath("//a[@data-tracking-control-name='guest_homepage-basic_nav-header-signin']")).click();
        CapSetUp.getMobDriver().findElement(By.id("username")).click();
        CapSetUp.getMobDriver().findElement(By.id("username")).sendKeys("kpirangute@gmail.com");
        Thread.sleep(5000);
        //CapSetUp.getMobDriver().findElement(By.name(""));

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
