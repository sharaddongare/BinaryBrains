package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterLandingPage {

    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By POST_BUTTON = By.cssSelector(ConfigReader.init_prop().getProperty("twitterPostButtonByCss"));
    private By TWITTER_PLACEHOLDER = By.xpath(ConfigReader.init_prop().getProperty("twitterPostPlaceholderByCss"));



    /**
     *
     */
    public void waitForPostPlaceholderToDisplay() {
        webCommonMethods.waitForVisible(TWITTER_PLACEHOLDER);
    }

    /**
     * @param post - passed as an argument to enter post in web element
     */
    public void enterPost(String post) {
        webCommonMethods.fillValueInWebElement(TWITTER_PLACEHOLDER, post);
    }

    /**
     * This method use to wait For Post ButtonTo Clickable
     *
     */
    public void waitForPostButtonToClickable() {
        webCommonMethods.waitForClickable(POST_BUTTON);
    }

    /**
     * This method use to wait For Post ButtonTo Clickable
     *
     */
    public void clickOnPostButton() {
        webCommonMethods.clickWebElementJSE(POST_BUTTON);
    }

    /**
     * @param post - passed as an argument to waitForPostToDisplay
     */
    public void waitForPostToDisplay(String post) {
        String twit = ConfigReader.init_prop().getProperty("twitterTwitToPostByXpath");
        webCommonMethods.waitUntilHasText(By.xpath(String.format(twit,post)), post);
    }
}
