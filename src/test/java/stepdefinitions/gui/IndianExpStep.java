package stepdefinitions.gui;


import com.gui.pages.EmailPage;
import com.gui.pages.IndianBuissnessLogic;
import com.gui.pages.LoginTwitterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class IndianExpStep {

    public String title;

    private EmailPage emailPage=new EmailPage();

    IndianBuissnessLogic IB =new IndianBuissnessLogic();
    private static final Logger LOG = LogManager.getLogger(IndianExpStep.class);



        @When("User accept the prefferances")
    public void useraccessCokkies() throws InterruptedException {

            IB.dontallows();


    }

    @Then("Click on Option Link India")
    public void clickOnOptionLinkIndia() throws InterruptedException {

            IB.SearchForDatainIndia();


    }

    @Then("Click on FirstSub Window")
    public void firstSubWindow() throws InterruptedException {

        IB.firstSubWindow();


    }

    @Then("Get The parameters from Firstwindow")
    public void getTheParametersFromFirstwindow() throws InterruptedException {

        IB.getfirstLinksDetails();

    }

/*    @When("user hits URL {string}")
    public void userHitsURLHttpEmailAtagtrCom(String URL) {
        emailPage.hitURL(URL);


    }


    @Then("user enters emaild {string} and Password {string}")
    public void userEntersEmaildTeamAutoAtagtrComAndPasswordAutomatahon(String username, String Pass) throws InterruptedException {
        Thread.sleep(3000);
        emailPage.enterUserNameandPass(username,Pass);
    }

    @Then("user click on sign in button")
    public void userClickOnSignInButton() {
    emailPage.clickonSignButton();
    }

    @Then("User clicks on Inbox")
    public void userClicksOnInbox() {

    emailPage.clickoninbox();
    }

    @Then("Check for mail entries")
    public void checkForMailEntries() throws IOException, InterruptedException {

    emailPage.checkmail();
    }*/
}
