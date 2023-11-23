package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver= DriverFactory.getDriver();

    // 1. By Locators: OR
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.xpath("//input[@value=\"Log In\"]");
    private By forgotPwdLink = By.linkText("Forgot your password?111");

    public WebCommonMethods webCommonMethods;


    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    /**
     * @return
     */
    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    /**
     * @param username
     */
    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    /**
     * @param pwd
     */
    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    /**
     *
     */
    public void clickOnLogin() {
        webCommonMethods.clickOnElement(signInButton);
    }



}
