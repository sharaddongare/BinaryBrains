package com.pages.gui;

import com.qa.util.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // 1. By Locators: OR
    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.xpath("//input[@value=\"Log In\"]");
    private By forgotPwdLink = By.linkText("Forgot your password?111");

    public WebCommonMethods webCommonMethods;
    // 2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        webCommonMethods = new WebCommonMethods(driver);
    }

    // 3. page actions: features(behavior) of the page the form of methods:

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        webCommonMethods.clickOnElement(signInButton);
    }



}
