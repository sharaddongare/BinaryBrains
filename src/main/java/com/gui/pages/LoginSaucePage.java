package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSaucePage {

    private WebDriver driver= DriverFactory.getDriver();

    public WebCommonMethods webCommonMethods;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");



    /**
     * @param user - passed as an argument to perform enter username operation on web element
     */
    public void enterUser(String user) {
        webCommonMethods.fillValueInWebElement(username,user);

    }

    /**
     * @param pwd - passed as an argument to perform enter password operation on web element
     */
    public void enterPass(String pwd) {

        webCommonMethods.fillValueInWebElement(password,pwd);
    }

    /**
     * This method to perform Click operation on Login button
     *
     */
    public void loginClick() {

        webCommonMethods.clickOnElement(loginButton);
    }

}
