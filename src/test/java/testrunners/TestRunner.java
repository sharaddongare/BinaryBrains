package testrunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/Features"},
		glue = {"stepdefinitions"},
		tags="@Mytag",
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/"},
		stepNotifications = true
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		
		)

public class TestRunner {

}
