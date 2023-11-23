package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSaucePage {

    private WebDriver driver= DriverFactory.getDriver();

    public WebCommonMethods webCommonMethods;

    // 1. By Locators: OR
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");



    /**
     * @param user
     */
    public void enterUser(String user) {
        webCommonMethods.fillValueInWebElement(username,user);

    }

    /**
     * @param pwd
     */
    public void enterPass(String pwd) {

        webCommonMethods.fillValueInWebElement(password,pwd);
    }

    /**
     *
     */
    public void loginClick() {

        webCommonMethods.clickOnElement(loginButton);
    }

}
