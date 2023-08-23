package stepdefinitions.gui;

import com.pages.gui.LoginSaucePage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoginSauceSteps
{
    public WebDriver driver;
    private LoginSaucePage loginSaucePage = new LoginSaucePage(DriverFactory.getDriver());
    private static final Logger LOG = LogManager.getLogger(LoginSauceSteps.class);


    @Given("user should launch the webpage {string}")
    public void user_should_launch_the_webpage(String webUrl) {
        LOG.info("User is navigating to Sauce login page");
        DriverFactory.getDriver()
                .get(webUrl);
        System.out.println("Url launch success!");
    }

    @Then("user should enter valid username {string} and password {string} and click on login button")
    public void user_should_enter_valid_username_and_password_and_click_on_login_button(String user, String pass) {
        loginSaucePage.enterUser(user);
        loginSaucePage.enterPass(pass);
        loginSaucePage.loginClick();
    }


/*    @Then("user should close the browser")
    public void userCloseBrowser() {
        LOG.info("Closed Success!");

    }*/


}
