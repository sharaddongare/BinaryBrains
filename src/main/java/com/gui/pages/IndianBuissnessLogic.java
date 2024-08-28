package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class IndianBuissnessLogic
{
    private WebDriver driver= DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    // 1. By Locators: OR
    private By addToCartButton = By.xpath("(//button[contains(text(),\"Add to cart\")])[1]");
    private By cartIcon = By.xpath("//div/a[@class=\"shopping_cart_link\"]");

    private By dontallow = By.xpath(ConfigReader.init_prop().getProperty("ieDontAllowbutton"));
    private By IndiaLink = By.xpath("(//a[contains(text(),'India')])[1]");




    /**
     * This method used to add Cart Button
     *
     */
    public void dontallows() throws InterruptedException {

        Thread.sleep(8000);

        webCommonMethods.clickOnElement(dontallow);

        //driver.findElement(dontallow).click();

    }


    public void SearchForDatainIndia() throws InterruptedException {


        webCommonMethods.clickOnElement(IndiaLink);
        Set<String > handles =driver.getWindowHandles();
        System.out.println(handles.getClass().getName());

        //driver.findElement(dontallow).click();

    }
    /**
     * This method used to add cart Icon
     *
     */
    public void cartIcon() {
        driver.findElement(cartIcon).click();
    }




}
