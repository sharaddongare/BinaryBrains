package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTwitterPage {

    private WebDriver driver= DriverFactory.getDriver();

    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By twitterloginButton = By.xpath("//span[contains(text(),'Log in')]");

    private By signinButton = By.xpath("//span[contains(text(),'Sign in')]");

    private By twitterEmail = By.xpath("//input[@autocomplete=\"username\"]");

    private By twitterUsername = By.xpath("//input[@name=\"text\"]");

    private By twitterPassword= By.xpath("//input[@autocomplete=\"current-password\"]");
    private By nextButton= By.xpath("//span[contains(text(),'Next')]");


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

        webCommonMethods.clickOnElement(twitterloginButton);
    }

    /**
     * @return - login page title
     */
    public String getLoginPageTitle() {

        return driver.getTitle();
    }

}
