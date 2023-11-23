package stepdefinitions.gui;


import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.pages.LoginTwitterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Base64;

public class LoginTwitterSteps {

    public String title;
    private LoginTwitterPage loginTwitterPage = new LoginTwitterPage();
    private static final Logger LOG = LogManager.getLogger(LoginTwitterSteps.class);


    @Then("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        loginTwitterPage.twitterSignInButtonClick();

    }

    @Then("user enters valid Username and Password")
    public void userEntersValidUsernameAndPassword() {
        String password = new String(Base64.getDecoder().decode((ConfigReader.init_prop().getProperty("password")).getBytes()));
        loginTwitterPage.enterUser(ConfigReader.init_prop().getProperty("username"));
        loginTwitterPage.enterPass(password);
    }

    @Then("User enters valid Email ID")
    public void userEntersValidEmailID() {
        loginTwitterPage.enterEmail("dongaresharad@gmail.com");
    }

//
//    @Then("user should close the browser")
//    public void userCloseBrowser() {
//        LOG.info("Closed Success!");
//
//    }

    @And("click on login button")
    public void clickOnSigninButton() {
        loginTwitterPage.twitterLoginButton();
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginTwitterPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));

    }

    @Then("User enters {string}")
    public void userEntersValid_Email_ID(String email) {
    }
}
