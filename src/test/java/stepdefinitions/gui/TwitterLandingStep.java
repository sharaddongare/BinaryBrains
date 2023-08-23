package stepdefinitions.gui;

import com.pages.gui.LoginPage;
import com.pages.gui.TwitterLandingPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwitterLandingStep {

    private TwitterLandingPage twitterLandingPage = new TwitterLandingPage(DriverFactory.getDriver());
    private static final Logger LOG = LogManager.getLogger(TwitterLandingPage.class);

    @When("When user enter a post {string}")
    public void user_enters_post(String post) {
        twitterLandingPage.waitForPostPlaceholderToDisplay();
        twitterLandingPage.enterPost(post);
        twitterLandingPage.waitForPostButtonToClickable();
        twitterLandingPage.clickOnPostButton();
        twitterLandingPage.waitForPostToDisplay(post);
    }
}
