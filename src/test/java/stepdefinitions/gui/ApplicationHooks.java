package stepdefinitions.gui;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

	private WebDriver driver= DriverFactory.getDriver();
	private ConfigReader configReader;
	Properties prop;

	public String getProperty(String key){
		return prop.getProperty(key);
	}


	/**
	 * @param scenario
	 */
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
