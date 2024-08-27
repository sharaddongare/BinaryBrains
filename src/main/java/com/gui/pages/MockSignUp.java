package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;

public class MockSignUp {

    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    private By mocksinginButton = By.xpath(ConfigReader.init_prop().getProperty("mocksinginButton"));
    private By FirstNameMock = By.xpath(ConfigReader.init_prop().getProperty("mockfirstName"));
    private By LastNameMock = By.xpath(ConfigReader.init_prop().getProperty("mockLastName"));
    private By MockPass = By.xpath(ConfigReader.init_prop().getProperty("mockpass"));
    private By MockEmail = By.xpath(ConfigReader.init_prop().getProperty("mockEmail"));

    private By mockSubmitButton = By.xpath(ConfigReader.init_prop().getProperty("mockEmail"));

    private By MockAddnewContact = By.xpath(ConfigReader.init_prop().getProperty("addnewContact"));




 public void singin(){

     webCommonMethods.clickOnElement(mocksinginButton);
 }

 public void singUpdata(){

     webCommonMethods.fillValueInWebElement(FirstNameMock,"Sharad");
     webCommonMethods.fillValueInWebElement(LastNameMock,"Dongare");
     webCommonMethods.fillValueInWebElement(MockPass,"Sharad@2020");
     webCommonMethods.fillValueInWebElement(MockEmail,"Sharad.dongare@voda");

     //webCommonMethods.clickOnElement(mockSubmitButton);
     webCommonMethods.clickWebElementJSE(mockSubmitButton);

 }

    public void singUpdata(String firstname,String lastName, String email ,String Password) throws InterruptedException {

        webCommonMethods.fillValueInWebElement(FirstNameMock,firstname);
        webCommonMethods.fillValueInWebElement(LastNameMock,lastName);
        webCommonMethods.fillValueInWebElement(MockPass,email);
        webCommonMethods.fillValueInWebElement(MockEmail,Password);
            Thread.sleep(2000);
        webCommonMethods.clickOnElement(mockSubmitButton);
        Thread.sleep(2000);
        try {
            webCommonMethods.clickOnElement(mockSubmitButton);
        }
        catch (Exception E){
            System.out.println("Not avqailable");
        }
        webCommonMethods.clickOnElement(MockAddnewContact);


    }

    public void addUsersDetails(String firstname, String lastName){

        try {
            webCommonMethods.clickOnElement(MockAddnewContact);
        }
        catch (Exception E){
            System.out.println("Not avqailable");
        }
        webCommonMethods.fillValueInWebElement(FirstNameMock,firstname);
        webCommonMethods.fillValueInWebElement(LastNameMock,lastName);

    }

}
