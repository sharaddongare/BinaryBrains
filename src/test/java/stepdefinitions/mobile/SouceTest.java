package stepdefinitions.mobile;

import com.mobile.CapSetUp;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
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

        capset.setMobDriver();
        CapSetUp.getMobDriver().findElement(By.name(""));
        capset.quitMobDriver();

    }
}
