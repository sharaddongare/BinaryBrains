package com.gui.pages;

import com.gui.guiUtility.ConfigReader;
import com.gui.guiUtility.DriverFactory;
import com.gui.guiUtility.WebCommonMethods;
import com.opencsv.CSVWriter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmailPage {

    private WebDriver driver= DriverFactory.getDriver();

    private By emailId = By.xpath(ConfigReader.init_prop().getProperty("GodaddyEmail"));
    private By password = By.xpath(ConfigReader.init_prop().getProperty("GodayyPass"));
    private By signInButton = By.xpath(ConfigReader.init_prop().getProperty("GoDaddySignin"));

    private By Inbox = By.xpath(ConfigReader.init_prop().getProperty("Mail_Inbox"));



    private By forgotPwdLink = By.linkText(ConfigReader.init_prop().getProperty("forgotPasswordLinkByPartLink"));

    private By Checkbox = By.xpath(ConfigReader.init_prop().getProperty("GodaddyCheckBox"));


    public WebCommonMethods webCommonMethods;

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    /**
     * @return
     */
    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    /**
     * @param username - passed as an argument to perform enter username operation on web element
     */
    public void enterUserName(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    /**
     * @param pwd - passed as an argument to perform enter password operation on web element
     */
    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    /**
     * This method to perform Click operation on Login button
     *
     */
    public void clickOnLogin() {
        webCommonMethods.clickOnElement(signInButton);
    }

    public void hitURL(String URL){

        driver.get(URL);

    }

    public void enterUserNameandPass() {


    }


    public void enterUserNameandPass(String username, String pass) throws InterruptedException {

/*        driver.findElement(emailId).sendKeys(username);
        driver.findElement(password).sendKeys(pass);*/
        Thread.sleep(3000);
        driver.findElement(emailId).click();
        driver.findElement(emailId).sendKeys(username);
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickonSignButton(){


        driver.findElement(signInButton).click();
        //webCommonMethods.clickOnElement(Checkbox);
        //webCommonMethods.clickOnElement(signInButton);
    }

    public void clickoninbox(){


        driver.findElement(Inbox).click();
        //webCommonMethods.clickOnElement(Checkbox);
        //webCommonMethods.clickOnElement(signInButton);
    }

    public void checkmail() throws IOException, InterruptedException {
        boolean emailAvailble;
        int totalNumberofMails= driver.findElements(By.xpath("//*[@id=\"MEMessageListTBody\"]/tr")).size();
        for (int i =0;i<totalNumberofMails;i++){
            try {
                emailAvailble=driver.findElement(By.xpath("//*[@id=\"MEMessageListTBody\"]/tr//td[contains(@title,'Sample email: DISPOSAL REQUIRED FOR FCY INWARD')]")).isDisplayed();
                driver.findElement(By.xpath("//*[@id=\"MEMessageListTBody\"]/tr//td[contains(@title,'Sample email: DISPOSAL REQUIRED FOR FCY INWARD')]")).click();
            }
            catch(Exception e) {
                System.out.println("Not Available");
                break;
            }

            Thread.sleep(2000);

            String OSN_NO=driver.findElement(By.xpath("//td[text()='OSN NO']//following-sibling::td")).getText();
            String INW_NO=driver.findElement(By.xpath("//td[text()='INW_NO']//following-sibling::td")).getText();
            String Curr=driver.findElement(By.xpath("//td[text()='CUR']//following-sibling::td")).getText();
            String FCY_AMT=driver.findElement(By.xpath("//td[text()='FCY_AMT']//following-sibling::td")).getText();
            String REMITTER_R=driver.findElement(By.xpath("//td[text()='REMITTER_R']//following-sibling::td")).getText();
            String BENEFICIAR=driver.findElement(By.xpath("//td[text()='BENEFICIAR']//following-sibling::td")).getText();
            String PURP_REMIT=driver.findElement(By.xpath("//td[text()='PURP_REMIT']//following-sibling::td")).getText();

            File f = new File("src/Datafile");
            if(!(f.exists())) {
                CSVWriter writer = new CSVWriter(new FileWriter("src/Datafile"));
                //Writing data to a csv file
                String line1[] = {"OSN_NO", "INW_NO", "Curr", "FCY_AMT", "REMITTER_R","BENEFICIAR","PURP_REMIT"};
            }
            CSVWriter writer = new CSVWriter(new FileWriter("src/Datafile"));
            String line2[] = {OSN_NO,INW_NO,Curr,FCY_AMT,REMITTER_R,BENEFICIAR,PURP_REMIT};



        }
    }


}
