package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UltimateQAPage {


    private WebDriver driver= DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By ultimateUsername = By.xpath(ConfigReader.init_prop().getProperty("ultimateUserByXpath"));
    private By ultimatePassword= By.xpath(ConfigReader.init_prop().getProperty("ultimatePassByXpath"));
    private By ultimateLoginButton= By.xpath(ConfigReader.init_prop().getProperty("ultimateSignInByXpath"));
    private By ultimateLoginUrl= By.xpath(ConfigReader.init_prop().getProperty("ultimateLoginURl"));



    /**
     * @param user - passed as an argument to enter username element
     */
    public void enterUltimateUser(String user) {
        webCommonMethods.fillValueInWebElement(ultimateUsername,user);
        //webCommonMethods.clickOnElement(nextButton);
    }

    /**
     * @param pwd - passed as an argument to enter password in web element
     */
    public void enterUltimatePass(String pwd) {
        webCommonMethods.fillValueInWebElement(ultimatePassword,pwd);
    }

    /**
     * This method is used to perform twitter Login Button Click operation
     *
     */
    public void ultimateLoginButton() {
        webCommonMethods.clickWebElementJSE(ultimateLoginButton);
    }

    public void ultimateLoginURL() {
        webCommonMethods.clickWebElementJSE(ultimateLoginUrl);
    }


}
