package stepdefinitions.gui;

import com.gui.guiUtility.DriverFactory;
import com.gui.pages.TwitterLandingPage;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TwitterLandingStep {

    private TwitterLandingPage twitterLandingPage = new TwitterLandingPage();
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
