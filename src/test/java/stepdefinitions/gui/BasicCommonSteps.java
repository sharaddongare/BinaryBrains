package stepdefinitions.gui;

//import org.junit.Assert;

import com.pages.gui.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class BasicCommonSteps {

	public WebDriver driver;
	private static final Logger LOG = LogManager.getLogger(BasicCommonSteps.class);

	private DriverFactory driverFactory;


	@Given("User opens browser {string}")
	public void userOpensBrowser(String Browser) {
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(Browser);


	}

	@When("user hits URL {string}")
	public void userHitsURL(String URL) {
		LOG.info("User is navigating to login page");
		DriverFactory.getDriver()
				.get(URL);

	}

	@When("user should close the browser")
	public void closeBrowser() {
		LOG.info("User is navigating to login page");
		driver.close();
	}

	@Given("User open the browser {}")
	public void userOpensBrowsers(String Browser) {

		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(Browser);
	}
}
