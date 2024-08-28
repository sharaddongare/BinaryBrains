package com.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class Products {
    AppiumDriver driver=CapSetUp.getMobDriver();



    private By getProductIndex(int index){
      //  return By.xpath("//android.widget.TextView[@text=\""+product+"\"]");
        return By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View["+index+"]//android.widget.TextView");
    }

    public String getProductName(int index){
      return   driver.findElements(getProductIndex(index)).get(0).getText();
    }
    public String getProductDescription(int index){
        return   driver.findElements(getProductIndex(index)).get(1).getText();
    }
    public String getProductPrice(int index){
        return   driver.findElements(getProductIndex(index)).get(2).getText();
    }
}
