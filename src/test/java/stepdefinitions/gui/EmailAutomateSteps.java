package stepdefinitions.gui;

import com.gui.guiUtility.ConfigReader;
import com.gui.pages.EmailAutomatePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmailAutomateSteps {

    private EmailAutomatePage emailAutomatePage = new EmailAutomatePage();
    private static final Logger LOG = LogManager.getLogger(LoginTwitterSteps.class);

    /**
     * This method is used to enter the user name and password
     */
    @Then("user enters valid Username and Password for goDaddy")
    public void userEntersValidUsernameAndPassword() {
        emailAutomatePage.enterUser(ConfigReader.init_prop().getProperty("username"));
        emailAutomatePage.enterPass(ConfigReader.init_prop().getProperty("password"));
        emailAutomatePage.goDaddyLoginButton();
    }




}
