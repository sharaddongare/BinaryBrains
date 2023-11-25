package com.gui.pages;

import com.gui.guiUtility.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage
{
    private WebDriver driver= DriverFactory.getDriver();

    // 1. By Locators: OR
    private By addToCartButton = By.xpath("(//button[contains(text(),\"Add to cart\")])[1]");
    private By cartIcon = By.xpath("//div/a[@class=\"shopping_cart_link\"]");




    /**
     * This method used to add Cart Button
     *
     */
    public void addToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    /**
     * This method used to add cart Icon
     *
     */
    public void cartIcon() {
        driver.findElement(cartIcon).click();
    }




}
