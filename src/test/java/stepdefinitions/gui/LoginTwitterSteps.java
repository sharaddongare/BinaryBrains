package stepdefinitions.gui;

import com.pages.gui.LoginSaucePage;
import com.pages.gui.LoginTwitterPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginTwitterSteps {

    public String title;
    public WebDriver driver;
    private LoginTwitterPage loginTwitterPage = new LoginTwitterPage(DriverFactory.getDriver());
    private static final Logger LOG = LogManager.getLogger(LoginTwitterSteps.class);


/*    @Given("user should launch the webpage {string}")
    public void user_should_launch_the_webpage(String webUrl) {
        LOG.info("User is navigating to Sauce login page");
        DriverFactory.getDriver()
                .get(webUrl);
        System.out.println("Url launch success!");
    }*/

    /*  @Then("user should enter valid username {string} and password {string} and click on login button")
      public void user_should_enter_valid_username_and_password_and_click_on_login_button(String user, String pass) {
    *//*      loginSaucePage.enterUser(user);
        loginSaucePage.enterPass(pass);
        loginSaucePage.loginClick();*//*
    }
*/
    @Then("User clicks on Sign in button")
    public void userClicksOnSignInButton() {
        loginTwitterPage.twitterSignInButtonClick();

    }

    @Then("user enters valid Username and Password")
    public void userEntersValidUsernameAndPassword() {
        loginTwitterPage.enterUser("@sharaddongare");
        loginTwitterPage.enterPass("Sharad@2023");
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

}
