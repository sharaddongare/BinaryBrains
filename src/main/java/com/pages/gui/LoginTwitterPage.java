package com.pages.gui;

import com.qa.factory.DriverFactory;
import com.qa.util.WebCommonMethods;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTwitterPage {

    private WebDriver driver;
    public WebCommonMethods webCommonMethods;

    private By twitterloginButton = By.xpath("//span[contains(text(),'Log in')]");

    private By signinButton = By.xpath("//span[contains(text(),'Sign in')]");

    private By twitterEmail = By.xpath("//input[@autocomplete=\"username\"]");

    private By twitterUsername = By.xpath("//input[@name=\"text\"]");

    private By twitterPassword= By.xpath("//input[@autocomplete=\"current-password\"]");
    private By nextButton= By.xpath("//span[contains(text(),'Next')]");


    private static String title;




    public LoginTwitterPage(WebDriver driver)
    {
        this.driver = driver;
        webCommonMethods = new WebCommonMethods(driver);
    }

    // 3. page actions: features(behavior) of the page the form of methods:
    public void enterUser(String user) {
        //driver.findElement(username).sendKeys(user);
        webCommonMethods.fillValueInWebElement(twitterUsername,user);
        webCommonMethods.clickOnElement(nextButton);


    }

    public void enterEmail(String email) {
        //driver.findElement(username).sendKeys(user);
        webCommonMethods.fillValueInWebElement(twitterEmail,email);
        webCommonMethods.clickOnElement(nextButton);

    }


    public void enterPhone(String phone) {

        //driver.findElement(password).sendKeys(pwd);
        webCommonMethods.fillValueInWebElement(twitterPassword,phone);
        webCommonMethods.clickOnElement(nextButton);

    }
    public void enterPass(String pwd) {

        //driver.findElement(password).sendKeys(pwd);
        webCommonMethods.fillValueInWebElement(twitterPassword,pwd);


    }


    public void twitterSignInButtonClick() {

        webCommonMethods.clickOnElement(signinButton);
    }


    public void twitterLoginButton() {

        webCommonMethods.clickOnElement(twitterloginButton);
    }

    public String getLoginPageTitle() {

        return driver.getTitle();
    }

}
