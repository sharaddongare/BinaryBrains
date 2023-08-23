package com.pages.gui;

import com.qa.util.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterLandingPage {
    private WebDriver driver;
    public WebCommonMethods webCommonMethods;


    private By POST_BUTTON = By.cssSelector("div[data-testid='tweetButtonInline']");
    private By TWITTER_PLACEHOLDER = By.cssSelector("div[aria-label='Tweet text']");

    // 2. Constructor of the page class:
    public TwitterLandingPage(WebDriver driver) {
        this.driver = driver;
        webCommonMethods = new WebCommonMethods(driver);
    }

    public void waitForPostPlaceholderToDisplay() {
        webCommonMethods.waitForVisible(TWITTER_PLACEHOLDER);
    }

    public void enterPost(String post) {
        webCommonMethods.fillValueInWebElement(TWITTER_PLACEHOLDER, post);
    }

    public void waitForPostButtonToClickable() {
        webCommonMethods.waitForClickable(POST_BUTTON);
    }

    public void clickOnPostButton() {
        webCommonMethods.clickWebElementJSE(POST_BUTTON);
    }

    public void waitForPostToDisplay(String post) {
        webCommonMethods.waitUntilHasText(By.xpath("//span[text()='" + post + "']"), post);
    }
}
