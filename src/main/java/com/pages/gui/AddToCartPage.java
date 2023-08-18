package com.pages.gui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage
{
    private WebDriver driver;

    // 1. By Locators: OR
    private By addToCartButton = By.xpath("(//button[contains(text(),\"Add to cart\")])[1]");
    private By cartIcon = By.xpath("//div/a[@class=\"shopping_cart_link\"]");

    public AddToCartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void addToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void cartIcon() {
        driver.findElement(cartIcon).click();
    }




}
