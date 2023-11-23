package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterLandingPage {

    private WebDriver driver= DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods;


    private By POST_BUTTON = By.cssSelector("div[data-testid='tweetButtonInline']");
    private By TWITTER_PLACEHOLDER = By.cssSelector("div[aria-label='Tweet text']");



    /**
     *
     */
    public void waitForPostPlaceholderToDisplay() {
        webCommonMethods.waitForVisible(TWITTER_PLACEHOLDER);
    }

    /**
     * @param post
     */
    public void enterPost(String post) {
        webCommonMethods.fillValueInWebElement(TWITTER_PLACEHOLDER, post);
    }

    /**
     *
     */
    public void waitForPostButtonToClickable() {
        webCommonMethods.waitForClickable(POST_BUTTON);
    }

    /**
     *
     */
    public void clickOnPostButton() {
        webCommonMethods.clickWebElementJSE(POST_BUTTON);
    }

    /**
     * @param post
     */
    public void waitForPostToDisplay(String post) {
        webCommonMethods.waitUntilHasText(By.xpath("//span[text()='" + post + "']"), post);
    }
}
