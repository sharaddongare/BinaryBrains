package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailAutomatePage
{

    private WebDriver driver= DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By goDaddyUsername = By.xpath(ConfigReader.init_prop().getProperty("goDaddyUserByXpath"));
    private By goDaddyPassword= By.xpath(ConfigReader.init_prop().getProperty("goDaddyPasswordByXpath"));
    private By goDaddyloginButton = By.xpath(ConfigReader.init_prop().getProperty("goDaddyLoginButtonByXpath"));


    /**
     * @param user - passed as an argument to enter username element
     */
    public void enterUser(String user) {
        webCommonMethods.fillValueInWebElement(goDaddyUsername,user);
        //webCommonMethods.clickOnElement(nextButton);
    }

    /**
     * @param pwd - passed as an argument to enter password in web element
     */
    public void enterPass(String pwd) {

        webCommonMethods.fillValueInWebElement(goDaddyPassword,pwd);
    }

    /**
     * This method is used to perform twitter Login Button Click operation
     *
     */
    public void goDaddyLoginButton() {
        webCommonMethods.clickWebElementJSE(goDaddyloginButton);
    }

}
