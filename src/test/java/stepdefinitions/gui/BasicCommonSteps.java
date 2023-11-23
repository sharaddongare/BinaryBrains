package stepdefinitions.gui;


import com.gui.guiUtility.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BasicCommonSteps {

	private WebDriver driver= DriverFactory.getDriver();
	private static final Logger LOG = LogManager.getLogger(BasicCommonSteps.class);
	private DriverFactory driverFactory=new DriverFactory();


	/**
	 * @param Browser
	 */
	@Given("User opens browser {string}")
	public void userOpensBrowser(String Browser) {
		driverFactory.init_driver(Browser);
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
		LOG.info("User is navigating to login page");
		driver.close();
	}

	/**
	 * @param Browser
	 */
	@Given("User open the browser {}")
	public void userOpensBrowsers(String Browser) {
		driverFactory.init_driver(Browser);
	}
}
