package com.gui.pages;


import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Set;

public class IndianBuissnessLogic {
    private WebDriver driver = DriverFactory.getDriver();
    public WebCommonMethods webCommonMethods = new WebCommonMethods();

    // 1. By Locators: OR
    private By addToCartButton = By.xpath("(//button[contains(text(),\"Add to cart\")])[1]");
    private By cartIcon = By.xpath("//div/a[@class=\"shopping_cart_link\"]");

    private By dontallow = By.xpath(ConfigReader.init_prop().getProperty("ieDontAllowbutton"));
    private By IndiaLink = By.xpath("(//a[contains(text(),'India')])[1]");


    private By FirstLinkinIndia = By.xpath("//li[@id=\"slick-slide10\"]");
    private By firstLinkDate = By.xpath("//div[@id='storycenterbyline']//span[@itemprop='dateModified']");
    private By FirstHeadLine = By.xpath("//h1[@itemprop='headline']");

    String GlobalfirstDate=null;
    String firstHeadLine=null;


    /**
     * This method used to add Cart Button
     */
    public void dontallows() throws InterruptedException {

        Thread.sleep(8000);

        webCommonMethods.clickOnElement(dontallow);

        //driver.findElement(dontallow).click();

    }


    public void SearchForDatainIndia() throws InterruptedException {


        webCommonMethods.clickOnElement(IndiaLink);
        Set<String> handles = driver.getWindowHandles();
        String Parentwindow = driver.getWindowHandle();
        System.out.println(handles.getClass().getName());
        Iterator<String> it1 = handles.iterator();

        while (it1.hasNext()) {

            String chil_window = it1.next();
            if (!Parentwindow.equals(chil_window)) {
                driver.switchTo().window(chil_window);
                System.out.println(driver.switchTo().window(chil_window).getTitle());
            }
        }


        //driver.findElement(dontallow).click();

    }

    public void firstSubWindow() throws InterruptedException {

        Thread.sleep(8000);

        webCommonMethods.clickOnElement(FirstLinkinIndia);

    }

    public void getfirstLinksDetails() throws InterruptedException {

        Thread.sleep(2000);

        String HandleofFistLink = driver.getWindowHandle();
        System.out.println(HandleofFistLink);
        String firstDate = webCommonMethods.getTextOfElementOnceVisible(firstLinkDate);
        System.out.println("First Date" + firstDate);
        String dateTimeWithoutZone = firstDate.replace(" IST","");
        firstHeadLine = webCommonMethods.getTextOfElementOnceVisible(FirstHeadLine);
        System.out.println("First headline" + firstHeadLine);
        dateTimeWithoutZone.replace("Updated:","");
        GlobalfirstDate=covertDate(dateTimeWithoutZone);


    }


        public String covertDate(String Mydate){
            String inputDate = Mydate;
            String formattedDate = null;
            // Define the input format
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

            // Define the output format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MM yyyy");

            try {
                // Parse the input date string into a LocalDate object
                LocalDate date = LocalDate.parse(inputDate, inputFormatter);

                // Format the LocalDate object into the desired output format
                formattedDate = date.format(outputFormatter);

                // Output the result
                System.out.println("Formatted Date: " + formattedDate);
            } catch (DateTimeParseException e) {
                System.err.println("Invalid date format: " + e.getMessage());
            }
        return formattedDate;
        }




    /**
     * This method used to add cart Icon
     *
     */
/*
    public void cartIcon() {
        driver.findElement(cartIcon).click();
    }
*/




}
