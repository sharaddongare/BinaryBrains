package com.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomeScreen {
    AppiumDriver driver=CapSetUp.getMobDriver();

    By prodBtn=By.xpath("//android.widget.Button");

    public void openProducts(){
        driver.findElement(prodBtn).click();
    }
}
