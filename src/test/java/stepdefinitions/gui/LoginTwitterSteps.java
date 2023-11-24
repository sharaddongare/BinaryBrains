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


    /**
     * This method is used perform click on sign in button
     *
     */
    @Then("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        loginTwitterPage.twitterSignInButtonClick();

    }

    /**
     * This method is used to enter the user name and password
     *
     */
    @Then("user enters valid Username and Password")
    public void userEntersValidUsernameAndPassword() {
        String password = new String(Base64.getDecoder().decode((ConfigReader.init_prop().getProperty("password")).getBytes()));
        loginTwitterPage.enterUser(ConfigReader.init_prop().getProperty("username"));
        loginTwitterPage.enterPass(password);
    }

    /**
     * This method is used to enter the emailId
     *
     */
    @Then("User enters valid Email ID")
    public void userEntersValidEmailID() {
        loginTwitterPage.enterEmail("dongaresharad@gmail.com");
    }


    /**
     * This method is used perform click on login button
     *
     */
    @And("click on login button")
    public void clickOnSigninButton() {
        loginTwitterPage.twitterLoginButton();
    }

    /**
     * This method is used to get the title of the page
     *
     */
    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
        title = loginTwitterPage.getLoginPageTitle();
        System.out.println("Page title is: " + title);
    }

    /**
     * @param expectedTitleName - passed as argument to validate the page title
     */
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {
        Assert.assertTrue(title.contains(expectedTitleName));

    }

    /**
     * This method is used to enter the valid EmailId
     *
     */
    @Then("User enters {string}")
    public void userEntersValid_Email_ID(String email) {
    }
}
