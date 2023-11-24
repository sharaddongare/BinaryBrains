package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver= DriverFactory.getDriver();

    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.xpath("//input[@value=\"Log In\"]");
    private By forgotPwdLink = By.linkText("Forgot your password?111");

    public WebCommonMethods webCommonMethods;

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
     * @param username - passed as an argument to perform enter username operation on web element
     */
    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    /**
     * @param pwd - passed as an argument to perform enter password operation on web element
     */
    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    /**
     * This method to perform Click operation on Login button
     *
     */
    public void clickOnLogin() {
        webCommonMethods.clickOnElement(signInButton);
    }



}
