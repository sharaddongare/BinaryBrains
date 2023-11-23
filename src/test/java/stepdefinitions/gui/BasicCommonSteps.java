package stepdefinitions.gui;


import com.gui.guiUtility.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasicCommonSteps {

    private static final Logger LOG = LogManager.getLogger(BasicCommonSteps.class);
    private DriverFactory driverFactory = new DriverFactory();

    /**
     * @param Browser
     */
    @Given("User opens browser {string}")
    public void userOpensBrowser(String Browser) {
        driverFactory.init_driver();
    }

    /**
     * @param URL
     */
    @When("user hits URL {string}")
    public void userHitsURL(String URL) {
        LOG.info("User is navigating to login page");
        DriverFactory.getDriver()
                .get(URL);

    }

    /**
     *
     */
    @When("user should close the browser")
    public void closeBrowser() {
        WebDriver driver = DriverFactory.getDriver();
        LOG.info("User is navigating to login page");
        if (driver != null) {
            driver.quit();
            LOG.info("*** Killed driver instance ***");
        } else if (driver == null) {
            LOG.info("** Driver instance is null ***");
        }
    }

    /**
     * @param
     */
    @Given("User open the browser {}")
    public void userOpensBrowsers(String browser) {
        driverFactory.init_driver();
    }
}
