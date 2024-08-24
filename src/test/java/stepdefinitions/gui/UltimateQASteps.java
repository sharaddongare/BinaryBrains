package stepdefinitions.gui;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.pages.EmailAutomatePage;
import com.gui.pages.UltimateQAPage;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UltimateQASteps {

    private UltimateQAPage ultimatePage = new UltimateQAPage();

    private static final Logger LOG = LogManager.getLogger(BasicCommonSteps.class);
    private DriverFactory driverFactory = new DriverFactory();

    @Then("User should land on Home page")
    public void user_should_land_on_home_page() {
        System.out.println("Step 2");
    }

    @Then("User click on login Automation")
    public void user_click_on_login_automation() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 3 - Click Ultimate login URL");
        ultimatePage.ultimateLoginURL();
    }

    @Then("User enter username and password and click login button")
    public void user_enter_and_and_click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Step 4");
        ultimatePage.enterUltimateUser(ConfigReader.init_prop().getProperty("ultimateUser"));
        ultimatePage.enterUltimatePass(ConfigReader.init_prop().getProperty("ultimatePass"));
        ultimatePage.ultimateLoginButton();
        System.out.println("Done");
    }
}
