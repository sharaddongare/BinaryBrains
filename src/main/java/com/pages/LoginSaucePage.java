package com.pages;

import com.qa.util.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSaucePage {

    private WebDriver driver;
    public WebCommonMethods webCommonMethods;
    // 1. By Locators: OR
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginSaucePage(WebDriver driver)
    {
        this.driver = driver;
        webCommonMethods = new WebCommonMethods(driver);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public void enterUser(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void enterPass(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void loginClick() {
        webCommonMethods.clickOnElement(loginButton);
    }

}
