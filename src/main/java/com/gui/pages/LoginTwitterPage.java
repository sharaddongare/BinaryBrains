package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTwitterPage {

    private WebDriver driver= DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By nextButton= By.xpath(ConfigReader.init_prop().getProperty("twitterNextButtonByXpath"));

    private By signinButton = By.xpath(ConfigReader.init_prop().getProperty("twitterSignInButtonByXpath"));

    private By twitterEmail = By.xpath(ConfigReader.init_prop().getProperty("twitterEmailByXpath"));


    private By twitterUsername = By.xpath(ConfigReader.init_prop().getProperty("twitterUserByXpath"));
    private By twitterPassword= By.xpath(ConfigReader.init_prop().getProperty("twitterPasswordByXpath"));
    private By twitterloginButton = By.xpath(ConfigReader.init_prop().getProperty("twitterLoginButtonByXpath"));



    private static String title;




    /**
     * @param user - passed as an argument to enter username element
     */
    public void enterUser(String user) {
        webCommonMethods.fillValueInWebElement(twitterUsername,user);
        webCommonMethods.clickOnElement(nextButton);
    }

    /**
     * @param email - passed as an argument to enter Email in web element
     */
    public void enterEmail(String email) {
        webCommonMethods.fillValueInWebElement(twitterEmail,email);
        webCommonMethods.clickOnElement(nextButton);

    }


    /**
     * @param phone - passed as an argument to enter phone in web element
     */
    public void enterPhone(String phone) {
        webCommonMethods.fillValueInWebElement(twitterPassword,phone);
        webCommonMethods.clickOnElement(nextButton);
    }

    /**
     * @param pwd - passed as an argument to enter password in web element
     */
    public void enterPass(String pwd) {
        webCommonMethods.fillValueInWebElement(twitterPassword,pwd);
    }


    /**
     * This method is used to perform twitter Sign InButton Click operation
     *
     */
    public void twitterSignInButtonClick() {

        webCommonMethods.clickOnElement(signinButton);
    }


    /**
     * This method is used to perform twitter Login Button Click operation
     *
     */
    public void twitterLoginButton() {
        webCommonMethods.clickWebElementJSE(twitterloginButton);
    }

    /**
     * @return - login page title
     */
    public String getLoginPageTitle() {

        return driver.getTitle();
    }

}
